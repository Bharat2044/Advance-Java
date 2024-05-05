package com.product.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(authenticate(username, password)) {
			// Creating session object
			// HttpSession session = request.getSession();
			HttpSession session = request.getSession(true);
			
			// adding the username in session object
			session.setAttribute("username", username);
			
			response.sendRedirect("products.html");
		} else {
			response.sendRedirect("login.html");
		}
	}
	
	private boolean authenticate(String username, String password) {
		return username!=null && !username.isEmpty() && password!=null && !password.isEmpty();
	}
}
