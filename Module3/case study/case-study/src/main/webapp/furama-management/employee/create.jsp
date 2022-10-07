<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <form action="/employee?action=create" method="post">
                                <label for="employee_id">Employee ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="employee_id" class="form-control" placeholder="Customer ID" tabindex="1" autofocus="autofocus" id="employee_id" />
                                    </div>
                                </div>

                                <label for="employee_name">Name Employee: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="name" class="form-control" placeholder="Customer Name" tabindex="3" id="employee_name" />
                                    </div>
                                </div>

                                <label for="customer_birthday">Birthday: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="date" name="birthday" class="form-control" placeholder="Birthday" tabindex="4" id="customer_birthday" />
                                    </div>
                                </div>

                                <label for="customer_id_card">ID Card: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="id_card" class="form-control" placeholder="ID Card" tabindex="6" id="customer_id_card" />
                                    </div>
                                </div>

                                <label for="employee_salary">Salary: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="salary" class="form-control" placeholder="Salary" tabindex="6" id="employee_salary" />
                                    </div>
                                </div>

                                <label for="employee_phone">Phone: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="phone" class="form-control" placeholder="Phone" tabindex="7" id="employee_phone" />
                                    </div>
                                </div>

                                <label for="employee_email">Email: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="email" class="form-control" placeholder="Email" tabindex="8" id="employee_email" />
                                    </div>
                                </div>

                                <label for="employee_address">Address: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="address" class="form-control" placeholder="Address" tabindex="9" id="employee_address" />
                                    </div>
                                </div>

                                <label for="position_id">Position ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="position" class="form-control" placeholder="Position ID" tabindex="9" id="position_id" />
                                    </div>
                                </div>

                                <label for="education_id">Education Degree ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="education" class="form-control" placeholder="Education Degree ID" tabindex="9" id="education_id" />
                                    </div>
                                </div>

                                <label for="division_id">Division ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="division" class="form-control" placeholder="Division ID" tabindex="9" id="division_id" />
                                    </div>
                                </div>

                                <button type="reset" class="btn btn-primary btn-custom" tabindex="10"><i class="fa fa-check" aria-hidden="true"></i> Reset</button>
                                <button type="submit" class="btn btn-primary btn-custom" tabindex="11"><i class="fa fa-check" aria-hidden="true"></i> Add</button>
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
