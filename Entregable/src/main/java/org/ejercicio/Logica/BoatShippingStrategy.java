package org.ejercicio.Logica;

public class BoatShippingStrategy implements ShippingStrategy{
    @Override
    public double calculateCost(double peso, int volumen, String origen, String destino) {
        return 10 + peso + volumen * 0.5;
    }
}
