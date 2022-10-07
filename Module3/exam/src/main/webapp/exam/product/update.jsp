<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/9/2022
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Update Customer</title>
    <jsp:include page="/exam/layout/header.jsp" />

</head>
<body>
<jsp:include page="/exam/layout/page-loader.jsp" />
<jsp:include page="/exam/layout/navbar.jsp" />
<jsp:include page="/exam/layout/sidebar.jsp" />
<section class="content">
    <div class="container-fluid">
        <!-- Vertical Layout -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>
                            Add new customer
                        </h2>
                        <a href="/customer">Return List</a>
                        <c:if test="${error != null}">
                            <h2 style="color: red">${error}</h2>
                        </c:if>
                        <div class="body">
                            <form action="/customer?action=update" method="post">
                                <label for="customer_type_id">Type ID: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <select name="type_id" class="form-control" id="customer_type_id">

                                            <c:forEach items="${customerTypes}" varStatus="item">
                                                <option value="${item.current.customerTypeId}">${item.current.customerTypeName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <label for="customer_name">Name Customer: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="name" class="form-control" value="${customer.customerName}" placeholder="Customer Name" tabindex="3" id="customer_name" />
                                    </div>
                                </div>

                                <label for="customer_birthday">Birthday: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="date" name="birthday" class="form-control" <fmt:formatDate value="${customer.customerBirthday}"/> placeholder="Date release" tabindex="4" id="customer_birthday" />
                                    </div>
                                </div>

                                <label for="customer_gender">Gender: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <select name="gender" class="form-control" id="customer_gender">
                                            <c:if test="${customer.customerGender}">
                                                <option value="1">Male</option>
                                                <option value="0">Female</option>
                                            </c:if>
                                            <c:if test="${!customer.customerGender}">
                                                <option value="0">Female</option>
                                                <option value="1">Male</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>

                                <label for="customer_id_card">ID Card: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="id_card" class="form-control" value="${customer.customerIdCard}" placeholder="ID Card" tabindex="6" id="customer_id_card" />
                                    </div>
                                </div>

                                <label for="customer_phone">Phone: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="phone" class="form-control" value="${customer.customerPhone}" placeholder="Phone" tabindex="7" id="customer_phone" />
                                    </div>
                                </div>

                                <label for="customer_email">Email: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="email" class="form-control" value="${customer.customerEmail}'/>" placeholder="Email" tabindex="8" id="customer_email" />
                                    </div>
                                </div>

                                <label for="customer_address">Address: <span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" name="address" class="form-control" value="${customer.customerAddress}" placeholder="Address" tabindex="9" id="customer_address" />
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary btn-custom" tabindex="11"><i class="fa fa-check" aria-hidden="true"></i> Update</button>
                                <input type="hidden" name="id" value="${customer.customerId}"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/exam/layout/script.jsp" />
</body>
</html>
