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
    <title>Product List</title>
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
            padding: 2px;
            text-align: center;
        }

        th {
            padding: 10px;
            background-color: #04AA6D;
            color: white;
        }

        tr:hover {
            background-color: #dddddd;
        }

        .table {
            padding-top: 10px;
        }

        .button-edit {
            background-color: orange;
            font-size: 16px;
            text-decoration: none;
            width: 60px;
            height: 30px;
        }

        .button-delete {
            background-color: red;
            font-size: 16px;
            text-decoration: none;
            width: 60px;
            height: 30px;
        }
        .button-create{
            background-color: gainsboro;
            font-size: 16px;
            text-decoration: none;
            width: 150px;
            height: 30px;
            border-radius: 4px;
        }
        .create{
            padding-left: 20px;
        }
    </style>
</head>
<body>
<center>
    <h1>Product List</h1>
</center>
<a class="create" href="/products?action=create"><button class="button-create">Add New Product</button></a>
<div align="center" class="table">
    <table border="1px" width="100%"   >

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
        <c:forEach var="product" items="${productList}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td>
                    <a href="/products?action=edit&id=${product.id}"><button class="button-edit" >Edit</button></a>
<%--                 <form method="post" action="/products?action=delete&id=${product.id}"><button class="button-delete" >Delete</button></form>--%>
                    <a href="/products?action=delete&id=${product.id}"><button class="button-delete" >Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
