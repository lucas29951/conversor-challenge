import functions.Conversor;

import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static Conversor conversor = new Conversor();

    public static void main(String[] args) {
        while (true) {
            exhibirMenu();
            String opcion = entrada.nextLine();

            switch (opcion) {
                case "1" -> {
                    realizarConversion("USD", "ARS");
                }
                case "2" -> {
                    realizarConversion("ARS", "USD");
                }
                case "3" -> {
                    realizarConversion("USD", "BRL");
                }
                case "4" -> {
                    realizarConversion("BRL", "USD");
                }
                case "5" -> {
                    realizarConversion("USD", "COP");
                }
                case "6" -> {
                    realizarConversion("COP", "USD");
                }
                case "7" -> {
                    System.out.println("Saliendo del programa...");
                    return;
                }
                default -> {
                    System.out.println("Opción invalida. Intentelo de nuevo.");
                }
            }
        }
    }

    private static void realizarConversion(String base, String target) {
        System.out.print("Ingrese el monto a convertir: ");
        double monto = Double.parseDouble(entrada.nextLine());

        conversor.convertirMoneda(base, target, monto);
    }

    private static void exhibirMenu() {
        System.out.print("""
                \n**************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Salir
                Elija una opción valida:
                **************************************************
                """);
    }
}