<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Sign up</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/reg_style.css">
</head>

<body>

<form action="${pageContext.request.contextPath}/view/registration" method="post">
    <div class="container">
        <div class="header">

            <header><h2>Sign up</h2></header>
        </div>

        <h5 class="username">Username</h5>
        <label>
            <input class="profileEditorFields loginField" type="text" required
                   placeholder="Julia Parker"
                   name="name">
        </label>

        <h5 class="email">Email</h5>
        <label>
            <input class="profileEditorFields loginField" type="text" required
                   placeholder=buba@coconat.af
                   name="email">
        </label>
        <h5 class="password">Password</h5>
        <label>
            <input class="profileEditorFields loginField" type="password" required
                   placeholder=Password
                   name="password">
        </label>
        <div class="login-btn">
            <a href=${pageContext.request.contextPath}/view/registration>
                <button>Sign up</button>
            </a>
        </div>
        <form action="${pageContext.request.contextPath}/view/login">
            <p>
                Already have an account? <a href=${pageContext.request.contextPath}/view/login>Sign in</a>
            </p>
        </form>
    </div>
</form>

</body>
</html>
