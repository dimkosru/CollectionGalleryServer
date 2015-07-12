<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 23.02.2015
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Редактирвоание шоколадки</title>
  <link rel="stylesheet" href="/resources/css/main.css"/>

</head>

<body>

<h2>Редактирование</h2>
<form:form method="POST" modelAttribute="bar">

  <img src="/resources/original/${bar.id}.png" height="500" alt=""/>
  <table>
    <tr>
      <td><label for="id">id: </label> </td>
      <td><form:input path="id" id="id"/></td>
      <td><form:errors path="id" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="name">Название: </label> </td>
      <td><form:input path="name" id="name"/></td>
      <td><form:errors path="name" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="date">Дата изготовления: </label> </td>
      <td><form:input path="date" id="date"/></td>
      <td><form:errors path="date" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="weight">Масса: </label> </td>
      <td><form:input path="weight" id="weight"/></td>
      <td><form:errors path="weight" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="additional">Комментарий: </label> </td>
      <td><form:input path="additional" id="additional"/></td>
      <td><form:errors path="additional" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="brand">Изготовитель: </label> </td>
      <td><form:input path="brand" id="brand"/></td>
      <td><form:errors path="brand" cssClass="error"/></td>
    </tr>

    <tr>
      <td colspan="3"><input type="submit" value="Сохранить"/></td>
    </tr>
  </table>
</form:form>
<br/>
<br/>
Перейти к <a href="<c:url value='/bars' />">списку шоколадок</a>
</body>
</html>