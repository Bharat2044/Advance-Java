package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() method called.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() method executing.");
		
		String username = req.getParameter("username");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>Hello, " + username + "</h1>");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() method called.");
	}
}
