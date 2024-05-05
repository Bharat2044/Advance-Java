package com.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewServlet")
public class ViewEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/jdbc_db";
		String dbUsername = "root";
		String dbPassword = "test";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `users`");
			
			out.print("<html><body>");
			out.print("<table border='1'>");
			
			out.print("<tr>");
			out.print("<th> Id </th>");
			out.print("<th> Name </th>");
			out.print("<th> Salary </th>");
			out.print("<th> Hire Date </th>");
			out.print("<th> Password </th>");
			out.print("</tr>");
			
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString(1) + "</td>");
				out.print("<td>" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getString(3) + "</td>");
				out.print("<td>" + rs.getString(4) + "</td>");
				out.print("<td>" + rs.getString(5) + "</td>");
				out.print("</tr>");
			}

			out.print("</table");
			out.print("</body></html>");
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (out != null) {
				out.close();
			}
		}
	}
}
