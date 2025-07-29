package org.ejercicio.Logica;

public class PaypalGateway implements PaymentGateway{
    @Override
    public String authorize (double amount){
        return "Paypal autoriza: $" + amount;
    }

    @Override
    public String capture (double amount){
        return "Paypal captura: $" + amount;
    }
}
