# File Storage & Management API

## Overview

File Storage & Management API is a backend application built with Spring Boot that provides:

- User registration
- JWT authentication
- Protected API access
- File upload management
- File metadata storage
- File ownership authorization
- Docker deployment support
- CI/CD automated deployment

This project was developed as part of a backend deployment assignment using VPS, Docker, and GitHub Actions CI/CD.

---

# Features

## Authentication & Security

- User Registration
- Login Authentication
- JWT Token Authentication
- Protected Routes
- BCrypt Password Hashing
- Stateless Authentication

## File Management

- Upload File
- UUID File Naming
- File Metadata Storage
- File Ownership Authorization
- Get Uploaded Files
- Get User Uploaded Files

## Deployment & DevOps

- Dockerized Spring Boot Application
- Docker Compose Support
- VPS Deployment
- GitHub Actions CI/CD
- DockerHub Integration
- Environment Variable Configuration
- Automated Deployment Pipeline

---

# Tech Stack

| Technology | Description |
|---|---|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Stateless Authentication |
| Spring Data JPA | ORM |
| MySQL | Database |
| Docker | Containerization |
| Docker Compose | Container Orchestration |
| GitHub Actions | CI/CD Automation |
| DockerHub | Container Registry |
| Maven | Build Tool |
| Postman | API Testing |

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

| Method | Endpoint | Description |
|---|---|---|
| POST | /auth/login | Login user and generate JWT token |

---

## Users

| Method | Endpoint | Description |
|---|---|---|
| POST | /users | Register new user |
| GET | /users | Get all users |
| GET | /users/profile | Access protected profile endpoint |

---

## Files

| Method | Endpoint | Description |
|---|---|---|
| POST | /files/upload | Upload file |
| GET | /files | Get all uploaded files |
| GET | /files/my-files | Get current user uploaded files |

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

Create MySQL database.

Example:

```sql
CREATE DATABASE file_storage_db;
```

---

# 3. Create .env File

Create a `.env` file in the root project.

Example:

```env
APP_PORT=9001

DOCKERHUB_USERNAME=your_dockerhub_username

SPRING_PROFILES_ACTIVE=dev

DB_HOST=host.docker.internal
DB_PORT=3306
DB_NAME=file_storage_db
DB_USER=root
DB_PASSWORD=your_mysql_password

REDIS_HOST=localhost
REDIS_PORT=6379
```

---

# 4. Run Application Using Docker

Build and run container:

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

| Key | Type |
|---|---|
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

This project uses multi-stage Docker build:

- Build Stage using Maven + Java 21
- Runtime Stage using Eclipse Temurin JRE

---

## Docker Compose

Docker Compose is used to:

- Configure application container
- Configure environment variables
- Expose application port
- Connect to classroom Docker network

---

# CI/CD Workflow

This project uses GitHub Actions for automated deployment.

Deployment flow:

1. Push code to main branch
2. GitHub Actions automatically builds application
3. Docker image is pushed to DockerHub
4. VPS automatically pulls latest image
5. Docker Compose restarts container

CI/CD Features:

- Automated Maven build
- Automated Docker image build
- DockerHub image publishing
- Automated VPS deployment
- Continuous Deployment workflow

Deployment status can be monitored from:

```text
GitHub Repository → Actions
```

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
APP_PORT=9001

DOCKERHUB_USERNAME=your_dockerhub_username

SPRING_PROFILES_ACTIVE=dev

DB_HOST=be_mysql
DB_PORT=3306
DB_NAME=db_spring_student1
DB_USER=backend
DB_PASSWORD=your_database_password

REDIS_HOST=be_redis
REDIS_PORT=6379
```

Save file:

```text
CTRL + O
ENTER
CTRL + X
```

---

## 6. Push to Main Branch

```bash
git push origin main
```

---

## 7. Automatic Deployment

GitHub Actions will automatically:

- Build Spring Boot application
- Build Docker image
- Push image to DockerHub
- Connect to VPS server
- Pull latest Docker image
- Restart Docker container

Deployment process can be monitored from:

```text
GitHub Repository → Actions
```

---

# Postman Documentation

Postman Collection:

```text
https://reesky-it-9010141.postman.co/workspace/Riski-forwork's-Workspace~a9a28de2-9e45-4e3a-8ccf-d6ffc381a151/collection/49343633-f5f633b3-0122-422e-8e62-2ca53789e270?action=share&creator=49343633
```

---

# Public API URL

```text
http://38.47.180.195:9001
```

---

# Sample Testing

## Get All Users

```http
GET /users
```

Status:

```text
200 OK
```

---

## Login User

```http
POST /auth/login
```

Status:

```text
200 OK
```

---

## Upload File

```http
POST /files/upload
```

Status:

```text
200 OK
```

---

# Author

Developed by Reesky BE_6.