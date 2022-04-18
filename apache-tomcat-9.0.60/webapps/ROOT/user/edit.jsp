<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/18/2022
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/users?action=userList">Back to user list</a>
</p>
<form method="post" action="/users?action=edit">
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="name" required></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><input type="text" name="email" id="email" required></td>
        </tr>
        <tr>
            <th>Country</th>
            <td><input type="text" name="country" id="country" required></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
