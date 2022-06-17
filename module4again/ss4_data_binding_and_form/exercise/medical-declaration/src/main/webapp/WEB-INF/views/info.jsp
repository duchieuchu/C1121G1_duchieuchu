<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tờ Khai Y Tế </h1>
<table>
    <tr>
        <th>name</th>
        <td>${declaration.name}</td>
    </tr>
    <tr>
        <th>dateOfBirth</th>
        <td>${declaration.dateOfBirth}</td>
    </tr>
    <tr>
        <th>gender</th>
        <td>${declaration.gender==false?'Nam':'Nữ'}</td>
    </tr>
    <tr>
        <th>national</th>
        <td>${declaration.national}</td>
    </tr>
    <tr>
        <th>idCard</th>
        <td>${declaration.idCard}</td>
    </tr>
    <tr>
        <th>travelInfo</th>
        <td>${declaration.travelInfo}</td>
    </tr>
    <tr>
        <th>numberPlate</th>
        <td>${declaration.numberPlate}</td>
    </tr>
    <tr>
        <th>seatNumber</th>
        <td>${declaration.seatNumber}</td>
    </tr>
    <tr>
        <th>startDay</th>
        <td>${declaration.startDay}</td>
    </tr>
    <tr>
        <th>endDay</th>
        <td>${declaration.endDay}</td>
    </tr>
    <tr>
        <th>localArrive</th>
        <td>${declaration.localArrive}</td>
    </tr>
</table>
</body>
</html>
