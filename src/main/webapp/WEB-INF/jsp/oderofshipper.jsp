<%-- 
    Document   : oderofshipper
    Created on : Aug 27, 2022, 9:36:33 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Đơn hàng</h1>
<div>
    <table class="table">
        <tr>
            <th>Productname</th>
            <th>Image</th>
            <th>Shipaddress</th>
            <th>CustomerName</th>
            <th>Phone</th>
            <th>CustomerAddress</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${oderofship}" var="o">
            <tr>
                <td>${o.auctionId.productId.productname}</td>
                <td>
                    <img class="rounded-circle" src="${o.auctionId.productId.image}" width="70" height="70">
                </td>
                <td>${o.auctionId.productId.shipaddress}</td>
                <td>${o.auctionId.productId.customerId.firstname} ${o.auctionId.productId.customerId.lastname}</td>
                <td>${o.auctionId.productId.customerId.phone}</td>
                <td>${o.auctionId.productId.customerId.address}</td>
                <c:if test="${o.promotionId.discount==null}">
                    <td>${o.auctionId.price} VND</td>
                </c:if>
                <c:if test="${o.promotionId.discount!=null}">
                    <td>${o.auctionId.price*o.promotionId.discount} VND</td>
                </c:if>  
                <c:if test="${o.shipdate==null}">
                    <td>      
                        <button class="btn btn-danger" id="btn${o.id}" onclick="hide(${o.id})"><a style="text-decoration: none;color: white;" href="<c:url value="/oderofshipper/${o.id}"/>">Cập nhật</a></button>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    function hide(id) {
        document.getElementById("btn" + id).style.display = 'none';
        window.alert("Đã xác nhận giao");
    }

</script>