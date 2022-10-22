<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="get" action="/save">
    <input type="checkbox" id="vehicle1" name="vehicle1" value="Lettuce">
    <label for="vehicle1"> Lettuce</label><br>
    <input type="checkbox" id="vehicle2" name="vehicle2" value="Tomato">
    <label for="vehicle2"> Tomato</label><br>
    <input type="checkbox" id="vehicle3" name="vehicle3" value="Mustard">
    <label for="vehicle3"> Mustard</label><br><br>
    <input type="checkbox" id="vehicle4" name="vehicle4" value="Sprouts">
    <label for="vehicle4"> Sprouts</label>
    <input type="submit" value="Submit">
</form>

</body>
</html>