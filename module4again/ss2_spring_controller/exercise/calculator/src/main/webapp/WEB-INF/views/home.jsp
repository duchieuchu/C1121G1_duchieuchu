<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/16/2022
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="get">
    <input type="number" name="number1">
    <input type="number" name="number2">
    <br><br>
    <input type="submit" name="calculate" value="Addition(+)">
    <input type="submit" name="calculate" value="Subtraction(-)">
    <input type="submit" name="calculate" value="Multiplication(x)">
    <input type="submit" name="calculate" value="Division(/)">

</form>
<h1>${result}</h1>
</body>
</html>
