package com.java25;

/**
 * Exemplo didático de Java 25 - Pattern Matching para Tipos Primitivos (Preview)
 *
 * Objetivo:
 * - Pattern matching para tipos primitivos em switch
 * - Melhorar performance e legibilidade
 * - Suportar int, long, float, double, etc.
 */
public class Java25PatternMatchingPrimitives {

    public static void main(String[] args) {

        System.out.println("=== Pattern Matching para Primitivos (Java 25 Preview) ===\n");

        /*
         * 1) Pattern Matching com int
         */
        System.out.println("--- Pattern Matching com int ---");
        processarInt(5);
        processarInt(10);
        processarInt(15);
        processarInt(20);

        /*
         * 2) Pattern Matching com double
         */
        System.out.println("\n--- Pattern Matching com double ---");
        processarDouble(3.14);
        processarDouble(2.71);
        processarDouble(1.0);
        processarDouble(0.5);

        /*
         * 3) Pattern Matching com ranges
         */
        System.out.println("\n--- Pattern Matching com Ranges ---");
        classificarTemperatura(35);
        classificarTemperatura(25);
        classificarTemperatura(15);
        classificarTemperatura(5);
        classificarTemperatura(-5);

        /*
         * 4) Pattern Matching combinado
         */
        System.out.println("\n--- Pattern Matching Combinado ---");
        processarNumero(42);
        processarNumero(3.14);
        processarNumero(100L);
    }

    private static void processarInt(int valor) {
        String resultado = switch (valor) {
            case 0 -> "Zero";
            case 1, 2, 3 -> "Pequeno (1-3)";
            case 4, 5, 6, 7, 8, 9 -> "Médio (4-9)";
            case 10, 11, 12, 13, 14, 15 -> "Grande (10-15)";
            default -> "Muito grande: " + valor;
        };
        System.out.println("Valor " + valor + ": " + resultado);
    }

    private static void processarDouble(double valor) {
        String resultado = switch ((int) (valor * 100)) { // Converter para int para pattern matching
            case 314 -> "É Pi (aproximado)";
            case 271 -> "É e (aproximado)";
            case 100 -> "É 1.0";
            case 50 -> "É 0.5";
            default -> "Outro valor: " + valor;
        };
        System.out.println("Valor " + valor + ": " + resultado);
    }

    private static void classificarTemperatura(int temp) {
        String classificacao = switch (temp) {
            case Integer t when t >= 30 -> "Muito quente";
            case Integer t when t >= 20 -> "Quente";
            case Integer t when t >= 10 -> "Ameno";
            case Integer t when t >= 0 -> "Frio";
            default -> "Muito frio";
        };
        System.out.println("Temperatura " + temp + "°C: " + classificacao);
    }

    private static void processarNumero(Number numero) {
        String resultado = switch (numero) {
            case Integer i -> "Integer: " + (i * 2);
            case Double d -> "Double: " + (d * 2);
            case Long l -> "Long: " + (l * 2);
            default -> "Outro tipo: " + numero.getClass().getSimpleName();
        };
        System.out.println(resultado);
    }
}

