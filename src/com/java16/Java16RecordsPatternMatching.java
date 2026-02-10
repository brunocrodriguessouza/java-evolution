package com.java16;

/**
 * Exemplo didático de Java 16 - Pattern Matching para Records
 *
 * Objetivo:
 * - Usar pattern matching com records
 * - Simplificar desestruturação de records
 * - Melhorar legibilidade do código
 */
public class Java16RecordsPatternMatching {

    public static void main(String[] args) {

        System.out.println("=== Pattern Matching para Records (Java 16) ===\n");

        /*
         * 1) Pattern Matching com instanceof e Records
         */
        System.out.println("--- Pattern Matching com Records ---");
        Object obj1 = new Pessoa("João", 30);
        Object obj2 = new Produto("Notebook", 2500.00);

        processarObjeto(obj1);
        processarObjeto(obj2);

        /*
         * 2) Desestruturação de Records
         */
        System.out.println("\n--- Desestruturação de Records ---");
        Pessoa pessoa = new Pessoa("Maria", 25);
        
        if (pessoa instanceof Pessoa(String nome, int idade)) {
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
        }

        /*
         * 3) Pattern Matching em switch (preview)
         */
        System.out.println("\n--- Pattern Matching em Switch ---");
        Object objeto = new Pessoa("Carlos", 35);
        
        String resultado = switch (objeto) {
            case Pessoa(String nome, int idade) when idade >= 18 -> 
                nome + " é maior de idade (" + idade + " anos)";
            case Pessoa(String nome, int idade) -> 
                nome + " é menor de idade (" + idade + " anos)";
            case Produto(String nome, double preco) -> 
                "Produto: " + nome + " - R$ " + preco;
            default -> "Tipo desconhecido";
        };
        
        System.out.println(resultado);
    }

    private static void processarObjeto(Object obj) {
        if (obj instanceof Pessoa(String nome, int idade)) {
            System.out.println("Pessoa: " + nome + ", " + idade + " anos");
        } else if (obj instanceof Produto(String nome, double preco)) {
            System.out.println("Produto: " + nome + ", R$ " + preco);
        }
    }

    record Pessoa(String nome, int idade) {}
    record Produto(String nome, double preco) {}
}

