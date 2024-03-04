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
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		
		int sum = (int) req.getAttribute("mySum");
		int diff = (int) req.getAttribute("myDiff");
		
		int product = x * y;
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		

		out.println("<h1>Sum = " + sum + "</h1>");
		out.println("<h1>Difference = " + diff + "</h1>");
		
		out.println("<h1>Product = " + product + "</h1>");
	}
}
