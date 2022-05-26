<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/20/2022
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand" href="https://furamavietnam.com/"> <img src="https://gohola.vn/uploads/2015/02/furama.gif"
                                                                    width="50" height="60"></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/employees">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customers">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/services">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contracts?action=listContract">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<h1>Customer list</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<form method="get" action="/customers">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" placeholder="enter name">
    <input type="submit" value="search">
</form>
    <table id="tableCustomer" class="table table-hover table-dark">
    <thead>
    <tr>
        <th class="col-1">Id</th>
        <th class="col-1">CustomerCode</th>
        <th class="col-1">CustomerType</th>
        <th class="col-1">Name</th>
        <th class="col-1">Birthday</th>
        <th class="col-1">Gender</th>
<%--        <th class="col-1">IdCard</th>--%>
        <th class="col-1">Phone</th>
<%--        <th class="col-1">Email</th>--%>
        <th class="col-3">Address</th>
        <th class="col-1">Edit</th>
        <th class="col-1">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.customerCode}</td>
            <td>${customer.customerType.customerTypeName}</td>
            <td><a href="/customers?action=view&id=${customer.id}">${customer.name}</a></td>
            <td>${customer.birthday}</td>
            <td>${customer.gender==0?'Nam':'Nữ'}</td>
<%--            <td>${customer.idCard}</td>--%>
            <td>${customer.phone}</td>
<%--            <td>${customer.email}</td>--%>
            <td>${customer.address}</td>
            <td>
                <a class="btn btn-warning" href="/customers?action=edit&id=${customer.id}">edit</a>
            </td>
            <td>
                    <%--                <a href="/customers?action=delete&id=${customer.id}">delete</a>--%>
                <!-- Button trigger modal -->
                <button onclick="setIdDelete('${customer.id}')" type="button" class="btn btn-danger"
                        data-toggle="modal" data-target="#deleteModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="/customers?action=delete">
                <div class="modal-body">
                    <input type="hidden" 1name="id" id="id">
                    Are you sure ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>


<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function(){
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script>
    function setIdDelete(id) {
        document.getElementById("id").value = id;
    }
</script>
</html>
