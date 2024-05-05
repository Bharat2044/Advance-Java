<%@page import="com.bharat.example.EmployeesBean"%>
<%@page import="com.bharat.example.Employee, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employees Page</title>
</head>
<body>
	<%-- 
	<%
		EmployeesBean emps = new EmployeesBean();
	%> 
	--%>
	
	<!-- Creating Obhect -->
	<jsp:useBean id = "eBean" class = "com.bharat.example.EmployeesBean" />
	
	
	<%
		List<Employee> employees = eBean.fetchEmployees();
		request.setAttribute("employees", employees);
	%> 
	
	
	
	<%-- 
	<jsp:setProperty property="" name=""/>
	<jsp:getProperty property="" name=""/>
	 --%>
</body>
</html>