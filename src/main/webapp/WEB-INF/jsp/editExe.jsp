<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  UserDao: vampirec
  Date: 06/09/2018
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editExie</title>
</head>
<body>

<%@include file="headerAdm.jsp"%>

<c:choose>
    <c:when test="${id != 0}"> >

        <h5>Podaj nową nazwę dla zadania o id ${id}:</h5>
        <form method="post" action="/admExe">

            <input type="hidden" value="${id}" name="id">
            <input type="text" value="Nazwa zadania" name="title">
            <input type="text" value="Opis zadania" name="description">
            <input type="submit" value="Zatwierdź"><br>

                <%--zastanów się jak dodać funkcję usunięcia grupy --%>

        </form>
    </c:when>

    <c:otherwise>
        <h5>Podaj nazwę oraz adres e-mail nowego użytkownika</h5>
        <form method="post" action="/admExe">

            <input type="hidden" value="${id}" name="id">
            <input type="text" value="Nazwa zadania" name="title">
            <input type="text" value="Opis zadania" name="description">
            <input type="submit" value="Zatwierdź"><br>
        </form>

    </c:otherwise>
</c:choose>

<%@include file="footer.jsp"%>

</body>
</html>
