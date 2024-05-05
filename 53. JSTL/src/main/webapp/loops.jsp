<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Loops</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="5">  
	   Item <c:out value="${i}"/>  <br/>  
	</c:forEach>  
	
	<br/> <br/> 
	
	<c:forTokens var="name" items="Rahul-Nakul-Rajesh" delims="-">  
	   <c:out value="${name}"/>  <br/> 
	</c:forTokens>  
</body>
</html>