package com.bharat.profile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/entryServlet")
public class EntryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String choice = req.getParameter("option");
		
		if(choice.equals("build")) {
			RequestDispatcher rd = req.getRequestDispatcher("build_profile.html");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("update_profile.html");
			rd.forward(req, resp);
		}
	}
}
