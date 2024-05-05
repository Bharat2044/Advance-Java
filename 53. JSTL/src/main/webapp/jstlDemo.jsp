<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Demo</title>
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
	<br />

	<c:if test="${income > 8000}">  
	   My income is: <c:out value="${income}" />
	</c:if>
	<br />

	<c:choose>
		<c:when test="${income <= 1000}">  
	       Income is not good.  
	    </c:when>
			<c:when test="${income > 10000}">  
	        Income is very good.  
	    </c:when>
			<c:otherwise>  
	       Income is undetermined...  
	    </c:otherwise>
	</c:choose>
	<br>
	
	<c:forEach var="i" begin="1" end="5">  
	   Item <c:out value="${i}"/>  <br/>  
	</c:forEach>  
	
	<c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">  
	   <c:out value="${name}"/>  <br/> 
	</c:forTokens>  
</body>
</html>