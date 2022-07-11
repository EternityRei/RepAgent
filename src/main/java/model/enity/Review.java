package model.enity;

import model.builder.ReviewBuilder;

import java.util.Date;
import java.util.Objects;

public class Review extends Model{
    private int reviewId;
    private String content;
    private Date dateWorkDone;
    private float rating;
    private int userId;
    private int orderId;

    public Review(Review.ReviewBuilderImpl reviewBuilder){
        this.reviewId = reviewBuilder.reviewId;
        this.content = reviewBuilder.content;
        this.dateWorkDone = reviewBuilder.dateWorkDone;
        this.rating = reviewBuilder.rating;
        this.userId = reviewBuilder.userId;
        this.orderId = reviewBuilder.orderId;
    }

    public static class ReviewBuilderImpl implements ReviewBuilder{
        private int reviewId;
        private String content;
        private Date dateWorkDone;
        private float rating;
        private int userId;
        private int orderId;

        @Override
        public ReviewBuilder setId(int id) {
            this.reviewId = id;
            return this;
        }

        @Override
        public ReviewBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        @Override
        public ReviewBuilder setDateWorkDone(Date dateWorkDone) {
            this.dateWorkDone = dateWorkDone;
            return this;
        }

        @Override
        public ReviewBuilder setRating(float rating) {
            this.rating = rating;
            return this;
        }

        @Override
        public ReviewBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public ReviewBuilder setOrderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        @Override
        public Review build() {
            return new Review(this);
        }
    }

    public Review(){}

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateWorkDone() {
        return dateWorkDone;
    }

    public void setDateWorkDone(Date dateWorkDone) {
        this.dateWorkDone = dateWorkDone;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return getReviewId() == review.getReviewId()
                && Float.compare(review.getRating(), getRating()) == 0
                && getUserId() == review.getUserId()
                && getOrderId() == review.getOrderId()
                && getContent().equals(review.getContent())
                && getDateWorkDone().equals(review.getDateWorkDone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewId(), getContent(),
                getDateWorkDone(), getRating(),
                getUserId(), getOrderId());
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", content='" + content + '\'' +
                ", dateWorkDone=" + dateWorkDone +
                ", rating=" + rating +
                ", userId=" + userId +
                ", orderId=" + orderId +
                '}';
    }
}
