<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  UserDao: vampirec
  Date: 06/09/2018
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editUser</title>
</head>
<body>

<%@include file="headerAdm.jsp"%>

<c:choose>
    <c:when test="${id != 0}"> >

        <h5>Podaj nową nazwę dla użytkownika o id ${id}:</h5>
        <form method="post" action="/admUser">

            <input type="hidden" value="${id}" name="id">
            <input type="text" value="Nazwa użytkownika" name="userName">
            <input type="email" value="Adres e-mail" name="email">
            <input type="text" value="Hasło" name="pass">
            <input type="submit" value="Zatwierdź"><br>

                <%--zastanów się jak dodać funkcję usunięcia grupy --%>

        </form>
    </c:when>

    <c:otherwise>
        <h5>Podaj nazwę oraz adres e-mail nowego użytkownika</h5>
        <form method="post" action="/admUser">

            <input type="hidden" value="${id}" name="id">
            <input type="text" value="Nazwa użytkownika" name="userName">
            <input type="email" value="Adres e-mail" name="email">
            <input type="text" value="Hasło" name="pass">
            <input type="submit" value="Zatwierdź">

        </form>
    </c:otherwise>
</c:choose>

<%@include file="footer.jsp"%>
</body>
</html>
