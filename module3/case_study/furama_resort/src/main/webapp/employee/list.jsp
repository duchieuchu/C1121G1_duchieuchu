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
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body{
            background-image: url("https://www.color-hex.com/palettes/8887.png");
        }
        .add-button{
            padding-left: 1000px;
        }
    </style>
</head>
<body>
<center>
    <h2>List of Employees</h2>
    <h4>
        <a class="add-button" href="/employee?action=create">Add New Employee</a>
    </h4>
    <%--    <form action="/customers?action=search" method="get">--%>
    <%--        <input type="hidden" name="action" value="search">--%>
    <%--        <input type="text" name="search" placeholder="search">--%>
    <%--        <input type="submit" value="Search">--%>
    <%--    </form>--%>
</center>

<div align="center">
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>IdCard</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>EducationDegree</th>
            <th>Division</th>
            <th>UserName</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="employees" items="${listEmployee}">
            <tr>
                <td><c:out value="${employees.id}"/></td>
                <td><c:out value="${employees.name}"/></td>
                <td><c:out value="${employees.birthday}"/></td>
                <td><c:out value="${employees.idCard}"/></td>
                <td><c:out value="${employees.salary}"/></td>
                <td><c:out value="${employees.phone}"/></td>
                <td><c:out value="${employees.email}"/></td>
                <td><c:out value="${employees.address}"/></td>
                <td><c:out value="${employees.position.positionName}"/></td>
                <td><c:out value="${employees.educationDegree.educationDegreeName}"/></td>
                <td><c:out value="${employees.division.divisionName}"/></td>
                <td><c:out value="${employees.userName}"/></td>

                <td>
                    <a href="/employee?action=edit&id=${employees.id}">Edit</a>
                    <a href="/employee?action=delete&id=${employees.id}">Delete</a>
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
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
</html>