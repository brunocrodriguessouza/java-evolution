package com.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Exemplo didático de Java 9 - Factory Methods para Coleções
 *
 * Objetivo:
 * - Criar coleções imutáveis de forma mais concisa
 * - Substituir código verboso de criação de coleções
 * - Facilitar criação de listas, sets e maps imutáveis
 */
public class Java9FactoryMethodsCollections {

    public static void main(String[] args) {

        System.out.println("=== Factory Methods para Coleções (Java 9+) ===\n");

        /*
         * 1) List.of() - Cria lista imutável
         */
        System.out.println("--- List.of() - Lista Imutável ---");
        // Antes (Java 8): verboso
        // List<String> nomes = new ArrayList<>();
        // nomes.add("Ana");
        // nomes.add("Bruno");
        // nomes.add("Carlos");
        // List<String> imutavel = Collections.unmodifiableList(nomes);

        // Agora (Java 9+): conciso
        List<String> nomes = List.of("Ana", "Bruno", "Carlos", "Diana");
        System.out.println("Lista: " + nomes);

        // Tentar modificar lançará UnsupportedOperationException
        try {
            // nomes.add("Eduardo"); // ERRO: lista é imutável
            System.out.println("Lista é imutável - não pode adicionar elementos");
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao tentar modificar: " + e.getMessage());
        }

        /*
         * 2) Set.of() - Cria conjunto imutável
         */
        System.out.println("\n--- Set.of() - Conjunto Imutável ---");
        Set<Integer> numeros = Set.of(1, 2, 3, 4, 5);
        System.out.println("Conjunto: " + numeros);

        // Set não permite duplicatas
        try {
            // Set<Integer> duplicado = Set.of(1, 2, 2); // ERRO: IllegalArgumentException
            System.out.println("Set não permite valores duplicados");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        /*
         * 3) Map.of() - Cria mapa imutável (até 10 pares)
         */
        System.out.println("\n--- Map.of() - Mapa Imutável (até 10 pares) ---");
        Map<String, Integer> idades = Map.of(
                "Ana", 25,
                "Bruno", 30,
                "Carlos", 28
        );
        System.out.println("Mapa: " + idades);
        System.out.println("Idade de Ana: " + idades.get("Ana"));

        /*
         * 4) Map.ofEntries() - Cria mapa imutável com mais de 10 pares
         */
        System.out.println("\n--- Map.ofEntries() - Mapa com muitos pares ---");
        Map<String, String> paises = Map.ofEntries(
                Map.entry("BR", "Brasil"),
                Map.entry("US", "Estados Unidos"),
                Map.entry("FR", "França"),
                Map.entry("JP", "Japão")
        );
        System.out.println("Países: " + paises);

        /*
         * 5) Vantagens
         */
        System.out.println("\n--- Vantagens ---");
        System.out.println("✓ Código mais conciso");
        System.out.println("✓ Coleções imutáveis por padrão (thread-safe)");
        System.out.println("✓ Não permite null (evita NullPointerException)");
        System.out.println("✓ Performance melhorada");
    }
}

