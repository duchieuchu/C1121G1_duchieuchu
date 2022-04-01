<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2022
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
--%><%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url("https://www.color-hex.com/palettes/104061.png");
        }
    </style>
</head>
<body>
<h2>
    <a href="products?action=productList">Back List Product</a>
</h2>
<div align="center">
    <form method="post">
        <h1> Edit Product Information</h1>
        <table border="1" cellpadding="9">
            <c:if test="${product != null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' />"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"/>
                </td>
            </tr>

            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="45"
                           value="<c:out value='${product.quantity}' />"/>
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" size="45"
                           value="<c:out value='${product.color}' />"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${product.description}' />"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <input type="text" name="category" size="45"
                           value="<c:out value='${product.category}' />"/>
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
