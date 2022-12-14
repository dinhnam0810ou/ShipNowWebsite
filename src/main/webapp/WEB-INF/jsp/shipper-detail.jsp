<%-- 
    Document   : shipper-detail
    Created on : Aug 10, 2022, 4:26:51 PM
    Author     : Nguyen Dinh Nam
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .starshipper{
        font-size: 30px;
        color: #ff9800;
        background-color: unset;
        border: none;
    }
    .star{
        font-size:60px;
        color: #ff9800;
        background-color: unset;
        border: none;
    }
    .star:hover{
        cursor: pointer;
    }
    .imgcmt{
        width: 100px;
        height: 100px;

    }
</style>

<h1 class="text-center text-info">CHI TIẾT SHIPPER</h1>
<div class="row">
    <div class="col-md-3">      
        <img class="card-img-top " src="${shipper.avatar}" alt="Card image" width="100" height="200"/>     
    </div> 

    <div class="col-md-9">
        <h1>${shipper.firstname} ${shipper.lastname}</h1>
        <p>Số điện thoại: ${shipper.phone}</p>
        <p>Email: ${shipper.email}</p>      
    </div> 
</div>
<input id="countrating" style=" visibility: hidden;">
<h2>Đánh giá Shipper</h2>
<div class="form-group">
    <div class="star_rating">
        <button class="star">&#9734;</button>
        <button class="star">&#9734;</button>
        <button class="star">&#9734;</button>
        <button class="star">&#9734;</button>
        <button class="star">&#9734;</button>
    </div>
    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
        <textarea class="form-control" id="commentId" placeholder="Nhập đánh giá của bạn..."></textarea>
        <br>
        <input type="submit" value="Gửi đánh giá" class="btn btn-danger" onclick="addComment(${shipper.id})"/>   
    </sec:authorize>

</div>
<div id="commentArea" style="margin-top: 10px;">
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(countComment/pageSize)}" var="i">
            <c:url value="/${shipper.id}" var="u">  
                <c:param name="page" value="${i}" />
            </c:url>
            <li class="page-item"><a class="page-link" href="${u}">${i}</a></li>
            </c:forEach>
    </ul>
    <c:forEach items="${comments}" var="comment">
        <div class="row">
            <div class="col-md-1" style="padding: 10px;">
                <img src="${comment[1]}" class="card-img-top rounded-circle imgcmt"/>
            </div>
            <div class="col-md-11 my-date" >
                <c:forEach begin="1" end="${comment[4]}">
                    <button class="starshipper" disabled="false">&#9733;</button>
                </c:forEach>
                    <p style="margin-left: 10px;"><b>${comment[0]}</b> đã bình luận  <i>${comment[3]}</i></p>
                <p style="margin-left: 10px;">${comment[2]}</p>              
            </div>
        </div>
    </c:forEach> 
</div>
<script src="<c:url value="/js/rating.js"/>"></script>
<script src="<c:url value="/js/comment.js"/>"></script>
<script>
            window.onload = function () {
                let dates = document.querySelectorAll(".my-date >p> i")
                for (let i = 0; i < dates.length; i++) {
                    let d = dates[i];
                    d.innerText = moment(d.innerText).locale("vi").fromNow();
                }
            }
</script>
