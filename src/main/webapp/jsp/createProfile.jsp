<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

User's Locale : <c:out value="${locale}"/>

<h1> User Registration form </h1> <br/>

<form:errors path="*" cssClass="error" />

<form:form method="POST" commandName="user">
	<table>
		<tr>
			<td>Email Addresse :</td>
			<td><form:input path="emailAddress" /></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
		</tr>

		<tr>
			<td>Confirm Password :</td>
			<td><form:password path="confirmPassword" /></td>
		</tr>

		<tr>
			<td>First Name :</td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><form:input path="lastName" /></td>
		</tr>

		<tr>
			<td>Gender :</td>
			<td><form:radiobutton path="gender" value="M" label="Male" /> <form:radiobutton
				path="gender" value="F" label="Female" /></td>
		</tr>

		<tr>
			<td>Address :</td>
			<td><form:input path="address" /></td>
		</tr>

		<tr>
			<td>City :</td>
			<td><form:input path="city" /></td>
		</tr>
		<tr>
			<td>Zip Code :</td>
			<td><form:input path="zip" /></td>
		</tr>


		<tr>
			<td>State :</td>
			<td><form:select path="state">
				<form:option value="0" label="Select" />
				<form:options items="${stateList}" itemValue="stateId"
					itemLabel="stateName" />
			</form:select></td>
		</tr>


		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>

</body>
</html>