<%-- 
    Document   : productnotaucion
    Created on : Aug 15, 2022, 5:14:10 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thông tin sản phẩm chưa được đấu giá</h1>
<div>
    <table class="table">
        <tr>
            <th>ProductName</th>
            <th>Weight</th>
            <th>Shipaddress</th>
            <th>Active</th>
            <th>Image</th>
            <th>Description</th>
            <th>CreateDate</th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.productname}</td>
                <td>${p.weight}</td>
                <td>${p.shipaddress}</td>
                <td>${p.active}</td>
                <td><img src="${p.image}"  class="card-img-top rounded-circle" width="40" height="40" /></td>         
                <td>${p.description}</td>                   
                <td>${p.createdDate}</td>                
            </tr>
        </c:forEach>
    </table>
</div>
