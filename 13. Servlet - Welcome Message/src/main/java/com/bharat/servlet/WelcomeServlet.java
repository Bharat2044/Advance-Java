package com.bharat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		System.out.println("Hello " + name + ", Welcome to Homepage!!!");
		
		resp.setContentType("text/html");		
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>Hello " + name + ", Welcome</h1>");
	}
}
