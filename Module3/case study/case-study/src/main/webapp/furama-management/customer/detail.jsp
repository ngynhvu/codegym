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
                            Add new customer
                        </h2>
                        <a href="/customer">Return List</a>
                        <c:if test="${error != null}">
                            <h2 style="color: red">${error}</h2>
                        </c:if>
                        <div class="body">
                            <form action="/customer?action=detail" method="post">
                                <table>
                                    <tr>
                                        <td>Customer ID: </td>
                                        <td class="form-control">${customer.customerId}</td>
                                    </tr>
                                    <tr>
                                        <td>Customer Type ID: </td>
                                        <td class="form-control">${customer.customerTypeId}</td>
                                    </tr>
                                    <tr>
                                        <td>Customer Birthday: </td>
                                        <td class="form-control"><fmt:formatDate value="${customer.customerBirthday}" pattern="dd/MM/yyyy" /> </td>
                                    </tr>
                                    <tr>
                                        <td>Customer Gender: </td>
                                        <c:if test="${customer.customerGender}">
                                            <td class="form-control">Male</td>
                                        </c:if>
                                        <c:if test="${!customer.customerGender}">
                                            <td class="form-control" >Female</td>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <td>Customer ID Card: </td>
                                        <td class="form-control">${customer.customerIdCard}</td>
                                    </tr>
                                    <tr>
                                        <td>Customer Phone: </td>
                                        <td class="form-control">${customer.customerPhone}</td>
                                    </tr>
                                    <tr>
                                        <td>Customer Address: </td>
                                        <td class="form-control">${customer.customerEmail}</td>
                                    </tr>
                                    <tr>
                                        <td>Customer Address: </td>
                                        <td class="form-control">${customer.customerAddress}</td>
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
