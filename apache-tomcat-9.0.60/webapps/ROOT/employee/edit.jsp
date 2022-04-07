<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/22/2022
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%><%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url("https://www.color-hex.com/palettes/104061.png");
        }
    </style>
</head>
<body>
<h2>
    <a href="employee?action=employeeList">Back List Employee</a>
</h2>
<div align="center">
    <form method="post">
        <h1> Edit Employee Information</h1>
        <table border="1" cellpadding="9">
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${employee.name}' />"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="45"
                           value="<c:out value='${employee.birthday}' />"/>
                </td>
            </tr>

            <tr>
                <th>IdCard:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${employee.idCard}' />"/>
                </td>
            </tr>
            <tr>
                <th>Salary:</th>
                <td>
                    <input type="text" name="salary" size="45"
                           value="<c:out value='${employee.salary}' />"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${employee.phone}' />"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${employee.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${employee.address}' />"/>
                </td>
            </tr>
            <tr>
                <th>Position:</th>
                <td>
                    <select name="position">
                        <c:forEach var="position" items="${positions}">
                            <c:choose>
                                <c:when test="${position.positionId==employee.position.positionId}">
                                    <option value="${position.positionId}" selected><c:out value="${position.positionName}"></c:out></option>

                                </c:when>
                                <c:otherwise>
                                    <option value="${position.positionId}" ><c:out value="${position.positionName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>EducationDegree:</th>
                <td>
                    <select name="educationDegree">
                        <c:forEach var="educationDegree" items="${educationDegrees}">
                            <c:choose>
                                <c:when test="${educationDegree.educationDegreeId==employee.educationDegree.educationDegreeId}">
                                    <option value="${educationDegree.educationDegreeId}" selected><c:out value="${educationDegree.educationDegreeName}"></c:out></option>

                                </c:when>
                                <c:otherwise>
                                    <option value="${educationDegree.educationDegreeId}" ><c:out value="${educationDegree.educationDegreeName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>division:</th>
                <td>
                    <select name="division">
                        <c:forEach var="division" items="${divisions}">
                            <c:choose>
                                <c:when test="${division.divisionId==employee.division.divisionId}">
                                    <option value="${division.divisionId}" selected><c:out value="${division.divisionName}"></c:out></option>

                                </c:when>
                                <c:otherwise>
                                    <option value="${division.divisionId}" ><c:out value="${division.divisionName}"></c:out></option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

