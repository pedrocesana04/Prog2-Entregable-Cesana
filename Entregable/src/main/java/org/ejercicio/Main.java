package org.ejercicio;

import org.ejercicio.Logica.*;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){
        boolean continuar = true;

        while (continuar){
            menuDeInteraccion();
            int opcion = leerOpcion();

            switch (opcion){
                case 1 -> procesarPago();
                case 2 -> calcularEnvio();
                case 3 -> continuar = false;
                default -> System.out.println("Opción invalida");
            }
        }
    }

    private static void menuDeInteraccion(){
        System.out.println("Presione:");
        System.out.println("1 para procesar un pago.");
        System.out.println("2 para calcular el costo de envío de un paquete.");
        System.out.println("3 para finalizar la ejecución.");
    }

    private static int leerOpcion(){
        try{
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            return -1;
        }
    }

    private static void procesarPago(){
        System.out.println("Ingresa el monto que desea procesar.");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingresa el proveedor que desea utiilizar.");
        String proveedor = scanner.nextLine();

        CompletableFuture
            .supplyAsync(() -> {
                PaymentManager paymentManager = new PaymentManager();
                return paymentManager.processPayment(amount, proveedor);
            })
                .thenAccept(resultado -> System.out.println("Resultado del pago: " + resultado)).join();
    }

    private static void calcularEnvio(){

        System.out.println("Ingrese el peso del paquete: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese el volumen del paquete: ");
        int volumen = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el origen del envio: ");
        String origen = scanner.nextLine();

        System.out.println("Ingrese el destino del envio: ");
        String destino = scanner.nextLine();

        System.out.println("Elija el medio de envio:");
        System.out.println("1: Aereo.");
        System.out.println("2: Terrestre.");
        System.out.println("3: Marítimo");
        int medio = scanner.nextInt();
        scanner.nextLine();


        CompletableFuture
            .supplyAsync(() -> {
                ShippingStrategy shippingStrategy;

                switch (medio) {
                    case 1 -> shippingStrategy = new AirShippingStrategy();
                    case 2 -> shippingStrategy = new TruckShippingStrategy();
                    case 3 -> shippingStrategy = new BoatShippingStrategy();
                    default -> throw new IllegalArgumentException("Medio no vàlido.");
                }
                ShippingCalculator shippingCalculator = new ShippingCalculator(peso, volumen, origen, destino, shippingStrategy);
                return shippingCalculator.calculateCost();
            })
            .thenAccept(precio -> System.out.println("El precio del envío es: $" + precio)).join();
    }
}