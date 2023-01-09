
#Cadastro  simples de incidentes

#Sobre o projeto

A aplicação consiste em um cadastro simple de  que realiza operações REST onde possibilita a realização de cadadastro,atualização, remoção e consulta de incidentes.  

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
## Front end
- HTML
- CSS 
- JavaScript, Jquery, Ajax utilizados para realizar as requisições REST

# Como executar o projeto

## Back end
#Pré-requisitos: 
- Java 17
- Maven
- Variáveis de ambiente dos dois configuradas

```bash
# clonar repositório
git clone https://github.com/danilofranco1990/IncidentRest.git

# entrar na pasta do projeto 

# executar o projeto
./mvnw spring-boot:run
```
##Notas Adicionais
O sistema possui alguns campos somente leitura como: ID, updateAt. 
Esses campos são inseridos/Atualizados automaticamente.

# Autor

Danilo Lourenço Franco

