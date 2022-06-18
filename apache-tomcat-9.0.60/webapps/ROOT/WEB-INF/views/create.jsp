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

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            height: 100vh;
            justify-content: center;
            align-items: center;
            padding: 10px;
            background: linear-gradient(135deg, #71b7ec, #9b59b6);
        }

        .container {
            max-width: 700px;
            width: 100%;
            background: #fff;
            padding: 25px 30px;
            border-radius: 5px;
        }

        .container .title {
            font-size: 25px;
            font-weight: 500;
            position: relative;
        }

        .container .title::before {
            content: '';
            position: absolute;
            left: 0;
            bottom: 0;
            height: 3px;
            width: 30px;
            background: linear-gradient(135deg, #71b7ec, #9b59b6);
        }

        .container form .user-details {
            display: flex;
            flex-wrap: wrap;
        }

        form .user-details .input-box input {
            margin-bottom: 15px;
            width: calc(100% / 2 - 20px);
        }

        .user-details .input-box input {
            height: 45px;
            width: 100%;
            outline: none;
            border-radius: 5px;
            border: 1px solid #ccc;
            padding-left: 15px;
            font-size: 16px;
            border-bottom-width: 2px;
            transition: all 0.3s ease;
        }

        .user-details .input-box input:focus,
        .user-details .input-box input:valid {
            border-color: black;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="title">Tờ khai y tế</div>
    <form:form action="/create" modelAttribute="declaration" method="post">
        <div class="user-details">
            <div class="input-box">
                <form:label path="name" cssClass="details">Họ và tên(ghi chứ IN HOA):</form:label>
                <form:input path="name" placeholder="Enter your name"></form:input>
            </div>
            <div class="input-box">
                <form:label path="dateOfBirth" cssClass="details">Ngày sinh:</form:label>
                <form:input type="date" path="dateOfBirth"></form:input>
            </div>
            <div class="input-box">
                <form:label path="gender" cssClass="details">Giới tính:</form:label>

                <form:select path="gender">
                    <form:option value="false">Nam</form:option>
                    <form:option value="true">Nữ</form:option>
                </form:select>
            </div>
            <div class="input-box">
                <form:label path="national" cssClass="details">Quốc tịch:</form:label>
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
            </div>
            <div class="input-box">
                <form:label path="idCard" cssClass="details">Số hộ chiếu hoặc số CMND:</form:label>
                <form:input path="idCard" placeholder="Enter your idCard"></form:input>
            </div>
            <div class="input-box">
                <form:label path="travelInfo" cssClass="details">Thông tin đi lại:</form:label>
                <form:input path="travelInfo" placeholder="Enter your travelInfo"></form:input>

            </div>
            <div class="input-box">
                <form:label path="numberPlate" cssClass="details">Số hiệu phương tiện:</form:label>
                <form:input path="numberPlate" placeholder="Enter your numberPlate"></form:input>
            </div>
            <div class="input-box">
                <form:label path="seatNumber" cssClass="details">Số ghế</form:label>
                <form:input path="seatNumber" placeholder="Enter your seatNumber"></form:input>
            </div>
            <div class="input-box">
                <form:label path="startDay" cssClass="details">Ngày khởi thành</form:label>
                <form:input type="date" path="startDay"></form:input>
            </div>
            <div class="input-box">
                <form:label path="endDay" cssClass="details">Ngày kết thúc</form:label>
                <form:input type="date" path="endDay"></form:input>
            </div>
            <div class="input-box">
                <form:label path="localArrive"
                            cssClass="details">Trong vòng 14 ngày bạn đã đến các thành phố nào</form:label>
                <form:input path="localArrive" placeholder="Enter your localArrive"></form:input>
            </div>
            <div>
                <input type="submit" value="Gửi Tờ Khai" class="btn btn-primary">
            </div>
        </div>
    </form:form>

</div>
<%--    <form:form action="/create" modelAttribute="declaration" method="post">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <th><form:label path="name">Họ và tên(ghi chứ IN HOA):</form:label></th>--%>
<%--                <td><form:input path="name" placeholder="Enter your name"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="dateOfBirth">Ngày sinh:</form:label></th>--%>
<%--                <td><form:input type="date" path="dateOfBirth"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="gender">Giới tính:</form:label></th>--%>
<%--                <td>--%>
<%--                    <form:select path="gender">--%>
<%--                        <form:option value="false">Nam</form:option>--%>
<%--                        <form:option value="true">Nữ</form:option>--%>
<%--                    </form:select>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="national">Quốc tịch:</form:label></th>--%>
<%--                <td>--%>
<%--                    <form:select path="national">--%>
<%--                        <form:option value="VietNam">VietNam</form:option>--%>
<%--                        <form:option value="Thailand">Thailand</form:option>--%>
<%--                        <form:option value="Singapore">Singapore</form:option>--%>
<%--                        <form:option value="Philippines">Philippines</form:option>--%>
<%--                        <form:option value="Laos">Laos</form:option>--%>
<%--                        <form:option value="Malaysia">Malaysia</form:option>--%>
<%--                        <form:option value="Indonesia">Indonesia</form:option>--%>
<%--                        <form:option value="Cambodia">Cambodia</form:option>--%>
<%--                        <form:option value="United States">United States</form:option>--%>
<%--                        <form:option value="Canada">Canada</form:option>--%>
<%--                        <form:option value="Saudi Arabia">Saudi Arabia</form:option>--%>
<%--                        <form:option value="India">India</form:option>--%>
<%--                        <form:option value="Afghanistan">Afghanistan</form:option>--%>
<%--                        <form:option value="South Korea">South Korea</form:option>--%>
<%--                        <form:option value="Australia">Australia</form:option>--%>
<%--                        <form:option value="Egypt">Egypt</form:option>--%>
<%--                        <form:option value="Angola">Angola</form:option>--%>
<%--                    </form:select>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="idCard">Số hộ chiếu hoặc số CMND:</form:label></th>--%>
<%--                <td><form:input path="idCard" placeholder="Enter your idCard"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="travelInfo">Thông tin đi lại:</form:label></th>--%>
<%--                <td><form:input path="travelInfo" placeholder="Enter your travelInfo"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="numberPlate">Số hiệu phương tiện:</form:label></th>--%>
<%--                <td><form:input path="numberPlate" placeholder="Enter your numberPlate"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="seatNumber">Số ghế</form:label></th>--%>
<%--                <td><form:input path="seatNumber" placeholder="Enter your seatNumber"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="startDay">Ngày khởi thành</form:label></th>--%>
<%--                <td><form:input type="date" path="startDay"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="endDay">Ngày kết thúc</form:label></th>--%>
<%--                <td><form:input type="date" path="endDay"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="localArrive">Trong vòng 14 ngày bạn đã đến các thành phố nào</form:label></th>--%>
<%--                <td><form:input path="localArrive" placeholder="Enter your localArrive"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th></th>--%>
<%--                <td><input type="submit" value="Gửi Tờ Khai" class="btn btn-primary"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form:form>--%>
</body>
</html>
