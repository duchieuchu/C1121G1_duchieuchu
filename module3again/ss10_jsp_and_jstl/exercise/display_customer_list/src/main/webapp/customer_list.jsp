<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/13/2022
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th{
            font-size: 20px;
        }
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Customer List</h1>
<table style="width: 100%">
    <tr>
        <th>Name</th>
        <th>Day of birth</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.dayOfBirth}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img style="height:60px"width="60px" src="${customer.img}" alt="picture"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
