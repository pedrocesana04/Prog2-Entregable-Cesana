package org.ejercicio.Logica;

public class MercadoPagoPaymentProcessor extends PaymentProcessor{
    public MercadoPagoPaymentProcessor(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public String processPayment(double amount) {
        return paymentGateway.capture(amount) + " " + paymentGateway.authorize(amount);
    }

    @Override
    public String refundPayment(double amount) {
        return "Mercado Pago reembolsa: $" + amount;
    }
}
