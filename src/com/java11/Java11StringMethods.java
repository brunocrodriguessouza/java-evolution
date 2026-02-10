package com.java11;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exemplo didático de Java 11 - Novos Métodos em String
 *
 * Objetivo:
 * - Demonstrar métodos úteis adicionados à classe String
 * - Facilitar manipulação de strings
 * - Reduzir código boilerplate
 */
public class Java11StringMethods {

    public static void main(String[] args) {

        System.out.println("=== Novos Métodos em String (Java 11+) ===\n");

        /*
         * 1) isBlank() - Verifica se string está vazia ou contém apenas espaços
         */
        System.out.println("--- isBlank() ---");
        String vazia = "";
        String apenasEspacos = "   ";
        String comConteudo = "Java";

        System.out.println("'' está em branco? " + vazia.isBlank());
        System.out.println("'   ' está em branco? " + apenasEspacos.isBlank());
        System.out.println("'Java' está em branco? " + comConteudo.isBlank());

        // Comparação com isEmpty()
        System.out.println("\nComparação com isEmpty():");
        System.out.println("'' isEmpty()? " + vazia.isEmpty());
        System.out.println("'   ' isEmpty()? " + apenasEspacos.isEmpty()); // false
        System.out.println("'   ' isBlank()? " + apenasEspacos.isBlank()); // true

        /*
         * 2) strip() - Remove espaços em branco do início e fim
         */
        System.out.println("\n--- strip() ---");
        String comEspacos = "  Java 11  ";
        System.out.println("Original: '" + comEspacos + "'");
        System.out.println("strip(): '" + comEspacos.strip() + "'");

        // Comparação com trim()
        System.out.println("\nComparação com trim():");
        String unicode = "\u2000Java\u2000"; // Espaços Unicode
        System.out.println("Com Unicode: '" + unicode + "'");
        System.out.println("trim(): '" + unicode.trim() + "'"); // Não remove Unicode
        System.out.println("strip(): '" + unicode.strip() + "'"); // Remove Unicode

        /*
         * 3) stripLeading() e stripTrailing()
         */
        System.out.println("\n--- stripLeading() e stripTrailing() ---");
        String texto = "  Java  ";
        System.out.println("Original: '" + texto + "'");
        System.out.println("stripLeading(): '" + texto.stripLeading() + "'");
        System.out.println("stripTrailing(): '" + texto.stripTrailing() + "'");

        /*
         * 4) repeat() - Repete a string N vezes
         */
        System.out.println("\n--- repeat() ---");
        String palavra = "Java";
        System.out.println("Original: " + palavra);
        System.out.println("repeat(3): " + palavra.repeat(3));
        System.out.println("repeat(0): '" + palavra.repeat(0) + "'"); // String vazia

        /*
         * 5) lines() - Divide string em linhas (Stream)
         */
        System.out.println("\n--- lines() ---");
        String textoMultilinha = "Linha 1\nLinha 2\nLinha 3";
        System.out.println("Texto multilinha:");
        System.out.println(textoMultilinha);

        List<String> linhas = textoMultilinha.lines().collect(Collectors.toList());
        System.out.println("\nLinhas extraídas:");
        linhas.forEach(linha -> System.out.println("  - " + linha));

        /*
         * 6) Exemplo prático combinado
         */
        System.out.println("\n--- Exemplo Prático ---");
        String entrada = "  Java 11 é incrível!  ";
        
        if (!entrada.isBlank()) {
            String processada = entrada.strip()
                    .repeat(2)
                    .toUpperCase();
            System.out.println("Entrada processada: " + processada);
        }
    }
}

