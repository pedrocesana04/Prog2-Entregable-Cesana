package org.ejercicio.Logica;

public class MercadoPagoGateWay implements PaymentGateway{
    @Override
    public String authorize (double amount){
        return "Mercado Pago autoriza: $" + amount;
    }

    @Override
    public String capture (double amount){
        return "Mercado Pago captura: $" + amount;
    }
}
