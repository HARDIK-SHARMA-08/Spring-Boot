# 🍃 Spring Boot

This repository is aimed at providing a comprehensive introduction to **Spring Boot**, particularly focusing on three main aspects: **basic Spring Boot concepts**, building **REST APIs**, and **integrating with a database using Spring Data JPA**.

## 📝 Explanation of Spring Concepts

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

## 📂 Folder Structure

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

1. 📁 **demo**: Basic Spring Boot concepts are covered in this folder including Spring Beans, Qualifier, Spring Profiles, Dependency Injection, and creating the first class and service.

2. 📁 **rest**: This folder covers the basics of building REST APIs with Spring Boot. It includes creating the first controller using `@RestController`, and utilizing `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping`. Path variables and request parameters are also demonstrated, along with creating the first record.

3. 📁 **rest_database**: This folder focuses on integrating Spring Boot with a database using Spring Data JPA. Notably, the `application.properties` file is updated to `application.yaml` to configure the database connection. Below is the configuration explained:

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

## 📁 Package Structure for rest_database

In each of the `students`, `studentProfile`, and `School` packages within the `rest_database` folder, the following components are created:

- **Controller**: Defines endpoints for handling HTTP requests.
- **Mapper**: Converts between DTOs (Data Transfer Objects) and domain objects.
- **Response**: Defines response structures for API endpoints.
- **DTO**: Data Transfer Objects representing the data exchanged between the client and server.
- **Repository**: Interfaces defining methods for interacting with the database.
- **Service**: Implements business logic and interacts with repositories.

This structure helps in maintaining a clean and organized codebase, following the principles of separation of concerns and modularity.

## ❌ Exception Handling & Validation

In the `rest_database` module, exception handling and validation are implemented to enhance the robustness and reliability of the REST API endpoints.

### Exception Handling

- Exception handling is crucial for handling errors and exceptions gracefully in a Spring Boot application.
- In the `controller` layer, exception handling is implemented using `@ControllerAdvice` and `@ExceptionHandler` annotations.
- Custom exception classes can be created to represent different types of errors that may occur during the execution of API endpoints.
- Global exception handlers catch exceptions thrown during request processing and return appropriate HTTP responses with error details.
- This ensures consistent error responses across all endpoints and improves the overall user experience.

### Validation

- Input validation is important for ensuring that the data sent to the API endpoints is valid and meets the required criteria.
- In the `studentDTO` layer, input validation is performed using annotations such as `@Valid` and `@Validated`.
- Bean validation annotations like `@NotBlank`, `@NotNull`, `@Size`, etc., are used to define validation rules for request parameters, request bodies, and path variables.
- If the incoming data fails validation, Spring Boot automatically detects the validation errors and returns appropriate error responses with details about the validation failures.
- This helps in preventing invalid data from being processed further, improving data integrity and API reliability.
