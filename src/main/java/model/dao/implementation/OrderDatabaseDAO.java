package model.dao.implementation;

import model.dao.OrderDAO;
import model.dao.connection.Connector;
import model.dao.constant.Constants;
import model.enity.Order;
import model.enity.User;
import model.exception.DatabaseException;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDatabaseDAO implements OrderDAO {

    private Logger log = Logger.getLogger(OrderDatabaseDAO.class);
    @Override
    public boolean add(Order order) throws DatabaseException, SQLException, NamingException {
        Connection con = Connector.getInstance().getConnection();
        con.setAutoCommit(false);
        try(PreparedStatement pstmt = con.prepareStatement(Constants.INSERT_ORDER)){
            pstmt.setString(1, order.getTitle());
            pstmt.setString(2, order.getDescription());
            pstmt.setFloat(3, order.getCost());
            pstmt.setInt(4, 1);
            pstmt.setInt(5, 1);
            pstmt.setInt(6, order.getUserid());
            pstmt.setInt(7, order.getWorkerId());
            pstmt.setTimestamp(8, java.sql.Timestamp.from(Instant.now()));
            pstmt.execute();
            log.info("Order was added successful");
            con.commit();
            return true;
        } catch (SQLException e){
            con.rollback();
            throw new DatabaseException("Cannot add order ", e);
        }
    }

    @Override
    public boolean deleteEntity(Integer id) throws NamingException, SQLException {
        Connection con = Connector.getInstance().getConnection();
        try(PreparedStatement pstmt = con.prepareStatement(Constants.DELETE_ORDER)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            log.info("Order was deleted successful");
            con.commit();
            return true;
        } catch (SQLException e){
            con.rollback();
            throw new RuntimeException("Cannot delete order ", e);
        }
    }

    @Override
    public Order updateEntity(Order order) {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.UPDATE_ORDER)){
            pstmt.setString(1, order.getTitle());
            pstmt.setString(2, order.getDescription());
            pstmt.setFloat(3, order.getCost());
            pstmt.setInt(4, order.getPaymentStatus());
            pstmt.setInt(5, order.getWorkStatus());
            pstmt.setInt(6, order.getUserid());
            pstmt.setInt(7, order.getWorkerId());
            pstmt.setTimestamp(8, order.getTimestamp());
            pstmt.setInt(9, order.getId());
            pstmt.executeUpdate();
            System.out.println(order.toString());
            log.info("Order was updated successful");
            return order;
        } catch (SQLException e){
            throw new RuntimeException("Cannot update order ", e);
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> outputOrders = new ArrayList<>();
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.ALL_ORDERS)){
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setTitle(resultSet.getString(2));
                order.setDescription(resultSet.getString(3));
                order.setCost(resultSet.getFloat(4));
                order.setPaymentStatus(resultSet.getInt(5));
                order.setWorkStatus(resultSet.getInt(6));
                order.setUserid(resultSet.getInt(7));
                order.setWorkerId(resultSet.getInt(8));
                order.setTimestamp(resultSet.getTimestamp(9));
                outputOrders.add(order);
            }
            log.info("All orders were found successful");
            return outputOrders;
        } catch (SQLException e){
            throw new RuntimeException("Cannot find all orders ", e);
        }
    }

    @Override
    public Order getById(Integer id) throws DatabaseException {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.SELECT_BY_ORDER_ID)){
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            log.info("successful getById order");
            return new Order.OrderBuilderImpl()
                    .setId(id)
                    .setTitle(resultSet.getString("title"))
                    .setDescription(resultSet.getString("description"))
                    .setPrice(resultSet.getFloat("cost"))
                    .setPaymentStatus(resultSet.getInt("payment_id"))
                    .setWorkStatus(resultSet.getInt("work_status_id"))
                    .setUserId(resultSet.getInt("person_id"))
                    .setEmployeeId(resultSet.getInt("employee_id"))
                    .setDate(resultSet.getTimestamp("date"))
                    .build();

        } catch (SQLException e){
            throw new DatabaseException(String.format("Cannot get order by id = %d", id), e);
        }
    }

    @Override
    public List<Order> getAllOrdersInProcess(int work_status) {
        List<Order> listOrders = null;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_ORDER_IN_PROCESS)) {
            statement.setInt(1, work_status);
            ResultSet rs = statement.executeQuery();
            listOrders = initOrder(rs);
            log.info("successful getAllOrdersInProcess");
            return listOrders;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot getAllOrdersInProcess order ", e);
        }
    }

    @Override
    public List<Order> getAllOrdersByWorkerID(int worker_id) {
        List<Order> listOrders = null;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_ORDER_WORKER_ID)) {
            statement.setInt(1, worker_id);
            ResultSet rs = statement.executeQuery();
            listOrders = initOrder(rs);
            log.info("successful getAllOrderByWorkerID");
            return listOrders;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot getAllBooksByWorkerID order ", e);
        }
    }

    @Override
    public List<Order> getAllOrdersByPersonID(int user_id) {
        List<Order> listOrders = null;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ALL_ORDER_USER_ID)) {
            statement.setInt(1, user_id);
            ResultSet rs = statement.executeQuery();
            listOrders = initOrder(rs);
            log.info("successful getAllOrderByPersonID");
            return listOrders;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot getAllBooksByPersonID order", e);
        }
    }

    @Override
    public Order getByDescriptionAndUserId(String description, int userId) {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.SELECT_BY_ORDER_ID)){
            pstmt.setInt(1, userId);
            pstmt.setString(2, description);

            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            log.info("successful getByDescriptionAndUserId order");
            return new Order.OrderBuilderImpl()
                    .setUserId(userId)
                    .setDescription(description)
                    .setId(resultSet.getInt("id"))
                    .setTitle(resultSet.getString("title"))
                    .setPrice(resultSet.getFloat("cost"))
                    .setPaymentStatus(resultSet.getInt("payment_id"))
                    .setWorkStatus(resultSet.getInt("work_status_id"))
                    .setUserId(resultSet.getInt("person_id"))
                    .setEmployeeId(resultSet.getInt("employee_id"))
                    .setDate(resultSet.getTimestamp("date"))
                    .build();

        } catch (SQLException e){
            throw new RuntimeException("Cannot getByDescriptionAndUserId order " + e);
        }
    }

    @Override
    public Order getByUserId(int userId) {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.SELECT_ORDER_BY_USER_ID)){
            pstmt.setInt(1, userId);

            ResultSet resultSet = pstmt.executeQuery();
            Order order = null;
            if(resultSet.next()){
                order = new Order.OrderBuilderImpl()
                        .setId(resultSet.getInt("id"))
                        .setTitle(resultSet.getString("title"))
                        .setDescription(resultSet.getString("description"))
                        .setPrice(resultSet.getFloat("cost"))
                        .setPaymentStatus(resultSet.getInt("payment_id"))
                        .setWorkStatus(resultSet.getInt("work_status_id"))
                        .setUserId(resultSet.getInt("person_id"))
                        .setDate(resultSet.getTimestamp("date"))
                        .build();
            }
            log.info("Success getByUserId order");
            return order;

        } catch (SQLException e){
            throw new RuntimeException(String.format("Cannot get order by getByUserId = %d", userId), e);
        }
    }

    @Override
    public List<Order> getAllOrdersByUserId(int userId) {
        List<Order> listOrders = null;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.SELECT_USERS_ORDERS)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            listOrders = initOrder(rs);
            log.info("successful getAllOrderByPersonID");
            return listOrders;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot getAllOrdersByUserId order", e);
        }
    }


    private List<Order> initOrder(ResultSet rs) throws SQLException {
        List<Order> outerBooks = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt(1));
            order.setTitle(rs.getString(2));
            order.setDescription(rs.getString(3));
            order.setCost(rs.getFloat(4));
            order.setPaymentStatus(rs.getInt(5));
            order.setWorkStatus(rs.getInt(6));
            order.setUserid(rs.getInt(7));
            order.setWorkerId(rs.getInt(8));
            order.setTimestamp(rs.getTimestamp(9));
            outerBooks.add(order);
        }
        return outerBooks;
    }
}
