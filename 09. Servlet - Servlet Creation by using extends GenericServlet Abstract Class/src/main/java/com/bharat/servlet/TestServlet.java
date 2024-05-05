package com.bharat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<h1>Hello, " + name + " Welcome to Generic Servlet</h1>");
	}

}
