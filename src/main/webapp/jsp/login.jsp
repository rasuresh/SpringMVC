<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FTPC Login Page</title>

<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<h1>FTPC Landing page.</h1>
<br />
<form:form method="POST" commandName="loginform">
	<table>
		<tr>
			<td><spring:message code="field.email" />:</td>
			<td><form:input path="emailAddress" /> <form:errors
				path="emailAddress" cssClass="error" /></td>
		</tr>
		<tr>
			<td><spring:message code="field.password" />:</td>
			<td><form:password path="password" /> <form:errors
				path="password" cssClass="error" /></td>
		</tr>
		<tr>
			<td />
			<td><input type="submit" value="Login" /></td>
			<td />
			<td />
		</tr>
		<tr>
			<td> <a href="/FTPC/register.htm"> New User? Click here.</a> </td>
		</tr>
		
	</table>
</form:form>
</body>
</html>