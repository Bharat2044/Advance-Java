package com.bharat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<h1>Hello, " + name + " Welcome to Http Servlet</h1>");

	}

}
