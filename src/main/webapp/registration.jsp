<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration.jsp" method="post">
    Enter your email:
    <p>
        <label>
            <input class="profileEditorFields loginField" type="text" required
                   placeholder=Login
                   name="login">
        </label>
    </p>
    Enter your password:
    <p>
        <label>
            <input class="profileEditorFields loginField" type="password" required
                   placeholder=Password
                   name="password">
        </label>
    </p>

    Enter your name:
    <p>
        <label>
            <input class="profileEditorFields loginField" type="text" required
                   placeholder=Name
                   name="user-name">
        </label>
    </p>

    <a href=${pageContext.request.contextPath}/registration.jsp>
        <button>Register</button>
    </a>
</form>
</body>
</html>
