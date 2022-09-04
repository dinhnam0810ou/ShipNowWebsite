<%-- 
    Document   : register
    Created on : Aug 22, 2022, 8:56:58 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<h1 class="text-center text-info"><spring:message code="label10"/></h1>
<c:if test="${erruser==1}">
    <div class="alert alert-danger">
        Username đã tồn tại
    </div>
</c:if>
<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:url value="/register" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-group">
        <label for="name"><spring:message code="label12"/></label>
        <form:input type="text" path="username" class="form-control" id="username"  name="name" />
        <form:errors path="username" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="name"><spring:message code="label13"/></label>
        <form:input type="password" path="password" class="form-control" id="password"  name="name" />
        <form:errors path="password" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="name"><spring:message code="label14"/></label>
        <form:input type="password" path="confirmPassword" class="form-control" id="confirmPassword"  name="name" />
    </div>
    <div>
        <br>
        <input type="submit" value="<spring:message code="label15"/>" class="btn btn-danger" />
    </div>
</form:form>
