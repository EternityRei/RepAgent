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
      <th><fmt:message key="id"/></th>
      <th><fmt:message key="username"/></th>
      <th><fmt:message key="email"/></th>
      <th><fmt:message key="money"/></th>
      <th></th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${people}" var="a">
      <tr>
        <td><c:out value="${a.id}" /></td>
        <td><c:out value="${a.name}" /></td>
        <td><c:out value="${a.email}" /></td>
        <td><c:out value="${a.money}" /></td>
        <td><a href="${pageContext.request.contextPath}/view/managerPack/increaseMoney?id=${a.id}&button=top-up">Top up</a></td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
</div>

</body>
</html>