<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pform" %>
    <%@ page isELIgnored="false" %>
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
ProductId
</th>
<th>
ProductName
</th>
<th>
ProductDescription
</th>
<th>
ProductPrice
</th>
<th>
ProductCategory
</th>
<th>
ProductSupplier
</th>
<th>
ProductImages
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>
<pform:forEach items="${showdata}" var="pro" >
<tr>
<td>${pro.productId}</td>
<td>${pro.productName}</td>
<td>${pro.productDescription}</td>
<td>${pro.productPrice}</td>
<td>${pro.productCategory}</td>
<td>${pro.productSupplier}</td>
<td><img src="resources/images/${pro.productId}.jpg" alt="Laptop" width="30px" height="30px"/></td>
<td><a href="edt?proId=${pro.productId}">Edit</a></td>
<td><a href="delet?proId=${pro.productId}">Delete</a></td>
</tr>
</pform:forEach>
</body>
</html>