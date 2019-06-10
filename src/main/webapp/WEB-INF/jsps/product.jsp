<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page isELIgnored="false" %>
   <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<sform:form class="form-inline" action="addPro"  method="post" modelAttribute="pro" enctype="multipart/form-data">
 <div class="form-group">
<sform:input  path="productName" class="form-control" placeholder="Enter Product Name" />
</div>
<div class="form-group">
<sform:input  path="productDescription" class="form-control" placeholder="Enter Product Description" />
</div>
<div class="form-group">
<sform:input  path="productPrice" class="form-control" placeholder="Enter Product Price" />
</div>
<div class="form-group">
ProductCategory<sform:select path="productCategory" class="form-control">
<c:forEach items="${catlist}" var="pr">
<sform:option value="${pr.categoryName}"> ${pr.categoryName}</sform:option>
 </c:forEach>
</sform:select>

</div>
<div class="form-group">
ProductSupplier<sform:select path="productSupplier" class="form-control">
<c:forEach items="${suplist}" var="prd">
<sform:option value="${prd.supplierName}"> ${prd.supplierName}</sform:option>
 </c:forEach>
</sform:select>
</div>
ProductImage<sform:input type="file" path="productImage"/>
<sform:input  path="productId" type="hidden" />
<input type="submit"  value="${buttonName}" />
</sform:form>
</body>
</html>