package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {
	private static int count = 3;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		session.setAttribute("userName", userName);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		if("test".equals(password)) {
			out.println("<h1>Hi, " + userName + " Welcome to Homepage!!!</h1>");
		} else if(count > 0) {
			out.println("Hi, " + userName + " You entered wrong password. You have " + count + " attempts left.");				count--;
					
			RequestDispatcher rq = req.getRequestDispatcher("index.html");
			rq.include(req, resp);
		} else {
			// RequestDispatcher rq = req.getRequestDispatcher("CallingServlet2");
			// rq.forward(req, resp);
			
			resp.sendRedirect("CallingServlet2");
		}
	}
}
