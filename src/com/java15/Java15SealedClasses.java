package com.java15;

/**
 * Exemplo didático de Java 15 - Sealed Classes (Preview)
 *
 * Objetivo:
 * - Controlar quais classes podem estender uma classe ou interface
 * - Restringir hierarquia de classes
 * - Melhorar segurança e design de APIs
 */
public class Java15SealedClasses {

    public static void main(String[] args) {

        System.out.println("=== Sealed Classes (Java 15 Preview) ===\n");

        /*
         * 1) Sealed Class - Controla quais classes podem estender
         */
        System.out.println("--- Sealed Class ---");
        Forma circulo = new Circulo(5.0);
        Forma retangulo = new Retangulo(4.0, 6.0);
        Forma triangulo = new Triangulo(3.0, 4.0, 5.0);

        System.out.println("Área do círculo: " + circulo.calcularArea());
        System.out.println("Área do retângulo: " + retangulo.calcularArea());
        System.out.println("Área do triângulo: " + triangulo.calcularArea());

        /*
         * 2) Sealed Interface
         */
        System.out.println("\n--- Sealed Interface ---");
        Veiculo carro = new Carro();
        Veiculo moto = new Moto();

        carro.acelerar();
        moto.acelerar();

        /*
         * 3) Pattern Matching com Sealed Classes
         */
        System.out.println("\n--- Pattern Matching com Sealed Classes ---");
        processarForma(circulo);
        processarForma(retangulo);
        processarForma(triangulo);
    }

    private static void processarForma(Forma forma) {
        // Com sealed classes, o compilador sabe todos os tipos possíveis
        if (forma instanceof Circulo c) {
            System.out.println("É um círculo com raio: " + c.raio());
        } else if (forma instanceof Retangulo r) {
            System.out.println("É um retângulo: " + r.largura() + "x" + r.altura());
        } else if (forma instanceof Triangulo t) {
            System.out.println("É um triângulo com lados: " + 
                    t.lado1() + ", " + t.lado2() + ", " + t.lado3());
        }
    }

    // Sealed class - apenas as classes permitidas podem estender
    sealed class Forma permits Circulo, Retangulo, Triangulo {
        public abstract double calcularArea();
    }

    // Final class - não pode ser estendida
    final class Circulo extends Forma {
        private final double raio;

        public Circulo(double raio) {
            this.raio = raio;
        }

        public double raio() {
            return raio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * raio * raio;
        }
    }

    // Final class
    final class Retangulo extends Forma {
        private final double largura;
        private final double altura;

        public Retangulo(double largura, double altura) {
            this.largura = largura;
            this.altura = altura;
        }

        public double largura() {
            return largura;
        }

        public double altura() {
            return altura;
        }

        @Override
        public double calcularArea() {
            return largura * altura;
        }
    }

    // Final class
    final class Triangulo extends Forma {
        private final double lado1, lado2, lado3;

        public Triangulo(double lado1, double lado2, double lado3) {
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }

        public double lado1() { return lado1; }
        public double lado2() { return lado2; }
        public double lado3() { return lado3; }

        @Override
        public double calcularArea() {
            // Fórmula de Heron
            double s = (lado1 + lado2 + lado3) / 2;
            return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
        }
    }

    // Sealed interface
    sealed interface Veiculo permits Carro, Moto {
        void acelerar();
    }

    final class Carro implements Veiculo {
        @Override
        public void acelerar() {
            System.out.println("Carro acelerando...");
        }
    }

    final class Moto implements Veiculo {
        @Override
        public void acelerar() {
            System.out.println("Moto acelerando...");
        }
    }
}

