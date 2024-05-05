package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello From Servlet1");
		
		String name = req.getParameter("username");
		System.out.println("Hello " + name);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//out.print("Hello " + name);
		out.print("<h1>Hello " + name);
		out.print("<h2>Hello " + name);
		out.print("<h3>Hello " + name);
	}
}
