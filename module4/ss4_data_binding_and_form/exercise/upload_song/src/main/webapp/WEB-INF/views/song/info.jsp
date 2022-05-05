<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 7:17 PM
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
<h2>Uploaded Song Information</h2>
<table class="table table-hover table-dark">
    <tr>
        <td>name:</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>singer:</td>
        <td>${singer}</td>
    </tr>
    <tr>
        <td>kindOfMusic:</td>
        <td>${kindOfMusic}</td>
    </tr>
    <tr>
        <td>filePath:</td>
        <td><a href="${filePath}">${filePath}</a></td>
    </tr>
</table>
</body>
</html>
