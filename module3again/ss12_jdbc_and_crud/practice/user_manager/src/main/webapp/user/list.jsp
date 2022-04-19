<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/18/2022
  Time: 11:29 AM
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
<h1>User List</h1>
<p>
    <a href="/users?action=create">Create new user</a>
</p>
<form method="get" action="/users">
    <input type="hidden" name="action" value="search">
    <input type="text" name="country" placeholder="enter country">
    <input type="submit" value="search">
</form>
<table class="table table-hover table-dark">
    <tr>
        <th class="col-1">#</th>
        <th class="col-1">Id</th>
        <th class="col-2">Name</th>
        <th class="col-3">Email</th>
        <th class="col-3">Country</th>
        <th class="col-1">Edit</th>
        <th class="col-1">Delete</th>
    </tr>

    <c:forEach items="${listUser}" var="user" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${user.id}</td>
            <td><a href="/users?action=view&id=${user.id}">${user.name}</a></td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/users?action=edit&id=${user.id}">edit</a></td>
            <td><a href="/users?action=delete&id=${user.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
