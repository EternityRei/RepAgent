package model.enity;

import model.builder.OrderBuilder;

import java.util.Objects;

public class Order extends Model{
    private int id;
    private float cost;
    private String description;
    private int workStatus;
    private int paymentStatus;
    private String title;
    private int user_id;
    private String review;
    private int user_role;
    private int worker_mark;


    public Order(OrderBuilderImpl orderBuilder){
        super(orderBuilder.id);
        this.cost = orderBuilder.cost;
        this.description = orderBuilder.description;
        this.workStatus = orderBuilder.workStatus;
        this.paymentStatus = orderBuilder.paymentStatus;
        this.title = orderBuilder.title;
        this.user_id = orderBuilder.user_id;
        this.review = orderBuilder.review;
        this.user_role = orderBuilder.user_role;
        this.worker_mark = orderBuilder.worker_mark;
    }

    public static class OrderBuilderImpl implements OrderBuilder {
        private int id;
        private float cost;
        private String description;
        private int workStatus;
        private int paymentStatus;
        private String title;
        private int user_id;
        private String review;
        private int user_role;
        private int worker_mark;



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
        public OrderBuilder setReview(String review) {
            this.review = review;
            return this;
        }

        @Override
        public OrderBuilder setUser_role(int role) {
            this.user_role = role;
            return this;
        }

        @Override
        public OrderBuilder setWorker_mark(int mark){
            this.worker_mark = mark;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public int getWorker_mark() {
        return worker_mark;
    }

    public void setWorker_mark(int worker_mark) {
        this.worker_mark = worker_mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId()
                && Float.compare(order.getCost(), getCost()) == 0
                && getWorkStatus() == order.getWorkStatus()
                && getPaymentStatus() == order.getPaymentStatus()
                && getUser_id() == order.getUser_id()
                && getUser_role() == order.getUser_role()
                && getWorker_mark() == order.getWorker_mark()
                && getDescription().equals(order.getDescription())
                && getTitle().equals(order.getTitle())
                && getReview().equals(order.getReview());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCost(), getDescription(),
                getWorkStatus(), getPaymentStatus(), getTitle(),
                getUser_id(), getReview(), getUser_role(), getWorker_mark());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", workStatus=" + workStatus +
                ", paymentStatus=" + paymentStatus +
                ", title='" + title + '\'' +
                ", user_id=" + user_id +
                ", review='" + review + '\'' +
                ", user_role=" + user_role +
                ", worker_mark=" + worker_mark +
                '}';
    }
}
