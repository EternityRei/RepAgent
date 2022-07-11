package service.impl;

import model.dao.ReviewDAO;
import model.dao.factory.DAOFactory;
import model.enity.Order;
import model.enity.Review;
import model.enity.User;
import model.exception.DatabaseException;
import model.exception.ServiceException;
import service.ReviewService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ReviewServiceImpl implements ReviewService {

    private static final Logger log = Logger.getLogger(String.valueOf(ReviewServiceImpl.class));

    private final DAOFactory DaoFactory = DAOFactory.getInstance();

    private ReviewDAO reviewDAO = DaoFactory.getReviewDAO();

    @Override
    public List<Review> findByUserId(int userId) {
        return reviewDAO.getAllReviewsByUserId(userId);
    }

    @Override
    public List<Review> findByOrderId(int orderId) {
        return reviewDAO.getAllReviewsByOrderId(orderId);
    }

    @Override
    public List<Review> findByUserAndOrderId(int userId, int orderId) {
        return reviewDAO.getAllReviewsByUserAndOrderId(userId, orderId);
    }

    @Override
    public List<Review> getAll() {
        return reviewDAO.getAll();
    }

    @Override
    public Review getEntity(Integer id) throws DatabaseException, ServiceException, DatabaseException, ServiceException {
        return reviewDAO.getById(id);
    }

    @Override
    public boolean add(Review entity) throws ServiceException {
        boolean flag = false;
        try {
            flag = reviewDAO.add(entity);
        } catch (SQLException | NamingException | DatabaseException e) {
            log.info(e.getMessage());
        }
        return flag;
    }

    @Override
    public Review update(Review entity) {
        return reviewDAO.updateEntity(entity);
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        try {
            flag = reviewDAO.deleteEntity(id);
        } catch (SQLException | NamingException e) {
            log.info(e.getMessage());
        }
        return flag;
    }
}
