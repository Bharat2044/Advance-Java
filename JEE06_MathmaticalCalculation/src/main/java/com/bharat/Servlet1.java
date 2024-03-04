package com.bharat;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		
		int sum = x + y;
		
		req.setAttribute("mySum", sum);
		
		RequestDispatcher rq = req.getRequestDispatcher("CallingServlet2");
		rq.forward(req, resp);
	}
}
