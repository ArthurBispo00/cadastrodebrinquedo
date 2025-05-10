# 🎮 Cadastro de Brinquedos

Este projeto é uma API RESTful construída com **Spring Boot**, voltada para o cadastro de brinquedos em um banco de dados Oracle. A aplicação permite cadastrar informações sobre brinquedos, como nome, tipo, classificação, tamanho e preço, utilizando o Spring Data JPA para persistência.

## Funcionalidades

- Cadastro de brinquedos com as propriedades: nome, tipo, classificação, tamanho e preço.
- API RESTful com endpoints para realizar o cadastro de brinquedos.
- Persistência de dados no banco de dados Oracle.
- Testes podem ser realizados utilizando o **Postman**.

## 📦 Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Web**: Usado para criação da API RESTful.
- **Spring Data JPA**: Para a persistência de dados utilizando o padrão JPA.
- **Oracle JDBC Driver**: Para conexão com o banco de dados Oracle.
- **Spring Boot DevTools**: Ferramentas de desenvolvimento para acelerar o ciclo de desenvolvimento (como reinício automático).
- **Java 21**: Versão do Java utilizada no desenvolvimento.
- **Maven**: Gerenciador de dependências e automação de build.

## ⚙️ Dependências do Spring Initializr

Ao criar o projeto no [Spring Initializr](https://start.spring.io/), certifique-se de marcar as seguintes opções:

- Project: Maven
- Language: Java
- Spring Boot: 3.x.x (ou a versão mais recente)
- Java: 21

### Dependências:

- **Spring Web** – Para criação de APIs REST
- **Spring Data JPA** – Para integração com banco de dados
- **Oracle Driver** – Driver JDBC para Oracle
- **Spring Boot DevTools** – Para recarregamento automático em desenvolvimento



- 
As dependências principais no arquivo `pom.xml` são:

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


- ## 💾 Configuração do Banco de Dados Oracle

No arquivo `src/main/resources/application.properties`, adicione as configurações de conexão com o banco Oracle:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driverClassName=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.Oracle12cDialect
spring.jpa.hibernate.ddl-auto=update
```
## 🚀 Como Rodar a Aplicação

1. Clone este repositório ou baixe o projeto ZIP:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git

2. abra o projeto na sua IDE (IntelliJ IDEA, Eclipse, VS Code, etc.).

Verifique se o banco de dados Oracle está configurado corretamente.

Execute a classe principal CadastroBrinquedoApplication.java como uma aplicação Java.

Após executar, a aplicação estará disponível em:

http://localhost:8080

## Testando a API com Postman

#1. Cadastro de Brinquedo (POST)
Para cadastrar um brinquedo, envie uma requisição POST para o endpoint http://localhost:8080/cadastrar com o seguinte corpo JSON no Postman:

URL: http://localhost:8080/cadastrar

Método: POST

Cabeçalhos:

Content-Type: application/json

Corpo (JSON):

{
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacao": "Infantil",
  "tamanho": "Médio",
  "preco": 100.50
}


#2. Resposta Esperada
Se o brinquedo for cadastrado com sucesso, a resposta será um 201 Created com a seguinte estrutura:


{
  "message": "Brinquedo cadastrado com sucesso"
}

#3. Consulta de Brinquedos (GET)
Para listar os brinquedos cadastrados, envie uma requisição GET para http://localhost:8080/brinquedos.

URL: http://localhost:8080/brinquedos

Método: GET

Resposta Esperada (Exemplo):

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
