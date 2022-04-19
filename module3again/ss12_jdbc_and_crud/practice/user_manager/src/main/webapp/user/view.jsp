<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/19/2022
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<p>
    <a href="/users?action=userList">Back to user list</a>
</p>
<h1>User</h1>
<table class="table table-hover table-dark">
    <tr>
        <th>Id</th>
        <td>${user.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${user.name}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${user.email}</td>
    </tr>
    <tr>
        <th>Country</th>
        <td>${user.country}</td>
    </tr>
</table>
</body>
</html>
