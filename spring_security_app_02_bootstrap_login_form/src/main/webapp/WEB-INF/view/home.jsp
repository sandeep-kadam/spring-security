<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<h2> My Home Page!!</h2>
<hr>
<h4> Welcome to Spring Security Web Application</h4>
<br>

<!-- Add logout button  -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>

</body>
</html>