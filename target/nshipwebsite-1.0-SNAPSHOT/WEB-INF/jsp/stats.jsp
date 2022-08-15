<%-- 
    Document   : stats
    Created on : Aug 12, 2022, 9:52:45 AM
    Author     : Nguyen Dinh Nam
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 class="text-center text-info">Thống kê doanh số</h1>
<div class="row">
    <div class="col-md-6">
        <table class="table">
            <tr>
                <th>ShipperID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Số đơn hàng đã nhận</th>
            </tr>
            <c:forEach items="${orderstat}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                    <td>${c[3]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6">
        <canvas id="myChart"></canvas>
    </div>
</div>
<br>
<div class="row">
    <div class="col-md-6">
        <table class="table">
            <tr>
                <th>ShipperID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${revenue}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                    <td>
                        <fmt:formatNumber type="number" value="${c[3]}" maxFractionDigits="3" /> VND
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6">
        <c:url value="/admin/stats" var="action" />
        <form action="${action}">
            <div class="mb-3 mt-3">
                <select class="form-control" name="quarter">
                    <c:forEach begin="1" end="4" var="i">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">

                <input type="number" class="form-control" placeholder="Nhập năm" name="year">
            </div>
            <button type="submit" class="btn btn-primary">Lọc dữ liệu</button>
        </form>
        <canvas id="myChart2"></canvas>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];
        let data2 = [];
        let labels2 = [];
    <c:forEach items="${orderstat}" var="c">
        data.push(${c[3]});
        labels.push('${c[1]} ${c[2]}');
    </c:forEach>
        
    <c:forEach items="${revenue}" var="c">
        data2.push(${c[3]});
        labels2.push('${c[1]} ${c[2]}');
    </c:forEach>
                getStat(data, labels);
                revenue(data2,labels2);
            }
</script>