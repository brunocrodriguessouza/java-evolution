package com.java19;

/**
 * Exemplo didático de Java 19 - Pattern Matching para Switch (Preview)
 *
 * Objetivo:
 * - Pattern matching completo em expressões switch
 * - Desestruturação de objetos em switch
 * - Guardas (when) para condições adicionais
 */
public class Java19PatternMatchingSwitch {

    public static void main(String[] args) {

        System.out.println("=== Pattern Matching para Switch (Java 19 Preview) ===\n");

        /*
         * 1) Pattern Matching com tipos primitivos
         */
        System.out.println("--- Pattern Matching com Tipos ---");
        Object obj1 = "Java";
        Object obj2 = 42;
        Object obj3 = 3.14;

        processarComSwitch(obj1);
        processarComSwitch(obj2);
        processarComSwitch(obj3);

        /*
         * 2) Pattern Matching com Records
         */
        System.out.println("\n--- Pattern Matching com Records ---");
        Pessoa pessoa1 = new Pessoa("João", 30);
        Pessoa pessoa2 = new Pessoa("Maria", 17);
        Produto produto = new Produto("Notebook", 2500.00);

        processarObjeto(pessoa1);
        processarObjeto(pessoa2);
        processarObjeto(produto);

        /*
         * 3) Pattern Matching com guardas (when)
         */
        System.out.println("\n--- Pattern Matching com Guardas ---");
        processarComGuardas(pessoa1);
        processarComGuardas(pessoa2);

        /*
         * 4) Pattern Matching com null
         */
        System.out.println("\n--- Pattern Matching com null ---");
        processarComSwitch(null);
    }

    private static void processarComSwitch(Object obj) {
        String resultado = switch (obj) {
            case String s -> "É uma String: " + s.toUpperCase();
            case Integer i -> "É um Integer: " + (i * 2);
            case Double d -> "É um Double: " + (d * 2);
            case null -> "É null";
            default -> "Tipo desconhecido: " + obj.getClass().getSimpleName();
        };
        System.out.println(resultado);
    }

    private static void processarObjeto(Object obj) {
        String resultado = switch (obj) {
            case Pessoa(String nome, int idade) when idade >= 18 -> 
                nome + " é maior de idade (" + idade + " anos)";
            case Pessoa(String nome, int idade) -> 
                nome + " é menor de idade (" + idade + " anos)";
            case Produto(String nome, double preco) -> 
                "Produto: " + nome + " - R$ " + preco;
            default -> "Tipo não reconhecido";
        };
        System.out.println(resultado);
    }

    private static void processarComGuardas(Pessoa pessoa) {
        String categoria = switch (pessoa) {
            case Pessoa(String nome, int idade) when idade >= 65 -> 
                nome + " é idoso";
            case Pessoa(String nome, int idade) when idade >= 18 -> 
                nome + " é adulto";
            case Pessoa(String nome, int idade) when idade >= 13 -> 
                nome + " é adolescente";
            case Pessoa(String nome, int idade) -> 
                nome + " é criança";
        };
        System.out.println(categoria);
    }

    record Pessoa(String nome, int idade) {}
    record Produto(String nome, double preco) {}
}

