# BookClub Project Documentation

## 1. Overview

`BookClub` is a RESTful application built with Spring Boot that allows users to register, create and join book clubs, schedule club meetings, review books, and manage their personal bookshelves.

## 2. Tech Stack

- **Backend**: Java 21, Spring Boot 3.4.5
- **Persistence**: Spring Data JPA, MySQL 8.0
- **Security**: Spring Security with JWT (io.jsonwebtoken jjwt)
- **Build & Dependency Management**: Maven (Wrapper 3.3.2)
- **Object Mapping**: ModelMapper 3.2.2
- **Email**: Spring Boot Starter Mail
- **Containers**: Docker Compose for MySQL

## 3. Getting Started

### 3.1 Prerequisites

- Java 21
- Maven
- Docker & Docker Compose
- SMTP email account configured in `application.properties`

### 3.2 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/usuario/tonycode2-bookclub.git
   cd tonycode2-bookclub/bookclub
   ```
2. Set up environment variables in `src/main/resources/application.properties`:
   ```properties
   jwt.secret=<BASE64_SECRET_KEY>
   spring.mail.host=<SMTP_HOST>
   spring.mail.username=<USER>
   spring.mail.password=<PASSWORD>
   spring.datasource.url=jdbc:mysql://localhost:3308/bookclub
   spring.datasource.username=admin
   spring.datasource.password=bookclub
   ```

### 3.3 Running the Services

```bash
# Start MySQL database
docker-compose up -d

# Run Spring Boot application
./mvnw spring-boot:run
```

## 4. Architecture & Directory Structure

\```
tonycode2-bookclub/
├── README.md
├── LICENSE
└── bookclub/
    ├── docker-compose.yml
    ├── mvnw*  
    ├── pom.xml
    └── src/
        ├── main/java/com/portfolio/bookclub/bookclub/
        │   ├── BookclubApplication.java
        │   ├── config/
        │   ├── persistence/
        │   ├── presentation/
        │   ├── service/
        │   └── util/
        └── test/java/.../BookclubApplicationTests.java
\```

## 5. Configuration

### 5.1 ModelMapper

- **`ModelMapperConfig`**: Exposes a `ModelMapper` bean for DTO ↔ Entity conversion.

### 5.2 Security

- **`ApplicationConfig`**: Defines `AuthenticationProvider`, `PasswordEncoder` (BCrypt), `UserDetailsService`, and `AuthenticationManager`.
- **`SecurityConfig`**: Configures Spring Security filter chain, disables CSRF, sets CORS to `http://localhost:5173`, and applies JWT.
- **JWT Components**:
  - **`JwtService`**: Generates and validates JWT tokens with custom claims (`userId`, `role`).
  - **`JwtAuthenticationFilter`**: A `OncePerRequestFilter` to extract and validate `Authorization: Bearer` tokens.

## 6. Persistence

### 6.1 Entities (JPA)

| Entity              | Description                                  | Key Fields                                                |
| ------------------- | -------------------------------------------- | --------------------------------------------------------- |
| `User`              | User with roles and credentials              | `id`, `username`, `password`, `role`, `enabled`           |
| `VerificationToken` | Email verification token                     | `token`, `expiryDate`                                     |
| `Club`              | Book club                                    | `id`, `name`, `category`, `bookOfTheWeekId`               |
| `ClubByUser`        | User ↔ Club association                      | `id`, `user`, `club`, `joinDate`                          |
| `BookshelfByUser`   | User bookshelf management (started/finished) | `id`, `user`, `bookId`, `isStarted`, `isCompleted`        |
| `Event`             | Club event (virtual/in-person meeting)       | `id`, `name`, `club`, `eventDateTime`, `type`, `status`   |
| `Review`            | Book review                                  | `id`, `user`, `bookId`, `rating`, `comment`, `reviewDate` |

### 6.2 Repositories

Spring Data JPA interfaces (extending `JpaRepository`) for CRUD and basic queries:

- `UserRepo`, `VerificationTokenRepo`, `ClubRepo`, `ClubByUserRepo`, `BookshelfByUserRepo`, `EventRepo`, `ReviewRepo`.

## 7. Business Logic (Service Layer)

- **Packages**: `service.interfaces`, `service.implementation`, `service.http`
- **Core Services**:
  - `AuthService`: Handles registration, login, token sending/verification.
  - `ClubService`, `ClubByUserService`, `BookshelfByUserService`, `EventService`, `ReviewService`: CRUD operations and business rules.
  - `GoogleBookService`: Integrates with Google Books API for book searches.
- **Error Handling**: `ApiException` and a `GlobalExceptionHandler` that returns standardized `ApiError` responses.

## 8. Presentation Layer

### 8.1 REST Controllers

| Endpoint                  | Method           | Description                       |
| ------------------------- | ---------------- | --------------------------------- |
| `/auth/register`          | POST             | User registration                 |
| `/auth/login`             | POST             | Authentication and JWT issuance   |
| `/auth/verify?token=`     | GET              | Verify account via token          |
| `/clubs`                  | GET, POST        | List/Create clubs                 |
| `/clubs/{id}`             | GET, PUT, DELETE | Club operations                   |
| `/clubs/{id}/join`        | POST             | Join a club                       |
| `/bookshelf`              | GET, POST        | View/Add to bookshelf             |
| `/events`                 | GET, POST        | List/Create events                |
| `/reviews`                | GET, POST        | List/Create reviews               |
| `/google-books/search?q=` | GET              | Search books via Google Books API |

### 8.2 DTOs

Data Transfer Objects for requests and responses, defined in `presentation.dto`, mapped using ModelMapper.

## 9. Utilities

- **`AppUtil`**: Common validation and mapping functions.
- **Custom Mappers**: Manual DTO ↔ Entity mappers when extra control is needed.

## 10. Testing

- **`BookclubApplicationTests`**: Context load test for Spring Boot.

## 11. License

This project is licensed under the **Apache License 2.0**.

---