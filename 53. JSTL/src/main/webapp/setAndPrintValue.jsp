<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Set abd Print Value</title>
</head>
<body>
	<c:out value="${'Welcome to JSTL'}" />
	<br />

	<c:out value="${100}" />
	<br />

	<c:set var="age" value="${21}" />
	<c:set var="income" value="${4000.50 * 4}" />

	<c:out value="${age}" />
	<br />
	
	<c:out value="${income}" />
</body>
</html>