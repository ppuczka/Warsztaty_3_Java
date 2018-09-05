<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 05/09/2018
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editGroup</title>
</head>
<body>
<%@include file="header.jsp"%>
   <c:choose>
   <c:when test="${id != 0}"> >

    <h5>Podaj nową nazwę dla grupy o id ${id}:</h5>
        <form method="post" action="/admGroup">

            <input type="hidden" value="${id}" name="id">
            <input type="text" value="Nazwa grupy" name="groupName">
            <input type="submit" value="Zatwierdź">

        </form>
       </c:when>

    <c:otherwise>
    <h5>Podaj nazwę nowej grupy</h5>
        <form method="post" action="/admGroup">

            <input type="hidden" value="${id}" name="id">
            <input type="text" value="Nazwa grupy" name="groupName">
            <input type="submit" value="Zatwierdź">

        </form>
    </c:otherwise>
    </c:choose>

<%@include file="footer.jsp"%>
</body>
</html>
