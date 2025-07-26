# Spring WebFlux Demo

This is a demo project showcasing [Spring WebFlux](https://docs.spring.io/spring-boot/3.5.4/reference/web/reactive.html) with reactive MySQL access using R2DBC.

## Features

- Reactive REST API for managing students
- Functional routing (no `@RestController`)
- MySQL database integration via R2DBC
- Docker Compose for local MySQL setup

## Project Structure

- `src/main/resources/` - Application properties and SQL scripts
- `compose.yml` - Docker Compose file for MySQL
- `.env` - Environment variables for database configuration

## Getting Started

### Prerequisites

- Java 21+
- Maven
- Docker (for running MySQL locally)

### Setup MySQL with Docker

1. Create local `.env` file and adjust credentials if needed.
2. Start MySQL:

   ```sh
   docker compose up -d
   ```

### Initialize Database

Use SQL script in [`src/main/resources/insert_data.txt`](src/main/resources/insert_data.txt) to create and populate the `students` table.

### Build and Run

```sh
./mvnw spring-boot:run
```

The app will start on [http://localhost:8080](http://localhost:8080).

## API Endpoints

- `GET /students`  
  Streams all students as Server-Sent Events.

- `GET /students/{id}`  
  Returns a student by ID in JSON.

- `GET /test`  
  Streams integers 1-5 as Server-Sent Events (demo endpoint).

## Configuration

See [`src/main/resources/application.properties`](src/main/resources/application.properties) for database connection settings.
