<%-- 
    Document   : shipper.jsp
    Created on : Aug 8, 2022, 9:05:59 AM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">QUẢN LÝ SHIPPER</h1>

<c:url value="/admin/shippers" var="action" />
<form:form method="post" action="${action}" modelAttribute="shipper" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="firstname" class="form-control" id="firstname" placeholder="firstname" name="name" />
        <label for="name">FirstName</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="lastname" class="form-control" id="lastname" placeholder="lastname" name="name" />
        <label for="name">LastName</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="identification" class="form-control" id="identification" placeholder="identification" name="name" />
        <label for="name">Identification</label>
        <form:errors path="identification" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="phone" class="form-control" id="phone" placeholder="phone" name="name" />
        <label for="name">Phone</label>
        <form:errors path="phone" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="email" class="form-control" id="email" placeholder="email" name="name" />
        <label for="name">Email</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="active" class="form-control" id="active" placeholder="active" name="name" />
        <label for="name">Active</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" path="file" class="form-control" id="file" placeholder="file" name="name"  size="150px"/>
        <label for="name">Avatar</label>
        <form:errors path="file" cssClass="alert alert-danger" element="div"/>
    </div>
    <div>
        <br>
        <input type="submit" value="Add shipper" class="btn btn-danger" />
    </div>
</form:form>

<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table">
    <tr>
        <th>Phone</th>
        <th>Identification</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Avatar</th>
        <th>Email</th>
        <th>Active</th>
    </tr>
    <tbody id="myShipper">

    </tbody>
</table>
<script src="<c:url value="/js/shipper.js"/>"></script>
<script>
    <c:url value="/api/shippers" var="s" />
    window.onload = function () {
        getShippers('${s}');
    }
</script>