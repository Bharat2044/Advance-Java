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
			color: red;
		}	
	</style>
<body>	
	 
	<h1>Your Details are:</h1>
	<h3>		
		<!-- Expression Language -->		
		First Name: ${param.firstName} <br>
		Last Name: ${param.lastName} <br><br>
		
		
		<!-- Scriptlet Tag -->
		<%
			out.println("First Name: " + request.getParameter("firstName") + "<br>");
			out.println("Last Name: " + request.getParameter("lastName") + "<br><br>");
		%>
		
		
		<!-- Expression Tag -->
		First Name: <%= request.getParameter("firstName") %>
		<br>
		Last Name: <%= request.getParameter("lastName") %>
		<br><br>
		
		100 + 200 = <%= 100 + 200 %> <br>
		10 * 20 = <%= 10 * 20 %> <br>
		<br><br>
		100 + 200 = ${ 100 + 200 }<br>
		10 * 20 = ${ 10 * 20 }<br>
	
	</h3>
</body>
</html>