package com.java14;

/**
 * Exemplo didático de Java 14 - Pattern Matching para instanceof (Preview)
 *
 * Objetivo:
 * - Simplificar verificação de tipo e casting
 * - Reduzir código boilerplate
 * - Melhorar legibilidade
 */
public class Java14PatternMatchingInstanceof {

    public static void main(String[] args) {

        System.out.println("=== Pattern Matching para instanceof (Java 14 Preview) ===\n");

        /*
         * 1) instanceof tradicional (pré-Java 14)
         */
        System.out.println("--- instanceof Tradicional ---");
        Object objeto1 = "Java";
        if (objeto1 instanceof String) {
            String str = (String) objeto1; // Casting manual necessário
            System.out.println("É uma String: " + str.toUpperCase());
        }

        /*
         * 2) Pattern Matching instanceof (Java 14+ Preview)
         */
        System.out.println("\n--- Pattern Matching instanceof ---");
        Object objeto2 = "Java";
        if (objeto2 instanceof String str) {
            // Variável 'str' já está disponível, sem casting manual
            System.out.println("É uma String: " + str.toUpperCase());
        }

        /*
         * 3) Pattern Matching com diferentes tipos
         */
        System.out.println("\n--- Pattern Matching com Múltiplos Tipos ---");
        processarObjeto("Texto");
        processarObjeto(42);
        processarObjeto(3.14);
        processarObjeto(null);

        /*
         * 4) Pattern Matching em condições
         */
        System.out.println("\n--- Pattern Matching em Condições ---");
        Object valor = 100;
        if (valor instanceof Integer i && i > 50) {
            System.out.println("É um Integer maior que 50: " + i);
        }

        /*
         * 5) Pattern Matching com negativa
         */
        System.out.println("\n--- Pattern Matching Negativo ---");
        Object obj = "Java";
        if (!(obj instanceof String s)) {
            System.out.println("Não é uma String");
        } else {
            System.out.println("É uma String: " + s);
        }
    }

    private static void processarObjeto(Object obj) {
        if (obj instanceof String str) {
            System.out.println("Processando String: " + str.toUpperCase());
        } else if (obj instanceof Integer num) {
            System.out.println("Processando Integer: " + (num * 2));
        } else if (obj instanceof Double d) {
            System.out.println("Processando Double: " + (d * 2));
        } else {
            System.out.println("Tipo desconhecido ou null");
        }
    }
}

