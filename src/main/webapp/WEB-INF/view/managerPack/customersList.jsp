<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="static model.dao.constant.Constants.SELECT_USERS" %>
<%@ page import="java.util.logging.Logger" %>

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
          <th>Username</th>
          <th>Email</th>
          <th>Money</th>
        </tr>
      </thead>
      <%
        try{
          Class.forName("org.postgresql.Driver");
          Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                  "postgres", "root");
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(SELECT_USERS);
          while(rs.next()){
      %>
      <tbody>
      <tr>
        <td><%=rs.getInt("id")%></td>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("email")%></td>
        <td class="money"><%=rs.getFloat("money")%></td>
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
