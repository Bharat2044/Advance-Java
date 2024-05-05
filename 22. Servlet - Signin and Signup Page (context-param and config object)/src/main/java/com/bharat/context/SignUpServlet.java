package com.bharat.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;

	private static final String QUERY = "INSERT INTO `user_table` (`username`, `password`) VALUES(?, ?)";

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cnfPassword = request.getParameter("cnfPassword");

		if (password.equals(cnfPassword)) {
			try {
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				
				int i = pstmt.executeUpdate();
				
				if(i == 1) {
					out.println("<html><body>");
					out.println("<h1 style='color: green;'>Sign Up Successfull!!!</h1><br>");
					out.print("<h3><a href='signIn.html'> Click Here </a> to Sign In</h3>");
					out.println("</body> </html>");
				}
			} catch (SQLException e) {
				out.println("<html><body><h3>");
				out.println("User already exist!!!<br>");
				out.print("<a href='signUp.html'> Click Here </a> to try again");
				out.println("</h3> </body> </html>");
			}
		} else {
			out.println("<html><body>");
			out.println("<h1 style='color: red;'>Confirm Password doesn't match with Password!!!</h1>");
			out.println("<h3><a href='./index.html'>Click Here </a> to try again!!</h3>");
			out.println("</body> </html>");
		}
		out.close();
	}

	@Override
	public void destroy() {
		try {
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
