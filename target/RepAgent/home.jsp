<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>H&H</title>
    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
<header>
    <a href="#" class="logo">H&H</a>
    <ul>
        <li><a href="#" class="active">Home</a></li>
        <li><a href="#sec" id="btn_about">About</a></li>
        <li><a href="#">Workers</a></li>
        <li><a href="#">Contact</a></li>
        <li><a href="${pageContext.request.contextPath}/login.jsp" class="sign_in">Sign in</a></li>
    </ul>
</header>
<section>
    <img src="images/background.jpg" id="start" alt="">
    <h2 id="text">Horns & Hooves</h2>
    <img src="images/personEdit.png" id="person" alt="">
    <img src="images/ladder.png" id="ladder" alt="">

</section>
<div class="sec" id="sec">
    <h2>Horns & Hooves</h2>
    <p>Horns & Hooves - repair agency, created by Azriell Hogston & William Houp in 2019.<br><br>
        We have 15 workers, 5 managers and around 1000 offers. Great professionals will
        make your problem to disappear.<br><br> We are waiting for you! <br><br> Best regards,<br><br>
        Horns & Hooves</p>
</div>
<script src="js/homePageScript.js"></script>
</body>
</html>