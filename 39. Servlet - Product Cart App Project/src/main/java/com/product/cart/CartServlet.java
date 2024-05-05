package com.product.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class CartServlet extends HttpServlet {
	private static List<Product> productsList = null;

	static {
		productsList = new ArrayList<>(); 
			
		productsList.add(new Product("p-1231", "Samsung QLED TV", 250000.0f));
		productsList.add(new Product("p-1241", "Mackbook Pro", 175000.0f));
		productsList.add(new Product("p-1251", "Realme 9 Pro", 33000.0f));
		productsList.add(new Product("p-1261", "LG Micro Owen", 555000.0f));
		productsList.add(new Product("p-1271", "IPhone 15 Pro Max", 115000.99f));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] productIds = request.getParameterValues("product");
		
		if(productIds != null) {
			HttpSession session = request.getSession(false);
			
			List<Product> cart = (List<Product>) session.getAttribute("cart");
			
			if(cart == null) {
				cart = new ArrayList<Product>();
			}
			
			for(String pid : productIds) {
				Product selectedProduct = productsList.stream().filter(p -> p.getProductId().equals(pid)).findFirst().orElse(null);
				
				if(selectedProduct != null) {
					cart.add(selectedProduct);
				}
			}
			
			session.setAttribute("cart", cart);
			response.sendRedirect("next.html");
		} else {
			response.sendRedirect("products.html");
		}
	}
}
