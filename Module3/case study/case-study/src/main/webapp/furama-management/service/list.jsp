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
                        <h2>Service list</h2>
                    </div>
                    <div class="body table-responsive">
                        <a href="/service?action=create" class="btn btn-primary btn-custom">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i> Add new service
                        </a>
                        <table class="table table-striped" id="dataTable-listMember">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>ID Service</th>
                                <th>Name Service</th>
                                <th>Area Service</th>
                                <th>Service Cost</th>
                                <th>Max People</th>
                                <th>Rent Type ID</th>
                                <th>Service Type ID</th>
                                <th>Standard Room</th>
                                <th>Description</th>
                                <th>Pool Area</th>
                                <th>Floors</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${services}" varStatus="item">
                                <tr>
                                    <td>${item.count }</td>
                                    <td>${item.current.serviceId}</td>
                                    <td>${item.current.serviceName}</td>
                                    <td>${item.current.serviceArea}</td>
                                    <td>${item.current.service_cost}</td>
                                    <td>${item.current.people}</td>
                                    <td>${item.current.rentTypeId}</td>
                                    <td>${item.current.serviceTypeId}</td>
                                    <td>${item.current.standardRoom}</td>
                                    <td>${item.current.other}</td>
                                    <td>${item.current.poolArea}</td>
                                    <td>${item.current.floors}</td>
                                    <td>
                                        <a href="/service?action=detail&id=${item.current.serviceId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-circle-fill" viewBox="0 0 16 16">
                                            <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                                        </svg></a>
                                        <a href="/service?action=update&id=${item.current.serviceId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                        </svg></a>
                                        <a href="/service?action=delete&id=${item.current.serviceId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
                                            <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
                                        </svg></a>
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
