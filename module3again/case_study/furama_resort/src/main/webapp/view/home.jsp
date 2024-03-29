<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/20/2022
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .img1 {
            width: 100%;
        }

        .img2 {
            margin-left: auto;
            margin-right: auto;
            height: 10px;
        }

        .tm-footer-links li {
            list-style: none;
            margin-bottom: 5px;
        }

        .tm-footer-links li a {
            color: #999999;
        }

        .tm-footer-links li a:hover {
            color: #009999;
        }

        .tm-text-primary {
            color: #009999;
        }

        a.tm-text-primary:hover {
            color: #666666;
        }

        .tm-bg-gray {
            background-color: #EEEEEE;
        }

        /* Videos */
        #tm-video-container {
            max-height: 400px;
            overflow: hidden;
            background-color: #333;
            margin-bottom: 90px;
            position: relative;
        }

        #tm-video {
            display: block;
            width: 100%;
            height: auto;
        }

        .p1 {
            font-size:27px;
            text-align: center;
            font-weight: bold;
            font-family: "Comic Sans MS", cursive, sans-serif;
            font-style: italic;
        }

    </style>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand" href="https://furamavietnam.com/"> <img src="https://gohola.vn/uploads/2015/02/furama.gif"
                                                                    width="50" height="60"></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/employees">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customers">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/services">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contracts?action=listContract">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="tm-hero d-flex justify-content-center align-items-center" id="tm-video-container">
    <video autoplay muted loop id="tm-video">
        <source src="video/hero.mp4" type="video/mp4">
    </video>
</div>
<p class="p1">KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.</p>
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="keyboard">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/x.jpg" alt="Los Angeles" style="width:100%;">
        </div>
        <div class="carousel-item">
            <img src="img/y.jpg" alt="Chicago" style="width:100%;">
        </div>
        <div class="carousel-item">
            <img src="img/h.jpg" alt="New york" style="width:100%;">
        </div>
        <div class="carousel-item">
            <img src="img/z1.jpg" alt="House" style="width:100%;">
        </div>
        <div class="carousel-item">
            <img src="img/z2.jpg" alt="House1" style="width:100%;">
        </div>
        <div class="carousel-item">
            <img src="img/z3.jpg" alt="Sea" style="width:100%;">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-target="#carouselExampleIndicators" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </button>
</div>
<img class="img2" src="https://i.pinimg.com/originals/0a/f3/bc/0af3bca9a346a90010887620a8d9a153.jpg">
<p class="p1">CHỌN ĐỊA ĐIỂM CHƠI</p>

<div class="row" style="width: 100%">
    <div class="col-md-3 col-sm-6 col-12">
        <div class="card">
            <img src="img/z1.jpg" alt="...">
            <div class="card-body">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-6 col-12">
        <div class="card">
            <img src="img/z2.jpg" alt="...">
            <div class="card-body">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-6 col-12">
        <div class="card">
            <img src="img/h.jpg" alt="...">
            <div class="card-body">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-6 col-12">
        <div class="card">
            <img src="img/z3.jpg" alt="...">
            <div class="card-body">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                    card's content.</p>
            </div>
        </div>
    </div>
</div>
<img class="img2" src="https://i.pinimg.com/originals/0a/f3/bc/0af3bca9a346a90010887620a8d9a153.jpg">
<p class="p1">SÂN CHƠI TRÊN BIỂN ĐỘC ĐÁO, SANG CHẢNH</p>
<img class="img1" src="https://data2.1freewallpapers.com/download/yacht-concept-luxury.jpg">
<img class="img1" src="https://wallpaperaccess.com/full/220637.jpg">
<footer class="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
    <div class="container-fluid tm-container-small">
        <div class="row">
            <div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
                <h3 class="tm-text-primary mb-4 tm-footer-title">FURAMA - RESORT</h3>
                <p>SSWSS -Z is free <a rel="sponsored" href="https://v5.getbootstrap.com/">Bootstrap 5</a> Alpha 2 HTML
                    Template for video and photo websites. You can freely use this TemplateMo layout for a front-end
                    integration with any kind of CMS website.</p>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
                <h3 class="tm-text-primary mb-4 tm-footer-title">Our Links</h3>
                <ul class="tm-footer-links pl-0">
                    <li><a href="#">Advertise</a></li>
                    <li><a href="#">Support</a></li>
                    <li><a href="#">Our Company</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
                <ul class="tm-social-links d-flex justify-content-end pl-0 mb-5">
                    <li class="mb-2"><a href="https://facebook.com"><i class="fab fa-facebook"></i></a></li>
                    <li class="mb-2"><a href="https://twitter.com"><i class="fab fa-twitter"></i></a></li>
                    <li class="mb-2"><a href="https://instagram.com"><i class="fab fa-instagram"></i></a></li>
                    <li class="mb-2"><a href="https://pinterest.com"><i class="fab fa-pinterest"></i></a></li>
                </ul>
                <a href="#" class="tm-text-gray text-right d-block mb-2">Terms of Use</a>
                <a href="#" class="tm-text-gray text-right d-block">Privacy Policy</a>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 col-md-7 col-12 px-5 mb-3">
                Copyright 2020 SSWSS -Z Company. All rights reserved.
            </div>
            <div class="col-lg-4 col-md-5 col-12 px-5 text-right">
                Designed by <a href="https://templatemo.com" class="tm-text-gray" rel="sponsored"
                               target="_parent">CDH</a>
            </div>
        </div>
    </div>
</footer>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script>
    $('.carousel').carousel({
        interval: 2000
    })
</script>
</html>
