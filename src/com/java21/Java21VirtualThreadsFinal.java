package com.java21;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Exemplo didático de Java 21 - Virtual Threads (Feature Final)
 *
 * Objetivo:
 * - Virtual Threads agora são feature final (não mais preview)
 * - Threads leves para alta concorrência
 * - Simplificar programação assíncrona
 */
public class Java21VirtualThreadsFinal {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Virtual Threads - Feature Final (Java 21) ===\n");

        /*
         * 1) Criar virtual thread
         */
        System.out.println("--- Criar Virtual Thread ---");
        Thread virtualThread = Thread.ofVirtual()
                .name("worker-", 0)
                .start(() -> {
                    System.out.println("Virtual thread: " + 
                            Thread.currentThread().getName());
                    System.out.println("É virtual? " + 
                            Thread.currentThread().isVirtual());
                });
        virtualThread.join();

        /*
         * 2) Executor com virtual threads
         */
        System.out.println("\n--- Executor com Virtual Threads ---");
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 1000).forEach(i -> {
                executor.submit(() -> {
                    System.out.println("Tarefa " + i + " - Thread: " + 
                            Thread.currentThread().getName() + 
                            " (virtual: " + Thread.currentThread().isVirtual() + ")");
                    try {
                        Thread.sleep(10); // Simula I/O
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            });
        }

        /*
         * 3) Comparação: Platform Thread vs Virtual Thread
         */
        System.out.println("\n--- Comparação ---");
        System.out.println("Platform Thread:");
        System.out.println("  - Thread do sistema operacional");
        System.out.println("  - Limitado a algumas centenas");
        System.out.println("  - Overhead significativo");
        
        System.out.println("\nVirtual Thread:");
        System.out.println("  - Gerenciada pela JVM");
        System.out.println("  - Pode criar milhões");
        System.out.println("  - Overhead mínimo");
        System.out.println("  - Ideal para I/O intensivo");
    }
}

