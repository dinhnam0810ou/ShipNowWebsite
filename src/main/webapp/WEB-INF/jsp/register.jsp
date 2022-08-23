<%-- 
    Document   : register
    Created on : Aug 22, 2022, 8:56:58 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>


<h1 class="text-center text-info">Register</h1>
<c:url value="/register" var="action"/>
<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="username" class="form-control" id="username" placeholder="username" name="name" />
        <label for="name">Username</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" path="password" class="form-control" id="password" placeholder="password" name="name" />
        <label for="name">Password</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="password" path="confirmPassword" class="form-control" id="confirmPassword" placeholder="confirmPassword" name="name" />
        <label for="name">ConfirmPassword</label>
    </div>
    <div>
        <br>
        <input type="submit" value="Register" class="btn btn-danger" />
    </div>
</form:form>
