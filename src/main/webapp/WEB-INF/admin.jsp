<%--
  Created by IntelliJ IDEA.
  User: gamma
  Date: 02-03-2020
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h1>Admin page</h1>

    <p style="color: red">${requestScope.msg}</p>
    <form action="AdminServlet" method="post">
        <label form="title">Delete user</label><br>
        <input type="text" id="username" name="name"><br>
        <input type="submit" value="Delete">
    </form>

    <c:forEach var="element" items="${applicationScope.userMap}">
        ${element}
        <br>
    </c:forEach>
</body>
</html>
