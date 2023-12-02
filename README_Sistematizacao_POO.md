
# README para o Projeto "Sistematização-POO"

## Visão Geral
Este documento fornece instruções para a configuração e execução do projeto "Sistematização-POO", uma aplicação Java desenvolvida com Programação Orientada a Objetos (POO) e destinada a ser executada em um servidor Tomcat.

## Pré-requisitos
Antes de iniciar, certifique-se de que os seguintes pré-requisitos estão atendidos:
- Java JDK instalado.
- Servidor Tomcat configurado.
- Acesso a um banco de dados relacional (por exemplo, MySQL, PostgreSQL).
- Java Persistence API (JPA) para o gerenciamento de dados.
- Java Web para desenvolvimento de aplicações web.

## Configuração do Banco de Dados
Para funcionar corretamente, é necessário configurar o arquivo `application.properties` com os dados do seu banco de dados. Siga estas etapas:

1. **Localize o Arquivo**: O arquivo `application.properties` está na pasta de recursos do projeto (`src/main/resources`).

2. **Edite as Propriedades do Banco de Dados**: Modifique as propriedades com as informações do seu banco de dados, como URL, nome de usuário e senha.

3. **Salve as Alterações**: Após a edição, salve o arquivo.

## Testando as Requisições
Para testar as requisições da aplicação, você pode usar ferramentas como o Postman ou o APIdog. Estas ferramentas permitem que você envie requisições HTTP para a aplicação e veja as respostas, facilitando a verificação e o debug do funcionamento das APIs.

## Executando o Projeto
Com o banco de dados configurado, execute o projeto no servidor Tomcat seguindo as instruções do seu ambiente de desenvolvimento.

## Suporte
Em caso de dúvidas ou problemas, consulte a documentação do projeto ou entre em contato com a equipe de suporte.

---

Esta README inclui as diretrizes essenciais para a configuração e teste do projeto "Sistematização-POO". A correta configuração do arquivo `application.properties` é essencial para a conexão com o banco de dados e o funcionamento da aplicação no servidor Tomcat. Ferramentas como o Postman ou o APIdog são recomendadas para testar as requisições da API.
