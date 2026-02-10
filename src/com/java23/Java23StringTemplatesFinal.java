package com.java23;

/**
 * Exemplo didático de Java 23 - String Templates (Feature Final)
 *
 * Objetivo:
 * - String Templates agora são feature final (não mais preview)
 * - Interpolação segura de strings
 * - Prevenção de injection attacks
 *
 * Nota: STR é um template processor pré-definido disponível desde Java 21
 */
public class Java23StringTemplatesFinal {

    public static void main(String[] args) {

        System.out.println("=== String Templates - Feature Final (Java 23) ===\n");

        /*
         * 1) String Template básico
         */
        System.out.println("--- String Template Básico ---");
        String nome = "Java";
        int versao = 23;
        String mensagem = STR."Olá, \{nome}! Versão \{versao}";
        System.out.println(mensagem);

        /*
         * 2) String Template com expressões
         */
        System.out.println("\n--- String Template com Expressões ---");
        int x = 10;
        int y = 20;
        String calculo = STR."\{x} * \{y} = \{x * y}";
        System.out.println(calculo);

        /*
         * 3) String Template multilinha
         */
        System.out.println("\n--- String Template Multilinha ---");
        String html = STR."""
                <html>
                    <head>
                        <title>\{nome} \{versao}</title>
                    </head>
                    <body>
                        <h1>Bem-vindo ao \{nome} \{versao}!</h1>
                    </body>
                </html>
                """;
        System.out.println(html);

        /*
         * 4) String Template com métodos
         */
        System.out.println("\n--- String Template com Métodos ---");
        String usuario = "admin";
        String senha = "secret123";
        String credencial = STR."Usuário: \{usuario.toUpperCase()}, " +
                           STR."Senha: \{senha.length()} caracteres";
        System.out.println(credencial);

        /*
         * 5) Comparação com outras abordagens
         */
        System.out.println("\n--- Comparação ---");
        String nome2 = "Java";
        
        // Concatenação
        String concat = "Olá, " + nome2 + "!";
        
        // String.format
        String format = String.format("Olá, %s!", nome2);
        
        // String Template
        String template = STR."Olá, \{nome2}!";
        
        System.out.println("Concatenação: " + concat);
        System.out.println("String.format: " + format);
        System.out.println("String Template: " + template);

        /*
         * 6) Vantagens
         */
        System.out.println("\n--- Vantagens ---");
        System.out.println("✓ Interpolação segura");
        System.out.println("✓ Previne SQL injection");
        System.out.println("✓ Previne XSS attacks");
        System.out.println("✓ Sintaxe mais limpa");
        System.out.println("✓ Validação de tipos");
    }
}

