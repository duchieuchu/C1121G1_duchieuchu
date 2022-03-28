<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2022
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-image: url("https://www.color-hex.com/palettes/104061.png");
        }
    </style>
</head>
<body>
<h2>
    <a href="product?action=productList">Back List Product</a>
</h2>
<div align="center">
    <form method="post" >
        <h1>Product Information</h1>
        <table border="1" cellpadding="6" >
            <tr>
                <th>name</th>
                <td>
                    <input type="text" name="name" id="name" size="45" required >
                </td>
            </tr>
            <tr>
                <th>price</th>
                <td>
                    <input type="text" name="price" id="price" size="45" required>
                </td>
            </tr>
            <tr>
                <th>quantity</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45" required>
                </td>
            </tr>
            <tr>
                <th>color</th>
                <td>
                    <input type="text" name="color" id="color" size="45" required>
                </td>
            </tr>
            <tr>
                <th>description</th>
                <td>
                    <input type="text" name="description" id="description" size="45" required>
                </td>
            </tr>
            <tr>
                <th>category</th>
                <td>
                    <input type="text" name="category" id="category" size="45" required>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
