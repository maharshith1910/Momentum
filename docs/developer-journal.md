# Momentum Developer Journal

This journal documents the development journey of Momentum.

---

# Sprint 0 - Environment Setup

## Objective

Set up the complete development environment required for the project.

## Completed

* Installed Git
* Installed Java 21 (Temurin)
* Installed Maven
* Installed Node.js
* Installed PostgreSQL 18
* Installed Docker Desktop
* Installed IntelliJ IDEA Community
* Installed VS Code
* Installed Postman

## Challenges Faced

### Java not recognized

Problem:

```
'java' is not recognized as an internal or external command
```

Solution:

* Installed Temurin JDK 21
* Configured PATH correctly
* Verified using

```bash
java -version
javac -version
```

### PostgreSQL PATH issue

Problem:

```
psql is not recognized
```

Solution:

* Used the PostgreSQL installation path
* Configured PATH correctly

---

## Lessons Learned

* What JAVA_HOME is
* Difference between JDK and JRE
* Basic Git workflow
* Importance of setting up the environment correctly

---

# Sprint 1 - Backend Initialization

## Objective

Create the Spring Boot backend and connect it to PostgreSQL.

## Completed

* Created Spring Boot project
* Added required dependencies
* Configured PostgreSQL
* Connected Spring Boot to the database
* Started embedded Tomcat
* Created first REST API

### Endpoint

GET `/api/health`

Response

```
Momentum Backend is Running
```

## Challenges Faced

### DataSource configuration failed

Problem:

```
Failed to configure a DataSource
```

Cause:

Database connection properties were missing.

Solution:

* Created `momentum_db`
* Configured `application.properties`
* Connected PostgreSQL successfully

---

## Lessons Learned

* What Spring Boot is
* What Maven does
* What Controllers are
* What REST APIs are
* What Hibernate does
* How Spring Boot connects to PostgreSQL
* How to read Spring Boot startup logs

---

# Sprint 2 - User Module

## Objective

Implement the complete User module following a layered Spring Boot architecture.

## Completed

### Backend Architecture

* Created User Entity
* Created User Repository
* Created User Service
* Created User Controller
* Connected Entity with PostgreSQL using Spring Data JPA

### CRUD Operations

Implemented the following REST APIs:

* POST `/api/users`
* GET `/api/users`
* GET `/api/users/{id}`
* PUT `/api/users/{id}`
* DELETE `/api/users/{id}`

### DTO Pattern

Implemented:

* UserRequestDTO
* UserResponseDTO

Separated request/response models from the database entity.

Passwords are now stored in the database but are never returned through API responses.

### Validation

Added request validation using Jakarta Validation.

Implemented validations for:

* Username
* Email
* Password

Used `@Valid` to automatically validate incoming requests.

### Exception Handling

Implemented a Global Exception Handler using `@RestControllerAdvice`.

Validation errors now return clean JSON responses instead of the default Spring Boot error page.

### ResponseEntity

Implemented proper HTTP response codes.

Examples:

* 201 Created
* 200 OK
* 400 Bad Request

---

## Challenges Faced

### Port already in use

Problem:

```
Port 8080 was already in use.
```

Solution:

* Stopped the existing Spring Boot process
* Restarted the application

### DTO migration

Initially returned Entity objects directly from the Controller.

This exposed passwords in API responses.

Solution:

* Introduced Request DTOs
* Introduced Response DTOs
* Added mapping methods inside the Service layer

### Generic type mismatches

Encountered multiple errors involving:

* Optional<User>
* Optional<UserResponseDTO>
* List<User>
* List<UserResponseDTO>

Solution:

Updated both the Controller and Service layers to consistently return DTOs.

### Validation configuration

Validation annotations were initially ignored.

Solution:

* Added Spring Boot Validation dependency
* Used `@Valid`
* Implemented a Global Exception Handler

---

## Lessons Learned

* Layered Architecture
* Spring Data JPA
* Dependency Injection
* CRUD Operations
* DTO Pattern
* Request Validation
* Global Exception Handling
* ResponseEntity
* HTTP Status Codes
* REST API design
* Difference between Entity and DTO
* Why sensitive fields should never be returned through API responses

---

Next Sprint:

* Password Encryption using BCrypt
* Spring Security
* User Authentication
* JWT Token Generation
* Login API
* Protected Routes
* Authorization
