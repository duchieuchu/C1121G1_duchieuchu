<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/6/2022
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><a href="/student/list">back list student</a></h2>
<h1>Create student</h1>
<form:form action="" modelAttribute="student" method="post">
    <table class="table table-hover table-dark">
        <tr>
            <th>Name</th>
            <td><form:input type="text" path="name"></form:input></td>
        </tr>
        <tr>
            <th>DateOfBirth</th>
            <td><form:input type="date" path="dateOfBirth"></form:input></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="create"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
