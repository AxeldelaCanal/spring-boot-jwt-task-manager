# 🛡️ Secure Task Manager API (RBAC & JWT)

> **Sistema de Gestión de Tareas con Arquitectura de Seguridad Militar.**
> Implementación robusta de Autenticación (JWT), Autorización basada en Roles (RBAC) y Aislamiento de Datos por Usuario.

![Java 21](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot 3](https://img.shields.io/badge/Spring_Boot-3.x-green?logo=springboot)
![Spring Security](https://img.shields.io/badge/Security-Spring_Security_6-red?logo=springsecurity)
![JWT](https://img.shields.io/badge/Auth-JWT_Token-black)
![MySQL](https://img.shields.io/badge/Database-MySQL_8-blue?logo=mysql)

---

## 🔐 Problema y Solución
En entornos corporativos, no basta con un login. Se requiere que **los datos estén aislados** (que un usuario no vea lo de otro) y que existan **jerarquías** (Admin vs User).

Este backend resuelve tres pilares de seguridad:
1.  **Stateful vs Stateless:** Eliminación de sesiones en memoria mediante **Tokens JWT**.
2.  **Data Isolation:** Implementación de filtros a nivel de base de datos para que cada usuario acceda estrictamente a su información.
3.  **RBAC (Role-Based Access Control):** Arquitectura de roles escalable (`USER`, `MODERATOR`, `ADMIN`).

---

## 🛠️ Tech Stack & Arquitectura

* **Core:** Java 21 (LTS) & Spring Boot 3.4
* **Seguridad:** Spring Security 6 + JJWT (JSON Web Tokens).
* **Base de Datos:** MySQL 8 + Spring Data JPA (Hibernate).
* **Seguridad de Datos:** BCrypt Password Hashing & Data Sanitization (@JsonIgnore).
* **Herramientas:** Maven, Lombok, Postman.

### Patrones de Diseño
* **Interceptor Pattern:** Uso de `OncePerRequestFilter` para interceptar y validar tokens en cada petición HTTP.
* **DTO Pattern:** Separación estricta entre Entidades (BD) y Payloads (JSON) para no exponer datos sensibles (como passwords).
* **Repository Pattern:** Abstracción de consultas SQL.

---

## 🚀 Instalación y Despliegue

### Prerrequisitos
* MySQL Server (o Docker container)
* Java JDK 21+

### 1. Configuración de Base de Datos
Crea la base de datos en tu MySQL local:
```sql`

### 2. Configuración de Entorno
Edita src/main/resources/application.properties con tus credenciales:

`spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db`
`spring.datasource.username=root``
``spring.datasource.password=TU_CONTRASEÑA`

