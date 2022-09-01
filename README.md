# Projeto Ecommerce

## Foi utilizado para contrução:
- `Java (11) / SpringBoot (API)`;
- `React (FRONT)`;
- `base de dados MySQL`;

## Estrutura da base de dados:
- arquivo sql

## Instalação
- `/api -> mvn clean package`;
- `/web -> npm install`

## Inicialização
- `/api -> java -jar target/springboot-store-backend-0.0.1-SNAPSHOT.jar`;
- `/web -> npm start`;

## Configurações
- [API - conexão com a base de dados](https://github.com/rtof83/ecommerce/blob/main/api/database/conn.js);
- [FRONT - conexão com a API](https://github.com/rtof83/ecommerce/blob/main/web/src/api.js);

### a aplicação pode ser acessada através do link:
- http://enafood.s3-website.us-east-2.amazonaws.com
- `FRONT armazenado em instância Amazon S3`;
- `API instanciada em EC2 AWS (http://44.197.170.12:3001/)`;

### Implementações API:
- `Utilização de models mongoose para Clientes, Produtos e Pedidos`;
- `Rotas de acesso (para os métodos GET, POST, DELETE E PATCH):`;
    - `{baseURL}/customer -> retorna, atualiza, exclui clientes`;
    - `{baseURL}/product -> retorna, atualiza, exclui produtos`;
    - `{baseURL}/order -> retorna, atualiza, exclui pedidos`;
    - `{baseURL}/{rota}/:id -> retorna registro por ID`;
- `após inserção de pedidos, a quantidade de produtos é atualizada`;

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
