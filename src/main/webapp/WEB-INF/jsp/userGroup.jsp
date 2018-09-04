<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 04/09/2018
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>userGroup</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <table border="1", style="width: 75%">
        <tr>
            <th>Id</th>
            <th>Nazwa Użytkownika</th>
            <th>e-mail</th>
        </tr>
        
        <c:forEach items="users" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>


    </table>

    <%@include file="footer.jsp"%>
</body>
</html>
