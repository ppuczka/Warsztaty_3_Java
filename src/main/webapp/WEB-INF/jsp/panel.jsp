<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 05/09/2018
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>panel</title>
</head>
<body>
<%@include file="header.jsp"%><br>

    <h2>Witaj w panelu administracyjnym aplikacji: </h2>

    <a href="/admGroup">Lista grup</a><br>
    <a href="">Lista użytkowników</a><br>
    <a href="">Lista zadań</a>

<%@include file="footer.jsp"%>
</body>
</html>
