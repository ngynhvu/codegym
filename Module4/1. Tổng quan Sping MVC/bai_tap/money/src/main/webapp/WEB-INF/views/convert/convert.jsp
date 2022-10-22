<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/10/2022
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/money" method="get">
    <table>
        <tr>
            <td><label></label></td>
            <td><input type="number" name="tien" placeholder="Money..."></td>
        </tr>
        <tr>
            <td></td>
            <td><select name="option">
                <option value="24.400">USD --> VND</option>
                <option value="0.00004">VND --> USA</option>
            </select></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Convert" ></td>
        </tr>
    </table>
</form>
<h1>${result}</h1>
</body>
</html>
