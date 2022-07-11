<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="language" value="${not empty param.language ? param.language : pageContext.request.locale}"
       scope="application"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<html>
<head>
  <title>Customers</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/customersList_style.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
  <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
</head>
<body>
<div class="top">
  <aside>
    <a href="${pageContext.request.contextPath}/view/manager" type="back">
      <span class="material-icons-sharp">arrow_back_ios_new</span>
      <h3>Back</h3>
    </a>
  </aside>
</div>
<div class="table">
  <table id="sortableTable">
    <thead>
    <tr>
      <th data-sortable="true">Id</th>
      <th data-sortable="false">Username</th>
      <th data-sortable="false">Email</th>
      <th data-sortable="false">Money</th>
      <th data-sortable="false"></th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${people}" var="a">
      <tr>
        <td>${a.id}</td>
        <td>${a.name}</td>
        <td>${a.email}</td>
        <td>${a.money}</td>
        <td><a href=${pageContext.request.contextPath}/view/managerPack/increaseMoney?id=${a.id}&button=top-up>Top up</a></td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
</div>
<script>$('#sortableTable').DataTable();</script>
</body>
</html>