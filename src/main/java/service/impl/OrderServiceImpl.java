package service.impl;

import model.dao.OrderDAO;
import model.dao.UserDAO;
import model.dao.factory.DAOFactory;
import model.enity.Order;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import org.apache.log4j.Logger;
import service.OrderService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private Logger log = Logger.getLogger(OrderServiceImpl.class);

    private final DAOFactory DaoFactory = DAOFactory.getInstance();
    private OrderDAO orderDAO = DaoFactory.getOrderDAO();
    private UserDAO userDAO = DaoFactory.getUserDAO();


    @Override
    public List<Order> findByStatusAndWorker(int workStatus, int payStatus, int worker_id) {
        return orderDAO.getAll().stream()
                .filter(e -> e.getWorkStatus() == workStatus || e.getPaymentStatus() == payStatus
                || e.getUser_id() == worker_id).collect(Collectors.toList());
    }

    @Override
    public boolean setOrderStatus(int payStatus, int workStatus, int user_id, int order_id) {
        Order order = null;
        User user = null;
        Objects.requireNonNull(order).setUser_id(user_id);
        order.setId(order_id);
        order.setPaymentStatus(payStatus);
        order.setWorkStatus(workStatus);
        return true;
    }

    @Override
    public Map<Order, User> getAllInfoByOrder() {
        List<Order> list = orderDAO.getAll();
        User user;
        Order order;
        Map<Order, User> map = new HashMap<>();
        try {
            for (Order value : list) {
                order = value;
                user = userDAO.getById(order.getUser_id());
                map.put(order, user);
            }
        } catch (DatabaseException e) {
            log.error(e.getMessage());
            return Collections.emptyMap();
        }

        return map;
    }

    @Override
    public List<Order> getAllOrdersInProcess(int work_status) {
        return orderDAO.getAllOrdersInProcess(work_status);
    }

    @Override
    public List<Order> getAll() throws ServiceException {
        return orderDAO.getAll();
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDAO.getAll();
    }

    @Override
    public List<Order> getAllOrdersByUserIDandAddDebt(int user_id) {
        return null;
    }

    @Override
    public List<Order> getAllOrderByUserID(int user_id) {
        return orderDAO.getAllOrdersByPersonID(user_id);
    }

    @Override
    public Order getByUserId(int userId) {
        return orderDAO.getByUserId(userId);
    }

    @Override
    public Order getByDescriptionAndUserId(String description, int userId) {
        return orderDAO.getByDescriptionAndUserId(description, userId);
    }

    @Override
    public Order getEntity(Integer id) throws DatabaseException, ServiceException, DatabaseException, ServiceException {
        return orderDAO.getById(id);
    }

    @Override
    public boolean add(Order entity) throws ServiceException {
        boolean flag = false;
        try {
            flag = orderDAO.add(entity);
        } catch (SQLException | NamingException | DatabaseException e) {
            log.error(e.getMessage());
        }
        return flag;
    }

    @Override
    public Order update(Order entity) {
        return orderDAO.updateEntity(entity);
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        try {
            flag = orderDAO.deleteEntity(id);
        } catch (SQLException | NamingException e) {
            log.error(e.getMessage());
        }
        return flag;
    }

}
