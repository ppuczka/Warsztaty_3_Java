<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 05/09/2018
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>admGroups</title>
</head>
<body>
    <table border="1" style="width: 75%"><br>
        <h3>Lista wszystkich grup</h3>
        <tr>
            <th>Nazwa Grupy</th>
            <th>Id</th>

        </tr>
        <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.groupId}</td>
            <td>${group.name}</td>
            <td><a href="/manage?id=${group.groupId}">Edytuj/Usuń</a></td>

        </tr>
        </c:forEach>

    </table>
        <br>
        <a href="/manage?id=0">Dodaj nową grupę</a><br>

        <%@include file="footer.jsp"%>

</body>
</html>
