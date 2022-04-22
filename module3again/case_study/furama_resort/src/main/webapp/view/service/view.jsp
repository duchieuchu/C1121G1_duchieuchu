<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/22/2022
  Time: 10:15 AM
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
    <a href="/services?action=serviceList">Back to service list</a>
</p>
<h1>Customer</h1>
<table class="table table-hover table-dark">
    <tr>
        <th>Id</th>
        <td>${service.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${service.name}</td>
    </tr>
    <tr>
        <th>Area</th>
        <td>${service.area}</td>
    </tr>
    <tr>
        <th>Cost</th>
        <td>${service.cost}</td>
    </tr>
    <tr>
        <th>MaxPeople</th>
        <td>${service.maxPeople}</td>
    </tr>
    <tr>
        <th>RentalType</th>
        <td>${service.rentalType.rentalTypeName}</td>
    </tr>
    <tr>
        <th>ServiceType</th>
        <td>${service.serviceType.serviceTypeName}</td>
    </tr>
    <tr>
        <th>StandardRoom</th>
        <td>${service.standardRoom}</td>
    </tr>
    <tr>
        <th>DescriptionOtherConvenience</th>
        <td>${service.descriptionOtherConvenience}</td>
    </tr>
    <tr>
        <th>PoolArea</th>
        <td>${service.poolArea}</td>
    </tr>
    <tr>
        <th>NumberOfFloors</th>
        <td>${service.numberOfFloors}</td>
    </tr>
</table>
</body>
</html>
