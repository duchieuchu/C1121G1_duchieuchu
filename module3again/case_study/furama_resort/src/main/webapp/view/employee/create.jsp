<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/24/2022
  Time: 9:17 PM
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
    <a href="/employees?action=employeeList">Back to employee list</a>
</p>
<h1>Add Employee</h1>
<form method="post">
    <table class="table table-hover table-dark">
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="name" placeholder="Enter Name" required></td>
        </tr>
        <tr>
            <th>Birthday</th>
            <td><input type="date" name="birthday" id="birthday" placeholder="Enter Birthday" required></td>
        </tr>
        <tr>
            <th>IdCard</th>
            <td><input type="number" name="idCard" id="idCard"  placeholder="Enter IdCard" required></td>
        </tr>
        <tr>
            <th>Salary</th>
            <td><input type="number" name="salary" id="salary"  placeholder="Enter Salary" required></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><input type="number" name="phone" id="phone"   placeholder="Enter Phone" required></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><input type="text" name="email" id="email"  placeholder="Enter Email" required></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><input type="text" name="address" id="address"  placeholder="Enter Address" required></td>
        </tr>
        <tr>
            <th>Position</th>
            <td>
                <select name="position">
                    <c:forEach items="${positions}" var="position">
                        <option value="${position.positionId}"><c:out value="${position.positionName}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>EducationDegree</th>
            <td>
                <select name="educationDegree">
                    <c:forEach items="${educationDegrees}" var="educationDegree">
                        <option value="${educationDegree.educationDegreeId}"><c:out value="${educationDegree.educationDegreeName}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Division</th>
            <td>
                <select name="division">
                    <c:forEach items="${divisions}" var="division">
                        <option value="${division.divisionId}"><c:out value="${division.divisionName}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th></th>
            <td><input class="btn btn-primary" type="submit" value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
