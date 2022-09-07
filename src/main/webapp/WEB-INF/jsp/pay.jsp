<%-- 
    Document   : pay
    Created on : Aug 24, 2022, 9:32:26 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thanh toán</h1>
<c:if test="${mess1==102}">
    <script>window.alert("Tạo đơn hàng không thành công!!Vui lòng thử lại");</script>
</c:if>
<style>
    .tpay tr:nth-child(1){
        background-color:white;
    }
    .tpay th{
        background-color:skyblue;
    }
</style>
<div>
    <table class="table tpay">
        <c:forEach items="${auction}" var="a">
            <tr>
                <th>ProductName</th>
                <td>${a[0]}</td>
            </tr>
            <tr>
                <th>Shipaddress</th>
                <td>${a[1]}</td>
            </tr>
            <tr>
                <th>ShipperName</th>
                <td>${a[2]} ${a[3]}</td>
            </tr>
            <tr>
                <th>Price</th>
                <td><fmt:formatNumber type="number" value="${a[4]}" maxFractionDigits="3" /> VND</td>
            </tr>

        </table>
        <a href="<c:url value="/customerpromotion"/>"><ins>Chọn mã giảm giá</ins></a>&emsp;&ensp;
        <a href="<c:url value="${url}"/>"><ins>Thanh toán momo</ins></a>&emsp;&ensp;
        <span>Tổng thanh toán: <fmt:formatNumber type="number" value="${dis*a[4]}" maxFractionDigits="3" /> VND </span>
        <br>
        <br>
        <form method="post" action="<c:url value="/customerauction/${auctionId}"/>">
            <button class="btn btn-danger">Xác nhận</button>
        </form>
    </c:forEach>  
</div>
