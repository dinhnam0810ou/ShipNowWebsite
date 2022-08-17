<%-- 
    Document   : chat
    Created on : Aug 14, 2022, 9:13:07 AM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">CHAT</h1>
<style>

    /* Nút Để Mở Chatbox */

    /* Thêm style cho form */
    .form-container {
        margin: auto;

        border: 5px solid aqua;
        max-width: 500px;
        padding: 10px;
        background-color: white;
    }
    /* thiết lập style textarea */
    .form-container input {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        border: 2px solid yellow;
        background: #f1f1f1;
        resize: none;
        min-height: 50px;
    }
    /*thiết lập style cho textarea khi được focus */
    .form-container input:focus {
        background-color: #ddd;
        outline: none;
    }
    /* Thiết lập style cho nút trong form*/
    .form-container .btn {
        background-color: #4CAF50;
        color: white;
        padding: 16px 20px;
        border: none;
        cursor: pointer;
        width: 100%;
        margin-bottom:10px;
        opacity: 0.8;
    }

</style>



<div class="Chatbox" id="myForm">
    <form action="" class="form-container" onsubmit="addText()">    
        <label>
            <ul id="tinnhan">

            </ul>
        </label>
        <input id="txtChat" placeholder="Nhap tin nhan...."></input>
        <button type="submit" class="btn">Gửi</button>

    </form>

    <script src="https://www.gstatic.com/firebasejs/8.2.9/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.2.9/firebase-database.js"></script>
    <script src="<c:url value="/js/chat.js"/>"></script>
