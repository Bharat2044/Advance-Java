package com.bharat.profile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buildServlet")
public class ProfileCreateServlet extends HttpServlet {
	private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "test"; 
    
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    
    private static final String INSERT_QUERY = "INSERT INTO `users_profile` (`first_name`, `last_name`, `email`, `date_of_birth`, `contact`) VALUES(?, ?, ?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        long contact = Long.parseLong(req.getParameter("contact"));

        try {
        	Class.forName(DB_DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            pstmt = con.prepareStatement(INSERT_QUERY);

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setDate(4, Date.valueOf(dateOfBirth)); // Convert LocalDate to java.sql.Date
            pstmt.setLong(5, contact);

            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher rd = req.getRequestDispatcher("viewServlet");
        rd.forward(req, resp);
    }
}
