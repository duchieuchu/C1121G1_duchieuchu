<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form method="post" action="addMedicalDeclaration" modelAttribute="medicalDeclaration">
    <table class="table table-hover table-dark">
        <tr>
            <td><form:label path="name">Họ và tên(ghi chứ IN HOA):</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="dateOfBirth">Ngày sinh:</form:label></td>
            <td><form:input type="date" path="dateOfBirth"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="gender">Giới tính: </form:label></td>
            <td><form:input path="gender"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="national">Quốc tịch: </form:label></td>
            <td><form:input path="national"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="idCard">Sô hộ chiếu hoặc số CMND: </form:label></td>
            <td><form:input path="idCard"></form:input></td>
        </tr>

        <tr>
            <td><form:label path="travelInfo">Thông tin đi lại: </form:label></td>
            <td><form:input path="travelInfo"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="numberPlate">số hiệu phương tiện: </form:label></td>
            <td><form:input path="numberPlate"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="seatNumber">Số ghế</form:label></td>
            <td><form:input path="seatNumber"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="startDay">Ngày khởi thành</form:label></td>
            <td><form:input type="date" path="startDay"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="endDay">Ngày kết thúc</form:label></td>
            <td><form:input type="date" path="endDay"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="localArrive">Trong vòng 14 ngày bạn đã đến các thành phố nào</form:label></td>
            <td><form:input path="localArrive"></form:input></td>
        </tr>
        <tr>
            <td> <h2>Địa chỉ liên lạc </h2></td>
        </tr>
        <tr>
            <td><form:label path="city">Thành phó: </form:label></td>
            <td><form:input path="city"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="district">Quận/huyện: </form:label></td>
            <td><form:input path="district"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="wards">Phường/xã: </form:label></td>
            <td><form:input path="wards"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="address">Địa chỉ nơi ở: </form:label></td>
            <td><form:input path="address"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="phone">Điện thoại: </form:label></td>
            <td><form:input path="phone"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="email">Email: </form:label></td>
            <td><form:input path="email"></form:input></td>
        </tr>
        <tr>
            <td> <h2>Trong vòng 14 ngày qua, anh chị có thấy xuất hiện dấu hiệu nào sau đây không?</h2></td>
        </tr>
        <tr>
            <td><form:label path="fever">Sốt: </form:label></td>
            <td><form:input path="fever"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="cough">Ho: </form:label></td>
            <td><form:input path="cough"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="shortOfBreath">Khó thở: </form:label></td>
            <td><form:input path="shortOfBreath"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="soreThroat">Đau họng: </form:label></td>
            <td><form:input path="soreThroat"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="nausea">Buồn nôn: </form:label></td>
            <td><form:input path="nausea"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="diarrhea">Tiêu chảy: </form:label></td>
            <td><form:input path="diarrhea"></form:input></td>
        </tr>
        <tr>
            <td> <h2>Lịch sử phới nhiễm,Trong vòng 14 ngày qua, anh chị có </h2></td>
        </tr>
        <tr>
            <td><form:label path="hictory1"> Có đến đến trang trại chăn nuôi / chợ/ cơ sở giết mổ không?</form:label></td>
            <td><form:input path="hictory1"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="hictory2">Có tiếp xúc gần(<2m) với người nhiễm bệnh cov không?</form:label></td>
            <td><form:input path="hictory2"></form:input></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Gửi tờ khai">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
