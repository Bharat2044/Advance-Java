package com.bharat.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static final String QUERY = "SELECT COUNT(*) FROM users WHERE user_name = ? AND password = ?";

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "test");

			pstmt = conn.prepareStatement(QUERY);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// read the input from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			// setting the username and password to the PreparedStatement
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			rs.next();

			int count = rs.getInt(1);

			if (count == 1) {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>");
				out.println("<font color='green'>");
				out.println("Welcome " + username + "<br>");
				out.println("Your Login Success!!");
				out.println("</font> </h1> </body> </html>");
			} else {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>");
				out.println("<font color='red'>");
				out.println("Your username or password is invalid!!!");
				out.println("</font> </h1> </body> </html>");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

	@Override
	public void destroy() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
