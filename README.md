# File Storage & Management API

## Description
Backend API for user authentication and file management built with Spring Boot.

## Features
- User Registration
- JWT Authentication
- Protected Routes
- File Upload
- File Metadata Storage
- File Ownership Authorization

## Tech Stack
- Java 21
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Maven

## API Endpoints

### Authentication
POST /auth/login

### Users
POST /users
GET /users
GET /users/profile

### Files
POST /files/upload
GET /files
GET /files/my-files

## Local Setup

1. Clone repository

```bash
git clone https://github.com/reesdev/file-storage-api.git