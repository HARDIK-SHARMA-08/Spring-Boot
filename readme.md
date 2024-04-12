# 🍃 Spring Boot

This repository is aimed at providing a comprehensive introduction to **Spring Boot**, particularly focusing on three main aspects: **basic Spring Boot concepts**, building **REST APIs**, and **integrating with a database using Spring Data JPA**.

## Explanation of Spring Concepts

- **Spring Beans:**
  - Objects managed by Spring IoC container.
  - Core building blocks of a Spring application.
  - Configured with metadata supplied to the container.
  - Typically Java objects.

- **Spring Profiles:**
  - Segregate parts of application configuration.
  - Available only in specific environments.
  - Enable different configurations for development, testing, production, etc.
  - Control which beans are loaded and which configurations are applied.

- **Qualifiers:**
  - Resolve ambiguity when multiple beans of the same type are available.
  - Used with `@Qualifier` annotation.
  - Specify which bean should be autowired into a particular field or parameter.
  - Useful when multiple beans implement the same interface or are of the same type.

## Folder Structure

```
project/
│
├── demo/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com.example.demo/
│   │   │   │   │   └── ...
│   │   │   └── resources/
│   │   │       └── ...
│   │   └── test/
│   │       └── ...
│   └── pom.xml
│
├── rest/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com.example.rest/
│   │   │   │   │   └── ...
│   │   │   └── resources/
│   │   │       └── ...
│   │   └── test/
│   │       └── ...
│   └── pom.xml
│
└── rest_database/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   ├── com.example.rest_database/
    │   │   │   │   ├── students/
    │   │   │   │   │   ├── controller/
    │   │   │   │   │   ├── mapper/
    │   │   │   │   │   ├── response/
    │   │   │   │   │   ├── dto/
    │   │   │   │   │   ├── repository/
    │   │   │   │   │   └── service/
    │   │   │   │   ├── studentProfile/
    │   │   │   │   │   ├── controller/
    │   │   │   │   │   ├── mapper/
    │   │   │   │   │   ├── response/
    │   │   │   │   │   ├── dto/
    │   │   │   │   │   ├── repository/
    │   │   │   │   │   └── service/
    │   │   │   │   ├── School/
    │   │   │   │       ├── controller/
    │   │   │   │       ├── mapper/
    │   │   │   │       ├── response/
    │   │   │   │       ├── dto/
    │   │   │   │       ├── repository/
    │   │   │   │       └── service/
    │   │   │   └── ...
    │   │   └── resources/
    │   │       └── ...
    │   └── test/
    │       └── ...
    └── pom.xml
```

The project is organized into three main folders:

1. **demo**: Basic Spring Boot concepts are covered in this folder including Spring Beans, Qualifier, Spring Profiles, Dependency Injection, and creating the first class and service.

2. **rest**: This folder covers the basics of building REST APIs with Spring Boot. It includes creating the first controller using `@RestController`, and utilizing `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping`. Path variables and request parameters are also demonstrated, along with creating the first record.

3. **rest_database**: This folder focuses on integrating Spring Boot with a database using Spring Data JPA. Notably, the `application.properties` file is updated to `application.yaml` to configure the database connection. Below is the configuration explained:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: qwerty123
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
    database: postgresql
    database-platform: org.hibernate.dialect.PostgresSQLDialect
```

## Explanation of Configuration

- **Datasource Configuration**: Specifies the URL, username, password, and driver class for connecting to the PostgreSQL database.
- **JPA Configuration**: Configures Hibernate behavior, including DDL auto, SQL logging, and database dialect.

## Package Structure for rest_database

In each of the `students`, `studentProfile`, and `School` packages within the `rest_database` folder, the following components are created:

- **Controller**: Defines endpoints for handling HTTP requests.
- **Mapper**: Converts between DTOs (Data Transfer Objects) and domain objects.
- **Response**: Defines response structures for API endpoints.
- **DTO**: Data Transfer Objects representing the data exchanged between the client and server.
- **Repository**: Interfaces defining methods for interacting with the database.
- **Service**: Implements business logic and interacts with repositories.

This structure helps in maintaining a clean and organized codebase, following the principles of separation of concerns and modularity.