<%-- 
    Document   : pay
    Created on : Aug 24, 2022, 9:32:26 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thanh toán</h1>
<c:if test="${mess1==102}">
    <script>window.alert("Tạo đơn hàng không thành công!!Vui lòng thử lại");</script>
</c:if>
<div>
    <table class="table">
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
                <td>${a[4]}</td>
            </tr>

        </table>
        <a href="<c:url value="/customerpromotion"/>"><ins>Chọn mã giảm giá</ins></a>&emsp;&ensp;
        <span>Tong thanh toan:${dis*a[4]}</span>
        <br>
        <br>
        <form method="post" action="<c:url value="/customerauction/${auctionId}"/>">
            <button class="btn btn-danger">Xác nhận</button>
        </form>
    </c:forEach>  
</div>
