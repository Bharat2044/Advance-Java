package com.bharat.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateServlet")
public class ProfileUpdateServlet extends HttpServlet {
    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "test";

    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    private static final String UPDATE_QUERY = "UPDATE `users_profile` SET `date_of_birth`=?, `contact`=? WHERE `email`=?";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        long contact = Long.parseLong(req.getParameter("contact"));

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            if (con == null || con.isClosed()) {
                Class.forName(DB_DRIVER_CLASS);
                con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }

            // Check if the email exists in the database
            if (!isEmailExists(email)) {
                out.print("<h1 style='color: red'>You entered a wrong email</h1>");
                out.print("<h3><a href='index.html'>Click Here</a> back to the Home Page</h3>");
                return; // Exit method if email does not exist
            }

            pstmt = con.prepareStatement(UPDATE_QUERY);

            pstmt.setDate(1, Date.valueOf(dateOfBirth)); // Parameter index starts from 1
            pstmt.setLong(2, contact);
            pstmt.setString(3, email); // Set email at index 3

            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                // Do not close connection here, as it's a class-level variable and might be reused
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher rd = req.getRequestDispatcher("viewServlet");
        rd.forward(req, resp);
    }

    // Method to check if email exists in the database
    private boolean isEmailExists(String email) throws SQLException {
        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM `users_profile` WHERE `email` = ?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

            return false;
        } finally {
            if (rs != null) {
                rs.close();
            }
            // Do not close pstmt here, as it might still be needed in the doPost method
        }
    }
}
