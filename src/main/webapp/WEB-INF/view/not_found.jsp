<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html>
<head>
    <title>404</title>
</head>
<body>


<div align="centre">
    <h2>404</h2>
    <br>
    <p>SOMETHING WENT WRONG/></p>
</div>
<form class="w3-container" align="center" method="post"
      action="${pageContext.request.contextPath}/view/logout">
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <div>
            <input class="w3-button w3-margin-bottom w3-green" type="submit"
                   value="/logout">
        </div>
    </div>
</form>
</body>
</html>
