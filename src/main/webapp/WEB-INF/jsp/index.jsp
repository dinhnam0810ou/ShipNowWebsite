<%-- 
    Document   : index
    Created on : Aug 7, 2022, 8:07:03 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- about section -->
<c:if test="${mess!=null}">
    <script>window.alert("Tao don hang thanh cong");</script>
</c:if>
<section class="about_section ">
    <div class="container">
        <div class="row">
            <div class="col">
                <h2 class="heading_style">
                    About Us
                </h2>
                <p>
                    adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco
                </p>
            </div>

        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="about_img-box">
                    <img src=" <c:url value="/images/a-truck.jpg"/>" alt="" class="img-fluid">

                </div>
            </div>
            <div class="col-md-6 about_detail-container">
                <div class="about_detail-box">
                    <h3>
                        Company and Transport
                    </h3>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et
                        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex
                        ea commodo consequat. Duis aute irure dolor in reprehenderit in Lorem ipsum dolor sit amet, consectetur
                        adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna as
                    </p>
                    <div class="d-flex  justify-content-end">
                        <a href="" class="quote-btn about-btn">
                            <img src=" <c:url value="/images/white-next.png"/>" alt="" class="img-fluid">

                            <span>
                                About More
                            </span>

                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>

<!-- end about section -->

<!-- service section -->
<section class="service_section layout_padding">
    <div class="container">
        <div class="d-flex justify-content-center">
            <h2 class="heading_style">
                Our Services
            </h2>
        </div>
        <div class="row layout_padding2-top">
            <div class="col-md-4">
                <div class="service_img-box s-b-1">
                    <img src=" <c:url value="/images/service-1.jpg"/>" alt="" class="img-fluid">
                    <div class="d-flex">
                        <h3>
                            CARGO

                        </h3>
                    </div>
                </div>
                <div class="service-detail">
                    <p>
                        aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
                        dolore eu fugiat nulla pariatur.Excepteur
                    </p>
                    <div class="d-flex justify-content-end">
                        <a href="" class="service-btn">
                            See More
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service_img-box s-b-2">
                    <img src=" <c:url value="/images/service-2.jpg"/>" alt="" class="img-fluid">

                    <div class="d-flex">
                        <h3>
                            LOGISTIC SERVICE


                        </h3>
                    </div>
                </div>
                <div class="service-detail">
                    <p>
                        aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
                        dolore eu fugiat nulla pariatur.Excepteur
                    </p>
                    <div class="d-flex justify-content-end">
                        <a href="" class="service-btn">
                            See More
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="service_img-box s-b-3">
                    <img src=" <c:url value="/images/service-3.jpg"/>" alt="" class="img-fluid">

                    <div class="d-flex">
                        <h3>
                            STORAGE


                        </h3>
                    </div>
                </div>
                <div class="service-detail">
                    <p>
                        aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
                        dolore eu fugiat nulla pariatur.Excepteur
                    </p>
                    <div class="d-flex justify-content-end">
                        <a href="" class="service-btn">
                            See More
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end service section -->


<!-- shop section -->
<section class="shop_section">
    <div class="container">
        <div class="d-flex justify-content-center">
            <h2 class="heading_style">
                Our Shop
            </h2>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="d-flex align-items-center h-100">
                    <div class="shop-detail">
                        <h5>
                            Everything You Need
                        </h5>
                        <p>
                            ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                            magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="shop_img-box">
                    <img src=" <c:url value="/images/gift.jpg"/>" alt="" class="img-fluid">

                </div>
            </div>
        </div>
    </div>
</section>
<!-- end shop section -->

<!-- testimonial section -->
<section class="client_section layout_padding">
    <div class="d-flex justify-content-center">
        <h2 class="heading_style">
            Testimonial
        </h2>
    </div>
    <div id="carouselExampleIndicator" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicator" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicator" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicator" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicator" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="client_box c-b-1">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">
                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="client_box c-b-2">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">
                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="client_box c-b-1">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">
                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="client_box c-b-2">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">
                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="client_box c-b-1">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">
                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="client_box c-b-2">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">
                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="client_box c-b-1">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">
                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="client_box c-b-2">
                                <div class="client_img">
                                    <img src=" <c:url value="/images/client.png"/>" alt="" class="img-fluid">

                                </div>
                                <div class="client_detail">
                                    <h5>
                                        Rock lu
                                    </h5>
                                    <p>
                                        Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of
                                        classical
                                        Latin literature from 45 BC, making it over 2000 years
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</section>
<!-- end testimonial section -->



<!-- company section -->
<section class="company_section layout_padding2">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="d-flex align-items-center h-100">
                    <div class="company-detail">
                        <h3>
                            Company
                        </h3>
                        <p>
                            Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical
                            Latin literature from 45 BC, making it over 2000 yearsContrary to popular belief, Lorem Ipsum is not
                            simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over
                            2000 years
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="company_img-box">

                    <img src=" <c:url value="/images/company.jpg"/>" alt="" class="img-fluid">
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end company section -->



<!-- contact section -->
<section class="contact_section layout_padding">
    <div class="d-flex justify-content-center">
        <h2 class="heading_style">
            Contact us
        </h2>
    </div>
    <div class="container layout_padding2-top">
        <div class="row">
            <div class="col-md-6">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1903.6837721066568!2d106.67769730925696!3d10.816529605650935!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528e195f816b7%3A0xfb5c0101490d8870!2zMzcxIE5ndXnhu4VuIEtp4buHbSwgUGjGsOG7nW5nIDMsIEfDsiBW4bqlcCwgVGjDoG5oIHBo4buRIEjhu5MgQ2jDrSBNaW5oLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1660923557970!5m2!1svi!2s" width="600" height="490" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>

            <div class="col-md-6">
                <div class="contact_form-container">
                    <form action="<c:url value="/"/>" method="post">
                        <div>
                            <input name="name" type="text" placeholder="Your Name" autocomplete="off">
                        </div>
                        <div>
                            <input name="email" type="email" placeholder="Your Email" autocomplete="off">
                        </div>
                        <div>
                            <input name="phone" type="text" placeholder="Your Phone" autocomplete="off">
                        </div>

                        <div>
                            <input name="message" type="text" class="message_input" placeholder="Message" autocomplete="off">
                        </div>
                        <div class="d-flex justify-content-end">
                            <button  >
                                Send
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end contact section -->

