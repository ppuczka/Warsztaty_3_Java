<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 04/09/2018
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.coderslab.model.Solution"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<%@include file="header.jsp"%>

    <h4>Id rozwiązania:</h4> ${solution.id} <br>
    <h4>Id użytkownika: </h4> ${solution.users_id} <br>
    <h4>Id ćwiczenia: </h4>${solution.exercise_id} <br>
    <h4>Opis: </h4> ${solution.description}</h4>

<%@ include file="footer.jsp"%>

</body>
</html>
