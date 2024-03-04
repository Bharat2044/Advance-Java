package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello " + username + ", Welcome to Homepage(Servlet1)</h1>");
	
		
		RequestDispatcher rd = req.getRequestDispatcher("CallingServlet2");
		// rd.forward(req, resp);
		rd.include(req, resp);
	}
	
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hi " + username + ", Welcome to Homepage(doGet)</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello " + username + ", Welcome to Homepage(doPost)</h1>");
	}
	*/
}
