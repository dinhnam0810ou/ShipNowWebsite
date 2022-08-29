<%-- 
    Document   : login
    Created on : Aug 22, 2022, 4:19:18 PM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-danger text-center"><spring:message code="label9"/></h1>
<c:if test="${mess==1}">
    <script>
        window.alert("Đổi mật khẩu thành công");
    </script>
</c:if>
<c:if test="${param.error != null}">
    <div class="alert alert-danger">Đã có lỗi!!Vui lòng quay lại sau</div>
</c:if>
<c:if test="${param.accessDenied != null}">
<spring:message code="user.login.error2" />
</c:if>
<c:url value="/login" var="action"/>
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username"><spring:message code="label12"/></label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password"><spring:message code="label13"/></label>
        <input type="password" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="<spring:message code="label9"/>" class="btn btn-danger"/>
        <span style="margin-left: 900px;"><a href="<c:url value="/forgotpassword"/>"><spring:message code="label11"/></a></span>
    </div>
</form>
