
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
	<form method ="get" action ="Connexion">
		login:<input type= "text" name ="login">
		mot de passe:<input type= "text" name ="mdp">
		<input type= "submit" value="se connecter">
	</form>
</c:when>
<c:when test="${not empty sessionScope.nom }">
	<c:redirect url="menu.jsp" />
	
</c:when>
</c:choose>


</body>
</html>