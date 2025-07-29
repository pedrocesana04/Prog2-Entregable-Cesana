package org.ejercicio.Logica;

public abstract class PaymentProcessor {
    public PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public abstract String processPayment(double amount);
    public abstract String refundPayment(double amount);
}
