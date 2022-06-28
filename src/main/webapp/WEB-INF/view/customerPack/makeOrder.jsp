<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/makeOrder_style.css">
</head>
<body>
<div class="container">
    <div class="title">Make an order form</div>
    <form action="${pageContext.request.contextPath}/view/managerPack/makeOrder" method="post">
        <div class="order-details">
            <div class="input-box">
                <span class="details">Title</span>
                <label>
                    <input type="text" placeholder="Enter title" required name="title">
                </label>
            </div>
            <div class="input-box">
                <span class="details">Description</span>
                <label>
                    <textarea placeholder="Description" required name="description"></textarea>
                </label>
            </div>
        </div>
        <div class="button">
            <input type="submit" value="Make">
        </div>
    </form>
</div>
</body>
</html>