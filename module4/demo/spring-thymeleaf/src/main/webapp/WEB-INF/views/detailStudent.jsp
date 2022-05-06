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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

</head>
<body>
<h2>Detail Student</h2>
<table class="table table-hover table-dark">

    <tr>
        <th>Id</th>
        <td>${student.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${student.name}</td>
    </tr>
    <tr>
        <th>dateOfBirth</th>
        <td>${student.dateOfBirth}</td>
    </tr>
</table>
</body>
</html>
