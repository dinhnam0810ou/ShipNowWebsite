<%-- 
    Document   : shipperauction
    Created on : Aug 24, 2022, 2:02:35 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thông tin đấu giá của bạn</h1>
<div>
    <table class="table">
        <tr>
            <th>ProductName</th>
            <th>ShipAddress</th>
            <th>Price</th>
            <th>AuctionDate</th>
        </tr>
        <c:forEach items="${auctions}" var="a">
        <tr>
            <td>${a[0]}</td>
            <td><img src="${a[1]}" width="50" height="50"/></td>
            <td>${a[2]}</td>
            <td>${a[3]}</td>
            <td>${a[4]}</td>
            <td><button class="btn btn-danger">Delete</button></td>
        </tr>
        </c:forEach>
    </table>
</div>