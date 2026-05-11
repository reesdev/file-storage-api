# File Storage & Management API

## Overview

File Storage & Management API is a backend application built with Spring Boot that provides:

* User registration
* JWT authentication
* Protected API access
* File upload management
* File metadata storage
* File ownership authorization
* Docker deployment support

This project was developed as part of a backend deployment assignment using VPS and Docker.

---

# Features

## Authentication & Security

* User Registration
* Login Authentication
* JWT Token Authentication
* Protected Routes
* BCrypt Password Hashing
* Stateless Authentication

## File Management

* Upload File
* UUID File Naming
* File Metadata Storage
* File Ownership Authorization
* Get Uploaded Files
* Get User Uploaded Files

## Deployment

* Dockerized Application
* Docker Compose Support
* VPS Deployment
* Environment Variable Configuration

---

# Tech Stack

| Technology      | Description                    |
| --------------- | ------------------------------ |
| Java 21         | Programming Language           |
| Spring Boot     | Backend Framework              |
| Spring Security | Authentication & Authorization |
| JWT             | Stateless Authentication       |
| Spring Data JPA | ORM                            |
| MySQL           | Database                       |
| Docker          | Containerization               |
| Docker Compose  | Container Orchestration        |
| Maven           | Build Tool                     |
| Postman         | API Testing                    |

---

# Project Structure

```text
src/main/java/com/reesdev/file_storage_api
│
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
```

---

# API Endpoints

## Authentication

| Method | Endpoint    | Description                       |
| ------ | ----------- | --------------------------------- |
| POST   | /auth/login | Login user and generate JWT token |

---

## Users

| Method | Endpoint       | Description                       |
| ------ | -------------- | --------------------------------- |
| POST   | /users         | Register new user                 |
| GET    | /users         | Get all users                     |
| GET    | /users/profile | Access protected profile endpoint |

---

## Files

| Method | Endpoint        | Description                     |
| ------ | --------------- | ------------------------------- |
| POST   | /files/upload   | Upload file                     |
| GET    | /files          | Get all uploaded files          |
| GET    | /files/my-files | Get current user uploaded files |

---

# Local Installation Guide

## 1. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/file-storage-api.git
```

```bash
cd file-storage-api
```

---

# 2. Configure Database

Create a MySQL database.

Example:

```sql
CREATE DATABASE file_storage_db;
```

---

# 3. Create .env File

Create a `.env` file in the root project.

Example:

```env
SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/file_storage_db
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_mysql_password

SERVER_PORT=9001
```

---

# 4. Run Application Using Docker

Build and run the container:

```bash
docker compose up -d --build
```

Check running container:

```bash
docker ps
```

---

# 5. Access API

Example:

```text
http://localhost:9001/users
```

---

# API Testing Tutorial

## 1. Register User

### Request

```http
POST /users
```

### Body

```json
{
  "name": "name",
  "email": "name@mail.com",
  "password": "123456"
}
```

---

## 2. Login User

### Request

```http
POST /auth/login
```

### Body

```json
{
  "email": "name@mail.com",
  "password": "123456"
}
```

### Response

```json
{
  "token": "JWT_TOKEN"
}
```

Copy the token for protected endpoints.

---

## 3. Access Protected Endpoint

### Request

```http
GET /users/profile
```

### Header

```text
Authorization: Bearer JWT_TOKEN
```

---

## 4. Upload File

### Request

```http
POST /files/upload
```

### Authorization

```text
Bearer Token
```

### Body

```text
form-data
```

| Key  | Type |
| ---- | ---- |
| file | File |

---

## 5. Get Current User Files

### Request

```http
GET /files/my-files
```

### Authorization

```text
Authorization: Bearer JWT_TOKEN
```

---

# Docker Configuration

## Dockerfile

This project uses a multi-stage Docker build:

* Build Stage using Maven + Java 21
* Runtime Stage using Eclipse Temurin JRE

---

## Docker Compose

Docker Compose is used to:

* Build application container
* Configure environment variables
* Expose application port
* Connect to classroom Docker network

---

# VPS Deployment Guide

## 1. Login to VPS

```bash
ssh backend@38.47.180.195 -p 22
```

---

## 2. Go to Deployment Folder

```bash
cd ~/spring-app/student1
```

---

## 3. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/file-storage-api.git
```

---

## 4. Enter Project Folder

```bash
cd file-storage-api
```

---

## 5. Create .env File

```bash
nano .env
```

Example:

```env
SPRING_DATASOURCE_URL=jdbc:mysql://be_mysql:3306/db_spring_student1
SPRING_DATASOURCE_USERNAME=backend
SPRING_DATASOURCE_PASSWORD=your_database_password

SERVER_PORT=9001
```

Save:

```text
CTRL + O
ENTER
CTRL + X
```

---

## 6. Build and Run Container

```bash
docker compose up -d --build
```

---

## 7. Verify Running Container

```bash
docker ps
```

---

## 8. Test Public API

Example:

```text
http://38.47.180.195:9001/users
```

---

# Postman Documentation

Postman Collection:

```text
https://reesky-it-9010141.postman.co/workspace/Riski-forwork's-Workspace~a9a28de2-9e45-4e3a-8ccf-d6ffc381a151/collection/49343633-f5f633b3-0122-422e-8e62-2ca53789e270?action=share&creator=49343633
```

---

# Sample Deployment Result

## Public API URL

```text
http://38.47.180.195:9001
```

---

# Author

Developed by Reesky BE_6.
