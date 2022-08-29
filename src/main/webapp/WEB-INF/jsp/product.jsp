<%-- 
    Document   : product
    Created on : Aug 14, 2022, 3:22:01 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info"><spring:message code="label3"/></h1>
<c:url value="/product" var="action" />
<form method="get" action="${action}" class="d-flex">
    <input class="form-control me-2" type="text" name="kw" placeholder="<spring:message code="label8"/>">
    <button type="submit" class="btn btn-primary" type="button"><spring:message code="label4"/></button>  
</form>
<br>
 <sec:authorize access="hasRole('ROLE_CUSTOMER')">
<button type="button" class="btn btn-danger" type="button"><a href="/nshipwebsite/addproduct" style="text-decoration: none;color: white;"><spring:message code="label21"/></a></button>  
 </sec:authorize>



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
                <sec:authorize access="hasRole('ROLE_SHIPPER')">
                    <td>                 
                        <input id="price${p.id}" type="number" placeholder="Nhập giá cho sản phẩm"/>
                        <button class="btn btn-danger" onclick="addAuction(${p.id})"><spring:message code="label22"/></button>
                    </td>  
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="<c:url value="/js/auction.js"/>"></script>
