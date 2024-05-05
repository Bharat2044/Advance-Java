<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Simple Math Program</title>
	
	<style>
		h1 {
			color: red;
		}
		#sum {
			color: blue;
		}
		#sub {
			color: red;
		}
		#mul {
			color: purple;
		}
		#div {
			color: green;
		}
	</style>
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
	
	<h1 id = "sum">
		<% out.println("Sum = " + add(10, 5)); %>
	</h1>
	<h1 id = "sub">
		<% out.println("Diff = " + sub(10, 5)); %>
	</h1>
	<h1 id = "mul">
		<% out.println("Mul = " + mul(10, 5)); %>
	</h1>
	<h1 id = "div">
		<% out.println("Div = " + div(10, 5)); %>
	</h1>
	
	
	<script type="text/javascript">
		alert("Welcome to JSP World :)");
	</script>
	
	
	<%-- 
	<h1>
		<%	
			String name = "sub";
		
			if(name.equals("add")) {
				out.println("Sum = " + add(10, 5));
			}
			else if(name.equals("sub")) {
				out.println("Diff = " + sub(10, 5));
			}
			else if(name.equals("mul")) {
				out.println("Mul = " + mul(10, 5));
			}
			else if(name.equals("div")) {
				out.println("Div = " + div(10, 5));
			}	
			else {
				out.println("You entered wrong option");
			}			
		%>
	</h1> 
	--%>
</body>
</html>