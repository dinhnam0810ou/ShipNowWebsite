<%-- 
    Document   : addnewproduct
    Created on : Aug 15, 2022, 10:51:26 AM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-danger">Them thong tin don hang</h1>
<c:url value="/addnewproduct" var="action" />
<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="productname" class="form-control" id="productname" placeholder="productname" name="name" />
        <label for="name">ProductName:</label>
    </div>  
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="description" class="form-control" id="description" placeholder="description" name="name" />
        <label for="name">Description:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="active" class="form-control" id="active" placeholder="active" name="name" />
        <label for="name">Active:</label>
    </div> 
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="shipaddress" class="form-control" id="shipaddress" placeholder="shipaddress" name="name" />
        <label for="name">Shipaddress:</label>
    </div>  
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="weight" class="form-control" id="weight" placeholder="weight" name="name" />
        <label for="name">Weight:</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" path="file" class="form-control" id="file" placeholder="file" name="name"  size="150px"/>
        <label for="name">Image</label>
       
    </div>
    <div>
        <br>
        <input type="submit" value="Them san pham" class="btn btn-danger" />
    </div>
</form:form>