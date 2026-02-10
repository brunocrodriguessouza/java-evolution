package com.java8;

/**
 * Exemplo didático de Java 8 - Default Methods em Interfaces
 *
 * Objetivo:
 * - Permitir adicionar métodos em interfaces sem quebrar implementações existentes
 * - Mostrar como classes implementam interfaces com métodos default
 * - Demonstrar resolução de conflitos de múltiplas interfaces
 */
public class Java8DefaultMethods {

    public static void main(String[] args) {

        System.out.println("=== Exemplos de Default Methods ===\n");

        /*
         * 1) Interface com método default
         */
        Veiculo carro = new Carro();
        carro.ligar();           // Método abstrato
        carro.acelerar();        // Método default
        carro.frear();           // Método default

        System.out.println("------------------------------------------------");

        /*
         * 2) Classe pode sobrescrever método default
         */
        Veiculo moto = new Moto();
        moto.ligar();
        moto.acelerar();         // Método default sobrescrito
        moto.frear();

        System.out.println("------------------------------------------------");

        /*
         * 3) Múltiplas interfaces com métodos default
         */
        VeiculoEletrico tesla = new CarroEletrico();
        tesla.ligar();
        tesla.acelerar();        // Método de Veiculo
        tesla.carregar();        // Método de Eletrico
    }

    // Interface com método default
    interface Veiculo {
        // Método abstrato (deve ser implementado)
        void ligar();

        // Método default (implementação padrão)
        default void acelerar() {
            System.out.println("Veículo acelerando...");
        }

        // Método default (implementação padrão)
        default void frear() {
            System.out.println("Veículo freando...");
        }
    }

    // Interface adicional
    interface Eletrico {
        default void carregar() {
            System.out.println("Carregando bateria...");
        }
    }

    // Classe implementando interface
    static class Carro implements Veiculo {
        @Override
        public void ligar() {
            System.out.println("Carro ligado!");
        }
        // Usa métodos default de Veiculo
    }

    // Classe sobrescrevendo método default
    static class Moto implements Veiculo {
        @Override
        public void ligar() {
            System.out.println("Moto ligada!");
        }

        @Override
        public void acelerar() {
            System.out.println("Moto acelerando rapidamente!");
        }
        // Usa método default frear() de Veiculo
    }

    // Classe implementando múltiplas interfaces
    static class CarroEletrico implements Veiculo, Eletrico {
        @Override
        public void ligar() {
            System.out.println("Carro elétrico ligado silenciosamente!");
        }
    }
}

