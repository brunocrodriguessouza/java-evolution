package com.java10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Exemplo didático de Java 10 - Palavra-chave 'var'
 *
 * Objetivo:
 * - Inferência de tipo local para reduzir verbosidade
 * - Manter type-safety do Java
 * - Simplificar código mantendo legibilidade
 */
public class Java10VarKeyword {

    public static void main(String[] args) {

        System.out.println("=== Palavra-chave 'var' (Java 10+) ===\n");

        /*
         * 1) Uso básico de var
         */
        System.out.println("--- Uso Básico ---");
        // Antes (Java 9 e anteriores):
        String nome = "Java";
        int idade = 10;
        List<String> lista = new ArrayList<>();

        // Agora (Java 10+):
        var nomeVar = "Java";
        var idadeVar = 10;
        var listaVar = new ArrayList<String>();

        System.out.println("Nome: " + nomeVar);
        System.out.println("Idade: " + idadeVar);
        System.out.println("Lista: " + listaVar);

        /*
         * 2) var com tipos complexos
         */
        System.out.println("\n--- Tipos Complexos ---");
        var mapa = new HashMap<String, Integer>();
        mapa.put("um", 1);
        mapa.put("dois", 2);
        System.out.println("Mapa: " + mapa);

        var numeros = List.of(1, 2, 3, 4, 5);
        System.out.println("Números: " + numeros);

        /*
         * 3) var em loops
         */
        System.out.println("\n--- var em Loops ---");
        var nomes = List.of("Ana", "Bruno", "Carlos");
        
        for (var nome : nomes) {
            System.out.println("Nome: " + nome);
        }

        for (var i = 0; i < 3; i++) {
            System.out.println("Índice: " + i);
        }

        /*
         * 4) var com streams
         */
        System.out.println("\n--- var com Streams ---");
        var resultado = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .toList();
        System.out.println("Resultado: " + resultado);

        /*
         * 5) Limitações do var
         */
        System.out.println("\n--- Limitações do var ---");
        System.out.println("✗ Não pode ser usado em:");
        System.out.println("  - Campos de classe");
        System.out.println("  - Parâmetros de método");
        System.out.println("  - Tipos de retorno");
        System.out.println("  - Variáveis sem inicializador");
        System.out.println("  - null (sem contexto de tipo)");

        // Exemplos que NÃO funcionam:
        // var x; // ERRO: precisa inicializador
        // var y = null; // ERRO: não pode inferir tipo de null
        // public var campo; // ERRO: não pode em campos

        /*
         * 6) Boas práticas
         */
        System.out.println("\n--- Boas Práticas ---");
        System.out.println("✓ Use var quando o tipo é óbvio do contexto");
        System.out.println("✓ Evite var quando reduz legibilidade");
        System.out.println("✓ Prefira nomes descritivos de variáveis");
        
        // Bom uso:
        var usuario = buscarUsuario();
        var total = calcularTotal();
        
        // Uso questionável (tipo não óbvio):
        // var data = processar(); // Qual o tipo? Melhor: LocalDate data = processar();
    }

    private static String buscarUsuario() {
        return "João";
    }

    private static double calcularTotal() {
        return 100.50;
    }
}

