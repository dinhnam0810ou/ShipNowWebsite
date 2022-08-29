<%-- 
    Document   : completepassword
    Created on : Aug 27, 2022, 4:17:43 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Quên mật khẩu</h1>
<c:if test="${errMsg!=null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:if test="${mess==1}">
    <script>
        window.alert("Shipnow da gui ma xac nhan vao email cua ban");
    </script>
</c:if>
    <form method="post">
    <div class="form-group">
        <label for="newpassword">NewPassword</label>
        <input type="password" id="newpassword" class="form-control" name="newpassword">
    </div>
    <div class="form-group">
        <label for="confirmpassword">ConfirmPassword</label>
        <input type="password" id="confirmpassword" class="form-control" name="confirmpassword">
    </div>
    <div class="form-group">
        <input type="number" id="code" class="form-control" name="code" placeholder="Nhap ma xac nhan...">
    </div>
    <div class="form-group">
        <br>
        <button class="btn btn-danger">Xac nhan</button>
    </div>
</form>
