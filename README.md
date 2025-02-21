# ⚽ Football Match API

A Spring Boot REST API for managing football clubs, matches, and competitions.

## 🚀 Features
- Manage football clubs (Add, View, Delete)
- Track football matches with scores and teams
- Handle competitions and calculate winners
- RESTful API with Spring Boot and MySQL

## 🛠️ Technologies Used
- Java & Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database
- Spring Web (REST API)
- Lombok

## ⚡ Some API Endpoints
- GET /clubs - Fetch all clubs
- POST /clubs - Add a new club
- DELETE /clubs/{id} - Delete a club
- GET /matches - Fetch all matches
- PUT /competitions/{id}/winner/calculate - Calculate competition winner

## 🔧 Setup & Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/Aleksandar882/football-match-api.git
2. **Navigate to the project folder**
    ```sh
   cd football-match-api
3. **Build & Run the project**
   ```sh
   mvn spring-boot:run

## 🔗 Related Repositories

Frontend: [Football Match Frontend](https://github.com/Aleksandar882/football-match-frontend)