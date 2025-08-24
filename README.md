# 👤 User API - Learning Java Spring Boot

This project is a simple **RESTful API** for managing **User** data, built with **Java Spring Boot**.  
The main goal of this project is to learn and practice modern **backend architecture** with the **Controller - Service - Repository** pattern, along with **DTO & Exception Handling** implementation.

---

## ✨ Features
- 🔹 CRUD User (Create, Read, Update, Delete)
- 🔹 Unique email validation (custom exception `EmailAlreadyExistsException`)
- 🔹 Centralized error handling with `GlobalExceptionHandler`
- 🔹 DTO (`UserRequestDTO`) to separate entity from request payload
- 🔹 Clean architecture: **Controller → Service → Repository**

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Maven**
- **H2 Database** (default, can be swapped with MySQL/PostgreSQL)
- **JUnit 5** for testing (basic)

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/silkiy/user-api-belajar-java.git
cd user-api-belajar-java/userapi
