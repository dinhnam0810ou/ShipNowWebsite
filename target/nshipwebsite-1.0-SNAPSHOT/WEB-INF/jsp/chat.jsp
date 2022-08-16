<%-- 
    Document   : chat
    Created on : Aug 14, 2022, 9:13:07 AM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">CHAT</h1>

<ul id="tinnhan"></ul>

<form id="chat-form">
    <input type="text" id="txtChat" placeholder="Nhap tin nhan..."/>
    <button type="submit" id="btnSubmit" onclick="addText()">Gui</button>
</form>



<script src="https://www.gstatic.com/firebasejs/8.2.9/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.9/firebase-database.js"></script>
<script src="<c:url value="/js/chat.js"/>"></script>
