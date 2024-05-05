package com.bharat.policy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PolicyCancelServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		int policyId = Integer.parseInt(req.getParameter("policyid"));

		// get the ServletContext object
		ServletContext context = getServletContext();

		// read the map from context associated with the key polocies
		Map<Integer, Policy> polociesMap = (Map) context.getAttribute("polocies");

		// read the policy count from the context
		int policyCount = (Integer) context.getAttribute("policyCount");

		if (polociesMap.remove(policyId) != null) {
			policyCount--;

			// store the values back to the context
			context.setAttribute("polocies", polociesMap);
			context.setAttribute("policyCount", policyCount);

			out.println("<html> <body> ");
			out.println("<h2> Your policy with id: " + policyId + " is cancelled </h2><br>");
			out.println("<a href='index.html'> click here </a> to goto index page");
			out.println("</body> </html>");
		} else {
			out.println("<html> <body> ");
			out.println("<h2>policy with id: " + policyId + " doesn't exist!! </h2><br>");
			out.println("<a href='index.html'> click here </a> to goto index page");
			out.println("</body> </html>");
		}

		out.close();
	}
}
