<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : pageContext.request.locale}"
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
    <title>Manager page</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/manager_style.css">
</head>
<body>
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
                <a href="#">
                    <span class="material-icons-sharp">grid_view</span>
                    <h3>Dashboard</h3>
                </a>
                <a href="#" class="active">
                    <span class="material-icons-sharp">person</span>
                    <h3>Customers</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">receipt_long</span>
                    <h3>Orders</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">insights</span>
                    <h3>Analytics</h3>
                </a>
                <a href="#">
                    <span class="material-icons-sharp">engineering</span>
                    <h3>Employees</h3>
                </a>
                <a href="#">
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
                <a href="#">
                    <span class="material-icons-sharp">add</span>
                    <h3>Add employee</h3>
                </a>
                <a href="#">
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

            <div class="insights">
                <div class="orders">
                    <span class="material-icons-sharp">receipt</span>
                    <div class="middle">
                        <div class="left">
                            <h3>Total Orders</h3>
                            <h1>$4,259</h1>
                        </div>
                        <div class="progress">
                            <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                            </svg>
                        </div>
                        <div class="number">
                            <p>81%</p>
                        </div>
                    </div>
                    <small class="text-muted">Last 24 hours</small>
                </div>
                <div class="expenses">
                    <span class="material-icons-sharp">bar_chart</span>
                    <div class="middle">
                        <div class="left">
                            <h3>Total Expenses</h3>
                            <h1>$842</h1>
                        </div>
                        <div class="progress">
                            <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                            </svg>
                        </div>
                        <div class="number">
                            <p>62%</p>
                        </div>
                    </div>
                    <small class="text-muted">Last 24 hours</small>
                </div>
                <div class="income">
                    <span class="material-icons-sharp">stacked_line_chart</span>
                    <div class="middle">
                        <div class="left">
                            <h3>Total Income</h3>
                            <h1>$1,245</h1>
                        </div>
                        <div class="progress">
                            <svg>
                                <circle cx='38' cy='38' r='36'></circle>
                            </svg>
                        </div>
                        <div class="number">
                            <p>44%</p>
                        </div>
                    </div>
                    <small class="text-muted">Last 24 hours</small>
                </div>
            </div>

            <div class="recent-orders">
                <h2>Recent Orders</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Order title</th>
                            <th>Order number</th>
                            <th>Payment</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Gogogo</td>
                            <td>19191</td>
                            <td>Due</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>
                        <tr>
                            <td>Drop</td>
                            <td>12313</td>
                            <td>Done</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>
                        <tr>
                            <td>Gogogo</td>
                            <td>19191</td>
                            <td>Due</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>
                        <tr>
                            <td>Gogogo</td>
                            <td>19191</td>
                            <td>Due</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>
                        <tr>
                            <td>Gogogo</td>
                            <td>19191</td>
                            <td>Due</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>
                        <tr>
                            <td>Gogogo</td>
                            <td>19191</td>
                            <td>Due</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>
                        <tr>
                            <td>Gogogo</td>
                            <td>19191</td>
                            <td>Due</td>
                            <td class="warning">Pending</td>
                            <td class="primary">Details</td>
                        </tr>

                    </tbody>
                </table>
                <a href="#">Show All</a>
            </div>
        </main>

        <div class="right">
            <div class="top">
                <button id="menu-btn">
                    <span class="material-icons-sharp">menu</span>
                </button>
                <div class="profile">
                    <div class="info">
                        <p>Hey, <b>{$user.name}</b></p>
                        <small class="text-muted">Manager</small>
                    </div>
                </div>
            </div>

            <div class="recent-updates">
                <h2>Recent Updates</h2>
                <div class="updates">
                    <div class="update">
                        <div class="message">
                             <p><b>Mike Jonson</b>Done</p>
                            <small class="text-muted">2 Minutes Ago</small>
                        </div>
                    </div>
                </div>
                <div class="update">
                    <div class="message">
                        <p><b>{$user.name}</b>{$order.status}</p>
                        <small class="text-muted">2 Minutes Ago</small>
                    </div>
                </div>
                <div class="update">
                    <div class="message">
                        <p><b>{$user.name}</b>{$order.status}</p>
                        <small class="text-muted">2 Minutes Ago</small>
                    </div>
                </div>
                <div class="update">
                    <div class="message">
                        <p><b>{$user.name}</b>{$order.status}</p>
                        <small class="text-muted">2 Minutes Ago</small>
                    </div>
                </div>
                <div class="update">
                    <div class="message">
                        <p><b>{$user.name}</b>{$order.status}</p>
                        <small class="text-muted">2 Minutes Ago</small>
                    </div>
                </div>
            </div>

            <div class="orders-analytics">
                <h2>Orders Analytics</h2>
                <div class="item_online">
                    <div class="icon">
                        <span class="material-icons-sharp">shopping_cart</span>
                    </div>
                    <div class="right">
                        <div class="info">
                            <h3>ONLINE ORDERS</h3>
                            <small class="text-muted">Last 24 hours</small>
                        </div>
                        <h5 class="success">+50%</h5>
                        <h3>5171</h3>
                    </div>
                </div>
                <div class="item_offline">
                    <div class="icon">
                        <span class="material-icons-sharp">local_mall</span>
                    </div>
                    <div class="right">
                        <div class="info">
                            <h3>OFFLINE ORDERS</h3>
                            <small class="text-muted">Last 24 hours</small>
                        </div>
                        <h5 class="danger">-13%</h5>
                        <h3>2210</h3>
                    </div>
                </div>
                <div class="item_customers">
                    <div class="icon">
                        <span class="material-icons-sharp">person</span>
                    </div>
                    <div class="right">
                        <div class="info">
                            <h3>NEW CUSTOMERS</h3>
                            <small class="text-muted">Last 24 hours</small>
                        </div>
                        <h5 class="success">+5%</h5>
                        <h3>15</h3>
                    </div>
                </div>
            </div>

            <%-- FOR CUSTOMERS --%>
            <div class="item add-product">
                <div>
                    <span class="material-icons-sharp">add</span>
                    <h3>Add order</h3>
                </div>
            </div>
        </div>
    </div>
</body>
</html>