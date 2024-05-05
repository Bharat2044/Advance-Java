package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/registration")
public class RegistrationFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;

    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "test"; 

    private static final String INSERT_QUERY =  "INSERT INTO `aadhar_registration` (`name`, `father_name`, `mother_name`, `phone`, `email`, `address`, `qualification`, `percentage`) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String formNumber = request.getParameter("formNumber");

		if (formNumber.equals("1")) {
			String name = request.getParameter("name");
			String fatherName = request.getParameter("fatherName");
			String motherName = request.getParameter("motherName");
			
			session.setAttribute("name", name);
			session.setAttribute("fatherName", fatherName);
			session.setAttribute("motherName", motherName);
			
			response.sendRedirect("./form2.html");
		}
		
		if (formNumber.equals("2")) {
			String phoneNumber = request.getParameter("phoneNumber");
			String emailId = request.getParameter("emailId");
			String address = request.getParameter("address");
			
			session.setAttribute("phoneNumber", phoneNumber);
			session.setAttribute("emailId", emailId);
			session.setAttribute("address", address);
		
			response.sendRedirect("./form3.html");
		}
		
		if (formNumber.equals("3")) {
			String qualification = request.getParameter("qualification");
			String percentage = request.getParameter("percentage");
		
			String name = (String)session.getAttribute("name");
			String fatherName = (String)session.getAttribute("fatherName");
			String motherName = (String)session.getAttribute("motherName");
			String phoneNumber = (String)session.getAttribute("phoneNumber");
			String emailId = (String)session.getAttribute("emailId");
			String address = (String)session.getAttribute("address");
		
			
			try {
	            Class.forName(DB_DRIVER_CLASS);
	            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	            pstmt = connection.prepareStatement(INSERT_QUERY);

	            pstmt.setString(1, name);
	            pstmt.setString(2, fatherName);
	            pstmt.setString(3, motherName);
	            pstmt.setString(4, phoneNumber);
	            pstmt.setString(5, emailId);
	            pstmt.setString(6, address);
	            pstmt.setString(7, qualification);
	            pstmt.setString(8, percentage);

	            int i = pstmt.executeUpdate();

	            if (i != 0) { 
	                out.println("<h1>Registration Successful :)</h1>");
	                
	                out.println("<pre>");
	                out.println("Your Name:     " + name);
	                out.println("Father Name:   " + fatherName);
	                out.println("Mother Name:   "  + motherName);
	                out.println("Phone Number:  " + phoneNumber);
	                out.println("Email Id:      " + emailId);
	                out.println("Address:       " + address);
	                out.println("Qualification: " + qualification);
	                out.println("Percentage:    " + percentage);
	                out.println("</pre>");
	            } else {
	                out.println("<h1>Registration Failed :(</h1>");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
                out.println("<h1>Registration Failed :(</h1>" + e.getMessage());
	            e.printStackTrace();
	        } finally {
	        	try {
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

}
