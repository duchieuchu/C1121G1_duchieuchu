<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/12/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>discount</title>
    <style>
        body {
            background-color: #b5a789;
            font-family: Georgia, "Times New Roman", Times, Serif;
            font-size: small;
            margin: 0px;
        }

        #main {
            text-align: center;
            background-color: #efe5d0;
            font-size: 105%;
            padding: 15px;
            margin: auto;
        }
        h1{
            padding-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1> Product Discount Calculator</h1>
<form method="post" action="/discount" id="main">
    <input type="text" name="listPrice" placeholder="Giá niêm yết của sản phẩm"><br><br>
    <input type="text" name="discountPercent" placeholder="Tỷ lệ chiết khấu%"><br><br>
    <input type="submit" name="Calculate Discount" value="Calculate Discount">
</form>
</body>
</html>
