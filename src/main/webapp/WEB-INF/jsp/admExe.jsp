<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  UserDao: vampirec
  Date: 06/09/2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admExe</title>
</head>
<body>
<%@include file="headerAdm.jsp"%>
<table border="1" style="width: 75%"><br>
    <h3>Lista wszystkich zadań:</h3>
    <tr>
        <th>Id zadania</th>
        <th>Tytuł zadania</th>
        <th>Opis zadania</th>

    </tr>
    <c:forEach items="${exe}" var="ex">
        <tr>
            <td>${ex.id}</td>
            <td>${ex.title}</td>
            <td>${ex.description}</td>
            <td><a href="/manageExe?id=${ex.id}">Edytuj/Usuń</a></td>

        </tr>
    </c:forEach>

</table>
<br>
<a href="/manageExe?id=0">Dodaj nowe zadanie</a><br>

<%@include file="footer.jsp"%>

</body>
</html>
