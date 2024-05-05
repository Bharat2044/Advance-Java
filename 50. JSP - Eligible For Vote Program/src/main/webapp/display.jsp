<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head> 
	<meta charset="ISO-8859-1">
	<title>Display</title>
	</head>
<body>	
	<h2>		
		<!-- Expression Language -->		
		Your age is ${param.age}, ${param.age >= 18 ? " You are eligible for vote." : " You not are eligible for vote."}
		<br><br>
		
		
		<!-- Scriptlet Tag -->
		<%
			int age = Integer.parseInt(request.getParameter("age"));
			
			if(age >= 18) {
				out.println("Your age is " + age + ", You are eligible for vote.");
			} else {
				out.println("Your age is " + age + ", You are not eligible for vote.");
			}
		%>
		<br><br>
		
		
		<!-- Expression Tag -->
		Your age is <%= age %>, <%= age >= 18 ? " You are eligible for vote." : " You not are eligible for vote." %>
			
	</h2>
</body>
</html>