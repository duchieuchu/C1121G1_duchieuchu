<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form method="post" modelAttribute="email" action="/email/save">
    <table>
        <tr>
            <th>Language</th>
            <td>
                <select name="language">
                    <option value="English">English</option>
                    <option value="Vietnamese">Vietnamese</option>
                    <option value="Japanese">Japanese</option>
                    <option value="Thailand">Thailand</option>
                    <option value="Chinese">Chinese</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>
                <select name="pageSize">
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>Spams Filter:</th>
            <td>
                <input type="checkbox" name="spamsFilter">
            </td>
        </tr>
        <tr>
            <th>SignNature:</th>
            <td>
                <input type="text" name="signNature">
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
