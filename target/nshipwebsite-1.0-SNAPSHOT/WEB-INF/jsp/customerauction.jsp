<%-- 
    Document   : customerauction
    Created on : Aug 24, 2022, 4:02:48 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Các đấu giá cho sản phẩm của bạn</h1>
<div>
    <table class="table">
        <tr>
            <th>ProductName</th>
            <th>Image</th>
            <th>ShipAddress</th>
            <th>CreateDate</th>
            <th>ShipperName</th>
            <th>AuctionPrice</th>
            <th>AuctionDate</th>
        </tr>
        <c:forEach items="${auctions}" var="a">
            <tr>
                <td>${a[0]}</td>
                <td><img class="rounded-circle" src="${a[1]}" width="70" height="70"/></td>
                <td>${a[2]}</td>
                <td>${a[3]}</td>
                 <td>${a[4]} ${a[5]}</td>
                <td>${a[6]}</td>
                <td>${a[7]}</td>
                <c:if test="${a[9]==1}">
                <td><button class="btn btn-danger"><a href="<c:url value="/customerauction/${a[8]}"/>" style="text-decoration: none;color: white;"/>Choose</button></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>