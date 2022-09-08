<%-- 
    Document   : registerggshipper
    Created on : Sep 7, 2022, 8:19:07 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thông tin người dùng</h1>
<c:url value="/registerggshipper" var="action" />
<c:if test="${ggshiper!=null}">
    <form:form method="post" action="${action}" modelAttribute="ggshiper" enctype="multipart/form-data">

        <div class="form-group">
            <label for="name">FirstName</label>
            <form:input type="text" path="firstname" class="form-control" id="firstname"  name="name" />
            <form:errors path="firstname" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="name">LastName</label>
            <form:input type="text" path="lastname" class="form-control" id="lastname"  name="name" />
            <form:errors path="lastname" element="div" cssClass="text-danger" />
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
            <form:input type="email" path="email" class="form-control" id="email"  name="name" />
            <form:errors path="email" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="img">Avatar</label>
            <img class="imguserupdate rounded-circle" src="${ggshiper.avatar}" >
        </div>
        <div>
            <br>
            <input type="submit" value="Register" class="btn btn-danger" />
        </div>
    </form:form>
</c:if>