# 🎮 Cadastro de Brinquedos

API RESTful construída com **Spring Boot**, voltada para o cadastro de brinquedos em um banco de dados Oracle. A aplicação permite registrar informações como nome, tipo, classificação, tamanho e preço dos brinquedos, utilizando o **Spring Data JPA** para persistência.

---

## ✨ Funcionalidades

- ✅ Cadastro de brinquedos com os atributos:
  - `nome`
  - `tipo`
  - `classificação`
  - `tamanho`
  - `preço`
- 🌐 API RESTful com endpoints para inserção e consulta.
- 💾 Persistência de dados no banco de dados Oracle.
- 🧪 Testes de integração via **Postman**.

---

## 📦 Tecnologias Utilizadas

| Tecnologia              | Descrição                                        |
|-------------------------|--------------------------------------------------|
| **Spring Boot**         | Framework principal da aplicação                 |
| **Spring Web**          | Criação da API REST                              |
| **Spring Data JPA**     | Persistência no banco usando JPA                 |
| **Oracle JDBC Driver**  | Conexão com banco de dados Oracle                |
| **Spring DevTools**     | Suporte ao hot reload durante o desenvolvimento |
| **Java 21**             | Linguagem utilizada                              |
| **Maven**               | Gerenciador de dependências                      |

---

## ⚙️ Criação do Projeto com Spring Initializr

Ao gerar seu projeto no [Spring Initializr](https://start.spring.io/), utilize as seguintes opções:

- **Project**: Maven
- **Language**: Java
- **Spring Boot**: 3.x.x (ou superior)
- **Java**: 21

### ✅ Dependências a incluir:

- `Spring Web`
- `Spring Data JPA`
- `Oracle Driver`
- `Spring Boot DevTools`

---

## 📁 Dependências no `pom.xml`

Aqui estão as dependências principais para o funcionamento da aplicação:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc8</artifactId>
        <version>19.8.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 💾 Configuração do Banco de Dados Oracle

No arquivo `src/main/resources/application.properties`, adicione:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driverClassName=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
spring.jpa.hibernate.ddl-auto=update
```

---

## 🚀 Como Rodar a Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Abra o projeto na sua IDE favorita (IntelliJ, Eclipse, VS Code...).

3. Certifique-se de que o Oracle DB está ativo e com as credenciais corretas.

4. Execute a classe `CadastroBrinquedoApplication.java`.

5. A aplicação estará disponível em:
   ```
   http://localhost:8080
   ```

---

## 🧪 Testando a API com Postman

### 1️⃣ Cadastrar Brinquedo (POST)

**URL:** `http://localhost:8080/cadastrar`  
**Método:** `POST`  
**Headers:**
```
Content-Type: application/json
```

**Body (JSON):**
```json
{
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacao": "Infantil",
  "tamanho": "Médio",
  "preco": 100.50
}
```

**Resposta esperada:**
```json
{
  "message": "Brinquedo cadastrado com sucesso"
}
```

---

### 2️⃣ Consultar Brinquedos (GET)

**URL:** `http://localhost:8080/brinquedos`  
**Método:** `GET`

**Resposta esperada:**
```json
[
  {
    "id": 1,
    "nome": "Carrinho de Controle Remoto",
    "tipo": "Eletrônico",
    "classificacao": "Infantil",
    "tamanho": "Médio",
    "preco": 100.50
  }
]
```

## Criadores
- **João Paulo Moreira dos Santos** - RM 557808
- **Arthur Bispo de Lima** - RM 557568

**Curso:** Análise e Desenvolvimento de Sistemas - 2TDSPV
