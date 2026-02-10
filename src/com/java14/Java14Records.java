package com.java14;

/**
 * Exemplo didático de Java 14 - Records (Preview)
 *
 * Objetivo:
 * - Simplificar criação de classes imutáveis
 * - Reduzir código boilerplate (getters, equals, hashCode, toString)
 * - Representar dados de forma concisa
 */
public class Java14Records {

    public static void main(String[] args) {

        System.out.println("=== Records (Java 14 Preview) ===\n");

        /*
         * 1) Classe tradicional vs Record
         */
        System.out.println("--- Comparação: Classe vs Record ---");
        
        // Classe tradicional (muito código)
        PessoaTradicional pessoa1 = new PessoaTradicional("João", 30);
        System.out.println("Classe tradicional: " + pessoa1);
        
        // Record (código conciso)
        Pessoa pessoa2 = new Pessoa("Maria", 25);
        System.out.println("Record: " + pessoa2);

        /*
         * 2) Record com métodos customizados
         */
        System.out.println("\n--- Record com Métodos ---");
        Produto produto = new Produto("Notebook", 2500.00);
        System.out.println("Produto: " + produto);
        System.out.println("Preço com desconto: " + produto.precoComDesconto(10));

        /*
         * 3) Record com construtor compacto
         */
        System.out.println("\n--- Record com Construtor Compacto ---");
        Usuario usuario = new Usuario("admin", "admin123");
        System.out.println("Usuário: " + usuario);
        System.out.println("É válido? " + usuario.ehValido());

        /*
         * 4) Record imutável
         */
        System.out.println("\n--- Record Imutável ---");
        Pessoa pessoa = new Pessoa("Carlos", 35);
        System.out.println("Nome: " + pessoa.nome());
        System.out.println("Idade: " + pessoa.idade());
        
        // Records são imutáveis - não há setters
        // pessoa.nome() = "Novo Nome"; // ERRO: não compila
    }

    // Record - classe imutável de dados
    record Pessoa(String nome, int idade) {
        // Métodos podem ser adicionados
        public boolean ehMaiorDeIdade() {
            return idade >= 18;
        }
    }

    // Record com construtor compacto (validação)
    record Usuario(String login, String senha) {
        // Construtor compacto para validação
        public Usuario {
            if (login == null || login.isBlank()) {
                throw new IllegalArgumentException("Login não pode ser vazio");
            }
            if (senha == null || senha.length() < 6) {
                throw new IllegalArgumentException("Senha deve ter no mínimo 6 caracteres");
            }
        }

        public boolean ehValido() {
            return login != null && senha != null;
        }
    }

    // Record com métodos
    record Produto(String nome, double preco) {
        public double precoComDesconto(double percentual) {
            return preco * (1 - percentual / 100);
        }
    }

    // Classe tradicional equivalente (muito mais código)
    static class PessoaTradicional {
        private final String nome;
        private final int idade;

        public PessoaTradicional(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PessoaTradicional that = (PessoaTradicional) o;
            return idade == that.idade && nome.equals(that.nome);
        }

        @Override
        public int hashCode() {
            return nome.hashCode() * 31 + idade;
        }

        @Override
        public String toString() {
            return "PessoaTradicional{nome='" + nome + "', idade=" + idade + "}";
        }
    }
}

