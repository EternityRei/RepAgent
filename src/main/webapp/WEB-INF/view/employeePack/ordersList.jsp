<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Orders</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<div class="table">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Description</th>
            <th>Cost</th>
            <th>Payment</th>
            <th>Work status</th>
            <th>User Unique Code</th>
            <th>Employee Unique Code</th>
            <th>Date</th>
            <th></th>
        </tr>
        </thead>

        <tbody>

        <c:forEach items="${orders}" var="order">
            <tr>
                <td><c:out value="${order.id}" /></td>
                <td><c:out value="${order.title}" /></td>
                <td><c:out value="${order.description}" /></td>
                <td><c:out value="${order.cost}" /></td>
                <td>
                    <c:if test="${order.getPaymentStatus() == 1}">
                        <c:out value="Not paid" />
                    </c:if>
                    <c:if test="${order.getPaymentStatus() == 2}">
                        <c:out value="Paid" />
                    </c:if>
                    <c:if test="${order.getPaymentStatus() == 3}">
                        <c:out value="Canceled" />
                    </c:if>
                </td>
                <td>
                    <c:if test="${order.getWorkStatus() == 1}">
                        <c:out value="Not started" />
                    </c:if>
                    <c:if test="${order.getWorkStatus() == 2}">
                        <c:out value="In process" />
                    </c:if>
                    <c:if test="${order.getWorkStatus() == 3}">
                        <c:out value="Done" />
                    </c:if>
                </td>
                <td><c:out value="${order.getUserid()}" /></td>
                <td><c:out value="${order.getWorkerId()}" /></td>
                <td><c:out value="${order.getTimestamp()}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/view/employeePack/editOrderData?id=${order.id}&workStatus=${order.getWorkStatus()}">
                        <button type="button" class="btn btn-primary" data-toggle="modal" name="btn">Edit</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <script href="${pageContext.request.contextPath}/js/editTableScript.js"></script>
</div>
</body>
</html>
