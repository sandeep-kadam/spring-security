<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom Login Form</title>

<style>
.errors{
	color : red;
}

</style>
</head>
<body>

<h3> Custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	
	<c:if test="${param.error != null}">
		<i class="errors">Sorry! Invalid username/password.</i>
	</c:if>
	
	<p>
		User name : <input type="text" name="username">
	</p>
	
	<p>
		Password : <input type="password" name="password">
	</p>
	
	<input type="submit" value="Login">
</form:form>

</body>
</html>