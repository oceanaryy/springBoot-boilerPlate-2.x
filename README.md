이 레포지토리는 **Spring Boot 2.7.3 기반의 백엔드 보일러플레이트**입니다.  
운영/개발 환경에서 바로 사용할 수 있도록 기본적인 인증, JWT, Redis 캐시, MySQL 연동, Swagger, Docker 실행 환경을 포함합니다.

> ⚠️ 참고  
> Spring Boot 3.x 이상 버전은 **별도 레포지토리에서 관리**됩니다.  
> 이 레포는 **2.7.3 버전으로 고정**되며 더 이상 상위 버전 마이그레이션은 포함하지 않습니다.

## 🚀 Tech Stack

### Backend
- **Spring Boot 2.7.3**
- Spring Security 5.x
- JWT Authentication
- Spring Data JPA (Hibernate)
- Redis (토큰/캐시)
- MySQL 8
- Lombok
- springdoc-openapi (Swagger / OpenAPI 3)

### Infra / DevOps
- Docker / Docker Compose
- Gradle
- H2 Console (Local Dev Only)
- 환경변수 기반 설정 (.env 방식을 지원)

## 📁 Project Structure

```
/src
 └─ main
     ├─ java
     │   └─ com.jinsim.springboilerplate
     └─ resources
         ├─ application.yml
         └─ application-local.yml
/config
/docker
```

## 🌐 API Docs (Swagger)

Spring Boot 실행 후 Swagger UI 접근 경로:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI Docs:
```
/v3/api-docs
```

Swagger 관련 경로는 모두 Security에서 `permitAll` 처리되어 있음.

## 🔐 Environment Variables

### 📌 config/spring.env
```env
SPRING_JWT_SECRET=your-secret-key
SPRING_PROFILES_ACTIVE=local
```

### 📌 config/mysql.env
```env
MYSQL_ROOT_PASSWORD=root
MYSQL_DATABASE=spring_boilerplate
MYSQL_USER=springtest
MYSQL_PASSWORD=springtest
```

### 📌 config/redis.env
```env
REDIS_PASSWORD=1234
```

### 📌 config/tz.env
```env
TZ=Asia/Seoul
```

## 🐳 Running with Docker Compose

### 1. 빌드
```bash
./gradlew clean build -x test
```

### 2. 실행
```bash
docker-compose up --build
```

### 3. 종료
```bash
docker-compose down
```

## ⚙️ Running Locally (Without Docker)

```bash
export SPRING_JWT_SECRET=your-secret-key
export REDIS_PASSWORD=1234

./gradlew bootRun
```

## 🧩 Features

- 회원가입/로그인
- JWT 인증/인가
- Redis 기반 토큰 관리
- 게시글/댓글 CRUD
- Swagger UI 제공
- MySQL + Redis + Spring Boot 통합 환경
- 기본적인 예외 처리 구조 포함

## 🛑 Repository Policy

본 레포지토리는 **Spring Boot 2.7.3 버전 개발을 위한 최종 스냅샷**입니다.  
Spring Boot 3.x / 4.x 관련 소스는 별도 신규 레포지토리에서 작성됩니다.