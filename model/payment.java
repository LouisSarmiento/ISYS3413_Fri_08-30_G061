package model;

import enums.PaymentStatus;
import services.PaymentGateway;

public class Payment {
    private final int paymentId;
    private final float amount;
    private PaymentStatus status = PaymentStatus.PENDING;
    private final PaymentGateway gateway;

    public Payment(int paymentId, float amount, PaymentGateway gateway) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.gateway = gateway;
    }

    public PaymentStatus processPayment() {
        status = gateway.authorise(amount) ? PaymentStatus.APPROVED : PaymentStatus.DECLINED;
        return status;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public float getAmount() {
        return amount;
    }

    public int getPaymentId() {
        return paymentId;
    }
}
