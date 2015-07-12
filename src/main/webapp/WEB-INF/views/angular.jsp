<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 23.02.2015
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="collectionApp">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Все шоколадки</title>

  <script src="http://yastatic.net/jquery/2.1.4/jquery.js"></script>

  <link rel="stylesheet" href="http://yastatic.net/bootstrap/3.3.4/css/bootstrap.min.css"/>
  <script src="http://yastatic.net/bootstrap/3.3.4/js/bootstrap.js"></script>

  <script src="http://yastatic.net/angularjs/1.3.16/angular.js"></script>
  <script src="http://yastatic.net/angularjs/1.3.16/angular-route.js"></script>
  <script src="http://yastatic.net/angularjs/1.3.16/angular-resource.js"></script>
  <script src="/resources/js/app.js"></script>
  <script src="/resources/js/controllers.js"></script>
  <script src="/resources/js/services.js"></script>
  <link rel="stylesheet" href="/resources/css/main.css"/>
</head>

<body>
<div class="container-fluid">
  <div class="row">
    <div ng-view class="col-xs-12 col-sm-12 col-md-12"></div>
  </div>
</div>

</body>
</html>