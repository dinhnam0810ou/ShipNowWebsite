<%-- 
    Document   : promotion
    Created on : Aug 16, 2022, 7:36:06 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Mã khuyến mãi</h1>

<c:url value="/admin/promotion" var="action" />
<form:form method="post" action="${action}" modelAttribute="promotion">

    <div class="form-group">
        <label for="name">Discount</label>
        <form:input type="number" path="discount" class="form-control" id="discount"  name="name" />
        <form:errors path="discount" element="div" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="name">Code</label>
        <form:input type="text" path="code" class="form-control" id="code"  name="name" />
        <form:errors path="code" element="div" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="name">Expirationdate</label>
        <form:input type="text" path="expirationdate" class="form-control" id="expirationdate"  name="name" />
        <form:errors path="expirationdate" element="div" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="name">Quantity</label>
        <form:input type="number" path="quantity" class="form-control" id="quantity"  name="name" />
        <form:errors path="quantity" element="div" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="name">Description</label>
        <form:input type="text" path="description" class="form-control" id="description"  name="name" />
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div> 
    <div>
        <br>
        <input type="submit" value="Add Promotion" class="btn btn-danger" />
    </div>
</form:form>



<div>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Discount</th>
            <th>Createdate</th>
            <th>Expirationdate</th>
            <th>Quantity</th>
            <th>Code</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${promotions}" var="p">
            <c:if test="${p.id!=4}">
            <tr>
                <td>${p.id}</td>
                <td>${p.discount}%</td>
                <td>${p.createdate}</td>
                <td>${p.expirationdate}</td>
                <td>${p.quantity}</td>
                <td>${p.code}</td>
                <td>${p.description}</td>
            </tr>
            </c:if>
        </c:forEach>
    </table>
</div>