<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2022
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <h1>Product Discount Calculator</h1>
  <form method="post" action="/discount">
    <label>Product Description:</label><br>
    <input type="text" name="des"><br>
    <label>List Price:</label><br>
    <input type="text" name="price"><br>
    <label>Discount Percent:</label><br>
    <input type="text" name="percent"><br>
    <input type="submit" id="submit" value="Calculate Discount">
  </form>
  </body>
</html>
