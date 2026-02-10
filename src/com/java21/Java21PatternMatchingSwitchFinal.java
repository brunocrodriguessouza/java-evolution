package com.java21;

/**
 * Exemplo didático de Java 21 - Pattern Matching para Switch (Feature Final)
 *
 * Objetivo:
 * - Pattern matching completo em switch (não mais preview)
 * - Desestruturação de objetos
 * - Guardas para condições adicionais
 */
public class Java21PatternMatchingSwitchFinal {

    public static void main(String[] args) {

        System.out.println("=== Pattern Matching Switch - Feature Final (Java 21) ===\n");

        /*
         * 1) Pattern Matching com tipos
         */
        System.out.println("--- Pattern Matching com Tipos ---");
        processarTipo("Java");
        processarTipo(42);
        processarTipo(3.14);
        processarTipo(null);

        /*
         * 2) Pattern Matching com Records
         */
        System.out.println("\n--- Pattern Matching com Records ---");
        processarObjeto(new Pessoa("João", 30));
        processarObjeto(new Pessoa("Maria", 17));
        processarObjeto(new Produto("Notebook", 2500.00));

        /*
         * 3) Pattern Matching com guardas
         */
        System.out.println("\n--- Pattern Matching com Guardas ---");
        classificarIdade(new Pessoa("Carlos", 70));
        classificarIdade(new Pessoa("Ana", 25));
        classificarIdade(new Pessoa("Pedro", 15));
        classificarIdade(new Pessoa("Lucas", 8));

        /*
         * 4) Pattern Matching com sealed classes
         */
        System.out.println("\n--- Pattern Matching com Sealed Classes ---");
        Forma circulo = new Circulo(5.0);
        Forma retangulo = new Retangulo(4.0, 6.0);
        
        calcularEImprimir(circulo);
        calcularEImprimir(retangulo);
    }

    private static void processarTipo(Object obj) {
        String resultado = switch (obj) {
            case String s -> "String: " + s.toUpperCase();
            case Integer i -> "Integer: " + (i * 2);
            case Double d -> "Double: " + (d * 2);
            case null -> "null";
            default -> "Desconhecido: " + obj.getClass().getSimpleName();
        };
        System.out.println(resultado);
    }

    private static void processarObjeto(Object obj) {
        String resultado = switch (obj) {
            case Pessoa(String nome, int idade) when idade >= 18 -> 
                nome + " é maior de idade";
            case Pessoa(String nome, int idade) -> 
                nome + " é menor de idade";
            case Produto(String nome, double preco) -> 
                "Produto: " + nome + " - R$ " + preco;
            default -> "Tipo não reconhecido";
        };
        System.out.println(resultado);
    }

    private static void classificarIdade(Pessoa pessoa) {
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

    private static void calcularEImprimir(Forma forma) {
        String resultado = switch (forma) {
            case Circulo(double raio) -> 
                "Círculo com área: " + (Math.PI * raio * raio);
            case Retangulo(double largura, double altura) -> 
                "Retângulo com área: " + (largura * altura);
        };
        System.out.println(resultado);
    }

    record Pessoa(String nome, int idade) {}
    record Produto(String nome, double preco) {}

    sealed interface Forma permits Circulo, Retangulo {}
    record Circulo(double raio) implements Forma {}
    record Retangulo(double largura, double altura) implements Forma {}
}

