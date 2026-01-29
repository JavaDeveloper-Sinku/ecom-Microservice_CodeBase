# 🛒 E-Commerce Microservices Project

## 📌 Project Overview

This project is a **scalable E-Commerce application** built using **Microservices Architecture**. The primary goal is to design and implement a **production-ready backend system** that follows industry best practices such as **loose coupling**, **high scalability**, and **service independence**.

The project is especially useful for **Java Backend / Spring Boot Developers** who want hands-on experience with real-world microservices.

---

## 🧩 Microservices Architecture

Each core business functionality is implemented as an independent microservice:

* **User Service** – User registration, login, and profile management
* **Auth Service** – JWT-based authentication and authorization
* **Product Service** – Product management, categories, inventory
* **Order Service** – Order creation and order lifecycle management
* **Payment Service** – Payment processing and payment status handling
* **Notification Service** – Email / SMS notifications
* **API Gateway** – Single entry point for all client requests
* **Service Registry** – Service discovery using Eureka

---

## 🛠️ Tech Stack

### Backend

* Java 17+
* Spring Boot
* Spring Cloud (Eureka, Gateway, Config Server)
* Spring Security with JWT
* Hibernate / JPA

### Database

* MySQL / PostgreSQL
* Redis (Caching – optional)

### Communication

* REST APIs
* OpenFeign (Inter-service communication)
* Kafka / RabbitMQ (Asynchronous messaging – optional)

### DevOps & Tools

* Docker & Docker Compose
* Git & GitHub
* Maven
* Postman

---

## 📂 Project Structure

```
Ecommerce-Microservices/
│
├── api-gateway/
├── service-registry/
├── config-server/
├── auth-service/
├── user-service/
├── product-service/
├── order-service/
├── payment-service/
├── notification-service/
└── docker-compose.yml
```

---

## 🔐 Authentication Flow (JWT)

1. User performs login or signup
2. Auth Service generates a JWT token
3. API Gateway validates the token
4. Authorized requests are forwarded to respective microservices

---

## 🔄 Inter-Service Communication

* **Synchronous Communication**: REST APIs using Feign Client
* **Asynchronous Communication**: Event-driven communication using Kafka

Example Flows:

* Order Service → Payment Service
* Payment Success Event → Notification Service

---

## 🚀 How to Run the Project (Local Setup)

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/ecommerce-microservices.git
```

### 2️⃣ Build the Project

```bash
mvn clean install
```

### 3️⃣ Run Using Docker (Recommended)

```bash
docker-compose up
```

### 4️⃣ Access the Application

* API Gateway: `http://localhost:8080`
* Eureka Dashboard: `http://localhost:8761`

---

## 🧪 API Testing

* Postman collections are included
* Swagger UI is available for each microservice

---

## 📈 Key Features

✔ Scalable Microservices Architecture
✔ Secure JWT Authentication
✔ Centralized API Gateway
✔ Service Discovery with Eureka
✔ Dockerized Deployment
✔ Ready for Fault Tolerance and Scaling

---

## 🎯 Learning Outcomes

* Hands-on experience with Microservices Architecture
* Deep understanding of Spring Cloud ecosystem
* Secure authentication and authorization
* Inter-service communication patterns
* Real-world backend system design

---

## 🧠 Future Enhancements

* Kubernetes deployment
* Circuit Breaker implementation (Resilience4j)
* Distributed tracing with Zipkin
* Rate limiting at API Gateway
* Admin Dashboard

---

## 👨‍💻 Author

**Rishi Singh**
Java Backend Developer | Spring Boot | Microservices

---

## ⭐ Support

If you like this project, please consider giving it a ⭐ on GitHub.

Happy Coding 🚀
