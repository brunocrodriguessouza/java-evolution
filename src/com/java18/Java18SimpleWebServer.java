package com.java18;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Exemplo didático de Java 18 - Simple Web Server
 *
 * Objetivo:
 * - Demonstrar servidor HTTP simples embutido
 * - Útil para testes e desenvolvimento
 * - Sem necessidade de frameworks externos
 */
public class Java18SimpleWebServer {

    public static void main(String[] args) throws IOException {

        System.out.println("=== Simple Web Server (Java 18+) ===\n");

        /*
         * 1) Criar servidor HTTP simples
         */
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8000), 0);

        /*
         * 2) Criar contexto e handler
         */
        servidor.createContext("/", new MeuHandler());
        servidor.createContext("/api/hello", new HelloHandler());

        /*
         * 3) Iniciar servidor
         */
        servidor.start();
        System.out.println("Servidor iniciado em http://localhost:8000");
        System.out.println("Pressione Ctrl+C para parar");

        // Manter servidor rodando
        // servidor.stop(0); // Para parar o servidor
    }

    // Handler personalizado
    static class MeuHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String resposta = """
                    <html>
                        <body>
                            <h1>Servidor HTTP Simples do Java 18</h1>
                            <p>Funcionando perfeitamente!</p>
                        </body>
                    </html>
                    """;
            
            exchange.sendResponseHeaders(200, resposta.length());
            OutputStream os = exchange.getResponseBody();
            os.write(resposta.getBytes());
            os.close();
        }
    }

    // Handler para API
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String resposta = """
                    {
                        "mensagem": "Olá do Java 18!",
                        "versao": "18",
                        "status": "ok"
                    }
                    """;
            
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, resposta.length());
            OutputStream os = exchange.getResponseBody();
            os.write(resposta.getBytes());
            os.close();
        }
    }
}

