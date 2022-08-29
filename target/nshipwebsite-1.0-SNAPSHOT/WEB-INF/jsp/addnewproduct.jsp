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

    <div class="form-group">
         <label for="name">ProductName:</label>
        <form:input type="text" path="productname" class="form-control" id="productname"  name="name" />
       
    </div>  
    <div class="form-group">
        <label for="name">Description:</label>
        <form:input type="text" path="description" class="form-control" id="description"  name="name" />
        
    </div>
    <div class="form-group">
         <label for="name">Active:</label>
        <form:input type="text" path="active" class="form-control" id="active"  name="name" />
       
    </div> 
    <div class="form-group">
          <label for="name">Shipaddress:</label>
        <form:input type="text" path="shipaddress" class="form-control" id="shipaddress"  name="name" />
      
    </div>  
    <div class="form-group">
         <label for="name">Weight:</label>
        <form:input type="text" path="weight" class="form-control" id="weight"  name="name" />
       
    </div>
    <div class="form-group">
           <label for="name">Image</label>
        <form:input type="file" path="file" class="form-control" id="file"  name="name"  size="150px"/>
     
       
    </div>
    <div>
        <input type="submit" value="Them san pham" class="btn btn-danger" />
    </div>
</form:form>