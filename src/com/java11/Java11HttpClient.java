package com.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * Exemplo didático de Java 11 - HTTP Client
 *
 * Objetivo:
 * - Demonstrar o novo HTTP Client nativo do Java
 * - Substituir HttpURLConnection e bibliotecas externas
 * - Mostrar requisições síncronas e assíncronas
 */
public class Java11HttpClient {

    public static void main(String[] args) {

        System.out.println("=== HTTP Client (Java 11+) ===\n");

        /*
         * 1) Criar cliente HTTP
         */
        HttpClient cliente = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        /*
         * 2) Requisição GET síncrona
         */
        System.out.println("--- Requisição GET Síncrona ---");
        try {
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .GET()
                    .build();

            HttpResponse<String> resposta = cliente.send(requisicao, 
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + resposta.statusCode());
            System.out.println("Headers: " + resposta.headers().map());
            System.out.println("Body (primeiros 200 chars): " + 
                    resposta.body().substring(0, Math.min(200, resposta.body().length())));

        } catch (Exception e) {
            System.out.println("Erro na requisição: " + e.getMessage());
        }

        /*
         * 3) Requisição GET assíncrona
         */
        System.out.println("\n--- Requisição GET Assíncrona ---");
        try {
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .GET()
                    .build();

            CompletableFuture<HttpResponse<String>> futuro = cliente.sendAsync(requisicao,
                    HttpResponse.BodyHandlers.ofString());

            futuro.thenApply(HttpResponse::statusCode)
                    .thenAccept(status -> 
                        System.out.println("Status Code (assíncrono): " + status));

            // Aguardar conclusão
            HttpResponse<String> resposta = futuro.get();
            System.out.println("Requisição assíncrona concluída!");

        } catch (Exception e) {
            System.out.println("Erro na requisição assíncrona: " + e.getMessage());
        }

        /*
         * 4) Requisição POST
         */
        System.out.println("\n--- Requisição POST ---");
        try {
            String jsonBody = "{\"nome\": \"Java\", \"versao\": 11}";
            
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/post"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> resposta = cliente.send(requisicao,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + resposta.statusCode());
            System.out.println("POST enviado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro na requisição POST: " + e.getMessage());
        }

        System.out.println("\n--- Características do HTTP Client ---");
        System.out.println("✓ Suporta HTTP/1.1 e HTTP/2");
        System.out.println("✓ Requisições síncronas e assíncronas");
        System.out.println("✓ WebSocket support");
        System.out.println("✓ Mais simples que HttpURLConnection");
    }
}

