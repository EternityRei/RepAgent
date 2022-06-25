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
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/login_style.css">
    <title>Sign in</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/view/login" method="post">
    <div class="sign-in">
        <h2 class="title">Sign In</h2>
            <div class="profileEditorFields">
                <label>
                    <input type="text" required placeholder=Login name="login">
                </label>
            </div>
            <div class="profileEditorFields">
                <label>
                    <input type="password" required placeholder=Password name="password">
                </label>
            </div>
    </div>
    <a href=${pageContext.request.contextPath}/view/login>
        <button class="btn solid" id="singin-btn">Login</button>
    </a>



    <%--    <c:if test="${requestScope.notFound}">
            <div class="w3-container">
                <p>Invalid data</p>
            </div>
        </c:if>--%>

    <c:if test="${requestScope.wrongData}">
        <div class="w3-container">
            Incorrect data
        </div>
    </c:if>
</form>
<div class="panels-container">
    <div class="panel left-panel">
        <form action="${pageContext.request.contextPath}/view/registration">
            <h3>New here ?</h3>
            <p>Click button for registration</p>
            <a href=${pageContext.request.contextPath}/view/registration>
                <button class="btn transparent" id="sing-up-btn">Sign up</button>
            </a>
        </form>
    </div>
    <img src="${pageContext.request.contextPath}/images/login.svg" class="image" alt="">
</div>
</body>
</html>