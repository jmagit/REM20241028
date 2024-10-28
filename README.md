# Curso de Spring para desarrollo de aplicaciones en Java

## Instalación

- [JDK](https://www.oracle.com/java/technologies/downloads/)
- [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2024-09/R/eclipse-jee-2024-09-R-win32-x86_64.zip)
  - Help > Eclipse Marketplace ... > [Spring Tools 4 (aka Spring Tool Suite 4)](https://marketplace.eclipse.org/content/spring-tools-4-aka-spring-tool-suite-4)
  - [Project Lombok](https://projectlombok.org/downloads/lombok.jar)
- [Spring Tools](https://spring.io/tools)

## Documentación

- <https://docs.spring.io/spring-framework/reference/>
- <https://docs.spring.io/spring-boot/docs/current/reference/html/>
- <https://docs.spring.io/spring-data/commons/docs/current/reference/html/>
- <https://docs.spring.io/spring-data/jpa/docs/current/reference/html/>
- <https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/>
- <https://docs.spring.io/spring-data/redis/docs/current/reference/html/>
- <https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#spring-web>
- <https://docs.spring.io/spring-data/rest/docs/current/reference/html/>
- <https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/#spring-cloud-loadbalancer>
- <https://docs.spring.io/spring-cloud-config/docs/current/reference/html/>
- <https://docs.spring.io/spring-security/reference/index.html>

## Ejemplos

- <https://github.com/spring-projects/spring-data-examples>
- <https://github.com/spring-projects/spring-data-rest-webmvc>
- <https://github.com/spring-projects/spring-hateoas-examples>

## Laboratorios

- [Working a Getting Started guide with STS](https://spring.io/guides/gs/sts)
- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot)
- [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa)
- [Creating a Multi Module Project](https://spring.io/guides/gs/multi-module)
- [Managing Transactions](https://spring.io/guides/gs/managing-transactions)

## Base de datos de ejemplos

- [Página principal Sakila](https://dev.mysql.com/doc/sakila/en/)
- [Diagrama de la BD Sakila](http://trifulcas.com/wp-content/uploads/2018/03/sakila-er.png)

## Paquetes Java

- <https://downloads.mysql.com/archives/get/p/3/file/mysql-connector-java-5.1.49.zip>  
- <https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.6.5.Final/hibernate-release-5.6.5.Final.zip/download>

## Docker

### Instalación Docker

- <https://learn.microsoft.com/es-es/windows/wsl/install>
- <https://docs.docker.com/desktop/install/windows-install/>

### Bases de datos

- docker run -d --name mysql-sakila -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 jamarton/mysql-sakila
- docker run -d --name mongodb -p 27017:27017 mongo
- docker run -d --name redis -p 6379:6379 -p 6380:8001 redis/redis-stack:latest

### Cliente de bases de datos

- [HeidiSQL](https://www.heidisql.com/)
