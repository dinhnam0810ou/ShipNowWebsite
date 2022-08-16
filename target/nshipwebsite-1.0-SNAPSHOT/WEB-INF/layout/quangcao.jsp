<%-- 
    Document   : quangcao
    Created on : Aug 16, 2022, 9:05:42 AM
    Author     : Nguyen Dinh Nam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->


    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://res.cloudinary.com/da1xygjae/image/upload/v1660657100/nen3_sfdhui.jpg" alt="Nhanh" class="d-block w-100" width="10px" height="350px">
        </div>
        <div class="carousel-item">
            <img src="https://res.cloudinary.com/da1xygjae/image/upload/v1660657091/nen1_tqlslr.png" alt="An toàn" class="d-block w-100" width="10px" height="350px">
        </div>
        <div class="carousel-item">
            <img src="https://res.cloudinary.com/da1xygjae/image/upload/v1660657083/nen2_fmswjf.png" alt="Tiết kiệm" class="d-block w-100" width="10px" height="350px">
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
  
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        </div>

</div>
