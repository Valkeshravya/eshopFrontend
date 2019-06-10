<%@page import="com.shravya.eshopbackend.model.Supplier"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
     <%@ include file="header.jsp" %>
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
supplierName
</th>
<th>
supplierDescription
</th>
<th>
supplierAddress
</th>

<th>
Edit
</th>
<th>
Delete
</th>

</tr>
<s:forEach items="${datarecieve}" var="sup">
<tr>
<td>
${sup.supplierName}</td>
<td>
${sup.supplierDescription}</td>
<td>
${sup.supplierAddress}</td>

<td><a href="ed?suppId=${sup.supplierId}">Edit</a></td>
<td><a href="delete?suppId=${sup.supplierId}">Delete</a></td>
</tr>
</s:forEach>
</table>

</body>
</html>