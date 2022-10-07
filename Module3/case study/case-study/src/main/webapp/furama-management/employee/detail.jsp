<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 9/14/2022
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="UTF-8">
    <title>Create customer</title>
    <link rel="stylesheet" href="/assets/css/index.css">
    <jsp:include page="//furama-management/layout/header.jsp" />
</head>
<body>
<jsp:include page="/furama-management/layout/page-loader.jsp" />
<jsp:include page="/furama-management/layout/navbar.jsp" />
<jsp:include page="/furama-management/layout/sidebar.jsp" />
<section class="content">
    <div class="container-fluid">
        <!-- Vertical Layout -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>
                            Add new employee
                        </h2>
                        <a href="/employee">Return List</a>
                        <c:if test="${error != null}">
                            <h2 style="color: red">${error}</h2>
                        </c:if>
                        <div class="body">
                            <form action="/employee?action=detail" method="post">
                                <table>
                                    <tr>
                                        <td>Employee ID: </td>
                                        <td class="form-control">${employee.employeeId}</td>
                                    </tr>
                                    <tr>
                                        <td>Employee name: </td>
                                        <td class="form-control">${employee.employeeName}</td>
                                    </tr>
                                    <tr>
                                        <td>Employee Birthday: </td>
                                        <td class="form-control"><fmt:formatDate value="${employee.employeeBirthday}" pattern="dd/MM/yyyy" /> </td>
                                    </tr>
                                    <tr>
                                        <td>Employee ID Card: </td>
                                        <td class="form-control">${employee.employeeIdCard}</td>
                                    </tr>
                                    <tr>
                                        <td>Employee Salary: </td>
                                        <td class="form-control">${employee.employeeSalary}</td>
                                    </tr>
                                    <tr>
                                        <td>Employee Phone: </td>
                                        <td class="form-control">${employee.employeePhone}</td>
                                    </tr>
                                    <tr>
                                        <td>Employee Email: </td>
                                        <td class="form-control">${employee.employeeEmail}</td>
                                    </tr>
                                    <tr>
                                        <td>Employee Address: </td>
                                        <td class="form-control">${employee.employeeAddress}</td>
                                    </tr>
                                    <tr>
                                        <td>Position ID: </td>
                                        <td class="form-control">${employee.positionId}</td>
                                    </tr>
                                    <tr>
                                        <td>Education Degree ID: </td>
                                        <td class="form-control">${employee.educationId}</td>
                                    </tr>
                                    <tr>
                                        <td>Employee Address: </td>
                                        <td class="form-control">${employee.divisionId}</td>
                                    </tr>

                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/furama-management/layout/script.jsp" />
</body>
</html>
