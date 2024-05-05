<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL If-Else</title>
</head>
<body>
	<c:set var="income" value="${4000.50 * 4}" />
	
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
</body>
</html>