# Momentum Developer Journal

This journal dcuments the development journey of Momentum
 
---

# Sprint 0 - Environment Setup

## Objective

Set up the complete development environment required for the project.

## Completed

-Installed Git
-Installed Java 21 (Temurin)
-Installed Maven
-Installed Node.js
-Installed PostgreSQL 18
-Installed Docker Desktop
-Installed  IntelliJ IDEA Community
-Installed  VS Code
-Installed Postman

## Challenged Faced

### Java not recognized

Problem : 

---
'java' is not recognized as an internal or external command
---

Solution:

-Installed Temurin JDK 21
-Configured PATH correctly
-Verified using : 

```
java -version
javac -cersion
```

### PostgreSQL PATH issue

Problem: 
```
psql is not recognized
```

Solution : 
Used the PostgreQL installation path and later configured PATH correctly

---

## Lessons Learned

- What JAVA_HOME is
- Difference between JDK and JRE
- Basic Git Workflow
- Importance of settung up the environment correctly

---

# Sprint 1 - Backend Initialization

## Objective

Create the Spring Boot backend and connect it to PostgreSQL

## Completed

- Created Spring Boot project
- Added required dependencies
- Configured PostgreSQL
- Connected Spring Boot to the database
- Started embedded Tomcat
- Created first REST API

### Endpoint

GET `/api/health`

Response : 

```
Momentum Backend is Running
```

## Challenges Faced

### DataSource configuration failed

Problem : 

```
Failed to configure a DataSource
```

Cause : 

Database connection properties were missing.

Solution:
- Created 'momentum_db'
- Configured 'application.properties'
- Connected PostgreSQL successfully

---

## Lessons Learned

- What Spring Boot is
- What Maven does
- What Controllers are
- What REST APIs are
- What Hibernate does
- How Spring Boot connects to PostgreSQL
- How to read Spring Boot startup logs

---

Next Sprint:
 - User Entity
 - Repository
 - Service Layer
 - Save first user into PostgreSQL
