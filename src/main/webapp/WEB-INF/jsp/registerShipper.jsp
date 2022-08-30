<%--
    Document   : registerShipper
    Created on : Aug 22, 2022, 9:23:09 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info"><spring:message code="label23"/></h1>
<c:url value="/registershipper" var="action" />
<form:form method="post" action="${action}" modelAttribute="shipper" enctype="multipart/form-data">

    <div class="form-group">
        <label for="name">FirstName</label>
        <form:input type="text" path="firstname" class="form-control" id="firstname" name="name" />
        <form:errors path="firstname" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="name">LastName</label>
        <form:input type="text" path="lastname" class="form-control" id="lastname" name="name" />
        <form:errors path="lastname" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="name">Identification</label>
        <form:input type="text" path="identification" class="form-control" id="identification"  name="name" />
        <form:errors path="identification" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="name">Phone</label>
        <form:input type="text" path="phone" class="form-control" id="phone"  name="name" />
        <form:errors path="phone" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="name">Email</label>
        <form:input type="text" path="email" class="form-control" id="email"  name="name" />
        <form:errors path="email" cssClass="text-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="name">Avatar</label>
        <form:input type="file" path="file" class="form-control" id="file"  name="name"  size="150px"/>
        <form:errors path="file" cssClass="text-danger" element="div"/>
    </div>
    <div>
        <input type="submit" value="Register" class="btn btn-danger" />
    </div>
</form:form>