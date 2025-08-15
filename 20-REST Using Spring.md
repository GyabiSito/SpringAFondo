# 🌐 Spring Boot REST Controller - Desarrollo y Explicación Completa

---

## 🚀 ¿Qué es una API REST en Spring Boot?

Spring Boot facilita muchísimo la creación de aplicaciones web y APIs RESTful. No se necesita aprender un nuevo módulo. Se usa el mismo módulo de **Spring MVC (Web)** que ya conocés, pero con algunas anotaciones específicas.

---

## 🧱 Estructura del Proyecto

Tu proyecto tiene la siguiente estructura base:

```
springdatajpa/
├── controllers/
│   └── ProductController.java
├── entity/
│   └── Product.java
├── repos/
│   └── ProductRepository.java
├── application.properties
├── SpringdatajpaApplication.java
```

Esta estructura es típica en una aplicación Spring Boot que sigue la arquitectura MVC:
- **Controllers** → manejan las peticiones HTTP.
- **Entity** → representan tablas de la base de datos.
- **Repos** → se encargan del acceso a datos.

---

## 💡 ¿Cómo se crea un endpoint REST?

Solo necesitas:

### 1️⃣ Anotar tu clase con `@RestController`
Esta anotación combina `@Controller` y `@ResponseBody`, lo que significa que cada método retorna directamente datos (JSON, XML, etc.), no vistas HTML.

### 2️⃣ Definir una ruta base con `@RequestMapping("/products")`
Esto indica que todas las rutas dentro de la clase comenzarán con `/products`.

---

## 📦 Código del Controlador REST

```java
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }
}
```

---

## 🔍 Explicación de los Métodos

| Método | Anotación     | Descripción                                                                 |
|--------|----------------|-----------------------------------------------------------------------------|
| GET    | `@GetMapping`  | Obtiene todos los productos.                                                |
| POST   | `@PostMapping` | Crea un nuevo producto. El cuerpo de la petición se convierte en un objeto.|
| PUT    | `@PutMapping`  | Actualiza un producto existente.                                           |
| GET    | `@GetMapping("/{id}")` | Busca un producto por su ID.                               |
| DELETE | `@DeleteMapping("/{id}")` | Elimina un producto por su ID.                         |

✅ Las rutas están relacionadas al prefijo `/products`, definido en la anotación `@RequestMapping`.

---

## 🔐 Inyección de Dependencias

```java
@Autowired
ProductRepository productRepository;
```
Spring Boot automáticamente inyecta el repositorio que extiende `CrudRepository`. Este repositorio te permite acceder a métodos como `save`, `findAll`, `findById`, `deleteById`, etc., sin tener que implementarlos.

---

## ⚙️ application.properties (config opcional)

Podés agregar configuraciones como:
```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
```

---

## 📝 Resumen Final

- ✅ Crear APIs REST en Spring Boot es rápido y simple.
- 🧠 Solo necesitás crear un `@RestController`, definir rutas y usar anotaciones HTTP.
- 🛠️ Spring Boot configura automáticamente Tomcat, el `DispatcherServlet` y más.
- 📦 Usás `CrudRepository` para evitar escribir código repetitivo en la capa de datos.
- ⚡ Tu aplicación corre como un JAR standalone sin necesidad de deployear a un servidor externo.
