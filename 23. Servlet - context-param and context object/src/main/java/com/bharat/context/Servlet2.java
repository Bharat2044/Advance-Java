package com.bharat.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		ServletContext context = getServletContext();
		String value = context.getInitParameter("apiKey");

		out.println("<html><body><h1 style='color: green'>");
		out.println("apiKey : " + value);
		out.println("</h1></body></html>");
	}

}
