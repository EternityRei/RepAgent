package service;

import model.enity.Order;
import model.enity.User;
import model.exception.ServiceException;
import service.factory.ItemService;

import java.util.List;
import java.util.Map;

public interface OrderService extends ItemService<Integer, Order> {
    public List<Order> findByStatusAndWorker(int workStatus, int payStatus, int worker_id);

    public boolean setOrderStatus(int payStatus, int workStatus, int user_id, int order_id);

    public Map<Order, User> getAllInfoByOrder();

    List<Order> getAllOrdersInProcess(int work_status);

    List<Order> getAll() throws ServiceException;

    public List<Order> getAllOrder();

    List<Order> getAllOrdersByUserIDandAddDebt(int user_id);

    List<Order> getAllOrderByUserID(int user_id);
}
