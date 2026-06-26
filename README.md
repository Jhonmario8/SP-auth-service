# SP-auth-service

Microservicio de autenticación del proyecto **SportHub**, encargado de la gestión de usuarios, autenticación mediante JWT y autorización para los demás microservicios del sistema.

Este servicio permite registrar usuarios con diferentes roles y autenticar sus credenciales para generar un token JWT que será utilizado para acceder a los recursos protegidos.

---

# 📖 Tabla de Contenidos

- Descripción
- Arquitectura
- Tecnologías
- Requisitos Previos
- Configuración
- Variables de Entorno
- Instalación
- Ejecución
- Endpoints
- Autenticación
- Estructura del Proyecto
- Manejo de Errores
- Buenas Prácticas
- Autor

---

# 📝 Descripción

El microservicio **SP-auth-service** es responsable de:

- Registrar administradores.
- Registrar clientes.
- Autenticar usuarios mediante correo electrónico y contraseña.
- Generar tokens JWT.
- Gestionar la información de usuarios.
- Servir como proveedor de autenticación para los demás microservicios de SportHub.

Este servicio está desarrollado siguiendo los principios de **Arquitectura Hexagonal (Ports and Adapters)** para mantener desacoplada la lógica del negocio de los detalles de infraestructura.

---

# 🏗 Arquitectura

El proyecto implementa Arquitectura Hexagonal.

La organización principal del proyecto es:

```text
application
│
├── dto
├── handler
└── usecase

domain
│
├── api
├── model
└── spi

infrastructure
│
├── configuration
├── input
│   └── controller
├── output
│   ├── jpa
│   └── security
└── exception
```

Esta arquitectura permite:

- Separación de responsabilidades.
- Independencia del framework.
- Fácil mantenimiento.
- Mayor facilidad para realizar pruebas.

---

# 🚀 Tecnologías

- Java 17
- Spring Boot 3.5.3
- Spring Security
- Spring Data JPA
- JWT (jjwt 0.12.7)
- MapStruct
- Lombok
- MySQL
- Gradle

---

# 📋 Requisitos Previos

Antes de ejecutar el proyecto es necesario tener instalado:

- Java JDK 17
- Gradle
- MySQL Server
- Git

---

# ⚙ Configuración

Clonar el repositorio:

```bash
git clone https://github.com/Jhonmario8/SP-auth-service.git

cd SP-auth-service
```

Crear la base de datos:

```sql
CREATE DATABASE SP_users;
```

---

# 🔐 Variables de Entorno

El proyecto utiliza las siguientes variables:

| Variable | Descripción |
|----------|-------------|
| MYSQL_USER | Usuario de MySQL |
| MYSQL_PASSWORD | Contraseña de MySQL |
| PRAGMA_JWT_KEY | Clave secreta utilizada para firmar los JWT |

Ejemplo:

```properties
MYSQL_USER=root
MYSQL_PASSWORD=123456
PRAGMA_JWT_KEY=MiClaveSuperSecretaJWT
```

---

# ▶️ Ejecución

Ejecutar el proyecto:

```bash
./gradlew bootRun
```

o

```bash
gradlew bootRun
```

También puede ejecutarse desde IntelliJ IDEA ejecutando la clase principal:

```
AuthServiceApplication
```

El servicio quedará disponible en:

```
http://localhost:8080
```

---

# 🌐 Endpoints

## Registrar Administrador

```
POST /users/admin
```

Descripción:

Registra un nuevo usuario con rol Administrador.

Respuesta:

```
201 Created
```

---

## Registrar Cliente

```
POST /users/client
```

Descripción:

Registra un nuevo usuario con rol Cliente.

Respuesta:

```
201 Created
```

---

## Login

```
POST /auth/login
```

Descripción:

Autentica un usuario utilizando sus credenciales y retorna un JWT.

Respuesta:

```
200 OK
```

---

# 🔑 Autenticación

La autenticación del sistema se realiza mediante **JSON Web Token (JWT)**.

Proceso:

1. El usuario inicia sesión mediante `/auth/login`.
2. El sistema valida las credenciales.
3. Se genera un JWT firmado.
4. El cliente deberá enviar el token en las peticiones protegidas utilizando:

```
Authorization: Bearer <token>
```

---

# 🗄 Base de Datos

Motor utilizado:

- MySQL

Configuración JPA:

- Hibernate
- ddl-auto = update
- show-sql = true

---

# 📂 Estructura del Proyecto

```text
src
│
├── main
│   ├── java
│   │
│   └── com.sp.authservice
│       ├── application
│       ├── domain
│       └── infrastructure
│
└── resources
    └── application.yml
```

---

# ❌ Manejo de Errores

El proyecto implementa manejo centralizado de excepciones para responder con códigos HTTP adecuados cuando ocurre un error durante la ejecución.

Algunos códigos utilizados:

| Código | Descripción |
|---------|-------------|
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 409 | Conflict |
| 500 | Internal Server Error |

---

# 🧪 Pruebas

Para ejecutar las pruebas:

```bash
./gradlew test
```

---

# ✅ Buenas Prácticas Implementadas

- Arquitectura Hexagonal.
- Separación entre dominio e infraestructura.
- Uso de DTOs.
- Validación de datos.
- Mapeo mediante MapStruct.
- Contraseñas protegidas mediante Spring Security.
- Autenticación con JWT.
- Persistencia desacoplada mediante puertos y adaptadores.

---

# 👨‍💻 Autor

**Jhon Mario**

GitHub:

https://github.com/Jhonmario8

Repositorio:

https://github.com/Jhonmario8/SP-auth-service