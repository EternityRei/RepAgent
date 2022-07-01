
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Customers</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/customersList_style.css">
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
  <table>
    <thead>
    <tr>
      <th>Id</th>
      <th>Title</th>
      <th>Description</th>
      <th>Cost</th>
      <th>Payment</th>
      <th>Work status</th>
      <th>Username</th>
      <th>Employee</th>
      <th>Date</th>
      <th></th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${orders}" var="a">
      <tr>
        <td><c:out value="${a.id}" /></td>
        <td><c:out value="${a.title}" /></td>
        <td><c:out value="${a.description}" /></td>
        <td><c:out value="${a.cost}" /></td>
        <td><c:out value="${a.payment_id}" /></td>
        <td><c:out value="${a.work_status_id}" /></td>
        <td><c:out value="${a.person_id}" /></td>
        <td><c:out value="${a.employee_id}" /></td>
        <td><c:out value="${a.date}" /></td>
        <%--/*<td><a href="${pageContext.request.contextPath}/view/managerPack/increaseMoney?id=${a.id}&button=top-up">Top up</a></td>*/--%>
      </tr>
    </c:forEach>

    </tbody>
  </table>
</div>
</body>
</html>
