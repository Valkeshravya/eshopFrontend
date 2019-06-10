<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
    <%@ include file="header.jsp" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form action="addcat" modelAttribute="cat" method="post">
CategoryName<sf:input path="categoryName"/>
CategoryDescription<sf:input path="categoryDescription"/>
<sf:input  path="categoryId" type="hidden" />
<input type="submit"  value="${buttonName}" />
</sf:form>
</body>
</html>