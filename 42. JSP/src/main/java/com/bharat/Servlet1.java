package com.bharat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/callingServlet1")
public class Servlet1 extends HttpServlet {
	
	int a = 10;
	int b = 20;
	
	public int add() {
		return a + b;
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int sum = add();	// object is created by server for Servlet1 class
		
		PrintWriter out = res.getWriter();
		out.print("<h1>Sum = " + sum + "</h1>");
	}
}
