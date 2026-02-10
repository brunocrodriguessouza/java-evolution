package com.java24;

/**
 * Exemplo didático de Java 24 - Implicitly Declared Classes (Preview)
 *
 * Objetivo:
 * - Simplificar programas Java pequenos
 * - Não precisa declarar classe explicitamente
 * - Ideal para scripts e programas simples
 */
public class Java24ImplicitlyDeclaredClasses {

    public static void main(String[] args) {

        System.out.println("=== Implicitly Declared Classes (Java 24 Preview) ===\n");

        /*
         * 1) Programa tradicional (com classe explícita)
         */
        System.out.println("--- Programa Tradicional ---");
        System.out.println("public class MeuPrograma {");
        System.out.println("    public static void main(String[] args) {");
        System.out.println("        System.out.println(\"Olá!\");");
        System.out.println("    }");
        System.out.println("}");

        /*
         * 2) Programa com classe implícita (Java 24+ Preview)
         */
        System.out.println("\n--- Programa com Classe Implícita ---");
        System.out.println("// Arquivo: MeuPrograma.java");
        System.out.println("void main() {");
        System.out.println("    System.out.println(\"Olá!\");");
        System.out.println("}");
        System.out.println("\nNão precisa:");
        System.out.println("  - Declarar classe");
        System.out.println("  - Modificador public");
        System.out.println("  - Parâmetros String[] args");

        /*
         * 3) Exemplo prático conceitual
         */
        System.out.println("\n--- Exemplo Prático ---");
        String nome = "Java";
        int versao = 24;
        
        System.out.println(STR."Bem-vindo ao \{nome} \{versao}!");
        System.out.println("Este é um exemplo de programa simplificado.");

        /*
         * 4) Quando usar
         */
        System.out.println("\n--- Quando Usar ---");
        System.out.println("✓ Programas pequenos e simples");
        System.out.println("✓ Scripts e utilitários");
        System.out.println("✓ Aprendizado e prototipagem");
        System.out.println("✗ Aplicações complexas (use classes normais)");
    }
}

