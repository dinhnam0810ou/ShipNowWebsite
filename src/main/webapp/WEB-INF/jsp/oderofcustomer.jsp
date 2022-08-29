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
            <th>ProductName</th>
            <th>Image</th>
            <th>Shipaddress</th>
            <th>Price</th>
            <th>ShipperName</th>
            <th>Orderdate</th>
            <th>Shipdate</th>
        </tr>
        <c:forEach items="${oderofcus}" var="o">
        <tr>
            <td>${o[0]}</td>
            <td>
                <img src="${o[1]}" width="50" height="50">
            </td>
            <td>${o[2]}</td>
            <td>${o[3]*o[4]}</td>
            <td>${o[5]} ${o[6]}</td>
            <td>${o[7]}</td>
            <td>${o[8]}</td>
        </tr>
        </c:forEach>
    </table>
</div>