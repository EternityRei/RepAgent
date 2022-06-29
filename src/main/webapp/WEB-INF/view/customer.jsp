<%@ page import="java.sql.Connection" %>
<%@ page import="model.dao.connection.Connector" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="static model.dao.constant.Constants.SELECT_MANAGER_NAME_TO_JSP" %>
<%@ page import="model.enity.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
    private final User user = new User();
%><c:set var="language" value="${not empty param.language ? param.language : pageContext.request.locale}"
         scope="application"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<!DOCTYPE html>
<html lang="java">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<head>
    <title>Customer page</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/customer_style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/view/customer" method="post">
    <div class="container">
        <aside>
            <div class="top">
                <div class="logo">
                    <h2>H&H</h2>
                </div>
                <div class="close" id="close-btn">
                    <span class="material-icons-sharp">close</span>
                </div>
            </div>

            <div class="slidebar">


                <a href="${pageContext.request.contextPath}/view/customer" class="active">
                    <span class="material-icons-sharp">grid_view</span>
                    <h3>Dashboard</h3>
                </a>

                <a href="${pageContext.request.contextPath}/view/customerPack/ordersList">
                    <span class="material-icons-sharp">receipt_long</span>
                    <h3>Orders</h3>
                </a>

                <a href="${pageContext.request.contextPath}/view/customerPack/reviewsList">
                    <span class="material-icons-sharp">rate_review</span>
                    <h3>Reviews</h3>
                </a>

                <a href="#">
                    <span class="material-icons-sharp">report</span>
                    <h3>Reports</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">settings</span>
                    <h3>Settings</h3>
                </a>

                <a href="${pageContext.request.contextPath}/view/login">
                    <span class="material-icons-sharp">logout</span>
                    <h3>Logout</h3>
                </a>
            </div>
        </aside>
        <main>
            <h1>Dashboard</h1>

            <div class="date">
                <label>
                    <input type="date">
                </label>
            </div>

            <div class="recent-orders">
                <h2>Recent Orders</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Order title</th>
                        <th>Order number</th>
                        <th>Order price</th>
                        <th>Payment Status</th>
                        <th>Work Status</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Gogogo</td>
                        <td>19191</td>
                        <td>120$</td>
                        <td>Paid</td>
                        <td class="warning">Done</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/ordersList"
                            class="primary">Details</td>
                    </tr>
                    <tr>
                        <td>Drop</td>
                        <td>12313</td>
                        <td>Done</td>
                        <td class="warning">Pending</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/ordersList"
                            class="primary">Details</td>
                    </tr>
                    <tr>
                        <td>Gogogo</td>
                        <td>19191</td>
                        <td>Due</td>
                        <td class="warning">Pending</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/ordersList"
                            class="primary">Details</td>
                    </tr>
                    <tr>
                        <td>Gogogo</td>
                        <td>19191</td>
                        <td>Due</td>
                        <td class="warning">Pending</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/ordersList"
                            class="primary">Details</td>
                    </tr>
                    <tr>
                        <td>Gogogo</td>
                        <td>19191</td>
                        <td>Due</td>
                        <td class="warning">Pending</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/ordersList"
                            class="primary">Details</td>
                    </tr>
                    <tr>
                        <td>Gogogo</td>
                        <td>19191</td>
                        <td>Due</td>
                        <td class="warning">Pending</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/ordersList"
                            class="primary">Details</td>
                    </tr>
                    <tr>
                        <td>Gogogo</td>
                        <td>19191</td>
                        <td>Due</td>
                        <td class="warning">Pending</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/ordersList"
                            class="primary">Details</td>
                    </tr>

                    </tbody>
                </table>
                <a href="${pageContext.request.contextPath}/view/customerPack/ordersList">Show All</a>
            </div>
            <div class="recent-reviews">
                <h2>Recent reviews</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Review number</th>
                        <th>Order number</th>
                        <th>Order title</th>
                        <th>Rating</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Gogogo</td>
                        <td>19191</td>
                        <td>Due</td>
                        <td class="warning">4</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/reviewsList"
                            class="primary">Details</td>
                    </tr>
                    <tr>
                        <td>Drop</td>
                        <td>12313</td>
                        <td>Done</td>
                        <td class="warning">4.6</td>
                        <td href="${pageContext.request.contextPath}/view/customerPack/reviewsList"
                            class="primary">Details</td>
                    </tr>
                    </tbody>
                </table>
                <a href="${pageContext.request.contextPath}/view/customerPack/reviewsList">Show All</a>
            </div>
        </main>

        <div class="right">
            <div class="top">
                <button id="menu-btn">
                    <span class="material-icons-sharp">menu</span>
                </button>
                <div class="profile">
                    <div class="info">
                        <p>Hey, <b>customer</b></p>
                        <small class="text-muted">Customer</small>
                    </div>
                </div>
            </div>

            <div class="recent-updates">
                <h2>Notifications</h2>
                <div class="updates">
                    <div class="update">
                        <div class="message">
                            <p><b>Your order was submitted</b></p>
                            <small class="text-muted">24.06.22 16:24</small>
                        </div>
                    </div>
                </div>
                <div class="update">
                    <div class="message">
                        <p><b>Your order was done</b></p>
                        <small class="text-muted">24.06.22 20:05</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>