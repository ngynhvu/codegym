<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/9/2022
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/product">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Name Product: </td>
        <td>${product.getNameProduct()}</td>
    </tr>
    <tr>
        <td>Price Product: </td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>
    <tr>
        <td>Date release: </td>
        <td><fmt:formatDate value="${requestScope['product'].getDateRelease()}" pattern="dd/MM/yyyy"/></td>
    </tr>
    <tr>
        <td>Quantity: </td>
        <td>${requestScope["product"].getQuantity()}</td>
    </tr>
    <tr>
        <td>Status: </td>
        <td>${requestScope["product"].getStatus()}</td>
    </tr>
</table>
</body>
</html>