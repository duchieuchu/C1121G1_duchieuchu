<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2022
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management</title>
    <style>
        th, td {
            border-bottom: 1px solid #ddd;
        }
        h1 {
            padding-top: 10px;
            font-family: poppins, sans-serif;
            color: #04AA6D;
        }
        th, td {
            padding: 15px;
            text-align: center;
        }
        th {
            background-color: #04AA6D;
            color: white;
        }
        tr:hover {background-color: coral;}
        .table{
            padding-top: 20px;
            border-collapse: collapse;
        }
        
    </style>
</head>
<body>
<center>
    <h1>Product Management</h1>
</center>
<div align="center" class="table">
    <table border="1px" width="100%">

        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Description</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="products" items="${productList}">
            <tr>
                <td><c:out value="${products.id}"/></td>
                <td><c:out value="${products.name}"/></td>
                <td><c:out value="${products.price}"/></td>
                <td><c:out value="${products.quantity}"/></td>
                <td><c:out value="${products.color}"/></td>
                <td><c:out value="${products.description}"/></td>
                <td><c:out value="${products.category}"/></td>
                <td>
                    <a href="/products?action=edit&id=${products.id}">Edit</a>
                    <a href="/products?action=delete&id=${products.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
