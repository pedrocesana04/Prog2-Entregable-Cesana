package org.ejercicio.Logica;

public class PaypalPaymentProcessor extends PaymentProcessor{
    public PaypalPaymentProcessor(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public String processPayment(double amount) {
        return paymentGateway.capture(amount) + " " + paymentGateway.authorize(amount);
    }

    @Override
    public String refundPayment(double amount) {
        return "Paypal reembolsa: $" + amount;
    }
}
