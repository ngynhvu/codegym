<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/9/2022
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Products</title>
</head>
<body>
    <h1>List Products</h1>
    <a href="/product?action=create">Add new product</a><br>
    <table border="1">
        <tr>
            <th>No</th>
            <th>ID Product</th>
            <th>Name Product</th>
            <th>Price Product</th>
            <th>Date Release</th>
            <th>Quantity Product</th>
            <th>Status Product</th>
        </tr>
        <c:forEach items="${products}" varStatus="item">
            <tr>
                <td>${item.count}</td>
                <td>${item.current.getIdProduct()}</td>
                <td>${item.current.getNameProduct()}</td>
                <td>${item.current.getPrice()}</td>
                <td><fmt:formatDate value="${item.current.getDateRelease()}" pattern="dd/MM/yyyy"/></td>
                <td>${item.current.getQuantity()}</td>
                <td>${item.current.getStatus()}</td>
                <td><a href="/product?action=detail&id=${item.current.getIdProduct()}">Detail</a></td>
                <td><a href="/product?action=update&id=${item.current.getIdProduct()}">Edit</a></td>
                <td><a href="/product?action=delete&id=${item.current.getIdProduct()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
