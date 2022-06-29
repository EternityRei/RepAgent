<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addEmployee_style.css">
</head>
<body>
    <div class="container">
        <div class="title">Employee registration form</div>
        <form action="${pageContext.request.contextPath}/view/managerPack/addEmployee" method="post">
            <div class="user-details">
                <div class="input-box">
                    <span class="details">Full name</span>
                    <label>
                        <input type="text" placeholder="Enter name" required name="name">
                    </label>
                </div>
                <div class="input-box">
                    <span class="details">Email</span>
                    <label>
                        <input type="text" placeholder="Enter email" required name="email">
                    </label>
                </div>
                <div class="input-box">
                    <span class="details">Password</span>
                    <label>
                        <input type="password" placeholder="Enter password" required name="password">
                    </label>
                </div>
            </div>
            <div class="role-details">
                <input type="radio" name="role" id="dot-1">
                <span class="role-title">Role</span>
                <div class="category">
                    <label for="dot-1">
                        <span class="dot one"></span>
                        <span class="role">Employee</span>
                    </label>
                </div>
            </div>
            <div class="button">
                <a href="${pageContext.request.contextPath}/view/managerPack/successAddEmployee">
                    <input type="submit" value="Register">
                </a>
            </div>
        </form>
    </div>
</body>
</html>
