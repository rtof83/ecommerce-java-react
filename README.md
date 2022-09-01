# Projeto Ecommerce

## Foi utilizado para contrução:
- `API -> Java (11) / Spring Boot 2.7.3`;
- `FRONT -> React`;
- `DB -> MySQL`;
- `Ferramentas:`
    - `IntelliJ IDEA 2022.2.1 (Community Edition)`;
    - `Visual Studio Code 1.7.0.2`;
    - `Console de Gerenciamento da AWS`;

## Estrutura da base de dados:
- [database.sql](https://github.com/rtof83/ecommerce-java-react/blob/main/samples/database.sql);


## Instalação
- `MySQL -> CREATE DATABASE database`;
- `/api -> mvn clean package`;
- `/web -> npm install`;

## Inicialização
- `/api -> java -jar target/springboot-store-backend-0.0.1-SNAPSHOT.jar`;
- `/web -> npm start`;
- `porta padrão: 8080`;
- `usuário padrão para acesso ao front:`
    - `email: admin`;
    - `password: admin`;

## Configurações
- [API - conexão com a base de dados](https://github.com/rtof83/ecommerce-java-react/blob/main/api/src/main/resources/application.properties);
- [FRONT - conexão com a API](https://github.com/rtof83/ecommerce-java-react/blob/main/web/src/api.js);

### a aplicação pode ser acessada através do link:
- http://ecomm-teste.s3-website-us-east-1.amazonaws.com/
    - `FRONT armazenado em instância Amazon S3`;
    - `Banco de Dados instanciado no AWS RDS:`
        - database.c1pcbwgspp7k.us-east-1.rds.amazonaws.com:3306;
    - `API instanciada em EC2 AWS:`
        - http://3.231.26.124:8080;

### Implementações API:
- [Collections Postman](https://github.com/rtof83/ecommerce-java-react/blob/main/samples/ecommerce.postman_collection.json);
- `Rotas de acesso (para os métodos GET, POST, DELETE E PUT):`
    - `{baseURL}/api/customers -> retorna, cria, atualiza, exclui clientes`;
    - `{baseURL}/api/products -> retorna, cria, atualiza, exclui produtos`;
- `Rotas de acesso (para os métodos GET, POST E DELETE):`
    - `{baseURL}/orders -> retorna, cria e exclui pedidos`;
- `Rotas de busca:`
    - `{baseURL}/api/{rota}/:id -> retorna registro por ID`;
    - `{baseURL}/api/products/sku -> retorna produto por sku`;
- `após inserção de pedidos, a quantidade de produtos é atualizada (é verificado se quantidade solicitada é igual ou menor que o estoque)`;

### Implementações FRONT:
- `Cadastro, alteração e exclusão de Cliente`;
- `Cadastro, alteração e exclusão de Produto`;
- `Lista Clientes`;
- `Lista Produtos`;
- `Lista Pedidos`;
- `Carrinho`;
- `Login`;

### Próximos passos:
- `Filtrar listagens`;
- `Localizar registros por campo`;
- `Utilizar localstorage (pedidos) concomitante ao ContextAPI`;
- `Lista pedidos detalhada`;
- `Validação dos campos`;
- `Refatoração`;
