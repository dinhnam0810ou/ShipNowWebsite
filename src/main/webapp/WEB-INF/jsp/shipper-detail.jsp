<%-- 
    Document   : shipper-detail
    Created on : Aug 10, 2022, 4:26:51 PM
    Author     : Nguyen Dinh Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">CHI TIẾT SHIPPER</h1>
<div class="row">
    <div class="col-md-3">      
        <img class="card-img-top " src="${shipper.avatar}" alt="Card image" width="100" height="200"/>     
    </div> 

    <div class="col-md-9">
        <h1>${shipper.firstname} ${shipper.lastname}</h1>
        <p>Số điện thoại: ${shipper.phone}</p>
        <p>Căn cước công dân: ${shipper.identification}</p>
        <p>Email: ${shipper.email}</p>      
    </div> 
</div>
<br>
<div class="form-group">
    <textarea class="form-control" id="commentId" placeholder="Nhập đánh giá của bạn..."></textarea>
    <br>
    <input type="submit" value="Gửi đánh giá" class="btn btn-danger" onclick="addComment(${shipper.id})"/>
</div>
<div id="commentArea" style="margin-top: 10px">
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
            <div class="col-md-1" style="padding: 10px">
                <img src="https://res.cloudinary.com/da1xygjae/image/upload/v1660144588/images_yykwmm.jpg" class="card-img-top img-fluid rounded-circle" 
                     width="50" height="50"/>
            </div>
            <div class="col-md-11 my-date">
                <p>${comment.content}</p>
                <i>${comment.date}</i>
            </div>
        </div>
    </c:forEach> 
</div>
<script src="<c:url value="/js/comment.js"/>"></script>
<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i];
            d.innerText = moment(d.innerText).locale("vi").fromNow();
        }
    }
</script>
