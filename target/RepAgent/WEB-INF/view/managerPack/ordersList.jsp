<%@ page import="org.apache.log4j.Logger" %>
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
    <script src="https://unpkg.com/bootstrap-table@1.20.2/dist/bootstrap-table.min.js"></script>
    <script src="https://unpkg.com/bootstrap-table@1.20.2/dist/extensions/filter-control/bootstrap-table-filter-control.min.js"></script>
</head>
    <body>
        <div class="table">
          <table id="sortTable"
          data-filter-control="true" data-show-search-clear-button="true">
            <thead>
              <tr>
                <th data-sortable="true">Id</th>
                <th data-sortable="false">Title</th>
                <th data-sortable="false">Description</th>
                <th data-sortable="true">Cost</th>
                <th data-sortable="true" col-index="1"
                    data-filter-control="select" data-field="payment">
                    Payment
                </th>
                <th data-sortable="true" col-index="2"
                    data-filter-control="select" data-field="work">
                    Work status
                </th>
                <th data-sortable="false">User Unique Code</th>
                <th data-sortable="false" col-index="3"
                    data-filter-control="select" data-field="worker">
                    Employee Unique Code
                </th>
                <th data-sortable="true" col-index="9">Date</th>
                <th data-sortable="false"></th>
              </tr>
            </thead>

            <tbody>


            <c:forEach items="${orders}" var="order">
              <tr>
                  <td>${order.id}</td>
                  <td>${order.title}</td>
                  <td>${order.description}</td>
                  <td>${order.cost}</td>
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
                  <td>${order.getUserid()}</td>
                  <td>${order.getWorkerId()}</td>
                  <td>${order.getTimestamp()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/view/managerPack/editOrderData?id=${order.id}&price=${order.cost}&paymentStatus=${order.getPaymentStatus()}&worker=${order.getWorkerId()}">
                        <button type="button" class="btn btn-primary" data-toggle="modal" name="btn">Edit</button>
                    </a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>

          <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
          <script href="${pageContext.request.contextPath}/js/editTableScript.js"></script>
          <script>$('#sortTable').DataTable();</script>
            <script>
                $(function() {
                    $('#sortTable').bootstrapTable()
                })
            </script>
        </div>
    </body>
</html>
