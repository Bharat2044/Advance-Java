package com.product.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view")
public class CartViewServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		
		if(option.equals("continue")) {
			response.sendRedirect("products.html");
		} else {
			HttpSession session = request.getSession();
			List<Product> cart = (List<Product>) session.getAttribute("cart");
			String username = (String) session.getAttribute("username");
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			out.println("<h2>Hello " + username + "!</h2>");
			

			out.println("<h3>Your Cart Items</h3>");
			out.println("<ol>");
			for(Product p: cart) {
				out.println("<li>" + p.getProductId() + "  " + p.getProductName() + "  " + p.getProductPrice() + "</li>");
			}
			out.println("</ol><br><br>");
			
			out.println("<a href='./logout'> Logout </a>");
			out.println("</body></html>");
		}
	}
}
