<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top up</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/payment_style.css">
</head>
    <body>
    <div class="container">
        <h6>Checkout</h6>
        <a href="${pageContext.request.contextPath}/view/managerPack/customersList">
            <span>x</span>
        </a>
        <h1>Top up form</h1>
        <form action="${pageContext.request.contextPath}/view/managerPack/increaseMoney" method="post">
            <label for="sum">Sum
                <input type="text" name="sum" id="sum">
            </label>
            <div class="float">
                <label for="checkbox" name="checkbox" id="checkbox-label">
                    <input type="checkbox" name="checkbox" id="checkbox">
                    <p>I approve to top up this user account</p>
                </label>
            </div>
                <a href=${pageContext.request.contextPath}/view/managerPack/increaseMoney>
                    <button name="btn" value="Top up">Top up</button>
                </a>
            <input type="hidden" name="id" value="${param.id}">
        </form>
    </div>
        <script src="${pageContext.request.contextPath}/js/payment.js"></script>
    </body>
</html>
