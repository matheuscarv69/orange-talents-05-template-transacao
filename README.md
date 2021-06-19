# 🚀 Microservice de Transação 💳

Este projeto é um desafio proposto pela time da Zup Academy para a turma do Orange Talents 5.

[![GitHub stars](https://img.shields.io/github/stars/matheuscarv69/orange-talents-05-template-transacao?color=orange)](https://github.com/matheuscarv69/orange-talents-05-template-transacao/stargazers)
![Maven Central with version prefix filter](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven/3.6.3?color=orange)
![GitHub](https://img.shields.io/github/license/matheuscarv69/orange-talents-05-template-transacao?color=orange)

## 🤔 O que é o Microservice de Transação?

Ele é um serviço que é responsável por pegar as informações de compras do sistema legado de transações por meio do
Kafka, isso é feito usando alguns módulos do Spring Boot.

Basicamente o fluxo principal desse serviço é:

- Um Listener fica escutando um tópico do serviço legado de transações e pega os eventos/mensagens desse tópico e salva
  na base de dados.
- Para isso acontecer o sistema legado deve receber um incetivo, isso se dá através de uma requisição semelhante à essa:
  ```bash
  curl --location --request POST 'http://localhost:7777/api/cartoes' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "id": "<NÚMERO DO CARTÃO>",
    "email": "<EMAIL DO USUÁRIO LOGADO>"
  }'
  ```
- A partir daí o Sistema legado passaá a enviar mensagens com a transação para o kafka a cada 1 minuto (no docker-compose tem como aumenta ou diminuir esse intervalo por meio de uma variável de ambiente no serviço Transacao).
- Para fazer com que essas mensagens parem de ser geradas, o sistema legado deve receber um incentivo também, ele se dá por meio de outra requisição semelhante à essa:
  ```bash
  curl --location --request DELETE 'http://localhost:7777/api/cartoes/5541da9c-79c5-44fb-b701-cc50ed07b45d'
  ```
- É disponibilizado um endpoint para que o usuário autenticado possa listar as compras efetuadas pelo seu cartão.
- Todos esses endpoints já estão disponibilizados via [Insomnia](https://insomnia.rest/).
- 
## 🛠 Pré-Requisitos

### 📍 Local

Antes de começar a mexer no código você precisa ter instalado em sua máquina as seguintes ferramentas:

Essas são as ferramentas básicas, porém não irá conseguir rodar a aplicação somente com isso, pois ela se integra à
alguns serviços externos, esses descritos no Docker-compose do projeto.

- [Java JDK 11+](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.6.3](https://maven.apache.org/download.cgi)

### 🐳 Docker

Este projeto conta com um **docker-compose**, inclusive a própria imagem da aplicação já está configurada para ser
executada no docker. Os requisitos para isso são:

- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker-compose](https://docs.docker.com/compose/install/)

## 🎲 Executando a API com o docker-compose
Com esse repositório já clonado em sua máquina e com todos os pré-requisitos atendidos.

1. Você deve ir até a raiz do projeto onde o arquivo **docker-compose.yml** está.
2. Deve abrir um terminal na raiz do projeto.
3. Agora certifique-se que o seu Docker já está em execução.
4. Execute o seguinte comando no terminal:

```bash
docker-compose up -d
```

5. Com isso sua aplicação já está em execução

## 📝Fazendo requisições - Insomnia

Esse serviço tem alguns endpoints que estão configurados no aplicativo **Insomnia**, clicando no botão abaixo você pode
baixar o workspace de requests utilizados nesse projeto.
<br/>
<br/>
[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=microsservice%20-%20transacao&uri=https%3A%2F%2Fgist.githubusercontent.com%2Fmatheuscarv69%2F350586c06c4d98e21c92a98f660df762%2Fraw%2Fb3e89034de6fe247e99c9b61dfd12acb3a126606%2Fmicroservice-transacao.yaml)

## 🐳 Docker Hub 📦

Essa aplicação está disponibilizada no Docker Hub:

[Api-transação](https://hub.docker.com/repository/docker/matheuscarv69/api-transacao)

## 🚀 Tecnologias 👩‍🚀

As seguintes tecnologias foram utilizadas e/ou utilizadas no desenvolvimento do projeto.

- Spring Boot 2.3.11
    - Data JPA
    - Security OAuth2
    - Validation
- Prometheus
- Postgres
- Keycloak

## 👨🏻‍💻 Autor

<br>
<a href="https://github.com/matheuscarv69">
 <img style="border-radius: 35%;" src="https://avatars1.githubusercontent.com/u/55814214?s=460&u=ffb1e928527a55f53df6e0d323c2fd7ba92fe0c3&v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Matheus Carvalho</b></sub></a> <a href="https://github.com/matheuscarv69" title="Matheus Carvalho">🚀</a>

Feito por Matheus Carvalho, entre em contato!✌🏻
 <p align="left">
    <a href="mailto:matheus9126@gmail.com" alt="Gmail" target="_blank">
      <img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white&link=mailto:matheus9126@gmail.com"/></a>
    <a href="https://www.linkedin.com/in/matheus-carvalho69/" alt="Linkedin" target="_blank">
        <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white&link=https://www.linkedin.com/in/matheus-carvalho69/"/></a>  
    <a href="https://www.instagram.com/_mmcarvalho/" alt="Instagram" target="_blank">
      <img src="https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white&link=https://www.instagram.com/_mmcarvalho/"/></a>  
  </p>

## 📝 Licença
Este projeto esta sob a licença Apache-2.0 .
