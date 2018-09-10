<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 04/09/2018
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>index</title>
</head>
<body>
    <%@ include file="header.jsp"%>

    <table border="1" style="width: 75%">
        <tr>
            <th>id</th>
            <th>Data Utworzenia</th>
            <th>Data Aktualizowania</th>
            <th>Opcje</th>
        </tr>

        <c:forEach items="${loadAllSolutions}" var="solution">
        <tr>
            <td>${solution.id}</td>
            <td>${solution.created}</td>
            <td>${solution.updated}</td>
            <td><a href="/SolutionDetails?id=${solution.id}">Szczegóły rozwiazania</a></td>
        </c:forEach>
        </tr>

    </table>

    <h4><a href ="/authServlet">Zaloguj się do Panelu Administracyjnego</a></h4>
    <%@ include file="footer.jsp"%>

</body>
</html>