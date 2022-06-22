<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Sign in</title>
</head>

<body>

<form action="${pageContext.request.contextPath}/login.jsp" method="post">
    Please enter your username
    <p>
        <label>
            <input class="profileEditorFields loginField" type="text" required
                   placeholder=Login
                   name="login">
        </label>
    </p>

    Please enter your password
    <p>
        <label>
            <input class="profileEditorFields loginField" type="password" required
                   placeholder=Password
                   name="password">
        </label>
    </p>

    <a href=${pageContext.request.contextPath}/login.jsp>
        <button>Login</button>
    </a>


    <c:if test="${requestScope.notFound}">
        <div class="w3-container">
            <p>Invalid data</p>
        </div>
    </c:if>

    <c:if test="${requestScope.wrongData}">
        <div class="w3-container">
            Incorrect data
        </div>
    </c:if>
</form>
<form action="${pageContext.request.contextPath}/WEB-INF/view/registration.jsp">
    <a href=${pageContext.request.contextPath}/WEB-INF/view/registration.jsp>
        <button>Sign up</button>
    </a>
</form>
</body>
</html>