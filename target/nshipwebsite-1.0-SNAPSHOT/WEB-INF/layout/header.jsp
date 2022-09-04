<%-- 
    Document   : header
    Created on : Aug 7, 2022, 8:12:08 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .imguser{
        width: 40px;
        height: 40px;
    }
</style>
<c:if test="${mess==201}">
    <script>
        window.alert("Đã đăng ký thành công!!Hãy đăng nhập");
    </script>
</c:if>
<div style="padding-bottom: 50px; margin-top: 8px;">
    <span style="float: right; margin-left: 10px;">
        <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
            <spring:message code="label5"/>
        </button>

        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="?lang=vi"><spring:message code="label6"/></a></li>
            <li><a class="dropdown-item" href="?lang=en"><spring:message code="label7"/></a></li>
        </ul>
    </span>
    <span style="float: right;">
        <sec:authorize access="!isAuthenticated()">
            <button class="btn btn-outline-secondary">
                <a href="<c:url value="/login"/>"><span class="fa-solid fa-right-to-bracket text-danger"></span> <spring:message code="label9"/></a>
            </button>
            <button class="btn btn-outline-secondary">
                <a href="<c:url value="/register"/>"><span class="fa-solid fa-user-plus text-danger"></span> <spring:message code="label10"/></a>
            </button>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">   
            <c:if test="${currentshipper!=null}">
                <img  src="${currentshipper.avatar}" class="imguser img-fluid rounded-circle" >
            </c:if>
            <c:if test="${currentcustomer!=null}">
                <img src="${currentcustomer.avatar}" class="imguser img-fluid rounded-circle" >
            </c:if>      
            <a href="#">${pageContext.request.userPrincipal.name}</a>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <button class="btn btn-outline-secondary">
                    <a href="<c:url value="/admin/"/>"><span class="fa-solid fa-person-shelter text-danger"></span> Go to Admin Dashboard</a>
                </button>
            </sec:authorize>
            <button class="btn btn-outline-secondary">
                <a href="<c:url value="/chat"/>"><span class="fa-brands fa-rocketchat text-danger"></span> <spring:message code="label25"/></a>
            </button>
            <button class="btn btn-outline-secondary">
                <a href="<c:url value="/logout"/>"><spring:message code="label19"/></a>
            </button>
        </sec:authorize>

    </span>

</div>



<div class="hero_area">

    <!-- header section strats -->
    <section class="header_section">
        <div class="container">

            <div class="header_container ">
                <div class="logo-box">
                    <img src=" <c:url value="/images/logo.png"/>" alt="" class="img-fluid">

                    <span>SHIPNOW ONLINE</span>
                </div>
                <div>
                    <div class="header_top">
                        <div class="header_top-contact">

                            <a href="" class="ml-4">
                                <div>
                                    <img src=" <c:url value="/images/phone.png"/>" alt="" class="img-fluid">

                                </div>
                                <span>
                                    (+84)976319227
                                </span>
                            </a>
                            <a href="" class="ml-4">
                                <div>
                                    <img src=" <c:url value="/images/mail.png"/>" alt="" class="img-fluid">

                                </div>
                                <span>
                                    1951012077nam@ou.edu.vn
                                </span>

                            </a>
                        </div>
                        <div class="header_top-social">
                            <div>
                                <a href="https://www.facebook.com/">
                                    <img src=" <c:url value="/images/fb.png"/>" alt="" class="img-fluid">

                                </a>
                            </div>
                            <div>
                                <a href="">
                                    <img src=" <c:url value="/images/twitter.png"/>" alt="" class="img-fluid">

                                </a>
                            </div>
                            <div>
                                <a href="">
                                    <img src=" <c:url value="/images/g-plus.png"/>" alt="" class="img-fluid">

                                </a>
                            </div>
                            <div>
                                <a href="">
                                    <img src=" <c:url value="/images/linkedin.png"/>" alt="" class="img-fluid">

                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="header_btm">
                        <nav class="navbar navbar-expand-lg custom_nav-container pt-3">

                            <button class="navbar-toggler" type="button" data-toggle="collapse"
                                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                                    aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <div class="d-flex mx-auto flex-column flex-lg-row align-items-center">
                                    <ul class="navbar-nav  ">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="<c:url value="/"/>"><spring:message code="label1"/><span class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value="/listshipper"/>"><spring:message code="label2"/></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value="/product"/>"><spring:message code="label3"/></a>
                                        </li>
                                        <sec:authorize access="hasRole('ROLE_SHIPPER')">
                                            <li class="nav-item">
                                                <a class="nav-link" href="<c:url value="/myauction"/>"><spring:message code="label18"/></a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="<c:url value="/oderofshipper"/>"><spring:message code="label17"/></a>
                                            </li>
                                        </sec:authorize>
                                        <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                                            <li class="nav-item">
                                                <a class="nav-link" href="<c:url value="/customerauction"/>"><spring:message code="label16"/></a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="<c:url value="/oderofcustomer"/>"><spring:message code="label17"/></a>
                                            </li>
                                        </sec:authorize>                  
                                    </ul>

                                </div>

                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- end header section -->

    <!-- slider section -->
    <section class=" slider_section ">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="container">
                        <div class="slider_item-container">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="slider_item-detail">
                                        <div class="slider_form-box">
                                            <c:url value="/listshipper" var="action" />
                                            <form method="get" action="${action}" class="d-flex">
                                                <input class="form-control me-2" type="text" name="kw" placeholder="<spring:message code="label8"/>">
                                                <img src=" <c:url value="/images/search-icon.png"/>" alt="" class="img-fluid">
                                                <button type="submit" class="btn btn-primary" type="button"><spring:message code="label4"/></button>
                                            </form>
                                        </div>
                                        <div>
                                            <h1>
                                                Unbeatable <br>
                                                trucking & Transport <br>
                                                Services
                                            </h1>

                                            <div class="d-flex">
                                                <div>
                                                    <a href="" class="read-btn">

                                                        <span>
                                                            Read More
                                                        </span>
                                                        <img src=" <c:url value="/images/white-next.png"/>" alt="" class="img-fluid">
                                                    </a>
                                                </div>
                                                <div class="ml-3">
                                                    <a href="" class="quote-btn">

                                                        <span>
                                                            Get A Quote
                                                        </span>
                                                        <img src=" <c:url value="/images/white-next.png"/>" alt="" class="img-fluid">
                                                    </a>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="slider_img-box">
                                        <img src=" <c:url value="/images/truck.png"/>" alt="" class="img-fluid">
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>             
            </div>

        </div>


    </section>

    <!-- end slider section -->
</div>

