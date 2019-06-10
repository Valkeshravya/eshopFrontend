<%@ include file="userheader.jsp" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 
</head>
<body>
<div class="container">
  <div class="row">
    <s:forEach items="${showdata}" var="pro">
        <div class="col-sm-4">
    <img src="resources/images/${pro.productId}.jpg" class="img-responsive" alt="Laptop" width="100px" height="100px"/><br>
    ${pro.productName}<br>
    ${pro.productDescription}<br>
     ${pro.productPrice}<br>
    <a href="productdetail?pid=${pro.productId}">ViewProducts</a>
    </div>
    </s:forEach>
</div>
</div>
</body>
</html>