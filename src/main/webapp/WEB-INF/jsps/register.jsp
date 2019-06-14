<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="userheader.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="uform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<uform:form class="form-inline" action="addUser"  method="post" modelAttribute="usr">
 <div class="form-group">
EMAILID<uform:input  path="email" class="form-control"/>
</div>
<br>
 <div class="form-group">
PASSWORD<uform:input  path="password" class="form-control"/>
</div>
 <div class="form-group">
USERNAME<uform:input  path="userName" class="form-control"/>
</div>
 <div class="form-group">
MOBILE_NUMBER<uform:input  path="mobile" class="form-control"/>
</div>
 <div class="form-group">
SHIPPING_ADDRESS
HOUSE_NUMBER<uform:input  path="shippingAddress.apartmentnumber" class="form-control"/><br>
STREET<uform:input  path="shippingAddress.streetname" class="form-control"/><br>
CITY<uform:input  path="shippingAddress.city" class="form-control"/><br>
STATE<uform:input  path="shippingAddress.state" class="form-control"/><br>
COUNTRY<uform:input  path="shippingAddress.country" class="form-control"/><br>
PINCODE<uform:input  path="shippingAddress.zipcode" class="form-control"/><br>
</div>

<input type="submit" value="Submit"/>
</uform:form>
</body>
</html>