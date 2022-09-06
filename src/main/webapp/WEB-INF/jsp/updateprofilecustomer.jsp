<%-- 
    Document   : updateprofilecustomer
    Created on : Sep 6, 2022, 9:11:18 AM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-info text-center">Thông tin người dùng</h1>
<style>
    .imguserupdate{
        width: 150px;
        height: 150px;
    }
</style>
<c:if test="${update!=null}">
    <div class="alert alert-danger">
        ${update}
    </div>
</c:if>
<c:if test="${currentcustomer!=null}">
    <c:url value="/updateprofilecustomer" var="action" />
    <form:form method="post" action="${action}" modelAttribute="currentcustomer" enctype="multipart/form-data">

        <div class="form-group">
            <label for="name">FirstName</label>
            <form:input type="text" path="firstname" class="form-control" id="firstname"  name="name" />
            <form:errors path="firstname" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="name">LastName</label>
            <form:input type="text" path="lastname" class="form-control" id="lastname"  name="name" />
            <form:errors path="lastname" cssClass="text-danger" element="div"/>
        </div>  
        <div class="form-group">
            <label for="name">Phone</label>
            <form:input type="text" path="phone" class="form-control" id="phone"  name="name" />
            <form:errors path="phone" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="name">Email</label>
            <form:input type="email" path="email" class="form-control" id="email"  name="name" />
            <form:errors path="email" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="name">Address</label>
            <form:input type="text" path="address" class="form-control" id="address"  name="name" />
            <form:errors path="address" cssClass="text-danger" element="div"/>
        </div>
        <div class="form-group">
            <label for="name">Avatar</label>
            <img class="imguserupdate rounded-circle" src="${currentcustomer.avatar}" >
            <form:input type="file" path="file" class="form-control" id="file"  name="name"  size="150px"/>
            <form:errors path="file" cssClass="text-danger" element="div"/>
        </div>
        <div>
            <input type="submit" value="Update" class="btn btn-danger" />
        </div>
    </form:form>
</c:if>      
