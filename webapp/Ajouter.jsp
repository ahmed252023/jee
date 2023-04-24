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
	<form method ="post" action ="Traitement">
		ID:<input type= "text" name ="id">
		nom:<input type= "text" name ="nom">
		date_deb:<input type= "text" name ="date_deb">
		date_fin:<input type= "text" name ="date_fin">
		phone:<input type= "text" name ="phone">
		<input type= "submit" value="enregitre">
	</form>
</c:when>
</c:choose>






</body>
</html>