<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 7:17 PM
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
<h3>Welcome, Enter The Song Details</h3>
<form:form method="post" action="addSong" modelAttribute="song">
    <table class="table table-hover table-dark">
        <tr>
            <td><form:label path="name">name:</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="singer">singer:</form:label></td>
            <td><form:input path="singer"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="kindOfMusic">kindOfMusic:</form:label></td>
            <td><form:input path="kindOfMusic"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="filePath">filePath:</form:label></td>
            <td><form:input path="filePath"></form:input></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
