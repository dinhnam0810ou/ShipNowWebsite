<%-- 
    Document   : listshipper
    Created on : Aug 19, 2022, 10:27:13 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1 class="text-center text-info"><spring:message code="label2"/></h1>
<c:if test="${shippers.size() == 0}">
    <p>
        <strong>Không có shipper nào!!!</strong>
    </p>
</c:if>
<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(shipperCounter/pageSize)}" var="i">
        <c:url value="/listshipper" var="u">
            <c:param name="page" value="${i}" />
        </c:url>
        <li class="page-item"><a class="page-link" href="${u}">Trang ${i}</a></li>
        </c:forEach>
</ul>
<div class="row">
    <c:forEach items="${shippers}" var="s">
        <div class="col-md-3     col-xs-12" style="padding:10px;">
            <div class="card" >
                <a href="<c:url value="/${s.id}"/>">
                <img class="card-img-top" src="${s.avatar}" alt="Card image" width="0" height="200"/>
                </a>
                <div class="card-body">
                    <h4 class="card-title">${s.firstname} ${s.lastname}</h4>
                    <p class="card-text">SĐT: ${s.phone}</p>
                    <p class="card-text">Email: ${s.email}</p>
                    <a href="<c:url value="/${s.id}"/>" class="btn btn-primary"><spring:message code="label20"/></a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
