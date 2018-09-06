<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 06/09/2018
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admUsers</title>
</head>
<body>
<%@include file="headerAdm.jsp"%>
<table border="1" style="width: 75%"><br>
    <h3>Lista wszystkich użytkowników:</h3>
    <tr>
        <th>Id użytkownika</th>
        <th>Nazwa użytkownika</th>
        <th>Adres e-mail</th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><a href="/manageUser?id=${user.id}">Edytuj/Usuń</a></td>

        </tr>
    </c:forEach>

</table>
<br>
<a href="/manageUser?id=0">Dodaj nowego użytkownika</a><br>

<%@include file="footer.jsp"%>

</body>
</html>
