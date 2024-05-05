<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition</title>
</head>
<body>
	
	<!-- Declarative Tag: Used for declaration -->
	<%!
		int a = 10;
		int b = 20;
		
		int add() {
			return a + b;
		}
	%>
	
	<!-- Scriptlet Tag: Used for add all logic -->
	<%
		int sum = add();
		out.println("<h1>Sum = " + sum + "</h1>");
	%>
	
	<!-- Expression Tag: Used for print output --> 
	<%= sum %>
	
</body>
</html>