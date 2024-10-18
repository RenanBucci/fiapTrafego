# Gerenciamento de Tráfego

Este projeto é uma aplicação Spring Boot para gerenciamento de semáforos. Ele utiliza um banco de dados Oracle e é containerizado com Docker.

## Pré-requisitos

- Java 17
- Maven
- Docker
- Docker Compose

## Configuração do Banco de Dados

A aplicação utiliza um banco de dados Oracle. Certifique-se de que as credenciais e a URL do banco de dados estão corretas no arquivo `application.properties`.

```ini
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=RM98467
spring.datasource.password=040500


Inicialização do Projeto
1. Clonar o Repositório

git clone https://github.com/SeuUsuario/gerenciamento-de-trafego.git
cd gerenciamento-de-trafego

2. Compilar o Projeto

mvn clean install

3. Construir a Imagem Docker

docker build -t gerenciamento-de-trafego .

4.Executar com Docker Compose

docker-compose up --build

5. Acessar a Aplicação
A aplicação estará disponível em http://localhost:8080.  
Pipeline de CI/CD
Este projeto utiliza GitHub Actions para CI/CD. O pipeline está configurado no arquivo .github/workflows/ci-cd-pipeline.yml. 

Configuração de Segredos
Adicione os seguintes segredos no repositório do GitHub:  
DOCKER_HUB_USERNAME
DOCKER_HUB_PASSWORD
Estrutura do Projeto
src/main/java: Código fonte da aplicação
src/main/resources: Recursos da aplicação, incluindo application.properties
src/main/resources/db/migration: Scripts de migração do Flyway
Dockerfile: Arquivo de configuração do Docker
docker-compose.yml: Arquivo de configuração do Docker Compose
