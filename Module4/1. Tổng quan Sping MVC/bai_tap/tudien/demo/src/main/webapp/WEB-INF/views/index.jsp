<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/dictionary" method="post">
    <input type="text" name="english">
    <input type="submit" value="Dich">
</form>
<h1 style="color: red">${mess}</h1>
<h1>${result}</h1>
</body>
</html>