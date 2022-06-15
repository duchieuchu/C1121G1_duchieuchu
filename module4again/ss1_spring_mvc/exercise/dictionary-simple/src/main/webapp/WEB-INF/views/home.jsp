<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome To My Dictionary</h1>
<form action="/translate" method="get">
    <table>
        <tr>
            <th>English</th>
            <td><input type="text" name="english"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="search"></td>
        </tr>
    </table>
</form>
</body>
</html>
