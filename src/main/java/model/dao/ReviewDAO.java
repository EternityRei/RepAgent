package model.dao;

import model.enity.Review;
import model.enity.User;

import java.util.List;
import java.util.Map;

public interface ReviewDAO extends CrudDAO<Integer, Review>{

    List<Review> getAll();

    List<Review> getAllReviewsByUserId(int userId);

    List<Review> getAllReviewsByOrderId(int orderId);

    List<Review> getAllReviewsByUserAndOrderId(int userId, int orderId);
}
