package org.ejercicio.Logica;

public class TruckShippingStrategy implements ShippingStrategy{
    @Override
    public double calculateCost(double peso, int volumen, String origen, String destino) {
        return 20 + peso * 0.2 + volumen * 1.5;
    }
}
