# Sistema de Controle de Assinaturas de Aplicativos (SCAA)

Este projeto desenvolve um sistema de controle de assinaturas de aplicativos (SCAA), utilizando uma arquitetura CLEAN + DDD. Para melhorar a performance, foi implementado um microsserviço de cache chamado `AssCache`.

## Estrutura do Projeto

O projeto está dividido em cinco principais componentes:

1. **NameServer (Eureka Server)**: Serviço de registro e descoberta.
2. **SCAA (Sistema de Controle de Assinaturas de Aplicativos)**: O backend monolito que gerencia as assinaturas.
3. **AssCache**: Microsserviço responsável por cachear as consultas de validade das assinaturas.
4. **Gateway**: Serve como um ponto de entrada unificado para os clientes, roteando as requisições para os serviços apropriados.
5. **RabbitMQ**: Broker de mensagens utilizado para comunicação entre os serviços.

## Pré-requisitos

Para rodar este projeto, você vai precisar ter instalado:

- Docker

## Comando para iniciar

- Na raiz do projeto execute:

    ```
    docker-compose up
    ```
