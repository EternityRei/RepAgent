package model.dao;

import model.enity.Order;

import java.util.List;

public interface OrderDAO extends CrudDAO<Integer, Order> {
    List<Order> getAll();

    List<Order> getAllOrdersInProcess(int work_status);

    List<Order> getAllOrdersByWorkerID(int worker_id);

    List<Order> getAllOrdersByPersonID(int person_id);
}
