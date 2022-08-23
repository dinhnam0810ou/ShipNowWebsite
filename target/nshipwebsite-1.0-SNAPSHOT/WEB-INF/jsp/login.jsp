<%-- 
    Document   : login
    Created on : Aug 22, 2022, 4:19:18 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-danger text-center">Login</h1>
<c:if test="${param.error != null}">
    <div class="alert alert-danger">Da co loi! Vui long quay lai sau</div>
</c:if>
<c:if test="${param.accessDenied != null}">
<spring:message code="user.login.error2" />
</c:if>
<c:url value="/login" var="action"/>
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Dang nhap" class="btn btn-danger"/>
    </div>
</form>
