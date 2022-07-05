
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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
  <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
<div class="table">
  <table id="sortTable"
  data-filter-control="true">
    <thead>
    <tr>
      <th>Id</th>
      <th>Title</th>
      <th>Description</th>
      <th>Cost</th>
      <th>Payment
      <select class="table-filter">
        <option value="all"></option>
      </select>
      </th>
      <th>Work status
        <select class="table-filter">
          <option value="all"></option>
        </select>
      </th>
      <th>User Unique Code</th>
      <th>Employee Unique Code
        <select class="table-filter">
          <option value="all"></option>
        </select>
      </th>
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
          <td><c:out value="${order.getPaymentStatus()}" /></td>
          <td><c:out value="${order.getWorkStatus()}" /></td>
          <td><c:out value="${order.getUserid()}" /></td>
          <td><c:out value="${order.getWorkerId()}" /></td>
          <td><c:out value="${order.getTimestamp()}" /></td>
        <td>
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#edit-modal"
                  data-price="" data-payment_id=""
                  data-work_status_id="" data-employee_id="" name="btn">Edit</button>

          <button type="button" class="btn btn-danger" data-toggle="modal"
                  data-target="#delete-modal" data-title="" name="btn">Delete</button>

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
          </div>
          <div class="modal-footer">
            <a href=${pageContext.request.contextPath}/view/managerPack/ordersList>
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </a>

            <a href="${pageContext.request.contextPath}/view/managerPack/ordersList">
                  <button class="btn btn-primary" name="btn" value="Submit">Submit</button>
            </a>

          </div>
        </div>
      </form>
    </div>
  </div>

  <div class="modal fade" id="delete-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          Are you sure to delete order <span id="delete-title">Title</span>?
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-danger">Delete</button>
        </div>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
  <script href="${pageContext.request.contextPath}/js/editTableScript.js"></script>
  <script>$('#sortTable').DataTable();</script>
  <script>
    window.onload = () => {
      console.log(document.querySelector("#sortTable > tbody > tr:nth-child(1) > td:nth-child(5) ").innerHTML);
    };
  </script>
</div>
</body>
</html>
