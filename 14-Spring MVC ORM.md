# 🌐 Spring MVC + ORM + jQuery (AJAX)

---

## 📥 Subida de Usuarios a una Base de Datos

Este módulo integra:

* Spring MVC ✅
* Spring ORM (Hibernate) 🧩
* jQuery + AJAX para comunicación asíncrona ⚡

---

## 🔁 Synchronous vs Asynchronous Communication

### 🕒 Sincrónico (Synchronous)

1. El cliente (navegador) envía una solicitud HTTP.
2. Espera la respuesta ⏳.
3. Solo después puede enviar otra solicitud.

> 🚫 Mientras espera, **no puede interactuar con la app**.

### ⚡ Asincrónico (Asynchronous con AJAX)

1. El cliente **no necesita esperar** la respuesta.
2. Puede enviar múltiples solicitudes y seguir interactuando.
3. Las respuestas llegan luego, cuando estén listas.

> ✅ Permite una experiencia más fluida y reactiva para el usuario.

---

## 🔍 Ejemplo Real - Google Signup Page

1. Vas a [https://accounts.google.com/signup](https://accounts.google.com/signup)
2. Completás un campo como el nombre de usuario
3. Al pasar al siguiente campo (evento `onchange` o `onblur`):
4. Se dispara un **AJAX call** al backend de Google
5. El servidor valida si el usuario ya existe
6. Devuelve una respuesta (disponible o no)
7. ✅ Todo sin recargar la página

> Este es un ejemplo claro de **validación en tiempo real** usando AJAX + Backend

---

## 🧠 ¿Por qué usar AJAX en Spring MVC?

* Mejora la experiencia del usuario final 🧑‍💻
* Evita recargar toda la página por pequeñas validaciones 🔄
* Permite interacción fluida: enviar datos, recibir respuestas, actualizar porciones del DOM

---

## 🧱 Arquitectura Integrada

```text
UI (HTML + jQuery + AJAX)
   ↓
Spring MVC Controller (@Controller + @RequestMapping)
   ↓
Spring ORM (Hibernate + @Entity + @Transactional)
   ↓
Base de Datos (MySQL, PostgreSQL, etc.)
```

---

## ✍️ Pasos para Implementar

1. **Crear el formulario en la vista (JSP/HTML)** con campos de usuario
2. Escuchar eventos en campos específicos con jQuery (`onchange`, `onblur`, etc.)
3. Hacer un `$.ajax()` POST/GET al controlador Spring con los datos ingresados
4. Procesar la solicitud en un `@Controller`
5. Usar Spring ORM para interactuar con la base de datos
6. Retornar una respuesta (por ejemplo, `disponible` o `ya existe`)
7. Mostrar el resultado en el frontend dinámicamente

---

## 📦 Tecnologías Involucradas

| Componente    | Tecnología             |
| ------------- | ---------------------- |
| Backend       | Spring MVC             |
| Persistencia  | Spring ORM (Hibernate) |
| Base de Datos | MySQL/Postgres/etc     |
| Frontend      | HTML, JSP, jQuery      |
| Comunicación  | AJAX (Asíncrono)       |
