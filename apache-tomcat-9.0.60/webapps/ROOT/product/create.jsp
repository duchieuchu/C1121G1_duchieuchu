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
<h1>Create new product</h1>
<p>
    <a href="/products?action=productList">Back List Product</a>
</p>
<form method="post" action="/products?action=create">
    <table>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <th>Brand</th>
            <td><input type="text" name="brand"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit"  value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
