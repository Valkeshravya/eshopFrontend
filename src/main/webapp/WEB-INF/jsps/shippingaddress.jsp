<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sh" %>
     <%@ include file="userheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sh:form action="shipadd" modelAttribute="shi" method="post" >
HouseNumber<sh:input path="apartmentnumber"/>
StreetName<sh:input path="streetname"/>
City<sh:input path="city"/>
State<sh:input path="state"/>
Country<sh:input path="country"/>
Pincode<sh:input path="zipcode"/>
<input type="submit" value="NEXT">
</sh:form>
</body>
</html>