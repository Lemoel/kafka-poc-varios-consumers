# kafka-poc-varios-consumers - Kotlin

#### Projeto tem por objetivo apenas uma prova de conceito (POC) de groupID do Kafka. Verificar qual o comportamento 
#### que temos ao ter diversos consumidores e groupID diferente consumindo o mesmo tópico do Kafka.

### Vários consumidores de um único tópico do kafka com group id distintos.

## Technologies

- [Kotlin] - A modern JVM language
- [Spring Boot] - Makes it easy to create stand-alone, production-grade Spring based applications
- [JVM] - Virtual machine that enables a computer to run Java programs (or languages that are also compiled to Java
  bytecode)
- [Docker Compose] - Tool for running multi-container applications on Docker
- [Gradle] - Build automation tool for multi-language software development
- [Kafka Connect] - Apache Kafka is a community distributed event streaming technology capable of handling trillions of events a day

**Você não vai encontrar:** testes de integração nem testes unitário ou quais quer outros devido não ser
objetivo desta POC.

# Organização do projeto
- O projeto é composto de um publisher e 4 consumers.
- Dois consumidores pertencem a um grupoId `consumer-group-notification`
- Os outros 2 consumidores pertencem a outro groupId `consumer-group-financeiro`
- O único objetivo é publicar uma mensagem qualquer em um tópico do kafka, usando o publisher
e depois os consumidores consumirem, de forma que ocorra uma alternancia entre os consumidores 
dentro de cada grupo.
- Quando o grupoId `consumer-group-notification` for consumir um momento é o consumidor 1 na próxima mensagem 
é o consumidor 2;
- Da mesma forma no grupoId `consumer-group-financeiro` cada um consome uma mensagem de cada vez de forma alternada 
- Outra coisa a se observer é que quando um grupoId consome em nada interfere nas mensagens consumidas
do outro groupID. Assim mesmo que todas as mensagens do tópico tiverem sido consumidas por um grupo
quando o outro começar a consumir, iniciam da primeira mensagem.

# Pré requisitos
- docker
- docker-compose
- java 17
- kotlin

# Como rodar
- Para facilitar importe cada pasta como um módulo no intelijj;
- Dentro da pasta do publisher execute `$ docker-compose up`;
- Cada aplicação utiliza springboot, logo existe uma classe main em cada projeto;
- Execute cada uma das classes main, totalizando 5 aplicações rodando ao mesmo tempo;
- Depois disso execute o endpoint que esta no projeto `publisher` usando qualquer ferramenta para isso ou o curl como
abaixo;
- `$curl --location --request POST 'http://localhost:8080/order' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "code": "5",
  "productName": "Canjica Doce",
  "price": 10.00
  }'`;
- Isso vai publicar uma mensagem no tópico do kafka;
- Para verificar se a mensagem foi publicada corretamente pode usar a interface web que foi instalada
no script do docker-compose `http://localhost:9090/ui/docker-kafka-server/topic`
- Para entender os consumidores utilize breakpoint ou veja o console da aplicação;

[Kotlin]: <https://kotlinlang.org>

[Spring boot]: <https://spring.io/projects/spring-boot>

[Gradle]: <https://gradle.org>

[Docker Compose]: <https://github.com/docker/compose>

[JVM]: <https://docs.oracle.com/javase/specs/jvms/se15/html>

[Docker]: <https://www.docker.com>

[Kafka Connect]: <https://docs.confluent.io/platform/current/connect/index.html>