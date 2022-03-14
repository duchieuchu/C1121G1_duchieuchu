<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/11/2022
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="text-align: center">Danh sách khánh hàng</h2>
<table border="1px" style="width: 800px">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customers}" varStatus="loop">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.dayOfBirth}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img style="height:142px"width="104px" src="${customer.img}" alt="picture"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
