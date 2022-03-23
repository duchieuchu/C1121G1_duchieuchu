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
        body {
            background-image: url("https://www.color-hex.com/palettes/104061.png");
        }
    </style>
</head>
<body>
<h2>
    <a href="customer?action=customerList">Back List Customer</a>
</h2>
<div align="center">
    <form method="post">
        <h1> Edit Customer Information</h1>
        <table border="1" cellpadding="9">
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
                <th>CustomerType:</th>
                <td>
                    <select name="customerType">
                        <c:forEach var="customerType" items="${customerTypes}">
                            <c:choose>
                                <c:when test="${customerType.customerTypeId==customer.customerType.customerTypeId}">
                                    <option value="${customerType.customerTypeId}" selected><c:out value="${customerType.customerTypeName}"></c:out></option>

                                </c:when>
                                <c:otherwise>
                                    <option value="${customerType.customerTypeId}" ><c:out value="${customerType.customerTypeName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>

            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.name}' />"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="<c:out value='${customer.birthday}' />"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" size="45"
                           value="<c:out value='${customer.gender}' />"/>
                </td>
            </tr>
            <tr>
                <th>IdCard:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${customer.idCard}' />"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${customer.phone}' />"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${customer.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${customer.address}' />"/>
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
