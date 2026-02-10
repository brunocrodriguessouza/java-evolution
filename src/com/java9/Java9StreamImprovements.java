package com.java9;

import java.util.List;
import java.util.stream.Stream;

/**
 * Exemplo didático de Java 9 - Melhorias na API Streams
 *
 * Objetivo:
 * - Demonstrar novos métodos takeWhile, dropWhile, ofNullable
 * - Mostrar iterações infinitas com iterate
 * - Facilitar operações com streams
 */
public class Java9StreamImprovements {

    public static void main(String[] args) {

        System.out.println("=== Melhorias na API Streams (Java 9+) ===\n");

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*
         * 1) takeWhile() - Pega elementos enquanto condição é verdadeira
         */
        System.out.println("--- takeWhile() - Pega enquanto condição é verdadeira ---");
        List<Integer> menoresQue5 = numeros.stream()
                .takeWhile(n -> n < 5)
                .toList();
        System.out.println("Números menores que 5: " + menoresQue5);

        /*
         * 2) dropWhile() - Remove elementos enquanto condição é verdadeira
         */
        System.out.println("\n--- dropWhile() - Remove enquanto condição é verdadeira ---");
        List<Integer> maioresOuIguaisA5 = numeros.stream()
                .dropWhile(n -> n < 5)
                .toList();
        System.out.println("Números maiores ou iguais a 5: " + maioresOuIguaisA5);

        /*
         * 3) ofNullable() - Cria stream com elemento ou vazio se null
         */
        System.out.println("\n--- ofNullable() - Stream de elemento ou vazio ---");
        String nome = "Java";
        Stream<String> stream1 = Stream.ofNullable(nome);
        System.out.println("Stream de 'Java': " + stream1.toList());

        String nomeNull = null;
        Stream<String> stream2 = Stream.ofNullable(nomeNull);
        System.out.println("Stream de null (vazio): " + stream2.toList());

        /*
         * 4) iterate() melhorado - Permite condição de parada
         */
        System.out.println("\n--- iterate() melhorado - Com condição de parada ---");
        // Java 8: iterate(seed, function) - infinito
        // Java 9+: iterate(seed, predicate, function) - com condição
        
        List<Integer> numerosPares = Stream.iterate(0, n -> n < 20, n -> n + 2)
                .toList();
        System.out.println("Números pares até 20: " + numerosPares);

        /*
         * 5) Exemplo combinado
         */
        System.out.println("\n--- Exemplo Combinado ---");
        List<Integer> resultado = Stream.iterate(1, n -> n < 100, n -> n * 2)
                .takeWhile(n -> n < 50)
                .toList();
        System.out.println("Potências de 2 menores que 50: " + resultado);
    }
}

