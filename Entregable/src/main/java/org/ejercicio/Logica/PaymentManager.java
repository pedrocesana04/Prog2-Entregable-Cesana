package org.ejercicio.Logica;

public class PaymentManager {
    public String processPayment(double amount, String provider){
        PaymentGateway paymentGateway;
        PaymentProcessor paymentProcessor;
        if(provider.equalsIgnoreCase("paypal")){
            paymentGateway = new PaypalGateway();
            paymentProcessor = new PaypalPaymentProcessor(paymentGateway);
        }
        else if(provider.equalsIgnoreCase("mercadopago")){
            paymentGateway = new MercadoPagoGateWay();
            paymentProcessor = new MercadoPagoPaymentProcessor(paymentGateway);
        }
        else{
            return "El proveedor no está registrado.";
        }

        return paymentProcessor.processPayment(amount);
    }
}
