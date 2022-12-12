<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- Navbar  -->
<nav class="navbar-top navbar-default navbar-fixed-top nav-custom">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${contextPath}"><img src="${contextPath}/assets/img/codegym-logo.png" alt=""></a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav" style="margin-left: 270px">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false">Home
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${contextPath}/product?action=list">List products</a></li>
                        <li><a href="${contextPath}/product?action=create">Create product</a></li>
                    </ul>
                </li>
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
    aria-expanded="false">Employee
    <span class="caret"></span></a>
    <ul class="dropdown-menu">
    <li><a href="${contextPath}/employee?action=list">List employees</a></li>
    <li><a href="${contextPath}/employee?action=create">Create employees</a></li>
    </ul>
    </li>
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
    aria-expanded="false">Customer
    <span class="caret"></span></a>
    <ul class="dropdown-menu">
    <li><a href="${contextPath}/customer?action=list">List products</a></li>
    <li><a href="${contextPath}/customer?action=create">Create product</a></li>
    </ul>
    </li>
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
    aria-expanded="false">Service
    <span class="caret"></span></a>
    <ul class="dropdown-menu">
    <li><a href="${contextPath}/service?action=list">List service</a></li>
    <li><a href="${contextPath}/service?action=create">Create service</a></li>
    </ul>
    </li>
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
    aria-expanded="false">Contract
    <span class="caret"></span></a>
    <ul class="dropdown-menu">
    <li><a href="${contextPath}/customer?action=list">List products</a></li>
    <li><a href="${contextPath}/customer?action=create">Create product</a></li>
    </ul>
    </li>
            </ul>
        </div>
    </div>
</nav>