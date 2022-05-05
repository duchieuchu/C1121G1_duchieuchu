<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 7:34 PM
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
<h2>Medical Declaration Information</h2>
<table class="table table-hover table-dark">
    <tr>
        <td>Họ và tên:</td>
        <td>${name}</td>
    </tr>

    <tr>
        <td>Ngày sinh:</td>
        <td>${dateOfBirth}</td>
    </tr>
    <tr>
        <td>Giới tính:</td>
        <td>${gender}</td>
    </tr>
    <tr>
        <td>Quốc tịch:</td>
        <td>${national}</td>
    </tr>
    <tr>
        <td>Sô hộ chiếu hoặc số CMND:</td>
        <td>${idCard}</td>
    </tr>
    <tr>
        <td>Thông tin đi lại:</td>
        <td>${travelInfo}</td>
    </tr>
    <tr>
        <td>số hiệu phương tiện:</td>
        <td>${numberPlate}</td>
    </tr>
    <tr>
        <td>Số ghế</td>
        <td>${seatNumber}</td>
    </tr>
    <tr>
        <td>Ngày khởi thành</td>
        <td>${startDay}</td>
    </tr>
    <tr>
        <td>Ngày kết thúc</td>
        <td>${endDay}</td>
    </tr>
    <tr>
        <td>đã đến các thành phố</td>
        <td>${localArrive}</td>
    </tr>
    <tr>
        <td> <h2>Địa chỉ liên lạc </h2></td>
    </tr>
    <tr>
        <td>Thành phó:</td>
        <td>${city}</td>
    </tr>
    <tr>
        <td>Quận/huyện:</td>
        <td>${district}</td>
    </tr>
    <tr>
        <td>Phường/xã:</td>
        <td>${wards}</td>
    </tr>
    <tr>
        <td>Địa chỉ nơi ở:</td>
        <td>${address}</td>
    </tr>
    <tr>
        <td>Điện thoại:</td>
        <td>${phone}</td>
    </tr>
    <tr>
        <td>email</td>
        <td>${email}</td>
    </tr>
    <tr>
        <td> <h2> có thấy xuất hiện dấu hiệu nào sau đây không?</h2></td>
    </tr>
    <tr>
        <td>Sốt:</td>
        <td>${fever}</td>
    </tr>
    <tr>
        <td>Ho:</td>
        <td>${cough}</td>
    </tr>
    <tr>
        <td>Khó thở:</td>
        <td>${shortOfBreath}</td>
    </tr>
    <tr>
        <td>Đau họng:</td>
        <td>${soreThroat}</td>
    </tr>
    <tr>
        <td>Buồn nôn:</td>
        <td>${nausea}</td>
    </tr>
    <tr>
        <td>Tiêu chảy:</td>
        <td>${diarrhea}</td>
    </tr>
    <tr>
        <td> <h2>Lịch sử phới nhiễm,Trong vòng 14 ngày qua </h2></td>
    </tr>
    <tr>
        <td>đến đến trang trại chăn nuôi / chợ/ cơ sở giết mổ không?</td>
        <td>${hictory1}</td>
    </tr>
    <tr>
        <td>tiếp xúc gần(<2m) với người nhiễm bệnh cov không?</td>
        <td>${hictory2}</td>
    </tr>
</table>
</body>
</html>
