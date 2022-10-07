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
                            Add new service
                        </h2>
                        <a href="/service">Return List</a>
                        <c:if test="${error != null}">
                            <h2 style="color: red">${error}</h2>
                        </c:if>
                        <div class="body">
                            <form action="/service?action=create" method="post">
                                <label for="service_id">ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="id" class="form-control" placeholder="Service ID" tabindex="1" autofocus="autofocus" id="service_id" />
                                    </div>
                                </div>

                                <label for="service_name">Name Customer: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="name" class="form-control" placeholder="Customer Name" tabindex="3" id="service_name" />
                                    </div>
                                </div>

                                <label for="service_area">Service Area: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="area" class="form-control" placeholder="Service Area" tabindex="1" autofocus="autofocus" id="service_area" />
                                    </div>
                                </div>

                                <label for="service_cost">Service Cost: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="cost" class="form-control" placeholder="Service Cost" tabindex="1" autofocus="autofocus" id="service_cost" />
                                    </div>
                                </div>

                                <label for="max_people">ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="people" class="form-control" placeholder="Service ID" tabindex="1" autofocus="autofocus" id="max_people" />
                                    </div>
                                </div>

                                <label for="rent_type">ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="rent" class="form-control" placeholder="Service ID" tabindex="1" autofocus="autofocus" id="rent_type" />
                                    </div>
                                </div>

                                <label for="service_type">ID Card: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="service" class="form-control" placeholder="ID Card" tabindex="6" id="service_type" />
                                    </div>
                                </div>

                                <label for="standard_room">Phone: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="standard" class="form-control" placeholder="Phone" tabindex="7" id="standard_room" />
                                    </div>
                                </div>

                                <label for="description">Email: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="des" class="form-control" placeholder="Email" tabindex="8" id="description" />
                                    </div>
                                </div>

                                <label for="pool_area">Address: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="poolArea" class="form-control" placeholder="Address" tabindex="9" id="pool_area" />
                                    </div>
                                </div>

                                <label for="number_floors">Address: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="number" name="floors" class="form-control" placeholder="Address" tabindex="9" id="number_floors" />
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
