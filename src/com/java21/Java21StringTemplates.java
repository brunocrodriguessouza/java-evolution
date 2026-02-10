package com.java21;

/**
 * Exemplo didático de Java 21 - String Templates (Preview)
 *
 * Objetivo:
 * - Interpolação de strings de forma segura
 * - Prevenir SQL injection e outros ataques
 * - Simplificar formatação de strings
 *
 * Nota: String Templates são preview no Java 21
 * Pode precisar compilar com: javac --enable-preview --release 21
 * STR é um template processor pré-definido
 */
public class Java21StringTemplates {

    public static void main(String[] args) {

        System.out.println("=== String Templates (Java 21 Preview) ===\n");

        /*
         * 1) String Template básico
         */
        System.out.println("--- String Template Básico ---");
        String nome = "Java";
        int versao = 21;
        
        // Template com STR (String Template Processor)
        String mensagem = STR."Olá, \{nome}! Versão \{versao}";
        System.out.println(mensagem);

        /*
         * 2) String Template com expressões
         */
        System.out.println("\n--- String Template com Expressões ---");
        int a = 10;
        int b = 20;
        String calculo = STR."\{a} + \{b} = \{a + b}";
        System.out.println(calculo);

        /*
         * 3) String Template multilinha
         */
        System.out.println("\n--- String Template Multilinha ---");
        String json = STR."""
                {
                    "nome": "\{nome}",
                    "versao": \{versao},
                    "lts": true
                }
                """;
        System.out.println(json);

        /*
         * 4) String Template com métodos
         */
        System.out.println("\n--- String Template com Métodos ---");
        String saudacao = STR."Bem-vindo, \{nome.toUpperCase()}!";
        System.out.println(saudacao);

        /*
         * 5) Comparação com outras abordagens
         */
        System.out.println("\n--- Comparação ---");
        System.out.println("Concatenação: " + "Olá, " + nome + "!");
        System.out.println("String.format: " + String.format("Olá, %s!", nome));
        System.out.println("String Template: " + STR."Olá, \{nome}!");

        /*
         * 6) Vantagens de segurança
         */
        System.out.println("\n--- Segurança ---");
        System.out.println("✓ Previne SQL injection");
        System.out.println("✓ Previne XSS attacks");
        System.out.println("✓ Validação automática de tipos");
    }
}

