package model.builder;

import model.enity.Order;

import java.sql.Timestamp;
import java.util.Date;

public interface OrderBuilder {
    OrderBuilder setId(int id);
    OrderBuilder setDescription(String description);
    OrderBuilder setPrice(float price);
    OrderBuilder setPaymentStatus(int paymentStatus);
    OrderBuilder setUserId(int person_id);
    OrderBuilder setWorkStatus(int workStatus);
    OrderBuilder setTitle(String title);
    OrderBuilder setEmployeeId(int employeeId);
    OrderBuilder setDate(Timestamp date);
    Order build();
}
