package model.builder;

import model.enity.Order;

public interface OrderBuilder {
    OrderBuilder setId(int id);
    OrderBuilder setDescription(String description);
    OrderBuilder setPrice(float price);
    OrderBuilder setPaymentStatus(int paymentStatus);
    OrderBuilder setUserId(int person_id);
    OrderBuilder setWorkStatus(int workStatus);
    OrderBuilder setTitle(String title);
    OrderBuilder setReview(String review);
    OrderBuilder setUser_role(int role);
    OrderBuilder setWorker_mark(int mark);
    Order build();
}
