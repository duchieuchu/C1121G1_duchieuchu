<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/15/2022
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
<h1>Search Result</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Brand</th>
    </tr>
    <c:forEach var="product" items="${searchProductList}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getBrand()}</td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="/products">Back to product list</a>
</p>
</body>
</html>
