package com.java19;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Exemplo didático de Java 19 - Virtual Threads (Preview)
 *
 * Objetivo:
 * - Threads leves para operações I/O intensivas
 * - Milhares de threads sem overhead significativo
 * - Simplificar programação concorrente
 */
public class Java19VirtualThreads {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Virtual Threads (Java 19 Preview) ===\n");

        /*
         * 1) Thread tradicional (Platform Thread)
         */
        System.out.println("--- Platform Thread (Tradicional) ---");
        Thread threadTradicional = Thread.ofPlatform()
                .name("platform-thread")
                .start(() -> {
                    System.out.println("Thread tradicional: " + 
                            Thread.currentThread().getName());
                    System.out.println("É virtual? " + 
                            Thread.currentThread().isVirtual());
                });
        threadTradicional.join();

        /*
         * 2) Virtual Thread (Java 19+ Preview)
         */
        System.out.println("\n--- Virtual Thread ---");
        Thread virtualThread = Thread.ofVirtual()
                .name("virtual-thread")
                .start(() -> {
                    System.out.println("Virtual thread: " + 
                            Thread.currentThread().getName());
                    System.out.println("É virtual? " + 
                            Thread.currentThread().isVirtual());
                });
        virtualThread.join();

        /*
         * 3) Criar múltiplas virtual threads
         */
        System.out.println("\n--- Múltiplas Virtual Threads ---");
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10).forEach(i -> {
                executor.submit(() -> {
                    System.out.println("Tarefa " + i + " executada por: " + 
                            Thread.currentThread().getName() + 
                            " (virtual: " + Thread.currentThread().isVirtual() + ")");
                    try {
                        Thread.sleep(100); // Simula I/O
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            });
        }

        /*
         * 4) Comparação de performance conceitual
         */
        System.out.println("\n--- Vantagens das Virtual Threads ---");
        System.out.println("✓ Podem criar milhares de threads sem overhead");
        System.out.println("✓ Ideais para operações I/O (banco, HTTP, etc.)");
        System.out.println("✓ Gerenciadas pela JVM, não pelo OS");
        System.out.println("✓ Simplificam código assíncrono");
    }
}

