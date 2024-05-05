package com.bharat.send_redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<h2>Details are:</h2>");
		out.print("<h3>Name: " + name + "<br>");
		out.print("<h3>Age: " + age + "<br>");
		out.print("<h3>Email: " + email + "<br>");
		out.print("<h3>Mobile: " + mobile + "</h3>");
	}
}
