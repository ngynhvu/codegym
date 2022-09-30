<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/9/2022
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
    <jsp:include page="/furama-management/layout/header.jsp" />

</head>
<body>
<jsp:include page="/furama-management/layout/page-loader.jsp" />
<jsp:include page="/furama-management/layout/navbar.jsp" />
<jsp:include page="//furama-management/layout/sidebar.jsp" />
<section class="content">
    <div class="container-fluid">
        <!-- Vertical Layout -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Customer list</h2>
                    </div>
                    <div class="body table-responsive">
                        <a href="/customer?action=create" class="btn btn-primary btn-custom">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i> Add new customer
                        </a>
                        <table class="table table-striped" id="dataTable-listStudent">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>ID</th>
                                <th>Type ID</th>
                                <th>Name</th>
                                <th>Birthday</th>
                                <th>Gender</th>
                                <th>ID Card</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${customers}" varStatus="item">
                                <tr>
                                    <td>${item.count }</td>
                                    <td>${item.current.customerId}</td>
                                    <td>${item.current.customerTypeId}</td>
                                    <td>${item.current.customerName}</td>
                                    <td><fmt:formatDate value="${item.current.customerBirthday}" pattern="dd/MM/yyyy" /> </td>
                                    <c:if test="${item.current.customerGender}">
                                        <td>Male</td>
                                    </c:if>
                                    <c:if test="${!item.current.customerGender}">
                                        <td>Female</td>
                                    </c:if>
                                    <td>${item.current.customerIdCard}</td>
                                    <td>${item.current.customerPhone}</td>
                                    <td>${item.current.customerEmail}</td>
                                    <td>${item.current.customerAddress}</td>
                                    <td>
                                        <a href="/customer?action=update&id=${item.current.customerId}">Update</a>
                                        <a href="/customer?action=delete&id=${item.current.customerId}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/furama-management/layout/script.jsp" />
<jsp:include page="/furama-management/layout/footer.jsp" />
</body>
</html>
