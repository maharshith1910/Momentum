# Momentum Developer Journal

This journal documents the development journey of Momentum.

---

# Sprint 0 - Environment Setup

## Objective

Set up the complete development environment required for the project.

## Completed

- Installed Git
- Installed Java 21 (Temurin)
- Installed Maven
- Installed Node.js
- Installed PostgreSQL 18
- Installed Docker Desktop
- Installed IntelliJ IDEA Community
- Installed VS Code
- Installed Postman

---

## Challenges Faced

### Java not recognized

**Problem**

```text
'java' is not recognized as an internal or external command
```

**Solution**

- Installed Temurin JDK 21
- Configured PATH correctly
- Verified installation using

```bash
java -version
javac -version
```

---

### PostgreSQL PATH issue

**Problem**

```text
psql is not recognized
```

**Solution**

- Located the PostgreSQL installation directory
- Added PostgreSQL to the system PATH
- Verified installation using `psql`

---

## Lessons Learned

- What JAVA_HOME is
- Difference between JDK and JRE
- Basic Git workflow
- Importance of correctly configuring the development environment

---

## Sprint Summary

Sprint 0 focused on preparing a professional development environment for the Momentum project. All required tools were installed and configured successfully, providing a stable foundation for backend and frontend development.

---

# Sprint 1 - Backend Initialization

## Objective

Create the Spring Boot backend and connect it to PostgreSQL.

## Completed

- Created Spring Boot project
- Added required dependencies
- Configured PostgreSQL
- Connected Spring Boot to the database
- Started embedded Tomcat
- Created the first REST API

### Endpoint

GET `/api/health`

**Response**

```text
Momentum Backend is Running
```

---

## Challenges Faced

### DataSource configuration failed

**Problem**

```text
Failed to configure a DataSource
```

**Cause**

Database connection properties were missing.

**Solution**

- Created the `momentum_db` database
- Configured `application.properties`
- Verified successful PostgreSQL connection

---

## Lessons Learned

- Spring Boot fundamentals
- Maven project structure
- REST Controllers
- Spring Data JPA basics
- Hibernate overview
- Spring Boot startup lifecycle
- Reading application startup logs

---

## Sprint Summary

Sprint 1 established the backend foundation by integrating Spring Boot with PostgreSQL and exposing the first REST endpoint. The project now had a working server capable of interacting with a relational database.

---

# Sprint 2 - User Module

## Objective

Implement a complete User module following a layered Spring Boot architecture.

## Completed

### Backend Architecture

- Created User Entity
- Created User Repository
- Created User Service
- Created User Controller
- Connected Entity with PostgreSQL using Spring Data JPA

### CRUD Operations

Implemented the following REST APIs:

- POST `/api/users`
- GET `/api/users`
- GET `/api/users/{id}`
- PUT `/api/users/{id}`
- DELETE `/api/users/{id}`

### DTO Pattern

Implemented:

- UserRequestDTO
- UserResponseDTO

Separated request and response models from the database entity.

Sensitive information such as passwords is no longer returned through API responses.

### Validation

Implemented request validation using Jakarta Validation.

Validation rules include:

- Username validation
- Email validation
- Password length validation

Used `@Valid` to validate incoming requests automatically.

### Global Exception Handling

Implemented a centralized exception handler using `@RestControllerAdvice`.

Validation errors now return structured JSON responses instead of the default Spring Boot error page.

### Proper HTTP Responses

Implemented appropriate HTTP status codes such as:

- 201 Created
- 200 OK
- 400 Bad Request

---

## Challenges Faced

### Port already in use

**Problem**

```text
Port 8080 was already in use.
```

**Solution**

- Terminated the running Spring Boot process
- Restarted the application

---

### DTO Migration

Initially returned Entity objects directly from the Controller.

This exposed sensitive information such as passwords.

**Solution**

- Introduced UserRequestDTO
- Introduced UserResponseDTO
- Added mapping methods inside the Service layer

---

### Generic Type Mismatches

Encountered issues involving:

- Optional<User>
- Optional<UserResponseDTO>
- List<User>
- List<UserResponseDTO>

**Solution**

Refactored both Controller and Service layers to consistently return DTOs.

---

### Validation Configuration

Validation annotations were initially ignored.

**Solution**

- Added Spring Boot Validation dependency
- Used `@Valid`
- Implemented a Global Exception Handler

---

## Lessons Learned

- Layered Architecture
- Spring Data JPA
- Dependency Injection
- CRUD Operations
- DTO Pattern
- Request Validation
- Global Exception Handling
- ResponseEntity
- HTTP Status Codes
- REST API Design
- Difference between Entity and DTO
- Why sensitive fields should never be exposed through APIs

---

## Sprint Summary

Sprint 2 transformed the project from a basic backend into a structured REST API following clean architecture principles. The application now exposes production-style CRUD endpoints while protecting internal database models through DTOs.

---

# Sprint 3 - Application Security Foundation

## Objective

Improve the security and robustness of the User module by implementing password encryption and establishing the foundation for authentication.

## Completed

- Configured Spring Security
- Created a PasswordEncoder Bean
- Integrated BCrypt password hashing
- Stored hashed passwords in PostgreSQL
- Secured password handling within the Service layer
- Continued using DTOs to prevent password exposure through API responses

---

## Challenges Faced

### Passwords stored in plain text

**Problem**

User passwords were being stored directly in the database.

**Cause**

Although a PasswordEncoder Bean had been configured, it was never used while creating users.

**Solution**

Injected `PasswordEncoder` into the Service layer and replaced

```java
user.setPassword(userRequestDTO.getPassword());
```

with

```java
user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
```

**Result**

Passwords are now stored as BCrypt hashes rather than plain text.

---

### Spring Security blocked API requests

**Problem**

All requests immediately returned HTTP 401 Unauthorized after adding Spring Security.

**Cause**

Spring Security protects every endpoint by default.

**Solution**

Created a custom `SecurityFilterChain` and temporarily permitted requests to `/api/users/**` while authentication is under development.

---

## Lessons Learned

- Spring Security fundamentals
- PasswordEncoder Bean
- BCrypt password hashing
- Dependency Injection
- One-way hashing versus reversible encryption
- Why passwords should never be stored in plain text
- Secure API design
- Basic SecurityFilterChain configuration

---

## Sprint Summary

Sprint 3 focused on securing the application before implementing authentication. User passwords are now encrypted using BCrypt and never exposed through the API or stored in plain text. This establishes a strong security foundation for implementing JWT-based authentication.

---

## Next Sprint

Sprint 4 will focus on authentication.

Planned work includes:

- User Login API
- Authentication Manager
- JWT Token Generation
- JWT Validation
- Protected Endpoints
- Authorization
- Logged-in User Context

---

**Project Status after Sprint 3**

- ✅ Environment Setup
- ✅ Spring Boot Backend
- ✅ PostgreSQL Integration
- ✅ User Module
- ✅ CRUD APIs
- ✅ DTO Architecture
- ✅ Request Validation
- ✅ Global Exception Handling
- ✅ BCrypt Password Encryption
- 🚧 Authentication
- 🚧 JWT Security
- ⏳ Habit Module
- ⏳ Frontend Development