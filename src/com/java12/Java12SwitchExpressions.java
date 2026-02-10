package com.java12;

/**
 * Exemplo didático de Java 12 - Switch Expressions (Preview)
 *
 * Objetivo:
 * - Simplificar sintaxe do switch
 * - Permitir retorno de valores
 * - Reduzir código boilerplate
 */
public class Java12SwitchExpressions {

    public static void main(String[] args) {

        System.out.println("=== Switch Expressions (Java 12 Preview) ===\n");

        /*
         * 1) Switch tradicional (pré-Java 12)
         */
        System.out.println("--- Switch Tradicional ---");
        DiaSemana dia = DiaSemana.SEGUNDA;
        String mensagemTradicional = "";
        
        switch (dia) {
            case SEGUNDA:
            case TERCA:
            case QUARTA:
            case QUINTA:
            case SEXTA:
                mensagemTradicional = "Dia útil";
                break;
            case SABADO:
            case DOMINGO:
                mensagemTradicional = "Fim de semana";
                break;
        }
        System.out.println("Mensagem (tradicional): " + mensagemTradicional);

        /*
         * 2) Switch Expression (Java 12+ Preview)
         */
        System.out.println("\n--- Switch Expression ---");
        String mensagem = switch (dia) {
            case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA -> "Dia útil";
            case SABADO, DOMINGO -> "Fim de semana";
        };
        System.out.println("Mensagem (switch expression): " + mensagem);

        /*
         * 3) Switch Expression com múltiplas linhas
         */
        System.out.println("\n--- Switch Expression com Bloco ---");
        int numeroDias = switch (dia) {
            case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA -> {
                System.out.println("Calculando dias úteis...");
                yield 5; // yield retorna valor
            }
            case SABADO, DOMINGO -> {
                System.out.println("Calculando fim de semana...");
                yield 2;
            }
        };
        System.out.println("Número de dias: " + numeroDias);

        /*
         * 4) Switch Expression com diferentes tipos
         */
        System.out.println("\n--- Switch Expression com Tipos ---");
        Object objeto = "Java";
        String tipo = switch (objeto) {
            case String s -> "É uma String: " + s;
            case Integer i -> "É um Integer: " + i;
            case Double d -> "É um Double: " + d;
            default -> "Tipo desconhecido";
        };
        System.out.println(tipo);
    }

    enum DiaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }
}

