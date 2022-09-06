<%-- 
    Document   : footer
    Created on : Aug 7, 2022, 8:12:50 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- info section -->
<section class="info_section ">
    <div class="container ">
        <div class="row  mb-3 pb-4">
            <div class="col-md-3 info_logo">
                <div class="logo-box">
                    <img src="<c:url value="/images/logo-white.png"/>" alt="">

                    <span>
                        SHIPNOW ONLINE
                    </span>
                </div>
                <p>
                    <spring:message code="label26"/>
                </p>
                <div class="info_social">
                    <div>
                        <a href="">
                            <img src="<c:url value="/images/fb.png"/>" alt="">

                        </a>
                    </div>
                    <div>
                        <a href="">
                            <img src="<c:url value="/images/twitter.png"/>" alt="">

                        </a>
                    </div>
                    <div>
                        <a href="">
                            <img src="<c:url value="/images/g-plus.png"/>" alt="">

                        </a>
                    </div>
                    <div>
                        <a href="">

                            <img src="<c:url value="/images/linkedin.png"/>" alt="">
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-3 info_address">
                <h5>
                    Địa chỉ
                </h5>
                <p>
                    371 Nguyễn Kiệm,Phường 3,Gò Vấp, TPHCM
                </p>       
                <p>
                    (+84) 976319227
                </p>
                <p>
                    <a href="">
                        1951012077nam@ou.edu.vn
                    </a>
                </p>
            </div>
            <div class="col-md-3 info_links">

                <div class="info_nav ">
                    <nav class="">
                        <ul>
                            <h5>
                                Links
                            </h5>
                            <li>
                                <a class="nav-link" href="<c:url value="/"/>"><spring:message code="label1"/><span class="sr-only">(current)</span></a>
                            </li>
                            <li>
                                <a class="nav-link" href="<c:url value="/"/>"><spring:message code="label2"/></a>
                            </li>
                            <li>
                                <a class="nav-link" href="<c:url value="/product"/>"><spring:message code="label3"/></a>
                            </li>           
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="col-md-3 info_news">
                <h5>
                    Newsletter
                </h5>
                <form action="">
                    <div>
                        <input type="text" placeholder="Your Name">
                    </div>
                    <div>
                        <input type="email" placeholder="Email">
                    </div>
                    <div class="d-flex justify-content-end">
                        <button type="submit">
                            Subscribe
                        </button>
                    </div>
                </form>
            </div>
        </div>


    </div>
</section>
<!-- end info section -->

<!-- footer section -->
<section class="container-fluid footer_section">
    <p>
        Copyright &copy; 2022 All Rights Reserved By
        <a href="https://www.facebook.com/">Nguyễn Đình Nam</a>
    </p>
</section>
<!-- footer section -->

<script type="text/javascript" src="<c:url value="/js/jquery-3.4.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>




