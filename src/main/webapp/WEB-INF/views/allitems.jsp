<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>University Enrollments</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Items</h2>
	<table>
		<tr>
			<td>NAME</td><td>FactoryId</td><td>Date</td>
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
			<td><a href="<c:url value='/delete-${item.id}-item' />">${item.name}</a></td>
			<td>${item.factoryId}</td>
			<td>${item.date}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Item</a>
</body>
</html>