# stockmanagement

# Descrição:


# Ferramentas:

Spring Tool Suite 4
Robo 3T

# Tecnologias:

JDK 1.8+
Spring Boot
Spring MVC
MongoDB
Maven
Git
Thymeleaf

# Clonar e importar projeto

# Visão geral das funcionalidades

# Teste das funcionalidades


# Carga inicial de dados para teste:

db.fornecedores.insert(
    [
        {"identificador": "2001", "nome":"Apple"}, {"identificador": "2002", "nome":"Britania"},
        {"identificador": "2003", "nome":"Samsung"}, {"identificador": "2004", "nome":"Aragao"},
        {"identificador": "2005", "nome":"Consul"}
    ]
)
         
db.produtos.insert(
    [ {identificador: "1001", nome: "Sabonete", 
         categoria: {  identificador: "9993", nome: "Higiene" },
         fornecedor: { identificador: "9994", nome: "Protex" },
         estoque: { identificador: "1001", codigo: "AS45234FGR55H7", quantidade: "150", minimo: "50", maximo: "700" } }
    ]
)