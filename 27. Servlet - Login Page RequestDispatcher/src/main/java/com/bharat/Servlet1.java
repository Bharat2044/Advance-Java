package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	private static int count = 3;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		if("test".equals(password)) {
			out.println("<h1>Hi, " + userName + " Welcome to Homepage!!!</h1>");
		} else if(count > 0) {
			out.println("Hi, " + userName + " You entered wrong password. You have " + count + " attempts left.");				count--;
					
			RequestDispatcher rq = req.getRequestDispatcher("index.html");
			rq.include(req, resp);
		} else {
			out.println("<h1>Hi, " + userName + " Your attempts over, Contact to Admin.</h1>");
		}
	}
}
