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
            <td>${o[0]}</td>
            <td>
                <img src="${o[1]}" width="50" height="50">
            </td>
            <td>${o[2]}</td>
            <td>${o[3]} ${o[4]}</td>
            <td>${o[5]}</td>
            <td>${o[6]}</td>
            <td>${o[7]*o[8]}</td>       
            <td>      
               <button class="btn btn-danger"><a style="text-decoration: none;color: white;" href="<c:url value="/oderofshipper/${o[10]}"/>">Đã giao</a></button>
            </td>

        </c:forEach>

    </table>
</div>
