<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/21/2022
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-image: url("https://www.color-hex.com/palettes/104061.png");
        }
    </style>
</head>
<body>
<h2>
    <a href="customer?action=customerList">Back List Customer</a>
</h2>
<div align="center">
    <form method="post" >
        <h1>Customer Information</h1>
        <table border="1" cellpadding="9" >
        <tr>
            <th>customerType</th>
            <td>
                <select name="customerType">
                    <c:forEach var="customerType" items="${customerTypes}">
                        <option value="${customerType.customerTypeId}"><c:out value="${customerType.customerTypeName}"></c:out></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>name</th>
            <td>
                <input type="text" name="name" id="name" size="45" required>
            </td>
        </tr>
        <tr>
            <th>birthday</th>
            <td>
                <input type="date" name="birthday" id="birthday" size="45" required>
            </td>
        </tr>
        <tr>
            <th>gender</th>
            <td>
                <select name="gender">
                    <option value="0">Nam</option>
                    <option value="1">Nứ</option>

                </select>
            </td>
        </tr>
        <tr>
            <th>idCard</th>
            <td>
                <input type="text" name="idCard" id="idCard" size="45" required>
            </td>
        </tr>
        <tr>
            <th>phone</th>
            <td>
                <input type="text" name="phone" id="phone" size="45" required>
            </td>
        </tr>
        <tr>
            <th>email</th>
            <td>
                <input type="text" name="email" id="email" size="45" required>
            </td>
        </tr>
        <tr>
            <th>address</th>
            <td>
                <input type="text" name="address" id="address" size="45" required>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
        </tr>
        </table>
    </form>
</div>
</body>
</html>
