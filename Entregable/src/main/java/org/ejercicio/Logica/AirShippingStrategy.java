package org.ejercicio.Logica;

public class AirShippingStrategy implements ShippingStrategy{
    @Override
    public double calculateCost(double peso, int volumen, String origen, String destino) {
        return 30 + peso * 1.5 + volumen * 0.3;
    }
}
