# 🎬 MovieFlix API

A REST API built with **Spring Boot** and **PostgreSQL**. Currently, this service acts as a bridge to a **Supabase** backend to manage movie data, with plans to evolve into a full-scale movie discovery engine.

## 🚀 Project Overview

MovieFlix is designed to help users discover movies. 
* **Current State:** Fetches curated movie lists from Supabase.
* **Future State:** Allow users to search for and add movies.

---

## 🛠 Tech Stack

* **Backend:** Java 25, Spring Boot 4.0.5
* **Persistence:** Spring Data JPA, Hibernate
* **Database:** PostgreSQL (Supabase)
* **Dev Tools:** Lombok, Spring DevTools
* **Containerization:** Docker

---

## ⚙️ Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Useless8000B/MovieFlix-API.git
cd movieflix-api
```

### 2. Configure Environment & Database
Before running, you must configure your connection to Supabase. Create or update `src/main/resources/application.properties` with the following:

```properties
spring.application.name=movieflix-api
spring.datasource.url=jdbc:postgresql://your-project-id.supabase.co:5432/postgres
spring.datasource.username=postgres.username
spring.datasource.password=password
server.port=1212
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.maximum-pool-size=10
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=validate
```

### 3.Run the application
#### Option A: Run with Maven (Recommended for Development)

Use this method to take advantage of Spring DevTools (hot-reloading). Ensure your Postgres instance/Docker container is running in the background.

```bash
# Clean previous builds and run
./mvnw clean spring-boot:run
```

#### Option B: Run with Docker (Full Environment)

1. **Build the image** from the Dockerfile:
```bash
docker build -t movieflix-api .
```

2. **Start the container** (Mapping local port 3333 to container port 1212):
```bash
docker run -d -p 3333:1212 --name movieflix-app movieflix-api
```

3. **Stop container**
```
docker stop movieflix-app
```