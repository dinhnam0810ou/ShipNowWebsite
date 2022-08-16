<%-- 
    Document   : header
    Created on : Aug 7, 2022, 8:12:08 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">SHIPNOW ONLINE</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>"><spring:message code="label1"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>"><spring:message code="label2"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/product"/>"><spring:message code="label3"/></a>
                </li>
            </ul>

            <div class="dropdown" style="padding: 5px">
                <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
                    <spring:message code="label5"/>
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="?lang=vi"><spring:message code="label6"/></a></li>
                    <li><a class="dropdown-item" href="?lang=en"><spring:message code="label7"/></a></li>
                </ul>
            </div>

            <c:url value="/" var="action" />

            <form method="get" action="${action}" class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="<spring:message code="label8"/>">
                <button type="submit" class="btn btn-primary" type="button"><spring:message code="label4"/></button>
            </form>
        </div>
    </div>
</nav>

