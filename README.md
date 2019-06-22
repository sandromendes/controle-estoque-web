# Descrição:

Este projeto é uma amostra simples de gerenciamento de estoques para fins de demonstração dos recursos do Spring Framework e utilização do banco de dados não-relacional MongoDB.
Ele conta com telas de cadatro de fornecedores, clientes, produtos e estoque, também comtempla a movimentação de vendas de produtos que acarretam na diminuição do estoque. 
Uma tela de adminsitração é outra funcionalidade para apoio de indicadores como, alertas de estoque mínimo e máximo de determinado produto, 
totalizadores de vendas por mês e por categoria de produtos e relatórios gerais com filtros personalizados.

Nas próximas versões serão entregues um controle de acesso, cadastramento de novos usuários e associações à perfis.

# Ferramentas:

* Spring Tool Suite 4
* Robo 3T

# Tecnologias:

* JDK 1.8+
* Spring Boot
* Spring MVC
* MongoDB
* Maven
* Git
* Thymeleaf

# Clonar e importar projeto

1. Na raiz do repositório do GitHub, clique em "clone or download" e copie o link
2. Abra o STS e crie um workspace
3. Na view Git Repositories, clique em "Clone a Git Repository"
4. Cole a URI copiada > "Next" > Escolha a branch master
5. Informe o diretório onde ficarão os repositórios locais e clique em "Finish"
6. Expanda o repositório e a Working Tree
7. Selecione projeto "controle-estoque-web", clique com o botão direito e depois em "Import Projects"
8. Selecione o projeto e clique em "Finish"

# Build

* mvn clean install

# Inicialização

* mvn cargo:run

Obs: Irá inicializar na porta '8082'

# Access the pages using the URLs:

* http://localhost:8080/produtos/listar
* http://localhost:8080/produtos/adicionarProduto
* http://localhost:8080/categoria/listar
* http://localhost:8080/categorias/adicionarCategoria
* http://localhost:8080/fornecedores/listar
* http://localhost:8080/fornecedores/adicionarFornecedor
* http://localhost:8080/inventarios/listar
* http://localhost:8080/clientes/listar
* http://localhost:8080/clientes/adicionarCliente

# Funcionalidades previstas

* Cadastro de produtos e categorias de produtos
* Cadastro de fornecedores e clientes
* Realização de venda e controle por itens vendidos
* Aplicação de desconto
* Realização de venda mediante quantidade em estoque
* Alertas de estoque mínimo e máximo atingidos
* Relatórios de acompanhamento de vendas
* Controle de usuários


