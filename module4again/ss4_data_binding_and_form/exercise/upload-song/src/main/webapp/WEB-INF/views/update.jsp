<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/update" modelAttribute="song" method="post">
    <table>
        <tr>
            <th>Name Song</th>
            <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
            <th>Name singer</th>
            <td><form:input type="text" path="singer"/></td>
        </tr>
        <tr>
            <th>TypeMusic</th>
            <td><form:input type="text" path="typeMusic"/></td>
        </tr>
        <tr>
            <th>pathSong</th>
            <td><form:input type="text" path="pathSong"/></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
