# 🚀 Momentum
Build today.

Become tomorrow.

> **Build habits. Build consistency. Build Momentum.**

Momentum is a modern full-stack habit tracking platform designed to help users build lasting habits through intuitive tracking, insightful analytics, and a clean user experience.

This project is being developed as a **production-ready software engineering portfolio project**, following industry-standard architecture, clean code principles, Git workflow, testing, documentation, and deployment practices.

---
## 🚀 Current Status

### Sprint 5 — Habit Management ✅ COMPLETED

- ✅ User Registration
- ✅ Secure Login (JWT)
- ✅ BCrypt Password Encryption
- ✅ JWT Authentication & Authorization
- ✅ Protected API Routes
- ✅ Habit Management Module
  - ✅ Create Habit
  - ✅ View All Habits
  - ✅ View Habit by ID
  - ✅ Update Habit
  - ✅ Delete Habit
- ✅ PostgreSQL Integration
- ✅ End-to-End API Testing (Postman)
---

## 📖 Table of Contents

* Why Momentum
* Features
* Tech Stack
* Project Architecture
* Project Structure
* Development Roadmap
* Getting Started
* API
* Sprint 2 Accomplishments
* Documentation
* Current Progress
* Future Enhancements
* Contributing
* License
* Author

---

# 🎯 Why Momentum?

Most habit trackers simply record completed habits.

Momentum focuses on **building consistency**, not just tracking.

The application is designed around four principles:

* 📈 Make progress visible
* 🔥 Reward consistency
* ⚡ Keep interactions fast
* 🎨 Deliver a clean, distraction-free experience

Alongside building a useful product, Momentum is also an opportunity to demonstrate professional software engineering practices.

---

# ✨ Features

## 🔐 Authentication

* User Registration
* Secure Login
* JWT Authentication
* Password Encryption (BCrypt)
* Role-Based Authorization

---

## ✅ Habit Management

* Create Habits
* Edit Habits
* Delete Habits
* Daily Habit Completion
* Habit Categories
* Custom Habit Frequency

---

## 📊 Dashboard

* Daily Overview
* Weekly Statistics
* Monthly Progress
* Completion Rate
* Streak Counter

---

## 📅 Visualization

* Calendar View
* GitHub-style Contribution Heatmap
* Progress Charts
* Activity Timeline

---

## 🏆 Productivity

* Achievement Badges
* Smart Insights
* Weekly Reports
* Habit Recommendations

---

## 🎨 User Experience

* Responsive Design
* Light Mode
* Dark Mode
* Mobile Friendly
* Beautiful Animations

---

# 🛠 Tech Stack

| Layer            | Technology                  |
| ---------------- | --------------------------- |
| Frontend         | React                       |
| Language         | TypeScript                  |
| Styling          | Tailwind CSS                |
| Backend          | Spring Boot                 |
| Language         | Java 21                     |
| ORM              | Spring Data JPA + Hibernate |
| Database         | PostgreSQL                  |
| Build Tool       | Maven                       |
| Validation       | Jakarta Validation          |
| API Testing      | Postman                     |
| Version Control  | Git + GitHub                |
| Containerization | Docker (Planned)            |

---

# 🏗 Project Architecture

```
                   React Frontend
                          │
                          │ HTTP REST API
                          ▼
                Spring Boot Backend
                          │
          ┌───────────────┴───────────────┐
          │                               │
     Business Logic                  Security
          │                               │
          ▼                               ▼
   Spring Data JPA                 JWT Authentication
          │
          ▼
      PostgreSQL Database
```

---

# 📂 Project Structure

```
Momentum
│
├── backend
│   ├── src
│   ├── pom.xml
│   └── ...
│
├── frontend
│
├── docs
│   ├── developer-journal.md
│   ├── roadmap.md
│   ├── architecture.md
│   └── api.md
│
├── database
│
├── docker
│
├── postman
│
├── screenshots
│
└── README.md
```

---

# 🗺 Development Roadmap

## ✅ Phase 1 — Foundation

* Environment Setup
* Spring Boot Backend
* PostgreSQL Integration
* Health Check API

---

## 🚧 Phase 2 — Core Backend
- ✅ User Module
- ✅ CRUD Operations
- ✅ DTO Architecture
- ✅ Request Validation
- ✅ Global Exception Handling
- ✅ BCrypt Password Encryption
- 🚧 Authentication
- 🚧 JWT Security
- Habit Module

---

## ⏳ Phase 3 — Frontend

* React Setup
* Authentication Pages
* Dashboard
* Habit Management
* Analytics

---

## 🎯 Phase 4 — Production

* Docker
* CI/CD
* Deployment
* API Documentation
* Unit Testing
* Integration Testing

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/maharshith1910/Momentum.git

cd Momentum
```

---

## Backend Setup

```bash
cd backend
```

### Create PostgreSQL Database

```
momentum_db
```

Configure

```
src/main/resources/application.properties
```

Example

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/momentum_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

### Run Backend

Windows

```bash
mvnw.cmd spring-boot:run
```

Linux/macOS

```bash
./mvnw spring-boot:run
```

Backend runs at

```
http://localhost:8080
```

---

# 📡 API

## Current Endpoints

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| POST   | `/api/users`      | Create User    |
| GET    | `/api/users`      | Get All Users  |
| GET    | `/api/users/{id}` | Get User By ID |
| PUT    | `/api/users/{id}` | Update User    |
| DELETE | `/api/users/{id}` | Delete User    |

---

## Example Response

```json
[
  {
    "id": 1,
    "username": "maharshith",
    "email": "maharshith@gmail.com",
    "createdAt": "2026-06-28T14:11:07"
  }
]
```

---

# 🎉 Sprint 2 Accomplishments

Implemented a production-style User Management REST API using Spring Boot.

### Backend Features Completed

* Layered Architecture
* Spring Boot REST APIs
* Spring Data JPA
* PostgreSQL Integration
* CRUD Operations
* DTO Pattern
* Request Validation
* Global Exception Handling
* ResponseEntity
* RESTful HTTP Status Codes
* Clean API Responses
* Password Hidden from Responses

---

# 📚 Documentation

Documentation is available inside the **docs** directory.

* 📖 Developer Journal
* 🗺 Roadmap
* 🏗 Architecture
* 📡 API Documentation

---

## Sprint Progress

- ✅ Sprint 0 – Environment Setup
- ✅ Sprint 1 – Backend Initialization
- ✅ Sprint 2 – User Module
- ✅ Sprint 3 – Application Security Foundation
- ✅ Sprint 4 – JWT Authentication
- ✅ Sprint 5 – JWT Authorization & Protected APIs
- ✅ Sprint 6 – Habit Management Module
- ✅ Sprint 7 – Streak Engine & Habit Completion History
- ✅ Sprint 8 – Analytics Module
- ✅ Sprint 9 – Reminder & Notification Engine
- 🚧 Sprint 10 – Achievement & Badge System


---

# 📸 Screenshots

Coming soon...

* Login Page
* Dashboard
* Habit Management
* Analytics
* Contribution Heatmap

---

# 🌟 Future Enhancements

* AI Habit Insights
* Email Notifications
* Progressive Web App (PWA)
* Mobile Application
* OAuth Login
* Social Features
* Habit Sharing
* Leaderboards

---

# 🤝 Contributing

Contributions are welcome.

As the project evolves, contribution guidelines will be available inside **CONTRIBUTING.md**.

---

# 📜 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

**Maharshith Narsapuram**

Momentum is being developed as a long-term software engineering portfolio project to demonstrate:

* Full-Stack Development
* Backend Architecture
* REST APIs
* Database Design
* Authentication & Authorization
* Testing
* Docker
* CI/CD
* Deployment
* Software Engineering Best Practices

---

> **"Small habits, repeated consistently, create extraordinary results."**
