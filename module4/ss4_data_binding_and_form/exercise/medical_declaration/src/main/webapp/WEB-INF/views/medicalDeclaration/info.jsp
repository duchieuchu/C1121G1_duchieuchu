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
        <td>${medicalDeclaration.name}</td>
    </tr>

    <tr>
        <td>Ngày sinh:</td>
        <td>${medicalDeclaration.dateOfBirth}</td>
    </tr>
    <tr>
        <td>Giới tính:</td>
        <td>${medicalDeclaration.gender}</td>
    </tr>
    <tr>
        <td>Quốc tịch:</td>
        <td>${medicalDeclaration.national}</td>
    </tr>
    <tr>
        <td>Sô hộ chiếu hoặc số CMND:</td>
        <td>${medicalDeclaration.idCard}</td>
    </tr>
    <tr>
        <td>Thông tin đi lại:</td>
        <td>${medicalDeclaration.travelInfo}</td>
    </tr>
    <tr>
        <td>số hiệu phương tiện:</td>
        <td>${medicalDeclaration.numberPlate}</td>
    </tr>
    <tr>
        <td>Số ghế</td>
        <td>${medicalDeclaration.seatNumber}</td>
    </tr>
    <tr>
        <td>Ngày khởi thành</td>
        <td>${medicalDeclaration.startDay}</td>
    </tr>
    <tr>
        <td>Ngày kết thúc</td>
        <td>${medicalDeclaration.endDay}</td>
    </tr>
    <tr>
        <td>đã đến các thành phố</td>
        <td>${medicalDeclaration.localArrive}</td>
    </tr>
    <tr>
        <td> <h2>Địa chỉ liên lạc </h2></td>
    </tr>
    <tr>
        <td>Thành phó:</td>
        <td>${medicalDeclaration.city}</td>
    </tr>
    <tr>
        <td>Quận/huyện:</td>
        <td>${medicalDeclaration.district}</td>
    </tr>
    <tr>
        <td>Phường/xã:</td>
        <td>${medicalDeclaration.wards}</td>
    </tr>
    <tr>
        <td>Địa chỉ nơi ở:</td>
        <td>${medicalDeclaration.address}</td>
    </tr>
    <tr>
        <td>Điện thoại:</td>
        <td>${medicalDeclaration.phone}</td>
    </tr>
    <tr>
        <td>email</td>
        <td>${medicalDeclaration.email}</td>
    </tr>
    <tr>
        <td> <h2> có thấy xuất hiện dấu hiệu nào sau đây không?</h2></td>
    </tr>
    <tr>
        <td>Sốt:</td>
        <td>${medicalDeclaration.fever}</td>
    </tr>
    <tr>
        <td>Ho:</td>
        <td>${medicalDeclaration.cough}</td>
    </tr>
    <tr>
        <td>Khó thở:</td>
        <td>${medicalDeclaration.shortOfBreath}</td>
    </tr>
    <tr>
        <td>Đau họng:</td>
        <td>${medicalDeclaration.soreThroat}</td>
    </tr>
    <tr>
        <td>Buồn nôn:</td>
        <td>${medicalDeclaration.nausea}</td>
    </tr>
    <tr>
        <td>Tiêu chảy:</td>
        <td>${medicalDeclaration.diarrhea}</td>
    </tr>
    <tr>
        <td> <h2>Lịch sử phới nhiễm,Trong vòng 14 ngày qua </h2></td>
    </tr>
    <tr>
        <td>đến đến trang trại chăn nuôi / chợ/ cơ sở giết mổ không?</td>
        <td>${medicalDeclaration.hictory1}</td>
    </tr>
    <tr>
        <td>tiếp xúc gần(<2m) với người nhiễm bệnh cov không?</td>
        <td>${medicalDeclaration.hictory2}</td>
    </tr>
</table>
</body>
</html>
