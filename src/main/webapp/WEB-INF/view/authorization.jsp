<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale=1.0">
    <script>
        src="https://kit.fontawesome.com/64d58efce2.js"
        crossorigin="anonymous"
    </script>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../../styles/login_style.css">
</head>
<body>
<div class="container">
    <div class="forms-container">
        <div class="signin-signup">
            <form action="authorization.jsp" class="sign-in-form">
                <h2 class="title">Sign in</h2>
                <div class="input-field">
                    <i class="fas fa-envelope"></i>
                    <label>
                        <input type="text" placeholder="Email">
                    </label>
                </div>
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <label>
                        <input type="password" placeholder="Password">
                    </label>
                </div>
                <input type="submit" value="Login" class="btn solid">
            </form>

            <form action="authorization.jsp" class="sign-up-form">
                <h2 class="title">Sign up</h2>
                <div class="input-field">
                    <i class="fas fa-envelope"></i>
                    <label>
                        <input type="text" placeholder="Email">
                    </label>
                </div>
                <div class="input-field">
                    <i class="fas fa-lock"></i>
                    <label>
                        <input type="password" placeholder="Password">
                    </label>
                </div>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <label>
                        <input type="text" placeholder="Name">
                    </label>
                </div>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <label>
                        <input type="text" placeholder="Surname">
                    </label>
                </div>
                <input type="submit" value="Sing up" class="btn solid">
            </form>
        </div>
    </div>
    <div class="panels-container">
        <div class="panel left-panel">
            <h3>New here ?</h3>
            <p>Click button for registration</p>
            <button class="btn transparent" id="sing-up-btn">Sign up</button>
        </div>
        <img src="../../images/login.png" class="image" alt="">
    </div>

    <div class="panel left-panel">
        <div class="content">
            <h3>One of us ?</h3>
            <p>Sign into your account</p>
            <button class="btn transparent" id="sign-in-btn">Sign in</button>
        </div>
        <img src="../../images/registration.png" class="image" alt="">
    </div>
</div>

<script src="../../js/loginPageScript.js"></script>
</body>
</html>
