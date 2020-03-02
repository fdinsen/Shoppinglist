<%--
  Created by IntelliJ IDEA.
  User: gamma
  Date: 02-03-2020
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
    <p style="color: red">${requestScope.msg}</p>
    <h1>Create user:</h1>
    <form action="CreateUserServlet" method="post">
        <label form="frame">Username:</label>
        <input type="text" id="uname" name="name"><br>
        <label form="frame">Password:</label>
        <input type="text" id="passwd" name="passwd"><br>
        <input type="submit" value="Create User">
    </form>

</body>
</html>
