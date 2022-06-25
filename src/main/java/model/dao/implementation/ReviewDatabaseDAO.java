package model.dao.implementation;

import model.dao.ReviewDAO;
import model.dao.connection.Connector;
import model.dao.constant.Constants;
import model.enity.Review;
import model.enity.User;
import model.exception.DatabaseException;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewDatabaseDAO implements ReviewDAO {
    private static Logger log = Logger.getLogger(ReviewDatabaseDAO.class);

    public ReviewDatabaseDAO(){}

    @Override
    public boolean add(Review review) throws DatabaseException, SQLException, NamingException {
        Connection con = Connector.getInstance().getConnection();
        con.setAutoCommit(false);
        try(PreparedStatement pstmt = con.prepareStatement(Constants.INSERT_REVIEW)){
            pstmt.setString(1, review.getContent());
            pstmt.setDate(2, (Date) review.getDateWorkDone());
            pstmt.setFloat(3, review.getRating());
            pstmt.setInt(4, review.getUserId());
            pstmt.setInt(5, review.getOrderId());
            pstmt.execute();
            log.info("Review was added successful");
            con.commit();
            return true;
        } catch (SQLException e){
            con.rollback();
            throw new RuntimeException("Cannot add review " + e);
        }
    }

    @Override
    public Review getById(Integer reviewId) throws DatabaseException {
        try(Connection con = Connector.getInstance().getConnection();
        PreparedStatement pstmt = con.prepareStatement(Constants.SELECT_BY_REVIEW_ID)){
            pstmt.setInt(1, reviewId);
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            log.info("Successful get review by reviewId");
            return new Review.ReviewBuilderImpl()
                    .setId(reviewId)
                    .setContent(resultSet.getString("content"))
                    .setDateWorkDone(resultSet.getDate("dateWorkDone"))
                    .setRating(resultSet.getFloat("rating"))
                    .setUserId(resultSet.getInt("userId"))
                    .setOrderId(resultSet.getInt("orderId"))
                    .build();
        } catch (SQLException e){
            throw new DatabaseException(String.format("Cannot get review by its id = %d", reviewId), e);
        }
    }

    @Override
    public boolean deleteEntity(Integer reviewId) throws NamingException, SQLException {
        Connection con = Connector.getInstance().getConnection();
        try(PreparedStatement pstmt = con.prepareStatement(Constants.DELETE_USER)){
            pstmt.setInt(1, reviewId);
            pstmt.executeUpdate();
            log.info("Review was deleted successful");
            con.commit();
            return true;
        } catch (SQLException e){
            con.rollback();
            throw new RuntimeException("Cannot delete review ", e);
        }
    }

    @Override
    public Review updateEntity(Review review) {
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.UPDATE_USER)){
            pstmt.setInt(1, review.getReviewId());
            pstmt.setString(2, review.getContent());
            pstmt.setDate(3, (Date) review.getDateWorkDone());
            pstmt.setFloat(4, review.getRating());
            pstmt.setInt(5, review.getUserId());
            pstmt.setInt(6, review.getOrderId());
            pstmt.executeUpdate();
            log.info("Review was updated successful");
            return review;
        } catch (SQLException e){
            throw new RuntimeException("Cannot update review ", e);
        }
    }


    @Override
    public List<Review> getAll() {
        List<Review> outputReviews = new ArrayList<>();
        try(Connection con = Connector.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(Constants.ALL_REVIEWS)){
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                Review review = new Review();
                review.setReviewId(resultSet.getInt(1));
                review.setContent(resultSet.getString(2));
                review.setDateWorkDone((java.sql.Date) resultSet.getDate(3));
                review.setRating(resultSet.getFloat(4));
                review.setUserId(resultSet.getInt(5));
                review.setOrderId(resultSet.getInt(6));
                outputReviews.add(review);
            }
            log.info("All reviews were found successful");
            return outputReviews;
        } catch (SQLException e){
            throw new RuntimeException("Cannot find all reviews ", e);
        }
    }

    @Override
    public List<Review> getAllReviewsByUserId(int userId) {
        List<Review> reviewList = new ArrayList<>();
        try(Connection con = Connector.getInstance().getConnection();
        PreparedStatement pstmt = con.prepareStatement(Constants.SELECT_REVIEW_BY_ORDER_ID)){
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();
            Review review = null;
            while (resultSet.next()){
                review = new Review.ReviewBuilderImpl()
                        .setId(resultSet.getInt("reviewId"))
                        .setContent(resultSet.getString("content"))
                        .setDateWorkDone(resultSet.getDate("dateWorkDone"))
                        .setRating(resultSet.getFloat("rating"))
                        .setUserId(resultSet.getInt("userId"))
                        .setOrderId(resultSet.getInt("orderId"))
                        .build();
                reviewList.add(review);
            }
            log.info("review was found successful by userId");
            return reviewList;
        } catch (SQLException e){
            throw new RuntimeException("Cannot find review by userId", e);
        }
    }

    @Override
    public List<Review> getAllReviewsByOrderId(int orderId) {
        return null;
    }

    @Override
    public Map<User, Review> getAllReviewsByUserAndOrderId(int userId, int orderId) {
        return null;
    }
}
