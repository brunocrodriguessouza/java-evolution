package com.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Exemplo didático de Java 8 - Nova API de Data e Hora (java.time)
 *
 * Objetivo:
 * - Substituir as classes antigas (Date, Calendar) que eram problemáticas
 * - Demonstrar imutabilidade e thread-safety
 * - Mostrar operações com datas de forma intuitiva
 */
public class Java8DateTime {

    public static void main(String[] args) {

        System.out.println("=== Nova API de Data e Hora (Java 8+) ===\n");

        /*
         * 1) LocalDate - Representa apenas data (sem hora)
         */
        System.out.println("--- LocalDate (apenas data) ---");
        LocalDate hoje = LocalDate.now();
        System.out.println("Hoje: " + hoje);

        LocalDate dataEspecifica = LocalDate.of(2024, 12, 25);
        System.out.println("Data específica: " + dataEspecifica);

        LocalDate amanha = hoje.plusDays(1);
        System.out.println("Amanhã: " + amanha);

        /*
         * 2) LocalTime - Representa apenas hora (sem data)
         */
        System.out.println("\n--- LocalTime (apenas hora) ---");
        LocalTime agora = LocalTime.now();
        System.out.println("Agora: " + agora);

        LocalTime horaEspecifica = LocalTime.of(14, 30, 0);
        System.out.println("Hora específica: " + horaEspecifica);

        /*
         * 3) LocalDateTime - Data e hora combinadas
         */
        System.out.println("\n--- LocalDateTime (data + hora) ---");
        LocalDateTime agoraCompleto = LocalDateTime.now();
        System.out.println("Agora completo: " + agoraCompleto);

        LocalDateTime evento = LocalDateTime.of(2024, 12, 25, 20, 0);
        System.out.println("Evento: " + evento);

        /*
         * 4) ZonedDateTime - Data e hora com fuso horário
         */
        System.out.println("\n--- ZonedDateTime (com fuso horário) ---");
        ZonedDateTime agoraComFuso = ZonedDateTime.now();
        System.out.println("Agora com fuso: " + agoraComFuso);

        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Horário em Tóquio: " + tokyo);

        /*
         * 5) Duration - Diferença entre tempos
         */
        System.out.println("\n--- Duration (diferença de tempo) ---");
        LocalTime inicio = LocalTime.of(9, 0);
        LocalTime fim = LocalTime.of(17, 30);
        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Duração do trabalho: " + duracao.toHours() + " horas");

        /*
         * 6) Period - Diferença entre datas
         */
        System.out.println("\n--- Period (diferença de datas) ---");
        LocalDate nascimento = LocalDate.of(1990, 5, 15);
        LocalDate hoje2 = LocalDate.now();
        Period idade = Period.between(nascimento, hoje2);
        System.out.println("Idade: " + idade.getYears() + " anos, " + 
                          idade.getMonths() + " meses, " + 
                          idade.getDays() + " dias");

        /*
         * 7) Formatação de datas
         */
        System.out.println("\n--- Formatação ---");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormatada = agoraCompleto.format(formatador);
        System.out.println("Data formatada: " + dataFormatada);

        /*
         * 8) Imutabilidade - Operações retornam novos objetos
         */
        System.out.println("\n--- Imutabilidade ---");
        LocalDate data = LocalDate.of(2024, 1, 1);
        System.out.println("Data original: " + data);
        
        LocalDate novaData = data.plusMonths(2).plusDays(5);
        System.out.println("Nova data (original não mudou): " + novaData);
        System.out.println("Data original (ainda intacta): " + data);
    }
}

