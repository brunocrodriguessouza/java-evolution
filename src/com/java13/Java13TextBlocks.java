package com.java13;

/**
 * Exemplo didático de Java 13 - Text Blocks (Preview)
 *
 * Objetivo:
 * - Facilitar criação de strings multilinha
 * - Melhorar legibilidade de JSON, SQL, HTML, etc.
 * - Reduzir necessidade de escape characters
 */
public class Java13TextBlocks {

    public static void main(String[] args) {

        System.out.println("=== Text Blocks (Java 13 Preview) ===\n");

        /*
         * 1) String multilinha tradicional (verbosa)
         */
        System.out.println("--- String Multilinha Tradicional ---");
        String jsonTradicional = "{\n" +
                "  \"nome\": \"Java\",\n" +
                "  \"versao\": 13,\n" +
                "  \"lts\": false\n" +
                "}";
        System.out.println(jsonTradicional);

        /*
         * 2) Text Block (Java 13+ Preview)
         */
        System.out.println("\n--- Text Block ---");
        String json = """
                {
                  "nome": "Java",
                  "versao": 13,
                  "lts": false
                }
                """;
        System.out.println(json);

        /*
         * 3) Text Block com formatação
         */
        System.out.println("\n--- Text Block Formatado ---");
        String html = """
                <html>
                    <body>
                        <h1>Bem-vindo ao Java 13</h1>
                        <p>Text Blocks facilitam strings multilinha</p>
                    </body>
                </html>
                """;
        System.out.println(html);

        /*
         * 4) Text Block com variáveis (usando String.format)
         */
        System.out.println("\n--- Text Block com Variáveis ---");
        String nome = "Java";
        int versao = 13;
        String mensagem = """
                Olá, %s!
                Você está usando a versão %d.
                Text Blocks são incríveis!
                """.formatted(nome, versao);
        System.out.println(mensagem);

        /*
         * 5) Text Block preservando espaços
         */
        System.out.println("\n--- Text Block e Espaços ---");
        String codigo = """
                public class Exemplo {
                    public static void main(String[] args) {
                        System.out.println("Hello, World!");
                    }
                }
                """;
        System.out.println(codigo);

        /*
         * 6) Text Block com escape characters
         */
        System.out.println("\n--- Text Block com Escapes ---");
        String textoComEscapes = """
                Linha 1
                Linha 2 com "aspas"
                Linha 3 com \\barra invertida\\
                """;
        System.out.println(textoComEscapes);
    }
}

