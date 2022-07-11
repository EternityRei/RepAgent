package model.enity;

import model.builder.OrderBuilder;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.Comparator;
import java.util.Objects;

public class Order extends Model{
    private int id;
    private String title;
    private String description;
    private float cost;
    private int paymentStatus;
    private int workStatus;
    private int user_id;
    private int workerId;
    private Long currentTime = System.currentTimeMillis();
    private Timestamp timestamp = new Timestamp(currentTime);


    public Order(OrderBuilderImpl orderBuilder){
        this.id = orderBuilder.id;
        this.cost = orderBuilder.cost;
        this.description = orderBuilder.description;
        this.workStatus = orderBuilder.workStatus;
        this.paymentStatus = orderBuilder.paymentStatus;
        this.title = orderBuilder.title;
        this.user_id = orderBuilder.user_id;
        this.workerId = orderBuilder.workerId;
        this.timestamp = orderBuilder.date;
    }

    public static class OrderBuilderImpl implements OrderBuilder {
        private int id;
        private String title;
        private String description;
        private float cost;
        private int paymentStatus;
        private int workStatus;
        private int user_id;
        private int workerId;
        private Timestamp date;

        @Override
        public OrderBuilder setId(int id) {
            this.id = id;
            return this;
        }

        @Override
        public OrderBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public OrderBuilder setPrice(float price) {
            this.cost = price;
            return this;
        }

        @Override
        public OrderBuilder setPaymentStatus(int paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        @Override
        public OrderBuilder setUserId(int user_id) {
            this.user_id = user_id;
            return this;
        }

        @Override
        public OrderBuilder setWorkStatus(int workStatus) {
            this.workStatus = workStatus;
            return this;
        }

        @Override
        public OrderBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        @Override
        public OrderBuilder setEmployeeId(int employeeId) {
            this.workerId = employeeId;
            return this;
        }

        @Override
        public OrderBuilder setDate(Timestamp date) {
            this.date = date;
            return this;
        }

        @Override
        public Order build() {
            return new Order(this);
        }
    }

    public Order(){}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(int workStatus) {
        this.workStatus = workStatus;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserid() {
        return user_id;
    }

    public void setUserid(int user_id) {
        this.user_id = user_id;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId()
                && Float.compare(order.getCost(), getCost()) == 0
                && getPaymentStatus() == order.getPaymentStatus()
                && getWorkStatus() == order.getWorkStatus()
                && getUserid() == order.getUserid()
                && getWorkerId() == order.getWorkerId()
                && getTitle().equals(order.getTitle())
                && getDescription().equals(order.getDescription())
                && currentTime.equals(order.currentTime)
                && getTimestamp().equals(order.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(),
                getDescription(), getCost(), getPaymentStatus(),
                getWorkStatus(), getUserid(), getWorkerId(),
                currentTime, getTimestamp());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", paymentStatus=" + paymentStatus +
                ", workStatus=" + workStatus +
                ", user_id=" + user_id +
                ", workerId=" + workerId +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class IdComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            String o1Id = String.valueOf(o1.getId());
            String o2Id = String.valueOf(o2.getId());
            return o1Id.compareTo(o2Id);
        }
    }
}
