<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Work status edit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/payment_style.css">
</head>
<body>
<div class="container">
    <h6>Checkout</h6>
    <a href="${pageContext.request.contextPath}/view/employeePack/ordersList">
        <span>x</span>
    </a>
    <h1>Change work status</h1>
    <form action="${pageContext.request.contextPath}/view/employeePack/editOrderData" method="post">
        <div class="form-group">
            <label>Work status</label>
            <select name="workStatus" id="work_status">
                <option value="1">Not started</option>
                <option value="2">In process</option>
                <option value="3">Done</option>
            </select>
        </div>
        <button name="btn" value="Submit">Submit</button>
        <input type="hidden" name="id" value="${param.id}">
    </form>
</div>
</body>
</html>
