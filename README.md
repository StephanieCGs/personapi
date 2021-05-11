# personapi

API REST com Spring Boot para cadastro e gerenciamento de pessoas.

## Description

Projeto para aprender a desenvolver uma API Rest com Spring Boot para cadastro e gerenciamento de pessoas de uma organização. Abordando as boas práticas de Java e do Spring.

## Tecnologies

- [Java](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [H2 Database](https://www.h2database.com/html/main.html)

## Requirements

- Java 8
- IntelliJ Community
- Postman / Insomnia / Ou outro

## Getting Started/Project Setup

- Clonar esse repositório.

### Executing program

- Abrir no IntelliJ Community o projeto e executar.
- Rotas no Postman:
  - [POST] Adicionar uma pessoa: http://localhost:8080/api/v1/people

    * Exemplo de estrutura JSON para adicionar uma pessoa:

    ```shell script
    {
    	"firstName": "Harry",
    	"lastName": "Potter",
    	"cpf": "350.989.120-16", //CPF gerado aleatoriamente
    	"birthDate": "31-07-1980",
    	"phones": [
    		{
    			"type": "MOBILE",
    			"number": "(27)999999999"
    		}
    	]
    }
    ```

  - [GET] Retornar lista de pessoas armazenadas: http://localhost:8080/api/v1/people

  - [GET] Retorna uma pessoa com busca por id: http:<span></span>//localhost:8080/api/v1/people/**Id** 
    
    - Exemplo (retornará a pessoa de ID == 1): http://localhost:8080/api/v1/people/1
    
  - [DELETE]  Deletar uma pessoa a partir de seu id: http:<span></span>://localhost:8080/api/v1/people/**Id**

    - Exemplo (irá deletar a pessoa de ID == 1): http://localhost:8080/api/v1/people/1

  - [PUT] Fazer update das informações de uma pessoa a partir de seu id: http:<span></span>//localhost:8080/api/v1/people/**Id**

    * Exemplo (irá fazer o update da pessoa de ID == 1 para as informações abaixo): http://localhost:8080/api/v1/people/1

    ```shell script
    {
    	"id": 1,
    	"firstName": "Harry",
    	"lastName": "Potter",
    	"cpf": "975.853.180-81", // //CPF gerado aleatoriamente
    	"birthDate": "31-07-1980",
    	"phones": [
    		{
    			"id": 2,
    			"type": "MOBILE",
    			"number": "(27)777778888"
    		}
    	]
    }
    ```

---

---

### Heroku - Tests:

- Também é possível fazer os testes de retorno nos seguintes links:
  - 
