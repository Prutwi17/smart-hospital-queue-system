# 🏥 Smart Hospital Queue & Emergency Prioritization System

A full-stack Hospital Queue Management System built using Spring Boot, Spring Security (JWT), MySQL, and React. The application enables secure role-based access for administrators, doctors, receptionists, and patients while providing appointment booking, emergency prioritization, and dashboard analytics.
## 🚀 Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA (Hibernate)
- MySQL
- Maven

### Frontend
- React
- Vite
- HTML5
- CSS3
- JavaScript
- Axios

### Tools
- IntelliJ IDEA
- Postman
- Git & GitHub
## ✨ Features

### Authentication
- User Registration
- User Login
- JWT Authentication
- BCrypt Password Encryption
- Role-Based Access Control (RBAC)

### Patient Management
- Create Patient
- Update Patient
- Delete Patient
- View Patient Details

### Doctor Management
- Create Doctor
- Update Doctor
- Delete Doctor
- View Doctor Details

### Appointment Management
- Book Appointment
- View Appointments
- Appointment Status Tracking

### Emergency Management
- Emergency Request Creation
- Automatic Priority Assignment
- LOW / MEDIUM / HIGH / CRITICAL Classification

### Dashboard
- Total Patients
- Total Doctors
- Total Departments
- Total Appointments
- Today's Appointments
- Emergency Statistics
## 📁 Project Structure

```text
smart-hospital-queue-system/
│
├── backend/
│   ├── src/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   ├── security/
│   │   ├── config/
│   │   ├── exception/
│   │   └── HospitalQueueSystemApplication.java
│   │
│   ├── pom.xml
│   └── README.md
│
├── frontend/
│
└── README.md
```
## ⚙️ Backend Technologies

- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Swagger (OpenAPI)
## 🗄️ Database Tables

- Users
- Patients
- Doctors
- Departments
- Appointments
- Emergency Requests
## ⚡ Installation

### Clone the Repository

```bash
git clone https://github.com/<your-username>/smart-hospital-queue-system.git
```

### Navigate to Backend

```bash
cd backend
```

### Configure Database

Update the database credentials in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_queue
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run the Application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```
## 📡 API Endpoints

### Authentication

| Method | Endpoint |
|---------|----------|
| POST | /api/auth/register |
| POST | /api/auth/login |

---

### Patients

| Method | Endpoint |
|---------|----------|
| POST | /api/patients |
| GET | /api/patients |
| GET | /api/patients/{id} |
| PUT | /api/patients/{id} |
| DELETE | /api/patients/{id} |

---

### Doctors

| Method | Endpoint |
|---------|----------|
| POST | /api/doctors |
| GET | /api/doctors |
| GET | /api/doctors/{id} |
| PUT | /api/doctors/{id} |
| DELETE | /api/doctors/{id} |

---

### Appointments

| Method | Endpoint |
|---------|----------|
| POST | /api/appointments |
| GET | /api/appointments |
| GET | /api/appointments/{id} |

---

### Emergency

| Method | Endpoint |
|---------|----------|
| POST | /api/emergencies |
| GET | /api/emergencies |
| GET | /api/emergencies/{id} |

---

### Dashboard

| Method | Endpoint |
|---------|----------|
| GET | /api/dashboard/admin |
## 🚀 Future Enhancements

- Email Notifications
- SMS Notifications
- Queue Token Display
- Doctor Schedule Management
- Medical Reports
- Payment Integration
- Docker Deployment
- Cloud Deployment (AWS)
## 👨‍💻 Author

**Pruthibiraj Swain**

Java Full Stack Developer
## 📄 License

This project is developed for learning, portfolio, and educational purposes.