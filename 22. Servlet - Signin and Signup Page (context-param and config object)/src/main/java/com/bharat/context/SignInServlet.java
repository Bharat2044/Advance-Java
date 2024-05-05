package com.bharat.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	private static final String QUERY = "SELECT COUNT(*) FROM `user_table` WHERE `username` = ? AND `password` = ?";

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			String driver = config.getServletContext().getInitParameter("driverClassName");
			Class.forName(driver);

			String url = config.getServletContext().getInitParameter("dbUrl");
	        String username = config.getServletContext().getInitParameter("username");
	        String password = config.getServletContext().getInitParameter("password");

			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(QUERY);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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
				out.println("<html><body>");
				out.println("<h1 style='color: green;'>Welcome " + username + "<br>");
				out.println("Your Login Success!!</h1>");
				out.println("</body> </html>");
			} else {
				out.println("<html><body>");
				out.println("<h1 style='color: red;'>Your username or password is invalid!!!</h1>");
				out.println("<h3><a href='./index.html'>Click Here </a> to try again!!</h3>");
				out.println("</body> </html>");
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
