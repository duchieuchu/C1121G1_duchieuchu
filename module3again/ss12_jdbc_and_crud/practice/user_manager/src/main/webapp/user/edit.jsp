<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/18/2022
  Time: 4:52 PM
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
    <a href="/users?action=userList">Back to user list</a>
</p>
<h1>Edit user</h1>
<form method="post" >
    <table class="table table-hover table-dark">
        <c:if test="${user != null}">
            <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
        </c:if>
        <tr>
            <th>Name:</th>
            <td>
                <input type="text" name="name"
                       value="${user.name}"/>
            </td>
        </tr>
        <tr>
            <th>Email:</th>
            <td>
                <input type="text" name="email"
                       value="${user.email}"/>
            </td>
        </tr>
        <tr>
            <th>Country:</th>
            <td>
                <input type="text" name="country"
                       value="${user.country}"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
