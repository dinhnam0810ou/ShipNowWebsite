<%-- 
    Document   : oderofcustomer
    Created on : Aug 27, 2022, 9:01:54 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-info text-center">Đơn hàng</h1>
<div>
    <table class="table">
        <tr>
            <th>OderID</th>
            <th>Orderdate</th>
            <th>Shipdate</th>
            <th>Price</th>
            <th>Pay</th>
        </tr>

        <c:forEach items="${oderofcus}" var="o">
            <tr>          
                <td>${o.id}</td>
                <td>${o.orderdate}</td>
                <c:if test="${o.shipdate==null}">
                    <td>Đang giao</td>
                </c:if>
                <c:if test="${o.shipdate!=null}">
                    <td>${o.shipdate}</td>
                </c:if>
                <c:if test="${o.promotionId.discount==null}">
                    <td>${o.auctionId.price} VND</td>
                </c:if>
                <c:if test="${o.promotionId.discount!=null}">
                    <td>${o.auctionId.price*o.promotionId.discount} VND</td>
                </c:if>
                <c:if test="${o.pay==0}">
                    <td>Chưa thanh toán</td>
                </c:if>
                <c:if test="${o.pay==1}">
                    <td>Đã thanh toán</td>
                </c:if>
            </tr>
        </c:forEach>

    </table>
</div>