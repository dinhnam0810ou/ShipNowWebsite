<%-- 
    Document   : customerpromotion
    Created on : Aug 25, 2022, 2:11:33 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Mã giảm giá của bạn</h1>
<div>
    <table class="table">
        <tr>
            <th>Code</th>
            <th>Quantity</th>
            <th>ExpirationDate</th>
        </tr>
        <c:forEach items="${promotions}" var="p">
            <c:if test="${p.id!=4}">
                <tr>
                    <td>${p.code}</td>
                    <td>${p.quantity}</td>
                    <td>${p.expirationdate}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <form action="<c:url value="/customerpromotion"/>" method="get">
        <input type="text" name="code" placeholder="Nhập mã giảm giá ở đây...">
        <button class="btn btn-danger"/>Xác nhận
    </form>
</div>