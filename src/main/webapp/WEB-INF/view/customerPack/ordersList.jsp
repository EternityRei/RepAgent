<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/customersList_style.css">
</head>
<body>
    <div class="new-order">
        <a href="${pageContext.request.contextPath}/view/customerPack/makeOrder">
            <h3>Make a new order</h3>
        </a>
    </div>
    <div class="table">
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Payment</th>
                <th>Work status</th>
                <th>Employee UC</th>
                <th>Date</th>
                <th></th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${orders}" var="order">
                <tr>
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.title}" /></td>
                    <td><c:out value="${order.description}" /></td>
                    <td><c:out value="${order.cost}" /></td>
                    <td>
                        <c:if test="${order.getPaymentStatus() == 1}">
                            <c:out value="Not paid" />
                        </c:if>
                        <c:if test="${order.getPaymentStatus() == 2}">
                            <c:out value="Paid" />
                        </c:if>
                        <c:if test="${order.getPaymentStatus() == 3}">
                            <c:out value="Canceled" />
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${order.getWorkStatus() == 1}">
                            <c:out value="Not started" />
                        </c:if>
                        <c:if test="${order.getWorkStatus() == 2}">
                            <c:out value="In process" />
                        </c:if>
                        <c:if test="${order.getWorkStatus() == 3}">
                            <c:out value="Done" />
                        </c:if>
                    </td>
                    <td><c:out value="${order.getWorkerId()}" /></td>
                    <td><c:out value="${order.getTimestamp()}" /></td>
                    <td>
                        <c:if test="${order.getPaymentStatus() == 1}">
                            <a href="${pageContext.request.contextPath}/view/customerPack/ordersList?id=${order.id}&price=${order.cost}&btn=Pay">
                                <button name="btn" value="Pay">Pay</button>
                            </a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${order.getPaymentStatus() == 1}">
                            <a href="${pageContext.request.contextPath}/view/customerPack/ordersList?id=${order.id}&price=${order.cost}&btn=Cancel">
                                <button name="btn" value="Cancel">Cancel</button>
                            </a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${order.getWorkStatus() == 1}">
                            <a href="${pageContext.request.contextPath}/view/customerPack/cannotLeaveReview">
                                <button type="button" class="btn btn-primary" name="btn">Review</button>
                            </a>
                        </c:if>
                        <c:if test="${order.getWorkStatus() == 2}">
                            <a href="${pageContext.request.contextPath}/view/customerPack/cannotLeaveReview">
                                <button type="button" class="btn btn-primary" name="btn">Review</button>
                            </a>
                        </c:if>
                        <c:if test="${order.getWorkStatus() == 3}">
                            <a href="${pageContext.request.contextPath}/view/customerPack/leaveReview?id=${order.id}">
                                <button type="button" class="btn btn-primary" name="btn">Review</button>
                            </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <script src="${pageContext.request.contextPath}/js/reviewButtonScript.js"></script>
</body>
</html>