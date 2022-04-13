<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/13/2022
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>currency converter</title>
</head>
<body>
<h1>Currency Converter</h1>
<form method="post" action="converter.jsp">
    <label>Rate</label><br>
    <input type="text" name="rate" placeholder="enter RATE" value="22000"><br><br>
    <label>USD</label><br>
    <input type="text" name="usd" placeholder="enter USD" value="0"><br><br>
    <input type="submit" id="submit" value="converter">
</form>

</body>
</html>
