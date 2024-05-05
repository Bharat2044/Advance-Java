package com.bharat.rd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = (String) req.getAttribute("name");
		String email = (String) req.getAttribute("email");
		String mobile = (String) req.getAttribute("mobile");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>Start<br>");
		out.print(name + "<br>");
		out.print(email + "<br>");
		out.print(mobile + "<br>");
		
		RequestDispatcher rd = req.getRequestDispatcher("servlet3");
		rd.include(req, resp);
	}
}
