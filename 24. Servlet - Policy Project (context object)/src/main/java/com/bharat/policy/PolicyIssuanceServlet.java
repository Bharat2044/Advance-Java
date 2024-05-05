package com.bharat.policy;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PolicyIssuanceServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// read the input data
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));

		// generating policy id randomly
		Random random = new Random();
		int policyId = random.nextInt(100000) + 1;

		Policy policy = new Policy();
		policy.setPolicyId(policyId);
		policy.setName(name);
		policy.setAge(age);
		policy.setExpiresOn(LocalDate.of(2025, 8, 15));

		// get the ServletContext object
		ServletContext context = getServletContext();

		Map<Integer, Policy> polociesMap = null;

		if (context.getAttribute("polocies") == null) {
			polociesMap = new HashMap<>();
		} else {
			polociesMap = (Map) context.getAttribute("polocies");
		}

		int policyCount = 0;
		if (context.getAttribute("policyCount") == null) {
			policyCount = 1;
		} else {
			policyCount = (Integer) context.getAttribute("policyCount");
			policyCount++;
		}

		polociesMap.put(policyId, policy);

		// set/store the policiesMap object into the context
		context.setAttribute("polocies", polociesMap);

		// store the policy count into the context
		context.setAttribute("policyCount", policyCount);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html><body>");
		out.println("<h2> Your policy is successfully created with id : " + policyId + "</h2><br>");
		out.println("<a href='index.html'> click here </a> to goto index page");
		out.println("</body></html>");

		out.close();
	}

}
