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
<h1>Edit customer</h1>
<form method="post">
    <table class="table table-hover table-dark">
        <c:if test="${customer != null}">
            <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
        </c:if>
        <tr>
            <th>CustomerCode:</th>
            <td>
                <input type="text" name="customerCode"
                       value="${customer.customerCode}"/>
            </td>
        </tr>
        <tr>
            <th>CustomerType:</th>
            <td>
                <select name="customerType">
                    <c:forEach var="customerType" items="${customerTypes}">
                        <c:choose>
                            <c:when test="${customerType.customerTypeId==customer.customerType.customerTypeId}">
                                <option value="${customerType.customerTypeId}" selected><c:out
                                        value="${customerType.customerTypeName}"></c:out></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${customerType.customerTypeId}"><c:out
                                        value="${customerType.customerTypeName}"></c:out></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>
                <input type="text" name="name"
                       value="${customer.name}"/>
            </td>
        </tr>
        <tr>
            <th>Birthday:</th>
            <td>
                <input type="date" name="birthday"
                       value="${customer.birthday}"/>
            </td>
        </tr>
        <tr>
            <th>Gender:</th>
            <td>
                <select name="gender">
                    <option value="${customer.gender}">
                        <c:if test="${customer.gender==0}">
                        <p>Nam
                        <p>
                            </c:if>
                            <c:if test="${customer.gender==1}">
                        <p>Nữ
                        <p>
                            </c:if>
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <th>IdCard:</th>
            <td>
                <input type="number" name="idCard"
                       value="${customer.idCard}"/>
            </td>
        </tr>
        <tr>
            <th>Phone:</th>
            <td>
                <input type="number" name="phone"
                       value="${customer.phone}"/>
            </td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>
                <input type="text" name="email"
                       value="${customer.email}"/>
            </td>
        </tr>
        <tr>
            <th>Address:</th>
            <td>
                <input type="text" name="address"
                       value="${customer.address}"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td><input class="btn btn-primary" type="submit" value="edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
