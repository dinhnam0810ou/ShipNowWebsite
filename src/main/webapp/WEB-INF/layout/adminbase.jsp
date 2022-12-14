<%-- 
    Document   : adminbase
    Created on : Aug 20, 2022, 8:45:20 AM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles"
           uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta charset="utf-8">

        <title><tiles:insertAttribute name="title" /></title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><!-- comment -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>


        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="<c:url value="/css/owl.carousel.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/tempusdominus-bootstrap-4.min.css"/>" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->

        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="<c:url value="/css/styleadmin.css"/>" rel="stylesheet">
    </head>
    <body>
         <style>
            table tr:nth-child(1){
                background-color:skyblue;
            }
            table, th, td{
                border:1px solid #ccc;
            }
            table{
                border-collapse:collapse;
            }
            tr:hover{
                background-color:#ddd;
                cursor:pointer;
            }
        </style>
        <tiles:insertAttribute name="header" />

        <tiles:insertAttribute name="content" />

        <tiles:insertAttribute name="footer" />
    </body>
</html>

