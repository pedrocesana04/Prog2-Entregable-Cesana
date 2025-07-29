package org.ejercicio.Logica;

public interface PaymentGateway {
    String authorize(double amount);
    String capture(double amount);
}
