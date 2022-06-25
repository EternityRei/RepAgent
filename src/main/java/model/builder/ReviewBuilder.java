package model.builder;

import model.enity.Review;

import java.util.Date;

public interface ReviewBuilder {

    ReviewBuilder setId(int id);

    ReviewBuilder setContent(String content);

    ReviewBuilder setDateWorkDone(Date dateWorkDone);

    ReviewBuilder setRating(float rating);

    ReviewBuilder setUserId(int userId);

    ReviewBuilder setOrderId(int orderId);

    Review build();
}
