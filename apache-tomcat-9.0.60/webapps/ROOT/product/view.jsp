<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/15/2022
  Time: 10:05 AM
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
    <a href="/products?action=productList">Back list product</a>
</p>
<h1>Product</h1>
<table class="table table-hover table-dark">

    <tr>
        <th>Id: </th>
        <td>${requestScope["product"].getId()}</td>
    </tr>
    <tr>
        <th>Name: </th>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <th>Price: </th>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <th>Description: </th>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
    <tr>
        <th>Brand: </th>
        <td>${requestScope["product"].getBrand()}</td>
    </tr>
</table>
</body>
</html>
