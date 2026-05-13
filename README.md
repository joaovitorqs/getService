# getService

Projeto Full Stack desenvolvido com foco em consolidar conhecimentos em desenvolvimento Back-End utilizando Java e Spring Boot, aplicando arquitetura em camadas, validação de dados, persistência com PostgreSQL e integração com Front-End estático.

O objetivo da aplicação é permitir a criação e gerenciamento de cards de solicitação de serviços, funcionando como um pequeno mural de serviços disponíveis.

---

# Tecnologias Utilizadas

## Back-End
- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Jakarta Validation
- PostgreSQL
- H2 Database (testes)
- Maven
- Lombok

## Front-End
- HTML5
- CSS3
- JavaScript

## Ferramentas
- Git & GitHub
- Docker

---

# Funcionalidades

- Criar cards de serviço
- Listar cards ativos
- Buscar card por ID
- Remover card
- Validação de dados com Bean Validation
- Tratamento global de exceções
- Persistência com PostgreSQL
- Arquitetura em camadas
- Front-End integrado com API REST

---

# Estrutura do Projeto

```text
src/main/java
│
├── controller
├── service
├── repository
├── model
├── DTO
└── exception
```

A aplicação segue o padrão de separação por responsabilidades:

- **Controller** → recebe as requisições HTTP
- **Service** → contém as regras de negócio
- **Repository** → comunicação com o banco de dados
- **DTO** → transferência e validação de dados
- **Exception** → tratamento global de erros

---

# Regras de Negócio

## Cards Ativos
Os cards possuem tempo de vida de 72 horas.

Após esse período, deixam de ser retornados na listagem principal da aplicação.

## Validações
A API realiza validações nos dados recebidos:

- Nome obrigatório
- Contato obrigatório
- Contato com exatamente 11 dígitos
- Título obrigatório
- Limite de caracteres
- Descrição obrigatória

---

# Endpoints da API

## Listar Cards
```http
GET /api/cards
```

## Buscar Card por ID
```http
GET /api/cards/{id}
```

## Criar Card
```http
POST /api/cards
```

### Exemplo de Body

```json
{
  "nameClient": "João Vitor",
  "contact": "11999999999",
  "title": "Desenvolvedor Back-End",
  "description": "Preciso de ajuda com uma API em Spring Boot"
}
```

## Remover Card
```http
DELETE /api/cards/{id}
```

---

# Tratamento de Erros

A aplicação possui tratamento global de exceções utilizando `@RestControllerAdvice`.

Exemplo de resposta de erro:

```json
{
  "timestamp": "2026-05-12T12:00:00",
  "status": 400,
  "error": "Validation error.",
  "message": "Invalid fields.",
  "fields": {
    "contact": "Contact information must contain 11 digits."
  }
}
```

---

# Como Executar o Projeto

## Pré-requisitos

- Java 21
- Maven
- PostgreSQL

---

## Clonar Repositório

```bash
git clone https://github.com/joaovitorqs/getService.git
```

---

## Configurar Banco de Dados

Defina as propriedades no arquivo:

```properties
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/getservice
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Executar Aplicação

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

---

# Front-End

O projeto possui um Front-End estático integrado à API.

Páginas disponíveis:

- Página inicial
- Criação de serviços
- Listagem de serviços

Os arquivos estão localizados em:

```text
src/main/resources/static
```

---

# Docker

O projeto possui configuração Docker para facilitar execução e deploy.

## Build da imagem

```bash
docker build -t getservice .
```

## Executar container

```bash
docker run -p 8080:8080 getservice
```

---

# Objetivos do Projeto

Este projeto foi desenvolvido com foco em:

- Evolução prática em Spring Boot
- Construção de APIs REST
- Aplicação de arquitetura em camadas
- Validação e tratamento de exceções
- Integração entre Front-End e Back-End
- Persistência de dados com PostgreSQL
- Organização de código seguindo boas práticas

---

# Melhorias Futuras

- Implementação de autenticação com Spring Security + JWT
- Testes unitários com JUnit e Mockito
- Filtros
- Melhorias visuais no Front-End
- Sistema de usuários

---

# Autor

Desenvolvido por João Vitor de Queiroz Santos.

GitHub: https://github.com/joaovitorqs

