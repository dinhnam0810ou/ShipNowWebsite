<%-- 
    Document   : forgotpassword
    Created on : Aug 27, 2022, 2:40:42 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info"><spring:message code="label11"/></h1>
<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<form method="post">
    <div class="form-group">
        <label for="username"><spring:message code="label12"/></label>
        <input class="form-control" type="text" id="username" name="username" autocomplete="off">
    </div>
    <div class="form-group">
        <br>
        <button class="btn btn-danger"><spring:message code="label15"/></button>
    </div>
</form>