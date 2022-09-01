<%-- 
    Document   : provision
    Created on : Aug 30, 2022, 8:43:00 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Provision</h1>
<div>
    <P> Điều khoản rành buộc người dùng: </P> 
    <P> Điều khoản rành buộc shipper: </P> 
    <input type="checkbox" id="vehicle1" name="vehicle1"><span>Tôi đồng ý với tất cả điều khoản trên</span>
    <br>
    <span><a href="<c:url value="/registershipper"/>">Đăng ký shipper</a></span>
    <span><a href="<c:url value="/registercustomer"/>">Đăng ký Customer</a></span>
</div>

