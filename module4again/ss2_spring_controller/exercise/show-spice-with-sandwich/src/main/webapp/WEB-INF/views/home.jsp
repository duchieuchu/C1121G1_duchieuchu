<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/16/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/getInfo" method="get">
    <table>
        <tr>
            <th>Lettuce</th>
            <td><input type="checkbox" name="spice" value="Lettuce"></td>
        </tr>
        <tr>
            <th>Tomato</th>
            <td><input type="checkbox" name="spice" value="Tomato"></td>
        </tr>
        <tr>
            <th>Mustard</th>
            <td><input type="checkbox" name="spice" value="Mustard"></td>
        </tr>
        <tr>
            <th>Sprouts</th>
            <td><input type="checkbox" name="spice" value="Sprouts"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="save"></td>
        </tr>
    </table>
</form>
<h1>${note}</h1>
</body>
</html>
