<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gamma
  Date: 02-03-2020
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shoppinglist</title>
</head>
<body>
    ${sessionScope.msg}
    <h1>login successful</h1>
    <form action="addItemServlet" method="post">
        <label form="title">Add item</label><br>
        <input type="text" id="item" name="item"><br>
        <input type="submit" value="Add item">
    </form>

    <br>
    <br>
    ${requestScope.msg}
    <h2>Shopping list</h2>
    <c:forEach var="element" items="${sessionScope.basket}">
        ${element}
        <br>
    </c:forEach>
</body>
</html>
