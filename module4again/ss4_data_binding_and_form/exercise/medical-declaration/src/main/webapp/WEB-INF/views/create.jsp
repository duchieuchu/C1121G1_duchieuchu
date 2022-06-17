<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        p {
            font-size: 27px;
            text-align: center;
            font-weight: bold;
            font-family: "Comic Sans MS", cursive, sans-serif;
            font-style: italic;
        }

        .p1 {
            font-size: 27px;
            text-align: center;
            font-weight: bold;
            font-family: "Comic Sans MS", cursive, sans-serif;
            font-style: italic;
            color: red;
        }
    </style>
</head>
<body>
<p>Tờ khai y tế</p>
<p>Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để phòng chống địch
    bệnh</p>
<p class="p1">khuyến cáo: khai báo thông tin sai là vi pham pháp luật và có thể xử lí hình sự</p>
<form:form action="/create" modelAttribute="declaration" method="post">
    <table>
        <tr>
            <th><form:label path="name">Họ và tên(ghi chứ IN HOA):</form:label></th>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="dateOfBirth">Ngày sinh:</form:label></th>
            <td><form:input type="date" path="dateOfBirth"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="gender">Giới tính:</form:label></th>
            <td>
                <form:select path="gender">
                    <form:option value="false">Nam</form:option>
                    <form:option value="true">Nữ</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="national">Quốc tịch:</form:label></th>
            <td>
                <form:select path="national">
                    <form:option value="VietNam">VietNam</form:option>
                    <form:option value="Thailand">Thailand</form:option>
                    <form:option value="Singapore">Singapore</form:option>
                    <form:option value="Philippines">Philippines</form:option>
                    <form:option value="Laos">Laos</form:option>
                    <form:option value="Malaysia">Malaysia</form:option>
                    <form:option value="Indonesia">Indonesia</form:option>
                    <form:option value="Cambodia">Cambodia</form:option>
                    <form:option value="United States">United States</form:option>
                    <form:option value="Canada">Canada</form:option>
                    <form:option value="Saudi Arabia">Saudi Arabia</form:option>
                    <form:option value="India">India</form:option>
                    <form:option value="Afghanistan">Afghanistan</form:option>
                    <form:option value="South Korea">South Korea</form:option>
                    <form:option value="Australia">Australia</form:option>
                    <form:option value="Egypt">Egypt</form:option>
                    <form:option value="Angola">Angola</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="idCard">Số hộ chiếu hoặc số CMND:</form:label></th>
            <td><form:input path="idCard"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="travelInfo">Thông tin đi lại:</form:label></th>
            <td><form:input path="travelInfo"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="numberPlate">Số hiệu phương tiện:</form:label></th>
            <td><form:input path="numberPlate"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="seatNumber">Số ghế</form:label></th>
            <td><form:input path="seatNumber"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="startDay">Ngày khởi thành</form:label></th>
            <td><form:input type="date" path="startDay"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="endDay">Ngày kết thúc</form:label></th>
            <td><form:input type="date" path="endDay"></form:input></td>
        </tr>
        <tr>
            <th><form:label path="localArrive">Trong vòng 14 ngày bạn đã đến các thành phố nào</form:label></th>
            <td><form:input path="localArrive"></form:input></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
