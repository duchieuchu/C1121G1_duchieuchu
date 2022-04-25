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

</head>
<body>
<p>
    <a href="/customers?action=customerList">Back to customer list</a>
</p>
<h1>Add customer</h1>
<form method="post">
    <table class="table table-hover table-dark">
        <tr>
            <th>CustomerCode</th>
            <td><input type="text" name="customerCode" id="customerCode" placeholder="Enter CustomerCode" required ></td>
            <p style="color:red;">${error.get("customerCode")}</p>
        </tr>
        <tr>
            <th>CustomerType</th>
            <td>
                <select name="customerType">
                    <c:forEach items="${customerTypes}" var="customerType">
                        <option value="${customerType.customerTypeId}"><c:out
                                value="${customerType.customerTypeName}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" id="name" placeholder="Enter Name" required></td>
        </tr>
        <tr>
            <th>Birthday</th>
            <td><input type="date" name="birthday" id="birthday"  placeholder="Enter Birthday" required></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td>
                <select name="gender">
                    <option value="0">Nam</option>
                    <option value="1">Nữ</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>IdCard</th>
            <td><input type="number" name="idCard" id="idCard" placeholder="Enter IdCard" required></td>
            <p style="color:red;">${error.get("idCard")}</p>
        </tr>
        <tr>
            <th>Phone</th>
            <td><input type="number" name="phone" id="phone" placeholder="Enter Phone" required></td>
            <p style="color:red;">${error.get("phone")}</p>
        </tr>
        <tr>
            <th>Email</th>
            <td><input type="text" name="email" id="email" placeholder="Enter Email" required></td>
            <p style="color:red;">${error.get("email")}</p>
        </tr>
        <tr>
            <th>Address</th>
            <td><input type="text" name="address" id="address" placeholder="Enter Address" required></td>
        </tr>
        <tr>
            <th></th>
            <td><input class="btn btn-primary" type="submit" value="create"></td>
        </tr>

    </table>
</form>
</body>
</html>
