package services;

public class PaymentGateway {
    public boolean authorise(float amount) {
        return amount > 0;
    }

    public boolean capture(float amount) {
        return amount > 0;
    }
}
