<%-- 
    Document   : oder
    Created on : Aug 15, 2022, 4:41:55 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thông tin đơn hàng</h1>
<div>
    <table class="table">
        <tr>
            <th>OrderId</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>ProductName</th>
            <th>OderDate</th>         
        </tr>
        <c:forEach items="${oders}" var="o">
            <tr>
                <td>${o[0]}</td>
                <td>${o[1]}</td>
                <td>${o[2]}</td>
                <td>${o[3]}</td>
                <td>${o[4]}</td>
            </tr>
        </c:forEach>
    </table>
</div>
