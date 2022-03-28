<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2022
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-image: url("https://www.color-hex.com/palettes/104061.png");
        }
    </style>
</head>
<body>
<h2>
    <a href="sach?action=sachList">tro ve</a>
</h2>
<div align="center">
    <form method="post" >
        <h1>Muon Sach</h1>
        <table border="1" cellpadding="5" >
            <tr>
                <th>Ma muon sach</th>
                <td>
                    <input type="text" name="name" id="name" size="45" required >
                </td>
            </tr>
            <tr>
                <th>Ten sach</th>
                <td>
                    <input type="text" name="price" id="price" size="45" required>
                </td>
            </tr>
            <tr>
                <th>Ten hoc sinh</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45" required>
                </td>
            </tr>
            <tr>
                <th>Ngay muon sach</th>
                <td>
                    <input type="date" name="color" id="color" size="45" required>
                </td>
            </tr>
            <tr>
                <th>Ngay tra sach</th>
                <td>
                    <input type="date" name="description" id="description" size="45" required>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
