<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/9/2022
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<p>
    <a href="/product">Back to product list</a>
</p>
<c:if test="${error != null}">
    <h2 style="color: red">${error}</h2>
</c:if>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name Product: </td>
                <td><input type="text" name="name" value="${product.getNameProduct()}"></td>
            </tr>
            <tr>
                <td>Price Product: </td>
                <td><input type="text" name="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Date Release: </td>
                <td><input type="date" name="date" value="${requestScope["product"].getDateRelease()}"></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="number " name="quantity" value="${requestScope["product"].getQuantity()}"></td>
            </tr>
            <tr>
                <td>Status: </td>
                <td><input type="text" name="status" value="${requestScope["product"].getStatus()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
            <input type="hidden" name="action" value="update" />
        </table>
    </fieldset>
</form>
</body>
</html>
