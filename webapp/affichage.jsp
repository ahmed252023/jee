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

<c:forEach items ="${ requestScope.liste}" var="member">
id=${member.id }, nom=${member.nom },date_deb=${member.date_deb },date_fin=${member.date_fin },phone=${member.phone }<br>


</c:forEach>



</body>
</html>