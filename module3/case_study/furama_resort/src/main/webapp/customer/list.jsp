<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/21/2022
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <title>Customers Management Application</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers?action=create">Add New Customer</a>
    </h2>
    <form action="/customers?action=search" method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="search" placeholder="search">
        <input type="submit" value="Search">
    </form>
</center>

<div align="center">
    <table border="1" cellpadding="5" id="example" class="table table-striped table-bordered">
        <caption><h2>List of Customers</h2></caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>CustomerType</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>IdCard</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="users" items="${listCustomer}">
            <tr>
                <td><c:out value="${customers.id}"/></td>
                <td><c:out value="${customers.customerType}"/></td>
                <td><c:out value="${customers.name}"/></td>
                <td><c:out value="${customers.birthday}"/></td>
                <td><c:out value="${customers.gender}"/></td>
                <td><c:out value="${customers.idCard}"/></td>
                <td><c:out value="${customers.phone}"/></td>
                <td><c:out value="${customers.email}"/></td>
                <td><c:out value="${customers.address}"/></td>
                <td>
                    <a href="/customers?action=edit&id=${customers.id}">Edit</a>
                    <a href="/customers?action=delete&id=${customers.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
