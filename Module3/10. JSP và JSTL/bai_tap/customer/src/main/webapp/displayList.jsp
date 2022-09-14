<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .card-list{
            position: relative;
            width: 50%;
            left: 25%;
            margin: 0;
            padding: 0;
            border: 1px solid darkgray;
        }
        h1{
            text-align: center;
        }
        table{
            width: 100%;
        }
        img{
            position: relative;
            left: 28px;
        }
    </style>
</head>
<body>
<div class="card-list">
    <h1>Danh sách khách hàng</h1>
    <table>
        <tr>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Dịa Chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="cus" items="${customer}" varStatus="status">
            <tr>
                <td>${cus.getName()}</td>
                <td>${cus.getBirthday()}</td>
                <td>${cus.getAddress()}</td>
                <td><img src="${cus.getLinkImg()}" height="200px" width="150px"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
