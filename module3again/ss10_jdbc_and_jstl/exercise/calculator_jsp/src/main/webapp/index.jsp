<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/13/2022
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/calculator">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand</td>
                <td><input type="text" name="first-operand" placeholder="First Operand"></td>
            </tr>
            <tr>
                <td>Operator</td>
                <td>
                    <select name="operator">
                    <option value="+">Addition</option>
                    <option value="-">Subtraction</option>
                    <option value="*">Multiplication</option>
                    <option value="/">Division</option>
                </select><br></td>
            </tr>
            <tr>
                <td>Second operand</td>
                <td><input type="text" name="second-operand" placeholder="Second Operand"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"></td>
            </tr>
        </table>

    </fieldset>


</form>
</body>
</html>
