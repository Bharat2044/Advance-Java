package com.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthorizationFilter implements Filter {
	List<User> usersList = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		usersList = new ArrayList<>();

		usersList.add(new User("John", "john@123", "Admin"));
		usersList.add(new User("Manoj", "manoj@123", "Employee"));
		usersList.add(new User("Bharat", "bharat@123", "Admin"));
		usersList.add(new User("Hari", "hari@123", "Employee"));
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = usersList
					.stream()
					.filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password) && u.getRole().equals("Admin"))
					.findFirst()
					.orElse(null);
		
		if (user != null) {
			chain.doFilter(req, resp);
		} else {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			out.print("<h3 style='color: red;'>Username / Password is invalid or role is not Admin !!</br>");
			out.print("<a href='login.html'> Click Here </a></h3>");
		
			out.close();
		}
	}

	@Override
	public void destroy() {
		usersList = null;
	}
}
