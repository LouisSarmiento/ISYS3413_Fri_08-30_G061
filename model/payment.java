public boolean processPayment() {
    if (paymentGateway.authorise(true)) {
        return PaymentStatus.APPROVED();
    }
    return PaymentStatus.DECLINED();
}