📦 **Spring Boot - Introducción y Comparación con Spring Tradicional** 🚀

---

### 🧩 ¿Qué es Spring Boot?

Spring Boot es un módulo del ecosistema Spring que permite acelerar el desarrollo de aplicaciones productivas con configuración mínima. No es un framework independiente, sino una capa de conveniencia sobre todos los módulos de Spring (Spring MVC, Spring ORM, etc).

#### ✅ Ventajas Clave:

* 🎯 **Convención sobre Configuración**: Si seguís las convenciones de estructura, Spring Boot configura automáticamente todo.
* ⚙️ **Valores por Defecto Opinados (Opinionated Defaults)**: Usa valores de configuración predeterminados que funcionan bien para la mayoría de los casos, aunque se pueden personalizar.
* 🧠 **Autoconfiguración**: Detecta automáticamente los beans, dependencias y configuración necesaria sin intervención manual.

---

### 🆚 Comparación con Spring "a secas"

| Característica                   | Spring Tradicional 🐢               | Spring Boot 🚀                                             |
| -------------------------------- | ----------------------------------- | ---------------------------------------------------------- |
| 🔧 Configuración de Beans        | Manual vía `@Bean` o XML            | Automática vía `@ComponentScan` y `@SpringBootApplication` |
| 📁 Archivos XML requeridos       | Sí, o configuración Java manual     | ❌ No se necesita XML                                       |
| 📦 DispatcherServlet             | Manual en `web.xml`                 | Autoconfigurado                                            |
| 🗃️ ViewResolver                 | Manual con beans en XML o Java      | Automático si detecta Thymeleaf, JSP, etc.                 |
| 🧪 Testing                       | Requiere configuración del contexto | `@SpringBootTest` levanta el contexto automáticamente      |
| 📂 Estructura recomendada        | Flexible, depende del dev           | Convenciones claras y organizadas                          |
| 🧱 Dependencias (JPA, Web, etc.) | Agregar y configurar manualmente    | Usando Starters (`spring-boot-starter-...`)                |
| 🔁 Ciclo de Vida del App         | Manual via `ApplicationContext`     | `SpringApplication.run()`                                  |

---

### 🔍 ¿Cómo funciona "la magia" de Spring Boot?

No es magia real ni generación de código dinámica. Internamente, Spring Boot escanea el classpath de tu aplicación y, basado en lo que encuentra, habilita clases de configuración ya definidas.

📁 Dentro de cada JAR, hay un archivo `META-INF/spring.factories` con las configuraciones posibles. Estas clases están marcadas con `@Configuration` y `@Conditional`, por lo que se activan sólo si ciertos requisitos se cumplen (como tener ciertas dependencias en el classpath).

📌 Ejemplo: `HibernateJpaAutoConfiguration` se activa automáticamente si encuentra `hibernate-core` en el classpath.

---

### 📚 Anotaciones Clave en Spring Boot

```java
@SpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
```

#### 📌 `@SpringBootApplication` es equivalente a:

* `@Configuration`: Configuración vía Java.
* `@EnableAutoConfiguration`: Habilita la autoconfiguración de Spring Boot.
* `@ComponentScan`: Escanea todos los subpaquetes para detectar beans.

---

### 🧪 Pruebas con Spring Boot

```java
@SpringBootTest
class SpringbootApplicationTests {
    @Test
    void contextLoads() {
    }
}
```

* Usa el runner de Spring (`@SpringBootTest`) para levantar el contexto completo de Spring.
* Ideal para pruebas de integración o pruebas unitarias con contexto.

---

### 🧱 Spring Boot Starters

Los **starters** son conjuntos de dependencias predefinidas que facilitan el inicio de distintos tipos de aplicaciones Spring.

📦 Ejemplos comunes:

* `spring-boot-starter`: Base mínima para cualquier app Spring Boot.
* `spring-boot-starter-web`: Todo lo necesario para construir apps Web o REST (incluye Spring MVC, Jackson, Tomcat).
* `spring-boot-starter-data-jpa`: Dependencias para ORM con JPA y Hibernate.
* `spring-boot-starter-security`: Seguridad con Spring Security.

📝 En el `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

---

### 🛠️ ¿Cómo crear un proyecto Spring Boot?

Hay **4 formas principales**:

1. **Manual**: Crear un proyecto Maven o Gradle y agregar los `starter` necesarios manualmente.

2. **Spring Initializr (💻 [https://start.spring.io/](https://start.spring.io/))**:

   * Herramienta web para generar un proyecto Spring Boot.
   * Elegís dependencias, nombre del proyecto, tipo de empaquetado, lenguaje y lo descargás ya listo para importar.

3. **IDE Integrado**:

   * IntelliJ IDEA, Eclipse o Spring Tool Suite tienen asistentes visuales para crear proyectos Spring Boot.

4. **CLI (Command Line Interface)**:

   * Instalás Spring Boot CLI y podés crear proyectos desde la terminal.

---

### 🔁 Flujo Interno de Spring Boot

1. Agregás una dependencia `starter` (como `spring-boot-starter-data-jpa`).
2. Spring Boot detecta qué hay en el classpath.
3. Busca en `spring.factories` qué configuración aplicar.
4. Aplica esa configuración automáticamente.
5. Podés sobreescribir cualquier comportamiento con tus propias configuraciones (en `application.properties` o `application.yml`).

---

### ⚙️ Configuración: application.properties / application.yml

```properties
server.port=8085
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

Estas propiedades permiten personalizar el comportamiento predeterminado de Spring Boot.

---

### 📌 Resumen Final

✅ Spring Boot simplifica el desarrollo de aplicaciones Spring.

🚀 Se basa en:

* **Convención sobre configuración**.
* **Valores predeterminados opinados**.
* **Anotaciones reducidas (@SpringBootApplication)**.
* **Configuración automática basada en el classpath**.

🧰 Nos permite crear aplicaciones web, REST, ORM, y mucho más, de forma rápida y profesional, sin necesidad de archivos XML, con una experiencia lista para producción desde el primer momento.

🧪 Además, incluye herramientas modernas de testing e integración.

---

¿Listo para dejar atrás el XML y configurar todo con una sola anotación? 🌱
