<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/22/2022
  Time: 8:26 AM
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
<h1>Add service</h1>
<form method="post">
    <table class="table table-hover table-dark">
        <tr>
            <th>ServiceCode</th>
            <td><input type="text" name="serviceCode" id="serviceCode"  placeholder="Enter ServiceCode"></td>
            <p style="color:red;">${error.get("serviceCode")}</p>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="name"  placeholder="Enter Name"></td>
        </tr>
        <tr>
            <th>Area</th>
            <td><input type="number" name="area" id="area"  placeholder="Enter Area"></td>
            <p style="color:red;">${error.get("area")}</p>
        </tr>
        <tr>
            <th>Cost</th>
            <td><input type="number" name="cost" id="cost"  placeholder="Enter Cost"></td>
        </tr>
        <tr>
            <th>MaxPeople</th>
            <td><input type="number" name="maxPeople" id="maxPeople"  placeholder="Enter MaxPeople"></td>
            <p style="color:red;">${error.get("maxPeople")}</p>
        </tr>
        <tr>
            <th>RentalType</th>
            <td>
                <select name="rentalType">
                    <c:forEach items="${rentalTypes}" var="rentalType">
                        <option value="${rentalType.rentalTypeId}"><c:out
                                value="${rentalType.rentalTypeName}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>ServiceType</th>
            <td>
                <select  name="serviceType">
                    <c:forEach items="${serviceTypes}" var="serviceType">
                        <option value="${serviceType.serviceTypeId}"><c:out
                                value="${serviceType.serviceTypeName}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>StandardRoom</th>
            <td><input type="text" name="standardRoom" id="standardRoom" placeholder="Enter StandardRoom"></td>
        </tr>
        <tr>
            <th>DescriptionOtherConvenience</th>
            <td><input type="text" name="descriptionOtherConvenience" id="descriptionOtherConvenience" placeholder="Enter other in4"></td>
        </tr>
        <tr>
            <th>PoolArea</th>
            <td><input type="number" name="poolArea" id="poolArea" placeholder="Enter PoolArea"></td>
            <p style="color:red;">${error.get("poolArea")}</p>
        </tr>
        <tr>
            <th>NumberOfFloors</th>
            <td><input type="number" name="numberOfFloors" id="numberOfFloors" placeholder="Enter NumberOfFloors"></td>
            <p style="color:red;">${error.get("numberOfFloors")}</p>
        </tr>
        <tr>
            <th></th>
            <td><input class="btn btn-primary" type="submit" value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
