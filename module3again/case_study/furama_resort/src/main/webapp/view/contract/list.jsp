<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/26/2022
  Time: 9:20 AM
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
<h1>Contract list</h1>
<p>
    <a href="/contracts?action=create">Create new contract</a>
</p>
<table id="tableCustomer" class="table table-hover table-dark">
    <tr>
        <th class="col-1">Id</th>
        <th class="col-2">StartDate</th>
        <th class="col-2">EndDate</th>
        <th class="col-1">Deposit</th>
        <th class="col-1">TotalMoney</th>
        <th class="col-1">EmployeeName</th>
        <th class="col-2">CustomerName</th>
        <th class="col-2">ServiceName</th>
    </tr>
    <c:forEach items="${listContract}" var="contract">
        <tr>
            <td>${contract.id}</td>
            <td>${contract.startDate}</td>
            <td>${contract.endDate}</td>
            <td>${contract.deposit}</td>
            <td>${contract.totalMoney}</td>
            <td>${contract.employee.name}</td>
            <td>${contract.customer.name}</td>
            <td>${contract.service.name}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
