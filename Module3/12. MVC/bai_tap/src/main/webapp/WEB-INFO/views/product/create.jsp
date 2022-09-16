<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/9/2022
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
</head>
<body>
    <h1>Add new Product</h1>
    <c:if test="${error != null}">
        <h2 style="color: red">${error}</h2>
    </c:if>
    <form action="/product" method="post">
        <table>
            <tr>
                <td>ID Products: </td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>Name Products: </td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Price Products: </td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td>Date Release: </td>
                <td><input type="date" name="dateRelease"/></td>
            </tr>
            <tr>
                <td>Quantity Products: </td>
                <td><input type="number" name="quantity"/></td>
            </tr>
            <tr>
                <td>Status Products: </td>
                <td><input type="text" name="status"/></td>
            </tr>
            <tr>
                <td>
                    <input type="reset" value="Reset" />
                </td>
                <td>
                    <input type="submit" value="Submit" />
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="create" />
    </form>
</body>
</html>
