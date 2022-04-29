<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/27/2022
  Time: 6:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
//19-21
</head>
<body>
<p>
    <a href="/rooms?action=roomList">Back to customer list</a>
</p>
<h1>Add Room</h1>
<form method="post">
    <table class="table table-hover table-dark">
        <tr>
            <th>UserName</th>
            <td><input type="text" name="userName" id="userName" placeholder="Enter userName" required></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><input type="text" name="phone" id="phone" placeholder="Enter phone" required></td>
        </tr>
        <tr>
            <th>CheckIn</th>
            <td><input type="date" name="checkIn" id="checkIn"  required></td>
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
            <th>OtherInfo</th>
            <td><input type="text" name="otherInfo" id="otherInfo" placeholder="Enter otherInfo" required></td>
        </tr>
        <tr>
            <th></th>
            <td><input class="btn btn-primary" type="submit" value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
