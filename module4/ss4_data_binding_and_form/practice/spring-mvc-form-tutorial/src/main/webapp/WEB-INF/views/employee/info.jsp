<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 1:41 PM
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
<h2>Submitted Employee Information</h2>
<table class="table table-hover table-dark">
    <tr>
        <td>ID</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>ContractNumber</td>
        <td>${contactNumber}</td>
    </tr>
</table>
</body>
</html>
