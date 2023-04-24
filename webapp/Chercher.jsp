<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
<c:when test="${ empty sessionScope.nom }">
	
	<c:redirect url="index.jsp" />
</c:when>
<c:when test="${not empty sessionScope.nom }">
	<form method ="get" action ="Traitement">
		id:<input type= "text" name ="id">
		
		<input type= "submit" value="enregistre">
	</form>
</c:when>
</c:choose>






</body>
</html>