<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 5:06 PM
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
    <tr>
        <td>language</td>
        <td>${language}</td>
    </tr>
    <tr>
        <td>pageSize</td>
        <td>${pageSize}</td>
    </tr>
    <tr>
        <td>spamsFilter</td>
        <td>${spamsFilter}</td>
    </tr>
    <tr>
        <td>signNature</td>
        <td>${signNature}</td>
    </tr>
</table>
</body>
</html>
