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

<form action="${pageContext.request.contextPath}/view/login" method="post">
    <div class="container">
        <div class="header">
            <header><h2>Sign in</h2></header>
        </div>

        <h5 class="email">Email</h5>
        <label>
            <input class="profileEditorFields loginField" type="text" required
                   placeholder=buba@coconat.af
                   name="login">
        </label>
        <h5 class="password">Password</h5>
        <label>
            <input class="profileEditorFields loginField" type="password" required
                   placeholder=Password
                   name="password">
        </label>
        <div class="login-btn">
            <a href=${pageContext.request.contextPath}/view/login>
                <button>Login</button>
            </a>
        </div>
        <form action="${pageContext.request.contextPath}/view/registration">
            <p>
                New there? <a href=${pageContext.request.contextPath}/view/registration>Sign up</a>
            </p>
        </form>
    </div>
</form>
</body>
</html>


<%--
<form action="${pageContext.request.contextPath}/view/registration">
    <a href=${pageContext.request.contextPath}/view/registration>
        <button>Sign up</button>
    </a>
</form>--%>
