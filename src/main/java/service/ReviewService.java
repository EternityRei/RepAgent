package service;

import model.enity.Order;
import model.enity.Review;
import model.enity.User;
import service.factory.ItemService;

import java.util.List;
import java.util.Map;

public interface ReviewService extends ItemService<Integer, Review> {

    public List<Review> findByUserId(int userId);

    public List<Review> findByOrderId(int orderId);

    public List<Review> findByUserAndOrderId(int userId, int orderId);

    public List<Review> getAll();
}
