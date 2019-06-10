<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
    <%@ page isELIgnored="false" %>
      <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form action="addsup" modelAttribute="sup" method="post">
SupplierName<sf:input path="supplierName"/>
SupplierDescription<sf:input path="supplierDescription"/>
SupplierAddress<sf:input path="supplierAddress"/>
<input type="submit"  value="${buttonName}" />
</sf:form>
</body>
</html>