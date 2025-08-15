🚀 **Spring Boot Web - Quick Start** 🌐

---

### 🎯 Objetivo de esta sección

Aprender cómo **Spring Boot** facilita la creación, configuración y despliegue de aplicaciones **Web/MVC** y **RESTful** sin necesidad de configuración XML ni WAR files.

---

### 🧱 Dependencia Clave: `spring-boot-starter-web`

Para iniciar un proyecto Web con Spring Boot solo necesitamos agregar esta dependencia en el `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Este starter incluye:

* Spring MVC
* Jackson (para JSON)
* Tomcat embebido (server)

---

### ⚙️ Configuración automática

Spring Boot elimina configuraciones manuales como:

* Dispatcher Servlet
* Internal View Resolver

✅ Estos se configuran automáticamente gracias a la **autoconfiguración**.

📁 Si queremos personalizar rutas a vistas, lo hacemos desde el archivo `application.properties`:

```properties
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

---

### ▶️ ¿Cómo se ejecuta?

* No necesitas generar un `.war` ni desplegar en Tomcat externo
* Solo corrés el proyecto desde tu IDE o como un `jar`

👉 Gracias al **servidor Tomcat embebido**, Spring Boot ejecuta tu aplicación directamente con:

```bash
mvn spring-boot:run
```

---

### 🛠️ Creación de Controladores Web / REST

✅ Crear aplicaciones REST con Spring Boot es muy simple. Usamos los mismos conceptos que en Spring MVC:

```java
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        // lógica para obtener el producto por ID
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        // lógica para guardar producto
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        // lógica para actualizar producto
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        // lógica para eliminar producto
    }
}
```

### 🧾 Anotaciones clave:

* `@RestController`: Indica que esta clase expone endpoints REST.
* `@RequestMapping`: Define la ruta base del controlador.
* `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: Mapean métodos HTTP (GET, POST, etc.) a métodos Java.
* `@RequestBody`: Para recibir JSON del cliente.
* `@PathVariable`: Extrae variables de la URL.

---

### 📦 Despliegue como `.jar`

Spring Boot permite empaquetar la app como `.jar`, lista para ejecución:

```bash
java -jar nombre-proyecto.jar
```

---


### ✅ Ventajas del enfoque Spring Boot Web

* 🚫 Sin XML
* 🔧 Configuración mínima
* ⚡ Rápido de ejecutar y probar desde el IDE
* 📦 Despliegue como `.jar`, sin necesidad de servidor externo
* 🌍 Ideal para APIs REST modernas

---

### 📝 Resumen Final

✅ **Spring Boot Web** permite crear apps web y REST fácilmente usando `spring-boot-starter-web`.
✅ No necesita WAR ni servidor externo: ¡todo está embebido!
✅ Sin archivos XML ni configuración manual del DispatcherServlet.
✅ Anotaciones simples como `@RestController` y `@GetMapping` manejan los endpoints.
✅ Todo es configurable desde `application.properties`, ¡pero con buenas opciones por defecto!

