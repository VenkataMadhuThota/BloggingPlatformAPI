# 📝 Blogging Platform API

A RESTful API built with **Spring Boot** for managing blog posts — supports full CRUD operations, category filtering, keyword search, input validation, and structured error handling.

---

## 🛠 Tech Stack

| Technology | Version |
|------------|---------|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | - |
| Hibernate | 7.x |
| MySQL | 8.x |
| Lombok | - |
| Swagger (SpringDoc OpenAPI) | 3.0.2 |
| Maven | - |

---

## 📁 Project Structure

```
src/main/java/com/blogging/
├── controller/         # REST controllers
├── service/            # Service interfaces
├── serviceimpl/        # Service implementations
├── repository/         # JPA repositories
├── entity/             # JPA entities
├── mapper/             # Entity ↔ DTO mappers
├── requestdto/         # Request DTOs with validation
├── responsedto/        # Response DTOs
├── dto/                # Exception DTO
└── exception/          # Custom exceptions & global handler
```

---

## ⚙️ Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/BloggingPlatformAPI.git
cd BloggingPlatformAPI
```

### 2. Set environment variables
Set these in your system environment before running:
```
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```

### 3. Create the database
```sql
CREATE DATABASE preparation;
```

### 4. Run the application
```bash
mvn spring-boot:run
```

The app starts at:
```
http://localhost:8080/blogging
```

---

## 📖 API Endpoints

### Base URL: `http://localhost:8080/blogging`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| `POST` | `/blog` | Create a new blog | `201 Created` |
| `GET` | `/blog` | Get all blogs | `200 OK` |
| `GET` | `/blog/{id}` | Get blog by ID | `200 OK` |
| `PUT` | `/blog/{id}` | Update a blog | `200 OK` |
| `DELETE` | `/blog/{id}` | Delete a blog | `200 OK` |
| `GET` | `/blog/category/{categoryName}` | Get blogs by category | `200 OK` |
| `GET` | `/blog/search?keyword=` | Search blogs by title | `200 OK` |

---

## 📨 Sample Request & Response

### Create Blog — `POST /blog`

**Request Body:**
```json
{
    "titleName": "My First Blog",
    "content": "This is the content of my first blog post.",
    "categoryName": "Technology",
    "tags": ["java", "spring", "springboot"]
}
```

**Response:**
```json
{
    "id": 1,
    "titleName": "My First Blog",
    "content": "This is the content of my first blog post.",
    "categoryName": "Technology",
    "tags": ["java", "spring", "springboot"],
    "createdAt": "2026-05-30T10:15:23",
    "updatedAt": "2026-05-30T10:15:23"
}
```

### Error Response (Blog Not Found):
```json
{
    "timestamp": "2026-05-30T10:20:00",
    "status": 404,
    "error": "Not Found",
    "message": "Blog not found with id: 99",
    "path": "/blogging/blog/99"
}
```

---

## ✅ Features

- Full **CRUD** operations for blogs
- **Input validation** with proper error messages
- **Duplicate title** detection (409 Conflict)
- **Global exception handling** with structured error responses
- **Search** blogs by title keyword (case-insensitive)
- **Filter** blogs by category (case-insensitive)
- **Auto timestamps** — `createdAt` and `updatedAt` managed by Hibernate
- **Swagger UI** for API documentation and testing

---

## 📚 Swagger UI

Once the app is running, access the interactive API docs at:
```
http://localhost:8080/blogging/swagger-ui.html
```

---

## 🔐 Security Notes

- Database credentials are managed via **system environment variables** — never hardcoded

---
## About Me

**Venkata Madhu Thota** — Java Backend Developer  
Skilled in Java, Spring Boot, REST APIs, Spring Data JPA, Spring MVC ,Microservices and MySQL.

- LinkedIn: [linkedin.com/in/venkata-madhu-thota](https://linkedin.com/in/venkata-madhu-thota)
- Email: madhuthota131@gmail.com
