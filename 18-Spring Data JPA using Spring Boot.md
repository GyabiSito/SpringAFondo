📦 **Spring Data JPA usando Spring Boot** ⚙️

---

### 🧩 Introducción a JPA

**JPA** (Java Persistence API) es una especificación estándar de Oracle para el mapeo objeto-relacional (ORM). Permite guardar objetos Java en una base de datos relacional y viceversa, permitiendo que nuestras aplicaciones trabajen con objetos sin escribir código SQL manual.

🔧 **Proveedores más conocidos de JPA:**

* Hibernate ✅ (más popular)
* EclipseLink
* OpenJPA

Estos proveedores implementan la especificación de JPA, y los desarrolladores trabajamos con la API JPA estándar sin preocuparnos por los detalles internos.

---

### 🔍 Interfaces Clave de JPA

* `EntityManagerFactory`
* `EntityManager`

Estas interfaces se usan para realizar operaciones CRUD (crear, leer, actualizar, eliminar). Internamente, el proveedor traduce estas operaciones en SQL y las ejecuta.

---

### 💡 ¿Por qué Spring Data JPA?

En cada aplicación tradicional Java EE, teníamos que:

* Crear una clase DAO (Data Access Object)
* Implementar métodos como `save`, `findById`, `delete`, etc.

👉 Spring Data JPA **elimina ese boilerplate code**.

---

### 🚀 Usando Spring Data JPA

Con Spring Boot + Spring Data JPA:

1. Definís tu entidad JPA (ej: `Product`).
2. Creamos un **repositorio** que extiende `CrudRepository` o `JpaRepository`.

```java
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    // Getters y setters
}

public interface ProductRepository extends CrudRepository<Product, Long> {
}
```

✅ ¡Listo! Ya podés usar métodos como:

* `save()`
* `findById()`
* `findAll()`
* `deleteById()`

---

### 🔍 Métodos personalizados (Finder Methods)

Spring Data JPA permite crear consultas personalizadas usando el nombre del método:

```java
List<Product> findByName(String name);
List<Product> findByPrice(Double price);
List<Product> findByNameAndPrice(String name, Double price);
```

👉 Spring genera el SQL automáticamente.

---

### 📚 ¿Dónde ver todos los keywords?

Podés buscar en la documentación oficial:
🔎 `Spring Data JPA Reference Documentation`

Buscá: **supported keywords**.

🧠 Ejemplos útiles:

* `findByLastnameAndFirstname`
* `findByPriceLessThanEqual`
* `findByCreatedDateBefore`
* `findByNameIsNull`

---

### 🧪 ¿Qué necesitás para empezar?

1. Agregar en `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

2. Configuración en `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

3. Crear `@SpringBootApplication` y usar el repositorio inyectado.

---

### 🧾 Resumen

✅ JPA permite trabajar con objetos en lugar de SQL.
✅ Spring Data JPA elimina el código repetitivo.
✅ Con solo una entidad y una interfaz, tenés acceso a todas las operaciones básicas.
✅ Finder methods te permiten hacer queries dinámicas sin escribir SQL.

Spring Boot + Spring Data JPA = 🔥 productividad al máximo.
