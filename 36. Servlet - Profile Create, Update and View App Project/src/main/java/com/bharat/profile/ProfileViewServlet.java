package com.bharat.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewServlet")
public class ProfileViewServlet extends HttpServlet {
	private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "test"; 
    
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	private static final String SELECT_QUERY = "SELECT * FROM `users_profile` WHERE `email` = ?";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("email");
		
		try {
			Class.forName(DB_DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

			pstmt = con.prepareStatement(SELECT_QUERY);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();

			RequestDispatcher rd1 = req.getRequestDispatcher("headerServlet");
			rd1.include(req, resp);
			
			if (rs.next()) {
				out.print("<hr>");
				out.print("First Name : " + rs.getString(1));
				out.print("<br>Last Name : " + rs.getString(2));
				out.print("<br>Email: " + rs.getString(3));
				out.print("<br>Date of Birth : " + rs.getString(4));
				out.print("<br>Contact : " + rs.getString(5));
				out.print("<hr>");
			}
			
			RequestDispatcher rd2 = req.getRequestDispatcher("footerServlet");
			rd2.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(out != null) {
				out.close();
			}
		}
	}

}
