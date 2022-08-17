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

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="discount" class="form-control" id="discount" placeholder="discount" name="name" />
        <label for="name">Discount</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="expirationdate" class="form-control" id="expirationdate" placeholder="expirationdate" name="name" />
        <label for="name">Expirationdate</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="quantity" class="form-control" id="quantity" placeholder="quantity" name="name" />
        <label for="name">Quantity</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="description" class="form-control" id="description" placeholder="description" name="name" />
        <label for="name">Description</label>

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
            <th>Description</th>
        </tr>
        <c:forEach items="${promotions}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.discount}%</td>
                <td>${p.createdate}</td>
                <td>${p.expirationdate}</td>
                <td>${p.quantity}</td>
                <td>${p.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>