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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login_style.css">
</head>

<body>
    <div class="container">
        <div class="header">
            <h2>Sign in</h2>
        </div>
        <form id="form" class="form" action="${pageContext.request.contextPath}/view/login" method="post">
            <div class="form-control">
                <label>Email</label>
                <input type="email" placeholder="a@florin-pop.com" id="email" name="login"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label>Password</label>
                <input type="password" placeholder="Password" id="password" name="password"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <a href="${pageContext.request.contextPath}/view/login">Sign in</a>
            <br>
            <p class="sign-up">New there? <a href="${pageContext.request.contextPath}/view/registration">Sign up</a></p>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/js/loginPageScript.js" type="text/javascript"></script>
</body>
</html>


<%--
<form action="${pageContext.request.contextPath}/view/registration">
    <a href=${pageContext.request.contextPath}/view/registration>
        <button>Sign up</button>
    </a>
</form>--%>
