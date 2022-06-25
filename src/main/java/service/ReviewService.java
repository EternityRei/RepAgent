package service;

import model.enity.Order;
import model.enity.Review;
import model.enity.User;
import service.factory.ItemService;

import java.util.List;
import java.util.Map;

public interface ReviewService extends ItemService<Integer, Review> {

    public List<User> findByUserId(int userId);

    public List<Order> findByOrderId(int orderId);

    public Map<User, Order> findByUserAndOrderId(int userId, int orderId);
}
