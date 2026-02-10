package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Exemplo didático de Java 8 - Method References
 *
 * Objetivo:
 * - Simplificar expressões lambda quando apenas chamam um método
 * - Mostrar diferentes tipos de method references
 * - Comparar lambda vs method reference
 */
public class Java8MethodReferences {

    public static void main(String[] args) {

        List<String> nomes = Arrays.asList("Ana", "Bruno", "Carlos", "Diana");

        System.out.println("Lista original: " + nomes);
        System.out.println("------------------------------------------------");

        /*
         * 1) Lambda Expression (Java 8)
         */
        System.out.println("\n--- Usando Lambda Expression ---");
        nomes.forEach(nome -> System.out.println(nome));

        /*
         * 2) Method Reference - Referência a método de instância (Java 8+)
         * Quando o lambda apenas chama um método do parâmetro
         */
        System.out.println("\n--- Usando Method Reference (método de instância) ---");
        nomes.forEach(System.out::println);

        /*
         * 3) Method Reference - Referência a método estático
         */
        System.out.println("\n--- Method Reference (método estático) ---");
        List<String> nomesMaiusculos = nomes.stream()
                .map(String::toUpperCase)  // Equivale a: n -> n.toUpperCase()
                .toList();
        System.out.println("Nomes em maiúsculas: " + nomesMaiusculos);

        /*
         * 4) Method Reference - Referência a construtor
         */
        System.out.println("\n--- Method Reference (construtor) ---");
        List<Integer> tamanhos = nomes.stream()
                .map(String::length)  // Equivale a: n -> n.length()
                .toList();
        System.out.println("Tamanhos: " + tamanhos);

        /*
         * 5) Comparação: Lambda vs Method Reference
         */
        System.out.println("\n--- Comparação Lambda vs Method Reference ---");
        
        // Lambda
        Consumer<String> imprimirLambda = nome -> System.out.println(nome);
        
        // Method Reference (mais conciso)
        Consumer<String> imprimirMethodRef = System.out::println;
        
        System.out.println("Usando lambda:");
        imprimirLambda.accept("Teste Lambda");
        
        System.out.println("Usando method reference:");
        imprimirMethodRef.accept("Teste Method Reference");

        /*
         * 6) Method Reference com método de instância de classe específica
         */
        System.out.println("\n--- Method Reference (instância específica) ---");
        String prefixo = "Sr. ";
        Function<String, String> adicionarPrefixo = prefixo::concat;
        List<String> nomesComPrefixo = nomes.stream()
                .map(adicionarPrefixo)
                .toList();
        System.out.println("Nomes com prefixo: " + nomesComPrefixo);
    }
}

