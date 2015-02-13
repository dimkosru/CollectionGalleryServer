<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Item Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="item">
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>

			<tr>
				<td><label for="factoryId">FactoryId: </label> </td>
				<td><form:input path="factoryId" id="factoryId"/></td>
				<td><form:errors path="factoryId" cssClass="error"/></td>
			</tr>

			<tr>
				<td><label for="date">Joining Date: </label> </td>
				<td><form:input path="date" id="date"/></td>
				<td><form:errors path="date" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3"><input type="submit" value="Register"/></td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Items</a>
</body>
</html>