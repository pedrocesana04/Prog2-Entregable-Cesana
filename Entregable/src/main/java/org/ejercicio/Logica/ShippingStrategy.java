package org.ejercicio.Logica;

public interface ShippingStrategy {
    double calculateCost(double peso, int volumen, String origen, String destino);
}
