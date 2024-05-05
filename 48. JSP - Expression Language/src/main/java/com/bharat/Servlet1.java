package com.bharat;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/callingServlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		// RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		// rd.forward(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);
		
		response.sendRedirect("display.jsp");
	}
}
