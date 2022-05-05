<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 10:14 AM
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
<h2><a href="/student/list">back list student</a></h2>
<h1>Create student</h1>
<form:form action="" modelAttribute="student" method="post">
    <table class="table table-hover table-dark">
        <tr>
            <th>Name</th>
            <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
            <th>Date of birth:</th>
            <td><form:input type="date" path="dateOfBirth"/></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="Register"/></td>
        </tr>
    </table>

    <%--    <div>--%>
    <%--        Name:--%>
    <%--        <form:input type="text" path="name"/>--%>
    <%--    </div>--%>
    <%--    <div>--%>
    <%--        Date of birth:--%>
    <%--        <form:input type="date" path="dateOfBirth"/>--%>
    <%--    </div>--%>
    <%--    <div>--%>
    <%--        <input type="submit" value="Register">--%>
    <%--    </div>--%>
</form:form>
</body>
</html>
