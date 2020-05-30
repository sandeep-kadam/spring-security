<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

<hr>
<!-- display user name and roles -->
	<p>
		User : <security:authentication property="principal.username"/>
		<br><br>
		Role(s) : <security:authentication property="principal.authorities"/>
	</p>

<!-- add a link which will points to /managers ... this is only accessible by manager roles. -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/managers"> Managers Meeting</a>
			(Only for Manager People)
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems"> System Settings</a>
			(Only for Admin People)
		</p>
	</security:authorize>
<hr>


<!-- Add logout button  -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
</form:form>

</body>
</html>