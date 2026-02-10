package com.java8;

import java.util.Optional;

/**
 * Exemplo didático de Java 8 - Optional
 *
 * Objetivo:
 * - Evitar NullPointerException de forma elegante
 * - Demonstrar métodos úteis do Optional
 * - Mostrar boas práticas de uso
 */
public class Java8Optional {

    public static void main(String[] args) {

        System.out.println("=== Exemplos de Optional ===\n");

        /*
         * 1) Problema: NullPointerException (pré-Java 8)
         */
        System.out.println("--- Problema com null (pré-Java 8) ---");
        String nome = buscarNome(1);
        // Código perigoso - pode lançar NullPointerException
        // int tamanho = nome.length(); // ERRO se nome for null

        /*
         * 2) Solução tradicional (verbosa)
         */
        System.out.println("\n--- Solução tradicional ---");
        String nome2 = buscarNome(1);
        if (nome2 != null) {
            System.out.println("Nome encontrado: " + nome2);
            System.out.println("Tamanho: " + nome2.length());
        } else {
            System.out.println("Nome não encontrado");
        }

        /*
         * 3) Solução com Optional (Java 8+)
         */
        System.out.println("\n--- Solução com Optional ---");
        Optional<String> nomeOptional = buscarNomeOptional(1);

        // Verificar se existe valor
        if (nomeOptional.isPresent()) {
            System.out.println("Nome encontrado: " + nomeOptional.get());
        } else {
            System.out.println("Nome não encontrado");
        }

        /*
         * 4) Métodos úteis do Optional
         */
        System.out.println("\n--- Métodos úteis do Optional ---");

        // orElse: retorna valor padrão se vazio
        String nomeComDefault = buscarNomeOptional(99)
                .orElse("Nome não encontrado");
        System.out.println("Nome com default: " + nomeComDefault);

        // orElseGet: retorna valor de uma função se vazio
        String nomeComSupplier = buscarNomeOptional(99)
                .orElseGet(() -> "Nome gerado: Usuário " + System.currentTimeMillis());
        System.out.println("Nome com supplier: " + nomeComSupplier);

        // ifPresent: executa ação se valor existe
        buscarNomeOptional(1).ifPresent(n -> 
            System.out.println("Nome processado: " + n.toUpperCase())
        );

        // map: transforma o valor se presente
        Optional<Integer> tamanho = buscarNomeOptional(1)
                .map(String::length);
        tamanho.ifPresent(t -> System.out.println("Tamanho do nome: " + t));

        // filter: filtra se valor atende condição
        buscarNomeOptional(1)
                .filter(n -> n.length() > 5)
                .ifPresent(n -> System.out.println("Nome longo encontrado: " + n));
    }

    // Simula busca que pode retornar null
    private static String buscarNome(int id) {
        if (id == 1) {
            return "João";
        }
        return null; // Problema: pode ser null
    }

    // Versão melhorada retornando Optional
    private static Optional<String> buscarNomeOptional(int id) {
        if (id == 1) {
            return Optional.of("João");
        }
        return Optional.empty(); // Retorna Optional vazio ao invés de null
    }
}

