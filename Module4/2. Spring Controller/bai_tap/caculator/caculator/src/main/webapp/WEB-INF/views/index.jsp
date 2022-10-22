<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<span><strong>${result}</strong></span>
<span><strong style="color: red">${mess}</strong></span>
<form id="calculator" action="/calculator" method="post">
    <input type="number" name="value1">
    <input type="number" name="value2">
    <select name="phep_tinh" onchange="document.getElementById('calculator').submit()">
        <option value="cong" selected>Addition(+)</option>
        <option value="tru">Subtraction(-)</option>
        <option value="nhan">Multiplication(x)</option>
        <option value="chia">Division(/)</option>
    </select>
</form>
</body>
</html>