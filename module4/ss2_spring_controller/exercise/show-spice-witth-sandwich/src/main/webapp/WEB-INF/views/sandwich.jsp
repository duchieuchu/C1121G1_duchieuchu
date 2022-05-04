<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/4/2022
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SANDWICH SPICE FORM</h1>
<h3>Please choice your sandwich style like form</h3>
<form action="/sandwich" method="post">
    <label><input type="checkbox" name="spice" value="Lettuce">Lettuce</label>
    <label><input type="checkbox" name="spice" value="Tomato">Tomato</label>
    <label><input type="checkbox" name="spice" value="Mustard">Mustard</label>
    <label><input type="checkbox" name="spice" value="Sprouts">Sprouts</label><br>
    <label><input type="submit" value="enter"></label>
</form>
<div>
    Your sandwich:
    <c:forEach var="spice" items="${spice}">
        ${spice}
    </c:forEach>
</div>
</body>
</html>
