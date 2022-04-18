<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/15/2022
  Time: 8:43 AM
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
<h1>Product</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<form action="/products" method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="search" placeholder="enter Product's name">
    <input type="submit" value="Search">
</form>

<table class="table table-hover table-dark">
    <tr>
        <td>#</td>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Brand</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product" varStatus="count">
        <tr>
            <td>${count.count}</td>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getBrand()}</td>
            <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
