# 🏗️ Momentum Architecture

This document describes the high-level architecture of Momentum and how different components communicate with each other.

---

# Architecture Overview

Momentum follows a modern three-tier architecture.

```text
                ┌────────────────────┐
                │    React Frontend  │
                └─────────┬──────────┘
                          │
                     HTTP / REST API
                          │
                          ▼
                ┌────────────────────┐
                │ Spring Boot Backend│
                └─────────┬──────────┘
                          │
                  Spring Data JPA
                          │
                          ▼
                ┌────────────────────┐
                │    PostgreSQL      │
                └────────────────────┘
```

---

# Backend Architecture

The backend follows a layered architecture.

```text
HTTP Request
      │
      ▼
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
Database
```

Each layer has a single responsibility.

---

# Layer Responsibilities

## Controller

Responsible for:

- Receiving HTTP requests
- Validating request input
- Calling the appropriate service
- Returning HTTP responses

Controllers should **not** contain business logic.

---

## Service

Responsible for:

- Business rules
- Application logic
- Data processing
- Coordinating repositories

Most application logic belongs here.

---

## Repository

Responsible for:

- Reading data
- Writing data
- Updating records
- Deleting records

Repositories communicate directly with PostgreSQL using Spring Data JPA.

---

## Database

PostgreSQL stores all application data including:

- Users
- Habits
- Habit completions
- Streaks
- Statistics

---

# Current Architecture

Current implementation:

```text
Browser
    │
GET /api/health
    │
    ▼
HealthController
    │
Returns
"Momentum Backend is Running 🚀"
```

---

# Planned Request Flow

Once the User module is implemented:

```text
Browser
    │
POST /api/users
    │
    ▼
UserController
    │
    ▼
UserService
    │
    ▼
UserRepository
    │
    ▼
PostgreSQL
```

---

# Technology Stack

| Layer | Technology |
|--------|------------|
| Frontend | React |
| Language | TypeScript |
| Backend | Spring Boot |
| ORM | Spring Data JPA + Hibernate |
| Database | PostgreSQL |
| Build Tool | Maven |
| Version Control | Git |

---

# Design Principles

Momentum follows these engineering principles:

- Separation of Concerns
- Layered Architecture
- RESTful API Design
- Clean Code
- Single Responsibility Principle
- Dependency Injection
- Documentation First

---

# Future Enhancements

The architecture will evolve to include:

- JWT Authentication
- Spring Security
- Docker
- Redis (optional)
- CI/CD Pipeline
- Cloud Deployment
- API Documentation with Swagger