package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static PrintWriter out = null;

    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "test"; 

    private static final String Insert_Query = "INSERT INTO `members` (`first_name`, `last_name`, `age`, `email_id`) VALUES(?, ?, ?, ?)";

    @Override
    public void destroy() {
        try {
            // Explicitly unregister the JDBC driver
            DriverManager.deregisterDriver(DriverManager.getDriver(DB_URL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Ensure the cleanup thread is stopped
        com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName(DB_DRIVER_CLASS);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            pstmt = connection.prepareStatement(Insert_Query);

            pstmt.setString(1, req.getParameter("firstName"));
            pstmt.setString(2, req.getParameter("lastName"));
            pstmt.setInt(3, Integer.parseInt(req.getParameter("age")));
            pstmt.setString(4, req.getParameter("emailId"));

            int i = pstmt.executeUpdate();

            resp.setContentType("text/html");
            out = resp.getWriter();
                     
            if (i > 0) { 
                out.println("<h1>Registration Successful</h1>");
            } else {
                out.println("<h1>Registration Failed</h1>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
    		    if (out != null) {
    		        out.close();
    		    }
    		    if (pstmt != null) {
    		        pstmt.close();
    		    }
    		    if (connection != null) {
    		        connection.close();
    		    }
    		} catch (SQLException e) {
    		    e.printStackTrace();
    		}
		}
    }
}
