<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 04/09/2018
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>allGroups</title>
</head>
<%@include file="headerAdm.jsp"%>
    <table border="1" style="width: 75%">
        <tr>

            <th>Nazwa Grupy</th>
            <th>Id</th>
        </tr>
            <c:forEach items="${allGroups}" var="group">
        <tr>
            <td>${group.groupId}</td>
            <td>${group.name}</td>
            <td><a href="/UserGroup?id=${group.groupId}">Wyświetl listę użytkowników</a></td>
        </tr>
            </c:forEach>
    </table>

<body>


</body>
</html>
