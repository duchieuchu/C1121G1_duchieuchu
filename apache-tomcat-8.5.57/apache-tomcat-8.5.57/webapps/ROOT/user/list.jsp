<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/16/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<h1>User Management</h1>
<h2>
    <a href="/users?action=create">Add New User</a>
</h2>
<center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr>
                    <td><c:out value="${users.id}"/></td>
                    <td><c:out value="${users.name}"/></td>
                    <td><c:out value="${users.email}"/></td>
                    <td><c:out value="${users.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${users.id}">Edit</a>
                        <a href="/users?action=delete&id=${users.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</center>
</body>
</html>
