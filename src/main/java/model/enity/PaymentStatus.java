package model.enity;

public enum PaymentStatus {
    NOT_PAID(1),
    PAID(2),
    CANCELED(3);

    private int paymentStatus;

    PaymentStatus(int paymentStatus){
        this.paymentStatus = paymentStatus;
    }
}
