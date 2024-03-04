package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/callingServlet2")
public class Servlet2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello " + username + ", Welcome to Homepage(Servlet2)</h1>");
	
		
		RequestDispatcher rd = req.getRequestDispatcher("callingServlet3");
		rd.include(req, resp);
	}
}
