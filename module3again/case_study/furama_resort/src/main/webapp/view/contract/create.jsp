<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/26/2022
  Time: 9:21 AM
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
    <a href="/contracts?action=contractList">Back to contract list</a>
</p>
<h1>Add contract</h1>
<form method="post">
    <table class="table table-hover table-dark">
        <tr>
            <th>StartDate</th>
            <td><input type="datetime-local" name="startDate" id="startDate" placeholder="Enter StartDate" required></td>
        </tr>
        <tr>
            <th>endDate</th>
            <td><input type="datetime-local" name="endDate" id="endDate" placeholder="Enter EndDate" required></td>
        </tr>
        <tr>
            <th>Deposit</th>
            <td><input type="number" name="deposit" id="deposit" placeholder="Enter Deposit" required></td>
        </tr>
        <tr>
            <th>TotalMoney</th>
            <td><input type="number" name="totalMoney" id="totalMoney" placeholder="Enter TotalMoney" required></td>
        </tr>
        <tr>
            <th>EmployeeName</th>
            <td>
                <select name="employee">
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.id}"><c:out
                                value="${employee.name}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>CustomerName</th>
            <td>
                <select name="customer">
             <c:forEach items="${customers}" var="customer">
                 <option value="${customer.id}">
                     <c:out value="${customer.name}"></c:out>
                 </option>
             </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>ServiceName</th>
            <td>
                <select name="service">
                    <c:forEach items="${services}" var="service">
                        <option value="${service.id}"><c:out
                                value="${service.name}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
