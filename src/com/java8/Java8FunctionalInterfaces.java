package com.java8;

import java.util.function.*;

/**
 * Exemplo didático de Java 8 - Interfaces Funcionais
 *
 * Objetivo:
 * - Demonstrar as principais interfaces funcionais do pacote java.util.function
 * - Mostrar quando usar cada uma delas
 * - Facilitar programação funcional em Java
 */
public class Java8FunctionalInterfaces {

    public static void main(String[] args) {

        System.out.println("=== Interfaces Funcionais do Java 8 ===\n");

        /*
         * 1) Function<T, R> - Recebe um tipo T e retorna um tipo R
         */
        System.out.println("--- Function<T, R> ---");
        Function<String, Integer> tamanho = s -> s.length();
        System.out.println("Tamanho de 'Java': " + tamanho.apply("Java"));

        Function<Integer, Integer> quadrado = x -> x * x;
        System.out.println("Quadrado de 5: " + quadrado.apply(5));

        /*
         * 2) Predicate<T> - Recebe um tipo T e retorna boolean
         */
        System.out.println("\n--- Predicate<T> ---");
        Predicate<Integer> ehPar = n -> n % 2 == 0;
        System.out.println("4 é par? " + ehPar.test(4));
        System.out.println("5 é par? " + ehPar.test(5));

        Predicate<String> temMaisDe5Caracteres = s -> s.length() > 5;
        System.out.println("'Java' tem mais de 5 caracteres? " + 
                          temMaisDe5Caracteres.test("Java"));

        /*
         * 3) Consumer<T> - Recebe um tipo T e não retorna nada (void)
         */
        System.out.println("\n--- Consumer<T> ---");
        Consumer<String> imprimir = s -> System.out.println("Imprimindo: " + s);
        imprimir.accept("Olá, Java!");

        Consumer<Integer> dobrarEImprimir = n -> System.out.println("Dobro: " + (n * 2));
        dobrarEImprimir.accept(7);

        /*
         * 4) Supplier<T> - Não recebe nada e retorna um tipo T
         */
        System.out.println("\n--- Supplier<T> ---");
        Supplier<String> fornecerMensagem = () -> "Mensagem do supplier!";
        System.out.println(fornecerMensagem.get());

        Supplier<Double> numeroAleatorio = () -> Math.random();
        System.out.println("Número aleatório: " + numeroAleatorio.get());

        /*
         * 5) UnaryOperator<T> - Recebe T e retorna T (Function especializada)
         */
        System.out.println("\n--- UnaryOperator<T> ---");
        UnaryOperator<String> maiusculas = s -> s.toUpperCase();
        System.out.println("'java' em maiúsculas: " + maiusculas.apply("java"));

        UnaryOperator<Integer> incrementar = x -> x + 1;
        System.out.println("5 incrementado: " + incrementar.apply(5));

        /*
         * 6) BinaryOperator<T> - Recebe dois T e retorna T
         */
        System.out.println("\n--- BinaryOperator<T> ---");
        BinaryOperator<Integer> somar = (a, b) -> a + b;
        System.out.println("5 + 3 = " + somar.apply(5, 3));

        BinaryOperator<Integer> maior = (a, b) -> a > b ? a : b;
        System.out.println("Maior entre 10 e 7: " + maior.apply(10, 7));

        /*
         * 7) BiFunction<T, U, R> - Recebe T e U, retorna R
         */
        System.out.println("\n--- BiFunction<T, U, R> ---");
        BiFunction<String, Integer, String> repetir = (s, n) -> s.repeat(n);
        System.out.println("Repetir 'Java' 3 vezes: " + repetir.apply("Java", 3));

        /*
         * 8) Combinando interfaces funcionais
         */
        System.out.println("\n--- Combinando Interfaces Funcionais ---");
        Function<Integer, Integer> multiplicarPor2 = x -> x * 2;
        Predicate<Integer> maiorQue10 = x -> x > 10;
        
        int numero = 7;
        int resultado = multiplicarPor2.apply(numero);
        if (maiorQue10.test(resultado)) {
            System.out.println(numero + " * 2 = " + resultado + " (maior que 10)");
        }
    }
}

