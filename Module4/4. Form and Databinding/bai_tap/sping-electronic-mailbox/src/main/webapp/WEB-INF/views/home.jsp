<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="mail">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="language">Language:</form:label></td>
                <td><form:select path="language">
                    <form:option value="NONE"> --SELECT--</form:option>
                    <form:options items="${languageList}"></form:options>
                </form:select></td>
            </tr>
            <tr>
                <td><form:label path="page">Pages:</form:label></td>
                <td><form:select path="page">
                    <form:options items="${pageList}"></form:options>
                </form:select></td>
            </tr>
            <tr>
                <td><form:label path="spams">Spams filter:</form:label></td>
                <td><form:checkbox path="spams" value="enable"/>Enable spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature:</form:label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Update</form:button></td>
                <td><form:button>Cancel</form:button></td>
            </tr>
            <tr>

            </tr>

        </table>
    </fieldset>
</form:form>
</body>
</html>