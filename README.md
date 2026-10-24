# API Gestor de Tareas

Proyecto desarrollado para la evidencia:

GA7-220501096-AA5-EV03  
Diseño y desarrollo de servicios web - proyecto

## Autor

Jhonatan Carbonell Ibañez

Ficha: 3235899

Programa: Tecnólogo en Análisis y Desarrollo de Software

---

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- MySQL
- Postman
- Git
- GitHub

---

## Descripción

API REST desarrollada para gestionar tareas.

Permite:

- Crear tareas
- Listar tareas
- Consultar tareas por ID
- Actualizar tareas
- Eliminar tareas

La información se almacena en una base de datos MySQL denominada:

```text
gestor_tareas
```

---

# Recurso: Tareas

Ruta base:

```http
/api/tareas
```

---

## Crear tarea

### Descripción

Registra una nueva tarea.

### Método y URL

```http
POST /api/tareas
```

### Body

```json
{
  "titulo": "Realizar EV03",
  "descripcion": "Construir API REST",
  "fechaLimite": "2026-11-10",
  "completada": false
}
```

### Respuestas

```http
201 Created
```

```http
400 Bad Request
```

---

## Listar tareas

### Descripción

Obtiene todas las tareas registradas.

### Método y URL

```http
GET /api/tareas
```

### Respuestas

```http
200 OK
```

---

## Consultar tarea por ID

### Descripción

Obtiene una tarea específica según su identificador.

### Método y URL

```http
GET /api/tareas/{id}
```

### Respuestas

```http
200 OK
```

```http
404 Not Found
```

---

## Actualizar tarea

### Descripción

Actualiza la información de una tarea existente.

### Método y URL

```http
PUT /api/tareas/{id}
```

### Body

```json
{
  "titulo": "EV03 Terminada",
  "descripcion": "CRUD completado",
  "fechaLimite": "2026-11-15",
  "completada": true
}
```

### Respuestas

```http
200 OK
```

```http
404 Not Found
```

---

## Eliminar tarea

### Descripción

Elimina una tarea por su identificador.

### Método y URL

```http
DELETE /api/tareas/{id}
```

### Respuestas

```http
204 No Content
```

```http
404 Not Found
```

---

## Estructura del proyecto

```text
src
│
├── controller
│   └── TareaController.java
│
├── dto
│   └── TareaDTO.java
│
├── entity
│   └── Tarea.java
│
├── repository
│   └── TareaRepository.java
│
├── service
│   └── TareaService.java
│
└── ApiTareasApplication.java
```

---

## Repositorio

GitHub:

https://github.com/JhonatanCarbonell/api-tareas
