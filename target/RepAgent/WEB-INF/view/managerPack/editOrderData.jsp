
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit table data</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/payment_style.css">
</head>
<body>
<div class="container">
    <h6>Checkout</h6>
    <a href="${pageContext.request.contextPath}/view/managerPack/ordersList">
        <span>x</span>
    </a>
    <h1>Edit table</h1>
    <form action="${pageContext.request.contextPath}/view/managerPack/editOrderData" method="post">
        <div class="form-group">
            <label>Price</label>
            <input type="text" class="form-control" id="edit-price" name="price">
        </div>
        <div class="form-group">
            <label>Payment</label>
            <select name="paymentStatus" id="payment_status">
                <option value="1">Not paid</option>
                <option value="2">Paid</option>
                <option value="3">Canceled</option>
            </select>
        </div>
        <div class="form-group">
            <label>Employee</label>
            <select name="worker" id="workers">
                <% int k = 0; %>
                <c:forEach items="${employees}" var="a">
                    <option value=<c:out value="${a.id}"/> > <c:out value="${a.id}"/> <c:out value="${a.name}"/></option>
                </c:forEach>
            </select>
        </div>
        <button name="btn" value="Submit">Submit</button>
        <input type="hidden" name="id" value="${param.id}">
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/payment.js"></script>
</body>
</html>
