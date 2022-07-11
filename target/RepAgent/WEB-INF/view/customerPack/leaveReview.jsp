<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Leave a review</title>
        <title>Leave a review</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/leaveReview_style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    </head>
    <body>
    <form action="${pageContext.request.contextPath}/view/customerPack/leaveReview">
        <div class="container">
            <div class="post">
                <div class="text">Thanks for rating us!</div>
                <div class="edit">EDIT</div>
            </div>
            <div class="star-widget">
                <input type="radio" name="rate" id="rate-5" value="5">
                <label for="rate-5" class="fas fa-star"></label>
                <input type="radio" name="rate" id="rate-4" value="4">
                <label for="rate-4" class="fas fa-star"></label>
                <input type="radio" name="rate" id="rate-3" value="3">
                <label for="rate-3" class="fas fa-star"></label>
                <input type="radio" name="rate" id="rate-2" value="2">
                <label for="rate-2" class="fas fa-star"></label>
                <input type="radio" name="rate" id="rate-1" value="1">
                <label for="rate-1" class="fas fa-star"></label>
                <form action="${pageContext.request.contextPath}/view/customerPack/leaveReview">
                    <header></header>
                    <div class="textarea">
                        <textarea cols="30" placeholder="Describe your experience.." name="content"></textarea>
                    </div>
                    <input type="hidden" name="id" value="${param.id}">
                    <div class="btn">
                        <a href="${pageContext.request.contextPath}/view/customerPack/leaveReview?content=${param.content}&rating=${param.rate}">
                            <button type="submit" name="btn" value="Post">Post</button>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </form>
    <%--<script src="${pageContext.request.contextPath}/js/leaveReviewScript.js"></script>--%>
    </body>
</html>
