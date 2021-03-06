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
    <div class="title">T??? khai y t???</div>
    <form:form action="/create" modelAttribute="declaration" method="post">
        <div class="user-details">
            <div class="input-box">
                <form:label path="name" cssClass="details">H??? v?? t??n(ghi ch??? IN HOA):</form:label>
                <form:input path="name" placeholder="Enter your name"></form:input>
            </div>
            <div class="input-box">
                <form:label path="dateOfBirth" cssClass="details">Ng??y sinh:</form:label>
                <form:input type="date" path="dateOfBirth"></form:input>
            </div>
            <div class="input-box">
                <form:label path="gender" cssClass="details">Gi???i t??nh:</form:label>

                <form:select path="gender">
                    <form:option value="false">Nam</form:option>
                    <form:option value="true">N???</form:option>
                </form:select>
            </div>
            <div class="input-box">
                <form:label path="national" cssClass="details">Qu???c t???ch:</form:label>
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
                <form:label path="idCard" cssClass="details">S??? h??? chi???u ho???c s??? CMND:</form:label>
                <form:input path="idCard" placeholder="Enter your idCard"></form:input>
            </div>
            <div class="input-box">
                <form:label path="travelInfo" cssClass="details">Th??ng tin ??i l???i:</form:label>
                <form:input path="travelInfo" placeholder="Enter your travelInfo"></form:input>

            </div>
            <div class="input-box">
                <form:label path="numberPlate" cssClass="details">S??? hi???u ph????ng ti???n:</form:label>
                <form:input path="numberPlate" placeholder="Enter your numberPlate"></form:input>
            </div>
            <div class="input-box">
                <form:label path="seatNumber" cssClass="details">S??? gh???</form:label>
                <form:input path="seatNumber" placeholder="Enter your seatNumber"></form:input>
            </div>
            <div class="input-box">
                <form:label path="startDay" cssClass="details">Ng??y kh???i th??nh</form:label>
                <form:input type="date" path="startDay"></form:input>
            </div>
            <div class="input-box">
                <form:label path="endDay" cssClass="details">Ng??y k???t th??c</form:label>
                <form:input type="date" path="endDay"></form:input>
            </div>
            <div class="input-box">
                <form:label path="localArrive"
                            cssClass="details">Trong v??ng 14 ng??y b???n ???? ?????n c??c th??nh ph??? n??o</form:label>
                <form:input path="localArrive" placeholder="Enter your localArrive"></form:input>
            </div>
            <div>
                <input type="submit" value="G???i T??? Khai" class="btn btn-primary">
            </div>
        </div>
    </form:form>

</div>
<%--    <form:form action="/create" modelAttribute="declaration" method="post">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <th><form:label path="name">H??? v?? t??n(ghi ch??? IN HOA):</form:label></th>--%>
<%--                <td><form:input path="name" placeholder="Enter your name"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="dateOfBirth">Ng??y sinh:</form:label></th>--%>
<%--                <td><form:input type="date" path="dateOfBirth"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="gender">Gi???i t??nh:</form:label></th>--%>
<%--                <td>--%>
<%--                    <form:select path="gender">--%>
<%--                        <form:option value="false">Nam</form:option>--%>
<%--                        <form:option value="true">N???</form:option>--%>
<%--                    </form:select>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="national">Qu???c t???ch:</form:label></th>--%>
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
<%--                <th><form:label path="idCard">S??? h??? chi???u ho???c s??? CMND:</form:label></th>--%>
<%--                <td><form:input path="idCard" placeholder="Enter your idCard"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="travelInfo">Th??ng tin ??i l???i:</form:label></th>--%>
<%--                <td><form:input path="travelInfo" placeholder="Enter your travelInfo"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="numberPlate">S??? hi???u ph????ng ti???n:</form:label></th>--%>
<%--                <td><form:input path="numberPlate" placeholder="Enter your numberPlate"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="seatNumber">S??? gh???</form:label></th>--%>
<%--                <td><form:input path="seatNumber" placeholder="Enter your seatNumber"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="startDay">Ng??y kh???i th??nh</form:label></th>--%>
<%--                <td><form:input type="date" path="startDay"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="endDay">Ng??y k???t th??c</form:label></th>--%>
<%--                <td><form:input type="date" path="endDay"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th><form:label path="localArrive">Trong v??ng 14 ng??y b???n ???? ?????n c??c th??nh ph??? n??o</form:label></th>--%>
<%--                <td><form:input path="localArrive" placeholder="Enter your localArrive"></form:input></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th></th>--%>
<%--                <td><input type="submit" value="G???i T??? Khai" class="btn btn-primary"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form:form>--%>
</body>
</html>
