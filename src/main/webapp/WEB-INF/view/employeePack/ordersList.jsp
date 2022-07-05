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
            <th col-index="1">Id</th>
            <th col-index="2">Title</th>
            <th col-index="3">Description</th>
            <th col-index="4">Cost</th>
            <th col-index="5">Payment</th>
            <th col-index="6">Work status</th>
            <th col-index="7">User Unique Code</th>
            <th col-index="8">Employee Unique Code</th>
            <th col-index="9">Date</th>
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
                <td><c:out value="${order.getPaymentStatus()}" /></td>
                <td><c:out value="${order.getWorkStatus()}" /></td>
                <td><c:out value="${order.getUserid()}" /></td>
                <td><c:out value="${order.getWorkerId()}" /></td>
                <td><c:out value="${order.getTimestamp()}" /></td>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#edit-modal"
                            data-price="" data-payment_id=""
                            data-work_status_id="" data-employee_id="" name="btn">Edit</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="edit-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form>
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="ModalLabel">Edit</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Order Unique Code</label>
                            <input type="text" class="form-control" id="edit-id" name="id">
                        </div>
                        <div class="form-group">
                            <label>Work status</label>
                            <select name="workStatus" id="work_status">
                                <option value="1">Not started</option>
                                <option value="2">In process</option>
                                <option value="3">Done</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href=${pageContext.request.contextPath}/view/employeePack/ordersList>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </a>

                        <a href="${pageContext.request.contextPath}/view/employeePack/ordersList">
                            <button class="btn btn-primary" name="btn" value="Submit">Submit</button>
                        </a>

                    </div>
                </div>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <script href="${pageContext.request.contextPath}/js/editTableScript.js"></script>
</div>
</body>
</html>
