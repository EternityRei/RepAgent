<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 30.06.2022
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top up</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/IncreaseMoney_style.css">
</head>
<body>
<div class="top">
    <aside>
        <a href="${pageContext.request.contextPath}/view/managerPack/customersList" type="back">
            <span class="material-icons-sharp">arrow_back_ios_new</span>
            <h3>Back</h3>
        </a>
    </aside>
</div>
<form action="${pageContext.request.contextPath}/view/managerPack/increaseMoney" method="post">
    Please enter your sum to top up
    <p>
        <label>
            <input class="profileEditorFields sumField" type="text" required
                   placeholder=Sum
                   name="sum">
        </label>
    </p>
    <a href=${pageContext.request.contextPath}/view/managerPack/increaseMoney>
        <input type="submit" name="btn" value="Top up">
    </a>
</form>
</body>
</html>
