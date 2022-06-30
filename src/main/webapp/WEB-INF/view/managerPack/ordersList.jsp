<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="static model.dao.constant.Constants.ALL_ORDERS" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! Logger log = Logger.getLogger("customersList.jsp"); %>
<html>
<head>
    <title>Customers</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/customersList_style.css">
</head>
<body>
<div class="top">
  <aside>
    <a href="${pageContext.request.contextPath}/view/manager" type="back">
      <span class="material-icons-sharp">arrow_back_ios_new</span>
      <h3>Back</h3>
    </a>
  </aside>
</div>
  <div class="table">
    <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Title</th>
          <th>Description</th>
          <th>Cost</th>
          <th>Payment status</th>
          <th>Work status</th>
          <th>User id</th>
          <th>Worker id</th>
          <th>Date</th>
        </tr>
      </thead>
      <%
        try{
          Class.forName("org.postgresql.Driver");
          Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                  "postgres", "root");
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(ALL_ORDERS);
          while(rs.next()){
      %>
      <tbody>
      <tr>
        <td><%=rs.getInt("id")%></td>
        <td><%=rs.getString("title")%></td>
        <td><%=rs.getString("description")%></td>
        <td><%=rs.getFloat("cost")%></td>
        <td class="payment-status"><%=rs.getInt("payment_id")%></td>
        <td class="work-status"><%=rs.getInt("work_status_id")%></td>
        <td><%=rs.getInt("person_id")%></td>
        <td><%=rs.getInt("employee_id")%></td>
        <td><%=rs.getTimestamp("date")%></td>
      </tr>
      </tbody>
      <% }
      } catch(Exception e){
        log.info("something went wrong " + e.getMessage());
      }
      %>
    </table>
  </div>
</body>
</html>
