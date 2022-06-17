<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>WELCOME</h1>

<form:form action="/employee/addEmployee" method="post" modelAttribute="employee">
    <table>
        <tr>
            <th><form:label path="id">Employee ID:</form:label></th>
            <td><form:input type="text" path="id"/></td>
        </tr>
        <tr>
            <th><form:label path="name">Employee's name:</form:label></th>
            <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
            <th><form:label path="contactNumber">Contact's number:</form:label></th>
            <td><form:input type="number" path="contactNumber"/></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="save"></td>
        </tr>
    </table>
</form:form>

<%--<form action="/employee/addEmployee" method="post" >--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>Id</th>--%>
<%--            <td><input type="text" name="id"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>Name</th>--%>
<%--            <td><input type="text" name="name"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>ContactNumber</th>--%>
<%--            <td><input type="number" name="contactNumber"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th></th>--%>
<%--            <td><input type="submit" value="save"></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
</body>
</html>
