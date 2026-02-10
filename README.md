# 🚀 Java Evolution - Exemplos Didáticos do Java 8 ao Java 25

Este repositório contém exemplos práticos e didáticos de todas as principais funcionalidades introduzidas no Java desde a versão 8 até a versão 25. Cada exemplo foi cuidadosamente criado para demonstrar de forma clara e objetiva as novas features de cada versão.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades por Versão](#funcionalidades-por-versão)
- [Como Usar](#como-usar)
- [Requisitos](#requisitos)
- [Compilação e Execução](#compilação-e-execução)
- [Contribuindo](#contribuindo)

## 🎯 Sobre o Projeto

Este projeto foi criado com o objetivo de fornecer exemplos práticos e didáticos de todas as funcionalidades introduzidas no Java desde a versão 8 (LTS de 2014) até a versão 25 (2024). Cada exemplo:

- ✅ Está completamente comentado em português
- ✅ Demonstra a funcionalidade de forma clara e objetiva
- ✅ Compara abordagens antigas vs novas quando aplicável
- ✅ Inclui explicações sobre quando e como usar cada feature
- ✅ Segue um padrão de nomenclatura consistente

## 📁 Estrutura do Projeto

```
java-evolution/
├── src/
│   └── com/
│       ├── java8/          # Funcionalidades do Java 8
│       ├── java9/          # Funcionalidades do Java 9
│       ├── java10/         # Funcionalidades do Java 10
│       ├── java11/         # Funcionalidades do Java 11
│       ├── java12/         # Funcionalidades do Java 12
│       ├── java13/         # Funcionalidades do Java 13
│       ├── java14/         # Funcionalidades do Java 14
│       ├── java15/         # Funcionalidades do Java 15
│       ├── java16/         # Funcionalidades do Java 16
│       ├── java17/         # Funcionalidades do Java 17
│       ├── java18/         # Funcionalidades do Java 18
│       ├── java19/         # Funcionalidades do Java 19
│       ├── java20/         # Funcionalidades do Java 20
│       ├── java21/         # Funcionalidades do Java 21
│       ├── java22/         # Funcionalidades do Java 22
│       ├── java23/         # Funcionalidades do Java 23
│       ├── java24/         # Funcionalidades do Java 24
│       └── java25/         # Funcionalidades do Java 25
└── README.md
```

## 📚 Funcionalidades por Versão

### ☕ Java 8 (LTS - 2014) - A Revolução Funcional

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java8Lambda.java` | Expressões Lambda | Simplificação de código com funções anônimas |
| `Java8Streams.java` | API Streams | Processamento funcional de coleções |
| `Java8Optional.java` | Optional | Evitar NullPointerException de forma elegante |
| `Java8MethodReferences.java` | Method References | Referências a métodos para simplificar lambdas |
| `Java8DefaultMethods.java` | Default Methods | Métodos com implementação padrão em interfaces |
| `Java8DateTime.java` | Nova API de Data/Hora | Substituição das classes Date e Calendar |
| `Java8FunctionalInterfaces.java` | Interfaces Funcionais | Function, Predicate, Consumer, Supplier, etc. |

### ☕ Java 9 (2017)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java9PrivateMethodsInterfaces.java` | Métodos Privados em Interfaces | Reutilizar código em métodos default |
| `Java9FactoryMethodsCollections.java` | Factory Methods | Criar coleções imutáveis de forma concisa |
| `Java9StreamImprovements.java` | Melhorias em Streams | takeWhile, dropWhile, ofNullable, iterate |

### ☕ Java 10 (2018)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java10VarKeyword.java` | Palavra-chave `var` | Inferência de tipo local |

### ☕ Java 11 (LTS - 2018)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java11StringMethods.java` | Novos Métodos em String | isBlank(), strip(), repeat(), lines() |
| `Java11HttpClient.java` | HTTP Client | Cliente HTTP nativo (substitui HttpURLConnection) |

### ☕ Java 12 (2019)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java12SwitchExpressions.java` | Switch Expressions | Switch como expressão (preview) |

### ☕ Java 13 (2019)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java13TextBlocks.java` | Text Blocks | Strings multilinha (preview) |

### ☕ Java 14 (2020)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java14Records.java` | Records | Classes imutáveis de dados (preview) |
| `Java14PatternMatchingInstanceof.java` | Pattern Matching | Simplificação de instanceof (preview) |

### ☕ Java 15 (2020)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java15SealedClasses.java` | Sealed Classes | Controle de hierarquia de classes (preview) |

### ☕ Java 16 (2021)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java16RecordsPatternMatching.java` | Pattern Matching para Records | Desestruturação de records |

### ☕ Java 17 (LTS - 2021)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java17SealedClassesFinal.java` | Sealed Classes | Feature final (não mais preview) |

### ☕ Java 18 (2022)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java18SimpleWebServer.java` | Simple Web Server | Servidor HTTP simples embutido |

### ☕ Java 19 (2022)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java19VirtualThreads.java` | Virtual Threads | Threads leves para alta concorrência (preview) |
| `Java19PatternMatchingSwitch.java` | Pattern Matching Switch | Pattern matching completo em switch (preview) |

### ☕ Java 20 (2023)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java20ScopedValues.java` | Scoped Values | Substituição segura de ThreadLocal (preview) |

### ☕ Java 21 (LTS - 2023)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java21VirtualThreadsFinal.java` | Virtual Threads | Feature final |
| `Java21StringTemplates.java` | String Templates | Interpolação segura de strings (preview) |
| `Java21PatternMatchingSwitchFinal.java` | Pattern Matching Switch | Feature final |

### ☕ Java 22 (2024)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java22StatementsBeforeSuper.java` | Statements Before super() | Código antes de super() em construtores (preview) |

### ☕ Java 23 (2024)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java23StringTemplatesFinal.java` | String Templates | Feature final |

### ☕ Java 24 (2025)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java24ImplicitlyDeclaredClasses.java` | Implicitly Declared Classes | Classes implícitas para programas simples (preview) |

### ☕ Java 25 (2025)

| Arquivo | Funcionalidade | Descrição |
|---------|---------------|-----------|
| `Java25PatternMatchingPrimitives.java` | Pattern Matching Primitivos | Pattern matching para tipos primitivos (preview) |

## 🛠️ Como Usar

### Pré-requisitos

- **JDK 21 ou superior** (recomendado para executar todos os exemplos)
- **IDE** (IntelliJ IDEA, Eclipse, VS Code) ou editor de texto
- **Conhecimento básico de Java**

### Executando os Exemplos

#### Opção 1: Via IDE

1. Abra o projeto na sua IDE preferida
2. Navegue até a classe desejada (ex: `src/com/java8/Java8Lambda.java`)
3. Execute o método `main` diretamente pela IDE

#### Opção 2: Via Linha de Comando

```bash
# Compilar
javac src/com/java8/Java8Lambda.java

# Executar
java -cp src com.java8.Java8Lambda
```

#### Opção 3: Exemplos com Features Preview

Alguns exemplos usam features em preview que requerem flags especiais:

```bash
# Compilar com preview features
javac --enable-preview --release 21 src/com/java21/Java21StringTemplates.java

# Executar com preview features
java --enable-preview -cp src com.java21.Java21StringTemplates
```

## 📖 Exemplos de Uso

### Exemplo 1: Lambda Expressions (Java 8)

```java
// Antes (Java 7)
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};

// Depois (Java 8+)
Runnable r = () -> System.out.println("Hello");
```

### Exemplo 2: Records (Java 14+)

```java
// Antes: Muito código boilerplate
public class Pessoa {
    private final String nome;
    private final int idade;
    
    // construtor, getters, equals, hashCode, toString...
}

// Depois: Conciso e claro
record Pessoa(String nome, int idade) {}
```

### Exemplo 3: Pattern Matching (Java 21+)

```java
// Antes
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}

// Depois
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

## 🔍 Navegação Rápida

### Por Funcionalidade

- **Programação Funcional**: Java 8 (Lambda, Streams, Optional)
- **Concorrência**: Java 19/21 (Virtual Threads)
- **Pattern Matching**: Java 14, 16, 19, 21, 25
- **Classes de Dados**: Java 14 (Records), Java 15/17 (Sealed Classes)
- **Strings**: Java 11 (novos métodos), Java 13 (Text Blocks), Java 21/23 (Templates)
- **Sintaxe**: Java 10 (var), Java 12 (Switch Expressions), Java 22 (Statements Before super)

### Por Versão LTS

- **Java 8** (2014): Programação funcional
- **Java 11** (2018): HTTP Client, novos métodos String
- **Java 17** (2021): Sealed Classes final
- **Java 21** (2023): Virtual Threads, Pattern Matching final

## ⚠️ Notas Importantes

### Features Preview

Alguns exemplos usam features que ainda estão em preview. Essas features:

- Podem mudar em versões futuras
- Requerem flags `--enable-preview` para compilar/executar
- Não devem ser usadas em produção até se tornarem features finais

### Compatibilidade

- **Java 8-10**: Funcionam com JDK 10+
- **Java 11-16**: Funcionam com JDK 16+
- **Java 17-20**: Funcionam com JDK 20+
- **Java 21-25**: Requerem JDK 21+ (recomendado JDK 21+ para todas)

## 🤝 Contribuindo

Contribuições são bem-vindas! Se você:

- Encontrou um erro ou bug
- Tem sugestões de melhorias
- Quer adicionar mais exemplos
- Quer melhorar a documentação

Sinta-se à vontade para abrir uma issue ou pull request!

## 📝 Licença

Este projeto é destinado a fins educacionais e de aprendizado.

## 🎓 Recursos Adicionais

- [Documentação Oficial do Java](https://docs.oracle.com/javase/)
- [OpenJDK](https://openjdk.org/)
- [Java Enhancement Proposals (JEPs)](https://openjdk.org/jeps/)

## 📊 Estatísticas do Projeto

- **Total de Versões**: 18 (Java 8 ao 25)
- **Total de Exemplos**: 30+
- **Linhas de Código**: ~3000+
- **Comentários**: 100% em português

---

**Desenvolvido com ❤️ para a comunidade Java brasileira**

*Última atualização: 2024*

