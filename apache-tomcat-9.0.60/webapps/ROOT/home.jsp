<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/21/2022
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: poppins, poppins, sans-serif;
            box-sizing: border-box;
        }

        body {
            background-image: url("https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Garden-Superior-TwinBed-1-F-768x497.jpg");
            background-size: 100%;
        }

        nav {
            display: flex;
            align-items: center;
            justify-content: space-between;
            background: dimgray;
            padding: 5px 5%;
            position: sticky;
            top: 0;
            z-index: 100;
        }

        .logo {
            width: 70px;
            margin-right: 45px;
        }

        .nav-left, .nav-right {
            display: flex;
            align-items: center;
        }

        .nav-left ul li {
            list-style: none;
            display: inline-block;
        }

        .nav-left ul li img {
            width: 28px;
            margin:  15px;
        }

        .nav-user-icon img {
            width: 40px;
            border-radius: 50%;
            cursor: pointer;
        }

        .nav-user-icon {
            margin-left: 30px;
        }

        .search-box {
            background: #efefef;
            width: 350px;
            border-radius: 20px;
            display: flex;
            align-items: center;
            padding: 0 15px;
        }

        .search-box img {
            width: 18px;
        }

        .search-box input {
            width: 100%;
            background: transparent;
            padding: 10px;
            outline: none;
            border: 0;
        }
    </style>
</head>
<body>
<nav>
    <div class="nav-left">
        <img src="https://gohola.vn/uploads/2015/02/furama.gif"
             width=30 height="50" class="logo">
        <nav>
            <a href="/home?action=list"><img src="https://cdn-icons-png.flaticon.com/512/25/25694.png"
                             width="30" height="30">Home</a>
            <a href="/employee?action=list"><img src="https://i.pinimg.com/originals/a9/e7/78/a9e778d7f751401a5d4a51ca2f4aa9ee.png"
                             width="30" height="30">Employee</a>
            <a href="/customer?action=list"><img src="http://cdn.onlinewebfonts.com/svg/img_149065.png"
                             width="30" height="30">Customer</a>
            <a href="/service?action=list"><img src="https://icon-library.com/images/notebook-icon-png/notebook-icon-png-26.jpg"
                             width="30" height="30">Service</a>
            <a href="/contract?action=list"><img src="https://cdn-icons-png.flaticon.com/512/126/126249.png"
                             width="30" height="30">Contract</a>
        </nav>
    </div>
    <div class="nav-right">
        <div class="search-box">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Search_Icon.svg/1024px-Search_Icon.svg.png"
                 width="30" height="30">
            <input type="text" placeholder="Search">
        </div>
        <div class="nav-user-icon online">
            <img src="https://i.pinimg.com/236x/77/71/37/777137106de3a6026fdd7e1fc04fa8ef--man-suit-ironman.jpg"
                 width="30" height="30">
        </div>
    </div>
    <div class="main-content">

    </div>
</nav>
</body>
</html>
