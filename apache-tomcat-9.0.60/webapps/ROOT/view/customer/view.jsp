<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/21/2022
  Time: 11:21 AM
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
    <a href="/customers?action=customerList">Back to customer list</a>
</p>
<h1>Customer</h1>
<table class="table table-hover table-dark">
    <tr>
        <th>Id</th>
        <td>${customer.id}</td>
    </tr>
    <tr>
        <th>CustomerType</th>
        <td>${customer.customerType.customerTypeName}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${customer.name}</td>
    </tr>
    <tr>
        <th>Birthday</th>
        <td>${customer.birthday}</td>
    </tr>
    <tr>
        <th>Gender</th>
        <td>${customer.gender}</td>
    </tr>
    <tr>
        <th>IdCard</th>
        <td>${customer.idCard}</td>
    </tr>
    <tr>
        <th>Phone</th>
        <td>${customer.phone}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${customer.email}</td>
    </tr>
    <tr>
        <th>Address</th>
        <td>${customer.address}</td>
    </tr>
</table>
</body>
</html>
