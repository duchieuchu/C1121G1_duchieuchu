<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2022
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Welcome</h1>
<form action="/calculate" method="post">
    <table>
        <tr>
            <th>Rate</th>
            <td><input type="number" name="rate"></td>
        </tr>
        <tr>
            <th>USD</th>
            <td><input type="number" name="usd"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="calculate"></td>
        </tr>
<%--        <tr>--%>
<%--            <th>VND</th>--%>
<%--            <td><h1> ${vnd}</h1></td>--%>
<%--        </tr>--%>
    </table>
</form>
</body>
</html>
