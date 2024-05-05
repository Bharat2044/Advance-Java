package com.bharat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] c = req.getCookies();
		
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i].getName() + " : " + c[i].getValue());
		}
	}
}
