package org.ejercicio.Logica;

public class ShippingCalculator {
    private double peso;
    private int volumen;
    private String origen;
    private String destino;
    private ShippingStrategy shippingStrategy;

    public ShippingCalculator(double peso, int volumenm, String origen, String destino, ShippingStrategy shippingStrategy){
        this.shippingStrategy = shippingStrategy;
        this.destino = destino;
        this.origen = origen;
        this.volumen = volumenm;
        this.peso = peso;
    }

    public ShippingCalculator(){};

    public ShippingCalculator(double peso, int volumenm, String origen, String destino){
        this.destino = destino;
        this.origen = origen;
        this.volumen = volumenm;
        this.peso = peso;
    }

    public double calculateCost(){

        return shippingStrategy.calculateCost(peso, volumen, origen, destino);
    }

    public double getPeso() {
        return peso;
    }

    public int getVolumen() {
        return volumen;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public ShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }
}
