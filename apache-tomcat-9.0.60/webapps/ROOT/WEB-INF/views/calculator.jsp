<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2022
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Calculator</h1>
    <form action="/calculator" method="get">
        <input type="number" name="number1">
        <input type="number" name="number2">
        <br><br>
        <input type="submit" name="calculator" value="Addition(+)">
        <input type="submit" name="calculator" value="Subtraction(-)">
        <input type="submit" name="calculator" value="Multiplication(X)">
        <input type="submit" name="calculator" value="Division(/)">
    </form>
</div>
<div>
    ${show}
    ${result}
</div>
</body>
</html>
