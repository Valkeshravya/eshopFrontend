<%@ include file="userheader.jsp" %>
<%@page import="com.shravya.eshopbackend.model.Product"%>
<%@page import="com.shravya.eshopbackend.model.Supplier" %>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="resources/images/${showdata.productId}.jpg"  alt="Laptop" width="200px" height="200px"/><br>
${showdata.productName}<br>
${showdata.productDescription}<br>
${showdata.productPrice}<br>
${showdata.productSupplier}<br>

<form action="cart" >
<input type="number" name="quan" value="0" min="1" max="5"/>
<input type="hidden" name="pid" value="${showdata.productId}"/>
<input type="submit" value="${buttonName}" />
</form>
<a href="#" style="float: right;">BUY NOW</a>

</body>
</html>