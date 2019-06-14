<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="userheader.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="uform" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
EMAILID<input type="text" name="email" class="form-control"/>

PASSWORD<input type="password" name="password" class="form-control"/>
<input type="submit" value="Login"/><br>
<h1>${message}</h1>
</form>
</body>
</html>