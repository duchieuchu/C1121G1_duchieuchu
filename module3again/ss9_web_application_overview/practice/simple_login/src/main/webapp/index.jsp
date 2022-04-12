<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/12/2022
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style type="text/css">
        body{
            background-color: black;
        }
        .login {
            height:200px; width:250px;
            margin:auto;
            padding:10px;
            border:1px #CCC solid;
        }
        .login input {
            padding:5px; margin:5px
        }
        h2{
            color: white;
        }
    </style>
</head>
<body>
<form method = "post"
      action="/login">
    <div class="login" align="center">
        <h2>Login</h2>
        <input type="text" name="username" size="30"  placeholder="username" />
        <input type="password" name="password" size="30" placeholder="password" />
        <input type="submit" value="Sign in"/>
    </div>
</form>
</body>
</html>
