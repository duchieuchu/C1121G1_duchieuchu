<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/15/2022
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <a href="/products?action=productList">Back product list</a>
</p>
<form method="post">
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="number" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><input type="text" name="description" id="description"
                       value="${requestScope["product"].getDescription()}"></td>
        </tr>
        <tr>
            <th>Brand</th>
            <td><input type="text" name="brand" id="brand" value="${requestScope["product"].getBrand()}"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="Edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
