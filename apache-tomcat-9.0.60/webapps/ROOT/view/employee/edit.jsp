<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/24/2022
  Time: 10:58 PM
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
<p>
    <a href="/employees?action=employeeList">Back to employee list</a>
</p>
<h1>Edit employee</h1>
<form method="post">
    <table class="table table-hover table-dark">
        <c:if test="${employee != null}">
            <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
        </c:if>
        <tr>
            <th>Name</th>

            <td><input type="text" name="name" value="${employee.name}"></td>

        </tr>
        <tr>
            <th>Birthday</th>
            <td><input type="date" name="birthday" value="${employee.birthday}"></td>
        </tr>
        <tr>
            <th>IdCard</th>
            <td><input type="number" name="idCard" value="${employee.idCard}"></td>
        </tr>
        <tr>
            <th>Salary</th>
            <td><input type="number" name="salary" value="${employee.salary}"></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td><input type="number" name="phone" value="${employee.phone}"></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><input type="text" name="email" value="${employee.email}"></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><input type="text" name="address" value="${employee.address}"></td>
        </tr>
        <tr>
            <th>Position</th>
            <td>
                <select name="position">
                    <c:forEach var="position" items="${positions}">
                        <c:choose>
                            <c:when test="${position.positionId==employee.position.positionId}">
                                <option value="${position.positionId}" selected><c:out
                                        value="${position.positionName}"></c:out></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${position.positionId}"><c:out
                                        value="${position.positionName}"></c:out></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>

        </tr>
        <tr>
            <th>EducationDegree</th>
            <td>
                <select name="educationDegree">
                    <c:forEach var="educationDegree" items="${educationDegrees}">
                        <c:choose>
                            <c:when test="${educationDegree.educationDegreeId==employee.educationDegree.educationDegreeId}">
                                <option value="${educationDegree.educationDegreeId}" selected><c:out
                                        value="${educationDegree.educationDegreeName}"></c:out></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${educationDegree.educationDegreeId}"><c:out
                                        value="${educationDegree.educationDegreeName}"></c:out></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>Division</th>
            <td>
                <select name="division">
                    <c:forEach var="division" items="${divisions}">
                        <c:choose>
                            <c:when test="${division.divisionId==employee.division.divisionId}">
                                <option value="${division.divisionId}" selected><c:out
                                        value="${division.divisionName}"></c:out></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${division.divisionId}"><c:out
                                        value="${division.divisionName}"></c:out></option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th></th>
            <td><input class="btn btn-primary" type="submit" value="edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
