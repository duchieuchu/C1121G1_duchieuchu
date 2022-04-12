<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/12/2022
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>converter</title>
    <style>
        .converter {
            height:200px; width:250px;
            margin:auto;
            padding:10px;
            border:1px #CCC solid;
        }
        .login input {
            padding:5px; margin:5px
        }

    </style>
</head>
<body>
<div class="converter">
    <h2>Currency Converter</h2>
    <form method="post" action="/convert">
        <label>Rate: </label><br/>
        <input type="number" name="rate" placeholder="RATE" value="22000"/><br/>
        <label>USD: </label><br/>
        <input type="number" name="usd" placeholder="USD" value="0"/><br/>
        <input type = "submit"  value = "Converter"/>
    </form>
</div>
</body>
</html>
