package com.bharat.rd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		
		req.setAttribute("name", name);
		req.setAttribute("email", email);
		req.setAttribute("mobile", mobile);
		
		RequestDispatcher rd = req.getRequestDispatcher("servlet2");
		rd.forward(req, resp);
	}
}
