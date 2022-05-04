<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2022
  Time: 11:21 AM
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
<table class="table table-hover table-dark">
    <thead>
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>RequestParam</th>
        <th>PathVariable</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.dateOfBirth}</td>
            <td><a href="/student/detail?id=${student.id}">Detail (RP)</a></td>
            <td><a href="/student/detail/${student.id}">Detail (PV)</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
