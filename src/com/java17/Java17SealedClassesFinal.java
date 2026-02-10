package com.java17;

/**
 * Exemplo didático de Java 17 - Sealed Classes (Final)
 *
 * Objetivo:
 * - Sealed classes agora são feature final (não mais preview)
 * - Controlar hierarquia de classes de forma segura
 * - Melhorar pattern matching
 */
public class Java17SealedClassesFinal {

    public static void main(String[] args) {

        System.out.println("=== Sealed Classes - Feature Final (Java 17) ===\n");

        /*
         * 1) Sealed Class com diferentes modificadores
         */
        System.out.println("--- Sealed Class ---");
        Animal cachorro = new Cachorro("Rex");
        Animal gato = new Gato("Mimi");
        Animal passaro = new Passaro("Piu");

        cachorro.emitirSom();
        gato.emitirSom();
        passaro.emitirSom();

        /*
         * 2) Pattern Matching com Sealed Classes
         */
        System.out.println("\n--- Pattern Matching ---");
        processarAnimal(cachorro);
        processarAnimal(gato);
        processarAnimal(passaro);

        /*
         * 3) Sealed Interface
         */
        System.out.println("\n--- Sealed Interface ---");
        Transporte carro = new Carro();
        Transporte onibus = new Onibus();

        System.out.println("Carro transporta: " + carro.capacidade() + " pessoas");
        System.out.println("Ônibus transporta: " + onibus.capacidade() + " pessoas");
    }

    private static void processarAnimal(Animal animal) {
        // Com sealed classes, todos os casos são conhecidos
        switch (animal) {
            case Cachorro(String nome) -> 
                System.out.println("Cachorro " + nome + " late");
            case Gato(String nome) -> 
                System.out.println("Gato " + nome + " mia");
            case Passaro(String nome) -> 
                System.out.println("Pássaro " + nome + " canta");
        }
    }

    // Sealed class - apenas classes permitidas podem estender
    sealed class Animal permits Cachorro, Gato, Passaro {
        protected final String nome;

        public Animal(String nome) {
            this.nome = nome;
        }

        public abstract void emitirSom();
    }

    // Final - não pode ser estendida
    final class Cachorro extends Animal {
        public Cachorro(String nome) {
            super(nome);
        }

        @Override
        public void emitirSom() {
            System.out.println(nome + ": Au au!");
        }
    }

    // Final
    final class Gato extends Animal {
        public Gato(String nome) {
            super(nome);
        }

        @Override
        public void emitirSom() {
            System.out.println(nome + ": Miau!");
        }
    }

    // Final
    final class Passaro extends Animal {
        public Passaro(String nome) {
            super(nome);
        }

        @Override
        public void emitirSom() {
            System.out.println(nome + ": Piu piu!");
        }
    }

    // Sealed interface
    sealed interface Transporte permits Carro, Onibus {
        int capacidade();
    }

    final class Carro implements Transporte {
        @Override
        public int capacidade() {
            return 5;
        }
    }

    final class Onibus implements Transporte {
        @Override
        public int capacidade() {
            return 40;
        }
    }
}

