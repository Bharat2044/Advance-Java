package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello " + username + ", Welcome to Homepage(Servlet3)</h1>");
	}
}
