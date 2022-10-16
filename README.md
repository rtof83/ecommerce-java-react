# Projeto Ecommerce

## Foi utilizado para contrução:
- API -> Java (11) / Spring Boot 2.7.3;
- FRONT -> React;
- DB -> MySQL;
- Ferramentas:
    - IntelliJ IDEA 2022.2.1 (Community Edition);
    - Visual Studio Code 1.7.0.2;
    - Console de Gerenciamento da AWS;

&nbsp;

## Estrutura da base de dados:
- [database.sql](https://github.com/rtof83/ecommerce-java-react/blob/main/samples/database.sql);

&nbsp;

## Instalação
- MySQL -> CREATE DATABASE database;
- /api -> mvn clean package;
- /web -> npm install;

&nbsp;

## Inicialização
- /api -> java -jar target/springboot-store-backend-0.0.1-SNAPSHOT.jar;
- /web -> npm start;
- porta padrão: 8080;
- usuário padrão para acesso ao front:
    - email: admin;
    - password: admin;

&nbsp;

## Configurações
- [API - conexão com a base de dados](https://github.com/rtof83/ecommerce-java-react/blob/main/api/src/main/resources/application.properties);
- [FRONT - conexão com a API](https://github.com/rtof83/ecommerce-java-react/blob/main/web/src/api.js);

&nbsp;

### a aplicação pode ser acessada através do link:
- http://ecomm-mysql-java.s3-website-us-east-1.amazonaws.com
    - FRONT armazenado em instância Amazon S3;
    - API e Banco de Dados instanciados em EC2 AWS:
        - http://34.235.154.60:8080;

&nbsp;

### Implementações API:
- [Collections Postman](https://github.com/rtof83/ecommerce-java-react/blob/main/samples/ecommerce.postman_collection.json);
- [Swagger:](https://github.com/rtof83/ecommerce-java-react/blob/main/api/src/main/java/com/api/store/config/SwaggerConfig.java) {baseURL}/swagger-ui.html

&nbsp;

- Rotas de acesso:

    - POST
        - {baseURL}/customers/login -> retorna cliente por email e senha;
        - {baseURL}/customers/checkEmail -> verifica se email existe;
        - {baseURL}/customers -> cadastra cliente;
        - {baseURL}/products -> cadastra produto;
        - {baseURL}/orders -> cadastra pedido;

    - GET
        - {baseURL}/customers -> retorna todos os clientes;
        - {baseURL}/customers/{id} -> retorna cliente por id;

        - {baseURL}/products -> retorna todos os produtos;
        - {baseURL}/products/{id} -> retorna produto por id;

        - {baseURL}/orders -> retorna todos os pedidos;
        - {baseURL}/orders/{id} -> retorna pedido por id;

    - PUT
        - {baseURL}/customers/{id} -> atualiza cliente;
        - {baseURL}/products/{id} -> atualiza produto;

    - DELETE
        - {baseURL}/customers/{id} -> exclui cliente;
        - {baseURL}/products/{id} -> exclui produto;
        - {baseURL}/orders/{id} -> atualiza pedido;

&nbsp;

- Inserção de pedidos:
    - o total do pedido e a data e hora atual são inseridos através da API;
    - a quantidade de produtos é atualizada de forma automatizada (é verificado se a quantidade solicitada é igual ou menor que o estoque);

    &nbsp;

    #### exemplo de inserção de Clientes

    ```javascript
    {
        "name": "Test Client",
        "cpf": "99999999999",
        "email": "client@test.com",
        "address": "Test Street, 95",
        "phone": "(99) 99999-9999",
        "birth": "1999-01-01",
        "password": "123"
    }
    ```

    #### exemplo de inserção de Produtos

    ```javascript
    {
        "sku": "888",
        "name": "Product Test",
        "price": 99.9,
        "quantity": 30
    }
    ```

    #### exemplo de inserção de Pedidos

    ```javascript
    {
        "customerId": 3,
        "address": "Payment Street",
        "payment": "pix",
        "items": [
            {
                "quantity": 2,
                "sku": "888"
            },
            {
                "quantity": 2,
                "sku": "999ab"
            }
        ]
    }
    ```
&nbsp;

### Implementações FRONT:
- Cadastro, alteração e exclusão de Cliente;
- Cadastro, alteração e exclusão de Produto;
- Lista Clientes;
- Lista Produtos;
- Lista Pedidos;
- Carrinho;
- Login;

&nbsp;

### Próximos passos:
- Filtrar listagens;
- Localizar registros por campo;
- Utilizar localstorage (pedidos) concomitante ao ContextAPI;
- Lista pedidos detalhada;
- Validação dos campos;
- Refatoração;
