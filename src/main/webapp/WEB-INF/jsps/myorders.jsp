<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="userheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>DateOfPurchase</th>
<th>GrandTotal</th>
<th>UserName</th>
<th>Address</th>
</tr>

<c:forEach var="var" items="${ord}">
<tr>
<td>${var.date }</td>
<td>${var.grandTotal }</td>
</tr>
</c:forEach>
</table></body>
</html>