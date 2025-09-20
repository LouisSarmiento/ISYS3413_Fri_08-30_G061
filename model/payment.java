package model;

import enums.PaymentStatus;
import services.PaymentGateway;

public class Payment {
    private int paymentId;
    private float amount;
    private String status;
    private PaymentGateway gateway;

    public Payment(int paymentId, float amount, PaymentGateway gateway) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.gateway = gateway;
    }

    public PaymentStatus processPayment() {
        if (gateway.authorise(amount)) {
            return PaymentStatus.APPROVED;
        }
        return PaymentStatus.DECLINED;
    }
}
