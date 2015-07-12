<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 23.02.2015
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Подтверждение редатирования</title>
  <link rel="stylesheet" href="/resources/css/main.css"/>
</head>
<body>
${success}
<br/>
<br/>
Перейти к <a href="<c:url value='/bars' />">списку шоколадок</a>

</body>

</html>