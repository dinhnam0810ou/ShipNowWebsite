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

<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<h1 class="text-center text-info"><spring:message code="label10"/></h1>
<c:url value="/register" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="username" class="form-control" id="username" placeholder="username" name="name" />
        <label for="name"><spring:message code="label12"/></label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" path="password" class="form-control" id="password" placeholder="password" name="name" />
        <label for="name"><spring:message code="label13"/></label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" path="confirmPassword" class="form-control" id="confirmPassword" placeholder="confirmPassword" name="name" />
        <label for="name"><spring:message code="label14"/></label>
    </div>
    <div>
        <br>
        <input type="submit" value="<spring:message code="label15"/>" class="btn btn-danger" />
    </div>
</form:form>
