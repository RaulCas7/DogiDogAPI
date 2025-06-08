# 🐾 DogiDogAPI

**DogiDogAPI** es el backend oficial del ecosistema DogiDog la aplicación desarrollada por Raúl Casas Gómez para el instituto Miguel Herrero Pereda, una plataforma moderna dedicada a la gestión de perros, usuarios, valoraciones, notificaciones, incidencias y más. Esta API está construida con **Spring Boot 3.4.1**, conectada a una base de datos **MySQL** y diseñada para integrarse tanto con una aplicación de escritorio como una aplicación móvil.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.4.1**
  - Spring Web
  - Spring Data JPA
  - Spring Boot Mail
  - Spring Boot DevTools
- **MySQL** (gestión de datos relacional)
- **Commons IO** (gestión de archivos)
- **Maven** (gestión de dependencias)

---

## 📁 Estructura del proyecto

```
dogiDogApi/
├── src/
│   ├── main/
│   │   ├── java/org/example/dogiDogApi/
│   │   │   ├── controller/    # Controladores REST
│   │   │   ├── model/         # Entidades JPA
│   │   │   ├── repository/    # Repositorios JPA
│   │   │   ├── service/       # Servicios de negocio
│   │   │   └── DogiDogApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/...
```

---

## ⚙️ Configuración

Asegúrate de que tienes:

- Java 17
- MySQL ejecutándose localmente
- IntelliJ IDEA o Spring Tools (recomendado)

### 📌 Configuración de base de datos

Edita tu `application.properties` con tus credenciales MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dogidog
spring.datasource.username=root
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📡 Endpoints principales

Algunos de los endpoints REST incluidos:

- `GET /razas` – Lista todas las razas de perros.
- `POST /razas` – Crea una nueva raza.
- `GET /usuarios` – Lista todos los usuarios.
- `POST /usuarios/login` – Inicia sesión.
- `GET /valoraciones` – Obtiene valoraciones entre usuarios.
- `POST /notificaciones` – Envía notificaciones.
- `POST /incidencias` – Registra incidencias.
- `GET /bot/preguntas` – Obtiene respuestas del DogiBot.

> Puedes explorar todos los endpoints con Postman o integrarlos fácilmente con tu frontend de escritorio/móvil.

---

## ✨ Características destacadas

- Gestión completa de entidades como razas, usuarios, empleados, valoraciones, incidencias y más.
- Integración con cliente de correo para recuperación de credenciales o notificaciones.
- Control de acceso mediante autenticación de usuario.
- Preparada para despliegue en producción o pruebas locales.

---

## 🧪 Scripts y pruebas

Puedes correr pruebas unitarias con:

```bash
./mvnw test
```

---

## 💻 Aplicaciones conectadas

Esta API sirve de backend a:

- [DogiDog Escritorio](https://github.com/RaulCas7/DogiDogEscritorio)
- [DogiDog Móvil](https://github.com/RaulCas7/DogiDogMoviles)

---

## 🛠️ Cómo contribuir

1. Realiza un fork del repositorio.
2. Crea una rama con tu funcionalidad.
3. Haz commit de tus cambios.
4. Abre un Pull Request 🐾

---

## 📜 Licencia y derechos

© 2025 DogiDog. Todos los derechos reservados.

---

## 📬 Contacto

Desarrollado por [Raúl Castaño](https://github.com/RaulCas7).  
Para dudas o soporte: raulcasdev@gmail.com
