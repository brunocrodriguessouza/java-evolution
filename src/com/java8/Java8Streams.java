package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exemplo didático de Java 8 - API Streams
 *
 * Objetivo:
 * - Demonstrar o uso da API Streams para processamento de coleções
 * - Mostrar operações intermediárias e terminais
 * - Comparar código imperativo vs funcional
 */
public class Java8Streams {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Lista original: " + numeros);
        System.out.println("------------------------------------------------");

        /*
         * 1) Abordagem IMPERATIVA (pré-Java 8)
         * Código mais verboso e propenso a erros
         */
        System.out.println("\n--- Abordagem Imperativa ---");
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                int quadrado = numero * numero;
                System.out.println("Quadrado de " + numero + " = " + quadrado);
            }
        }

        /*
         * 2) Abordagem FUNCIONAL com Streams (Java 8+)
         * Código mais declarativo e legível
         */
        System.out.println("\n--- Abordagem Funcional com Streams ---");
        numeros.stream()
                .filter(n -> n % 2 == 0)           // Operação intermediária: filtra pares
                .map(n -> n * n)                    // Operação intermediária: transforma
                .forEach(n -> System.out.println("Quadrado = " + n)); // Operação terminal

        /*
         * 3) Coletando resultados em uma nova lista
         */
        System.out.println("\n--- Coletando resultados ---");
        List<Integer> quadradosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Quadrados dos números pares: " + quadradosPares);

        /*
         * 4) Operações agregadas
         */
        System.out.println("\n--- Operações Agregadas ---");
        int soma = numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();

        System.out.println("Soma dos números pares: " + soma);

        double media = numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .average()
                .orElse(0.0);

        System.out.println("Média dos números pares: " + media);
    }
}

