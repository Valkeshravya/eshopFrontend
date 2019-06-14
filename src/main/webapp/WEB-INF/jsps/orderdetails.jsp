<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="o" %>
    <%@page isELIgnored="false" %>
    <%@ include file="userheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${sh.date}
${sh.grandTotal}
${sh.user.shippingAddress.apartmentnumber}
${sh.user.email}
</body>
</html>