package com.java9;

/**
 * Exemplo didático de Java 9 - Métodos Privados em Interfaces
 *
 * Objetivo:
 * - Permitir métodos privados em interfaces para evitar duplicação de código
 * - Reutilizar lógica comum entre métodos default e static
 * - Manter interfaces mais organizadas
 */
public class Java9PrivateMethodsInterfaces {

    public static void main(String[] args) {

        System.out.println("=== Métodos Privados em Interfaces (Java 9+) ===\n");

        Calculadora calculadora = new CalculadoraSimples();

        System.out.println("Soma: " + calculadora.somar(10, 5));
        System.out.println("Subtração: " + calculadora.subtrair(10, 5));
        System.out.println("Multiplicação: " + calculadora.multiplicar(10, 5));
        System.out.println("Divisão: " + calculadora.dividir(10, 5));

        System.out.println("\n--- Método estático da interface ---");
        System.out.println("Potência (estático): " + Calculadora.potencia(2, 3));
    }

    // Interface com métodos privados
    interface Calculadora {
        // Métodos públicos abstratos
        double somar(double a, double b);
        double subtrair(double a, double b);
        double multiplicar(double a, double b);
        double dividir(double a, double b);

        // Métodos default que usam método privado
        default double somar(double a, double b, double c) {
            return validarEExecutar(() -> somar(somar(a, b), c));
        }

        default double subtrair(double a, double b, double c) {
            return validarEExecutar(() -> subtrair(subtrair(a, b), c));
        }

        // Método privado - pode ser usado por métodos default e static
        // Evita duplicação de código de validação
        private double validarEExecutar(Operacao operacao) {
            // Lógica comum de validação
            try {
                return operacao.executar();
            } catch (ArithmeticException e) {
                System.err.println("Erro na operação: " + e.getMessage());
                return 0;
            }
        }

        // Método estático que também usa método privado
        static double potencia(double base, double expoente) {
            if (expoente < 0) {
                throw new IllegalArgumentException("Expoente não pode ser negativo");
            }
            return Math.pow(base, expoente);
        }

        // Interface funcional para operações
        @FunctionalInterface
        interface Operacao {
            double executar();
        }
    }

    // Implementação da interface
    static class CalculadoraSimples implements Calculadora {
        @Override
        public double somar(double a, double b) {
            return a + b;
        }

        @Override
        public double subtrair(double a, double b) {
            return a - b;
        }

        @Override
        public double multiplicar(double a, double b) {
            return a * b;
        }

        @Override
        public double dividir(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero!");
            }
            return a / b;
        }
    }
}

