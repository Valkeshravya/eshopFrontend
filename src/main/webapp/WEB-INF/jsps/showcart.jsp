<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cform" %>
    <%@ include file="userheader.jsp" %>
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
CartId
</th>
<th>
ProductId
</th>
<th>
ProductName
</th>
<th>
ProductPrice
</th>
<th>
ProductQuantity
</th>
<th>
ProductSupplier
</th>
<th>
TotalPrice
</th>
<th>
UserName
</th>
<th>
Edit
</th>
<th>
Delete
</th>
<cform:forEach items="${add}" var="cr" >
<tr>
<td>${cr.cartId}</td>
<td>${cr.productId}</td>
<td>${cr.productName}</td>
<td>${cr.productPrice}</td>
<td>${cr.productQuantity}</td>
<td>${cr.productSupplier}</td>
<td>${cr.totalPrice}</td>
<td>${cr.userName}</td>
<td><a href="update?cartId=${cr.cartId}">Edit</a></td>
<td><a href="de?cartId=${cr.cartId}">Delete</a></td>
</tr>
</cform:forEach>
</body>
</html>