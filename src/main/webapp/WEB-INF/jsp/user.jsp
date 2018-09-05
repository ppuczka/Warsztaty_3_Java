<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 05/09/2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>user</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <h4>Id użytkownika: ${user.id}</h4>
    <h4>Nazwa użytkownika: ${user.username}</h4>
    <h4>Adres e-mail: ${user.email}</h4><br>

    <h3>Lista rozwiązań dodanych przez użytkownika ${user.username}: </h3><br>

    <table border="1" style="width: 75%">
        <tr>
            <th>Id</th>
            <th>Data utwożenia</th>
            <th>Data aktualizacji</th>
            <th>Opis</th>
        </tr>
        <c:forEach items="${userSolutions}" var="sol">
        <tr>
            <td>${sol.id}</td>
            <td>${sol.created}</td>
            <td>${sol.updated}</td>
            <td>${sol.description}</td>
        </tr>
        </c:forEach>
    </table>

    <%@include file="footer.jsp"%>
</body>
</html>
