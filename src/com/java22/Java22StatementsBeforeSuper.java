package com.java22;

/**
 * Exemplo didático de Java 22 - Statements Before super() (Preview)
 *
 * Objetivo:
 * - Permitir código antes de chamar super() em construtores
 * - Validar parâmetros antes de chamar construtor pai
 * - Melhorar flexibilidade de construtores
 */
public class Java22StatementsBeforeSuper {

    public static void main(String[] args) {

        System.out.println("=== Statements Before super() (Java 22 Preview) ===\n");

        /*
         * 1) Problema tradicional - não pode ter código antes de super()
         */
        System.out.println("--- Problema Tradicional ---");
        System.out.println("Antes do Java 22, não era possível ter código");
        System.out.println("antes de super() no construtor");

        /*
         * 2) Solução com Java 22 - pode ter código antes de super()
         */
        System.out.println("\n--- Solução Java 22 ---");
        try {
            RetanguloValido retangulo1 = new RetanguloValido(5.0, 3.0);
            System.out.println("Retângulo criado: " + retangulo1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            RetanguloValido retangulo2 = new RetanguloValido(-5.0, 3.0);
            System.out.println("Retângulo criado: " + retangulo2);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Classe base
    static class Forma {
        protected final double area;

        public Forma(double area) {
            this.area = area;
        }

        @Override
        public String toString() {
            return "Forma com área: " + area;
        }
    }

    // Classe filha com validação antes de super()
    static class RetanguloValido extends Forma {
        private final double largura;
        private final double altura;

        public RetanguloValido(double largura, double altura) {
            // Agora podemos validar ANTES de chamar super()
            if (largura <= 0 || altura <= 0) {
                throw new IllegalArgumentException(
                    "Largura e altura devem ser positivas. " +
                    "Recebido: largura=" + largura + ", altura=" + altura
                );
            }
            
            // Calcular área antes de passar para super()
            double areaCalculada = largura * altura;
            
            // Agora chamamos super() com o valor validado
            super(areaCalculada);
            
            // Atribuir valores após super()
            this.largura = largura;
            this.altura = altura;
        }

        @Override
        public String toString() {
            return String.format("Retângulo: %.2f x %.2f (área: %.2f)", 
                    largura, altura, area);
        }
    }
}

