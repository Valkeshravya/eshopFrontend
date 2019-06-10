<%@page import="com.shravya.eshopbackend.model.Category"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border="1">
<tr>
<th>
CatogoryName
</th>
<th>
CategoryDescription
</th>
<th>
Edit
</th>
<th>
Delete
</th>

</tr>
<c:forEach items="${data}" var="cat">
<tr>
<td>
${cat.categoryName}</td>
<td>
${cat.categoryDescription}</td>
<td><a href="edit?catId=${cat.categoryId}">Edit</a></td>
<td><a href="del?catId=${cat.categoryId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>