# 🚀 Momentum

> **Build habits. Build consistency. Build Momentum.**

Momentum is a modern full-stack habit tracking platform designed to help users build lasting habits through intuitive tracking, insightful analytics, and a clean user experience.

This project is being developed as a **production-ready software engineering portfolio project**, following industry-standard architecture, documentation, Git workflow, testing, and deployment practices.

---

## 📖 Table of Contents

- [Why Momentum?](#-why-momentum)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Architecture](#-project-architecture)
- [Project Structure](#-project-structure)
- [Development Roadmap](#-development-roadmap)
- [Getting Started](#-getting-started)
- [API](#-api)
- [Documentation](#-documentation)
- [Current Progress](#-current-progress)
- [Author](#-author)

---

# 🎯 Why Momentum?

Most habit trackers simply record completed habits.

Momentum focuses on **building consistency**.

The application is designed around four principles:

- 📈 Make progress visible
- 🔥 Reward consistency
- ⚡ Keep interactions fast
- 🎨 Deliver a clean, distraction-free experience

Alongside building a useful product, Momentum is also an opportunity to demonstrate professional software engineering practices.

---

# ✨ Features

## 🔐 Authentication

- JWT Authentication
- User Registration
- Secure Login
- Password Encryption
- Role-Based Authorization

---

## ✅ Habit Management

- Create Habits
- Edit Habits
- Delete Habits
- Daily Habit Completion
- Categories
- Custom Habit Frequency

---

## 📊 Dashboard

- Daily Overview
- Weekly Statistics
- Monthly Progress
- Completion Rate
- Streak Counter

---

## 📅 Visualization

- Calendar View
- GitHub-style Contribution Heatmap
- Progress Charts
- Activity Timeline

---

## 🏆 Productivity

- Achievement Badges
- Smart Insights
- Weekly Reports
- Habit Recommendations

---

## 🎨 User Experience

- Responsive Design
- Light Mode
- Dark Mode
- Mobile Friendly
- Beautiful Animations

---

# 🛠 Tech Stack

| Layer | Technology |
|--------|------------|
| Frontend | React |
| Language | TypeScript |
| Styling | Tailwind CSS |
| Backend | Spring Boot |
| ORM | Spring Data JPA + Hibernate |
| Database | PostgreSQL |
| Build Tool | Maven |
| API Testing | Postman |
| Containerization | Docker |
| Version Control | Git + GitHub |

---

# 🏗 Project Architecture

```
                   React Frontend
                          │
                          │ HTTP REST API
                          ▼
                Spring Boot Backend
                          │
            ┌─────────────┴─────────────┐
            │                           │
       Business Logic              Security
            │                           │
            ▼                           ▼
      Spring Data JPA             JWT Authentication
            │
            ▼
        PostgreSQL
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

- Environment Setup
- Spring Boot Backend
- PostgreSQL Integration
- Health Check API

---

## 🚧 Phase 2 — Core Backend

- User Module
- Habit Module
- CRUD Operations
- Validation
- Authentication
- JWT Security

---

## ⏳ Phase 3 — Frontend

- React Setup
- Authentication Pages
- Dashboard
- Habit Management
- Analytics

---

## 🎯 Phase 4 — Production

- Docker
- CI/CD
- Deployment
- API Documentation
- Unit Testing
- Integration Testing

---

# 🚀 Getting Started

## Clone the Repository

```bash
git clone https://github.com/maharshith1910/Momentum.git

cd Momentum
```

---

## Backend Setup

```bash
cd backend
```

### Configure PostgreSQL

Create a database named:

```
momentum_db
```

Configure:

```
src/main/resources/application.properties
```

Example:

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

Linux / macOS

```bash
./mvnw spring-boot:run
```

Backend will start at

```
http://localhost:8080
```

---

# 📡 API

Current Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/health` | Health Check |

Future endpoints will be documented in:

```
docs/api.md
```

---

# 📚 Documentation

Detailed documentation is available inside the `docs` directory.

- 📖 Developer Journal
- 🗺 Roadmap
- 🏗 Architecture
- 📡 API Documentation

---

# 🚧 Current Progress

| Sprint | Status |
|----------|--------|
| Sprint 0 | ✅ Completed |
| Sprint 1 | ✅ Completed |
| Sprint 2 | 🚧 In Progress |

---

# 🌟 Future Enhancements

- AI Habit Insights
- Email Notifications
- Progressive Web App (PWA)
- Mobile Application
- OAuth Login
- Social Features
- Habit Sharing
- Leaderboards

---

# 🤝 Contributing

Contributions are welcome.

As the project evolves, contribution guidelines will be available inside `CONTRIBUTING.md`.

---

# 📜 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

**Maharshith Narsapuram**

Momentum is being developed as a long-term software engineering portfolio project to demonstrate full-stack development, backend architecture, REST APIs, database design, authentication, testing, Docker, and deployment.

---

> **"Small habits, repeated consistently, create extraordinary results."**