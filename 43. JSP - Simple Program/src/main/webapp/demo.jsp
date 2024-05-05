<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Program</title>
</head>
<body>
	<%!	
		int add(int a, int b) {
			return a + b;
		}
		int sub(int a, int b) {
			return a - b;
		}
		int mul(int a, int b) {
			return a * b;
		}
		int div(int a, int b) {
			return a / b;
		}
	%>
	
	<%	
		int a = 20, b = 4;
	
		out.println("<h3>Sum = " + add(10, 5));
		out.println("<h3>Diff = " + sub(10, 5));
		out.println("<h3>Mul = " + mul(10, 5));
		out.println("<h3>Div = " + div(10, 5));
		
		out.println("<h3>Sum = " + add(a, b));
		out.println("<h3>Diff = " + sub(a, b));
		out.println("<h3>Mul = " + mul(a, b));
		out.println("<h3>Div = " + div(a, b));
	%>
</body>
</html>