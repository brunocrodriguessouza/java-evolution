package com.java8;

/**
 * Exemplo didático de Java 8 - Expressões Lambda
 *
 * Objetivo:
 * - Mostrar a diferença entre classe anônima e lambda
 * - Mostrar como Runnable é usado com Thread
 * - Deixar claro quando uma nova thread é criada
 */
public class Java8Lambda {

    public static void main(String[] args) {

        System.out.println("Thread atual (main): " + Thread.currentThread().getName());
        System.out.println("------------------------------------------------");

        /*
         * 1) Runnable usando CLASSE ANÔNIMA (pré-Java 8)
         * Código mais verboso
         */
        Runnable runnableComClasseAnonima = new Runnable() {
            @Override
            public void run() {
                System.out.println("Classe Anônima -> Executando na thread: "
                        + Thread.currentThread().getName());
            }
        };

        /*
         * 2) Runnable usando LAMBDA (Java 8+)
         * Código mais limpo e legível
         * Runnable é uma interface funcional (possui apenas um método abstrato)
         */
        Runnable runnableComLambda =
                () -> System.out.println("Lambda -> Executando na thread: "
                        + Thread.currentThread().getName());

        /*
         * 3) Criando e iniciando threads
         * start() cria uma NOVA thread
         * run() é chamado pela JVM internamente
         */
        Thread thread1 = new Thread(runnableComClasseAnonima);
        thread1.start();

        Thread thread2 = new Thread(runnableComLambda);
        thread2.start();

        System.out.println("------------------------------------------------");
        System.out.println("Fim do método main");
    }
}
