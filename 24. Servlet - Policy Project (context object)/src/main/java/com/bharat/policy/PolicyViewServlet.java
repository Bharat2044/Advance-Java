package com.bharat.policy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PolicyViewServlet extends HttpServlet {

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

		Policy policy = polociesMap.get(policyId);
		if (policy != null) {
			out.println("<html> <body> <h2>");
			out.println("policy id   : " + policy.getPolicyId() + "<br>");
			out.println("Name        : " + policy.getName() + "<br>");
			out.println("Age         : " + policy.getAge() + "<br>");
			out.println("Expires on  : " + policy.getExpiresOn() + "<hr>");
			out.println("The total number of polices : " + policyCount + "<br>");
			out.println("<a href='index.html'> click here </a> to goto index page");
			out.println("</h2> </body> </html> ");
		} else {
			out.println("<html> <body> <h2>");
			out.println("Policy with id :" + policyId + " doesn't exist!!<br>");
			out.println("<a href='index.html'> click here </a> to goto index page");
			out.println("</h2> </body> </html>");
		}

		out.close();
	}
}
