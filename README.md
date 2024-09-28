
# Spring Boot HelloWorld API with Authentication

## Overview

This is a Spring Boot project demonstrating REST APIs secured with Spring Security.

## Features

- **Basic Authentication**: Username/password protection.
- **Role-based Access Control**: Restricts access based on user roles.
- **In-Memory Authentication**: User management with an in-memory store.
- **RESTful API**: Simple `/api/helloworld` endpoint.

## Technologies

- Java 21
- Spring Boot 3.2.10
- Spring Security 6.1
- Maven

### Running the Application

1. **Clone the repository**:

   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Build the project**:

   ```bash
   mvn clean install
   ```

3. **Run the project**:

   ```bash
   mvn spring-boot:run
   ```

4. The application will be accessible at \`http://localhost:8080\`.

## API Endpoints

### \`GET /api/helloworld\`

- **Description**: Returns a simple "Hello World" message.
- **Access**: Secured; requires authentication.
- **Authentication**: Basic Auth using username \`test\` and password \`123456\`.

Example:

```bash
curl -u test:123456 http://localhost:8080/api/helloworld
```

Response:

```bash
Hello World
```
