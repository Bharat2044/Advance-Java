<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Star Pattern Program</title>
	<style>
		h1 {
			color: green;
		}
	</style>
</head>
<body>
	<h1>
		<%
			int n = Integer.parseInt(request.getParameter("n"));
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					out.print("* ");
				}
				
				out.print("<br>");
			}
		%>
	</h1>
</body>
</html>