<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/25/2022
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>title</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            background-image: url("https://www.color-hex.com/palettes/8887.png");
        }

        .add-button {
            padding-left: 1000px;
        }

        .back-home {
            padding-left: 50px;
        }
    </style>
</head>
<body>
<center>
    <h2>Danh sach sach</h2>
    <h4>
        <a class="add-button" href="/sach?action=listMuonSach">Danh sach dang muon</a>
    </h4>

</center>

<div align="center">
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Ma sach</th>
            <th>Ten Sach</th>
            <th>Tac gia</th>
            <th>So luong</th>
            <th>Mo ta</th>
            <th>Chuc nang</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sachs" items="${sachList}">
            <tr>
                <td><c:out value="${sachs.maSach}"/></td>
                <td><c:out value="${sachs.tenSach}"/></td>
                <td><c:out value="${sachs.tacGia}"/></td>
                <td><c:out value="${sachs.soLuong}"/></td>
                <td><c:out value="${sachs.moTa}"/></td>
                <td>
                    <a class="btn btn-warning" href="/sach?action=muon&id=${sachs.idSach}">Muon</a>
<%--                    <button onclick="setIdDelete('${products.getId()}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">--%>
<%--                        Delete--%>
<%--                    </button>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--<!-- Modal -->--%>
<%--<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <form method="post" action="/product?action=delete">--%>
<%--                <div class="modal-body">--%>
<%--                    <input type="hidden" name="id" id="id">--%>
<%--                    Are you sure ?--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-danger">Delete</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
<%--<script>--%>
<%--    function setIdDelete(id) {--%>
<%--        document.getElementById("id").value=id;--%>
<%--    }--%>
<%--</script>--%>
</html>
