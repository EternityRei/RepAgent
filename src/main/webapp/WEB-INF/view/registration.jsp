<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/reg_style.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Sign up</h2>
        </div>
        <form id="form" class="form" action="${pageContext.request.contextPath}/view/registration" method="post">
            <div class="form-control">
                <label>Username</label>
                <input type="text" placeholder="florinpop17" id="name" />
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label>Email</label>
                <input type="email" placeholder="a@florin-pop.com" id="email" />
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label>Password</label>
                <input type="password" placeholder="Password" id="password"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label>Password check</label>
                <input type="password" placeholder="Password two" id="password2"/>
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error message</small>
            </div>
            <button>Sign up</button>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/js/regPageScript.js"></script>
</body>
</html>
