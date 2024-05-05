<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head> 
	<meta charset="ISO-8859-1">
	<title>Display</title>
	</head>
	<style>
		body {
			background-color: #000;
			color: #fff;
		}
		h1 {
			color: green;
			font-family: sans-serif;
		}	
	</style>
<body>	
	 
	<h1>		
		<!-- Expression Language -->
		Hi, ${sessionScope.userName} your password is ${sessionScope.password}
		<br>
	
		<%-- 
		<!-- Expression Language -->
		Hi, ${param.userName} your password is ${param.password}
		
		<!-- Scriptlet Tag -->
		<%
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			out.println("Hi, " + userName + " your password is " + password + "<br>");
		%>
		--%>
		
		 
	 	<!-- Scriptlet Tag -->
		<%
			String userName = (String)session.getAttribute("userName");
			String password = (String)session.getAttribute("password");
			
			out.println("Hi, " + userName + " your password is " + password + "<br>");
		%>
		
		
		<!-- Expression Tag -->
		<%= "Hi, " +userName+ " your password is " +password %>
	
	</h1>
</body>
</html>