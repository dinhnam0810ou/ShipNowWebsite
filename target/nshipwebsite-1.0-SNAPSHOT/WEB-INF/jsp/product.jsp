<%-- 
    Document   : product
    Created on : Aug 14, 2022, 3:22:01 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thông tin đơn hàng</h1>
<c:url value="/product" var="action" />
<form method="get" action="${action}" class="d-flex">
    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khó để tìm đơn hàng...">
    <button type="submit" class="btn btn-primary" type="button">Tìm</button>  
</form>
<br>

<button type="button" class="btn btn-danger" type="button"><a href="/nshipwebsite/addproduct" style="text-decoration: none;color: white;">Thêm đơn hàng mới</a></button>  




<c:if test="${products.size() == 0}">
    <p>
        <strong>Khong co san pham nao!!!</strong>
    </p>
</c:if>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(productCounter/pageSize)}" var="i">
        <c:url value="/product" var="u">
            <c:param name="page" value="${i}" />
        </c:url>
        <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
        </c:forEach>
</ul>


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
                <td>
                    <button class="btn btn-danger">Đấu giá</button>
                </td>    
            </tr>
        </c:forEach>
    </table>
</div>

