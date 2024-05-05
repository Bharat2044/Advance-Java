package com.bharat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet implements Servlet {
	ServletConfig config = null;

	public void init(ServletConfig config) {
		this.config = config;
		System.out.println("servlet is initialized");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.print("<h1>Hello, " + name + " Welcome to Servlet</h1>");
	}

	@Override
	public void destroy() {
		System.out.println("servlet is destroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "copyright 2024-1010";
	}
}
