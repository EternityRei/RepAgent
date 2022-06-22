package model.dao.implementation;

import model.dao.OrderDAO;
import model.dao.connection.Connector;
import model.dao.constant.Constants;
import model.enity.Order;
import model.enity.User;
import model.exception.DatabaseException;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDatabaseDAO implements OrderDAO {

    private Logger log = Logger.getLogger(OrderDatabaseDAO.class);
    @Override
    public boolean add(Order order) throws DatabaseException, SQLException, NamingException {
        Connection con = Connector.getInstance().getConnection();
        con.setAutoCommit(false);
        try(PreparedStatement pstmt = con.prepareStatement(Constants.INSERT_ORDER)){
            pstmt.setFloat(1, order.getCost());
            pstmt.setString(2, order.getDescription());
            pstmt.setInt(3, order.getWorkStatus());
            pstmt.setInt(4, order.getPaymentStatus());
            pstmt.setInt(5, order.getUser_id());
            pstmt.setString(6, order.getTitle());
            pstmt.setInt(7, order.getUser_role());
            pstmt.setString(8, order.getReview());
            pstmt.setInt(9, order.getWorker_mark());
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
            pstmt.setFloat(1, order.getCost());
            pstmt.setString(2, order.getDescription());
            pstmt.setInt(3, order.getWorkStatus());
            pstmt.setInt(4, order.getPaymentStatus());
            pstmt.setInt(5, order.getUser_id());
            pstmt.setInt(6, order.getId());
            pstmt.setString(7, order.getTitle());
            pstmt.setInt(8, order.getUser_role());
            pstmt.setString(8, order.getReview());
            pstmt.setInt(9, order.getWorker_mark());
            pstmt.executeUpdate();
            log.info("Order was updated successful");
            return order;
        } catch (SQLException | NamingException e){
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
                order.setCost(resultSet.getFloat(2));
                order.setDescription(resultSet.getString(3));
                order.setWorkStatus(resultSet.getInt(4));
                order.setPaymentStatus(resultSet.getInt(5));
                order.setReview(resultSet.getString(6));
                order.setWorker_mark(resultSet.getInt(7));
                order.setUser_id(resultSet.getInt(8));
                order.setTitle(resultSet.getString(9));
                order.setUser_role(resultSet.getInt(10));
                outputOrders.add(order);
            }
            log.info("All orders were found successful");
            return outputOrders;
        } catch (SQLException | NamingException e){
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
                    .setPrice(resultSet.getFloat("cost"))
                    .setDescription(resultSet.getString("description"))
                    .setWorkStatus(resultSet.getInt("work_status"))
                    .setPaymentStatus(resultSet.getInt("payment_status"))
                    .setUserId(resultSet.getInt("user_id"))
                    .setTitle(resultSet.getString("title"))
                    .setUser_role(resultSet.getInt("user_role"))
                    .setReview(resultSet.getString("review"))
                    .setWorker_mark(resultSet.getInt("worker_mark"))
                    .build();

        } catch (SQLException | NamingException e){
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
        } catch (SQLException | NamingException e) {
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
        } catch (SQLException | NamingException e) {
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
        } catch (SQLException | NamingException e) {
            throw new RuntimeException("Cannot getAllBooksByPersonID order", e);
        }
    }

    private List<Order> initOrder(ResultSet rs) throws SQLException {
        List<Order> outerBooks = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt(1));
            order.setCost(rs.getFloat(2));
            order.setDescription(rs.getString(3));
            order.setWorkStatus(rs.getInt(4));
            order.setPaymentStatus(rs.getInt(5));
            order.setReview(rs.getString(6));
            order.setWorker_mark(rs.getInt(7));
            order.setUser_id(rs.getInt(8));
            order.setTitle(rs.getString(9));
            order.setUser_role(rs.getInt(10));
            outerBooks.add(order);
        }
        return outerBooks;
    }
}
