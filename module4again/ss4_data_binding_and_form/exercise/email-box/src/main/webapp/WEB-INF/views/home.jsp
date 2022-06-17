<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/update" method="post" modelAttribute="update">
    <table>
        <tr>
            <th><form:label path="languages">Languages</form:label></th>
            <td>
                <form:select path="languages">
                    <option value="English">English</option>
                    <option value="Vietnamese">Vietnamese</option>
                    <option value="Chinese">Chinese</option>
                    <option value="Japanese">Japanese</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page size</form:label></th>
            <td>
                <form:select path="pageSize">
                    <form:option value="21">21</form:option>
                    <form:option value="22">22</form:option>
                    <form:option value="23">23</form:option>
                    <form:option value="24">24</form:option>
                    <form:option value="25">25</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="spamsFitter">Spams fitter</form:label></th>
            <td><input type="checkbox" name="pageSize">Enable spams fitter</td>
        </tr>
        <tr>
            <th><form:label path="signature">Signature</form:label></th>
            <td><form:input type="text" path="signature"/></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="update"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
