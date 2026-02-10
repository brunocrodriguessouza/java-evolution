package com.java20;

// Nota: ScopedValue está em preview no Java 20
// Pode precisar compilar com: javac --enable-preview --release 20
// No Java 20: jdk.incubator.concurrent.ScopedValue
// Em versões mais recentes (Java 21+): java.util.concurrent.ScopedValue
// Este exemplo usa a sintaxe conceitual - ajuste o import conforme sua versão do JDK
// import jdk.incubator.concurrent.ScopedValue; // Java 20
// import java.util.concurrent.ScopedValue;    // Java 21+

/**
 * Exemplo didático de Java 20 - Scoped Values (Preview)
 *
 * Objetivo:
 * - Substituir ThreadLocal de forma mais segura
 * - Valores imutáveis compartilhados entre threads
 * - Melhor para virtual threads
 */
public class Java20ScopedValues {

    // ScopedValue - valor compartilhado no escopo
    // Nota: Este código é conceitual - ScopedValue precisa ser importado corretamente
    // Descomente e ajuste conforme sua versão do JDK:
    // private static final ScopedValue<String> USUARIO = ScopedValue.newInstance();
    
    // Para demonstração, vamos usar uma abordagem simplificada
    private static final ThreadLocal<String> USUARIO = new ThreadLocal<>();

    public static void main(String[] args) {

        System.out.println("=== Scoped Values (Java 20 Preview) ===\n");

        /*
         * 1) Usar ScopedValue para armazenar valor no escopo
         * Nota: Este exemplo demonstra o conceito usando ThreadLocal
         * ScopedValue real requer import correto conforme versão do JDK
         */
        System.out.println("--- ScopedValue Básico (conceitual) ---");
        System.out.println("ScopedValue.runWhere(USUARIO, \"João\", () -> {");
        System.out.println("    System.out.println(\"Usuário: \" + USUARIO.get());");
        System.out.println("});");
        
        // Exemplo prático com ThreadLocal (similar ao conceito)
        USUARIO.set("João");
        System.out.println("Usuário no escopo: " + USUARIO.get());
        executarOperacao();
        USUARIO.remove();

        /*
         * 2) ScopedValue com múltiplos valores
         */
        System.out.println("\n--- Múltiplos ScopedValues (conceitual) ---");
        System.out.println("ScopedValue.runWhere(");
        System.out.println("    contexto, \"Desenvolvimento\",");
        System.out.println("    versao, 20,");
        System.out.println("    () -> { /* código */ }");
        System.out.println(");");

        /*
         * 3) ScopedValue em diferentes threads
         */
        System.out.println("\n--- ScopedValue com Threads (conceitual) ---");
        System.out.println("ScopedValue não é herdado automaticamente entre threads");
        System.out.println("Mas pode ser passado explicitamente");

        System.out.println("\n--- Vantagens do ScopedValue ---");
        System.out.println("✓ Imutável - mais seguro que ThreadLocal");
        System.out.println("✓ Melhor para virtual threads");
        System.out.println("✓ Escopo limitado - não vaza entre threads");
    }

    private static void executarOperacao() {
        // Acessa o valor do escopo
        String usuario = USUARIO.get();
        System.out.println("Executando operação para: " + usuario);
    }
}

