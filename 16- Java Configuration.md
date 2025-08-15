# 🧩 **Java Configuration en Spring (sin XML)**

Desde la versión 3.0 de Spring, podemos **configurar nuestras aplicaciones completamente sin usar archivos XML**, reemplazando la configuración XML por **clases Java anotadas**. Esto facilita la lectura, mantenimiento y testeo del código Spring.

---

### 🧠 ¿Cómo funciona?

✅ Reemplazamos `<bean>` en XML por métodos en una clase Java marcada con `@Configuration`, y esos métodos deben estar anotados con `@Bean`.

📄 XML:

```xml
<bean id="car" class="com.ejemplo.Car" />
```

☕ Java:

```java
@Configuration
public class MyConfig {
    @Bean
    public Car car() {
        return new Car();
    }
}
```

---

### ⚙️ Anotaciones importantes:

* `@Configuration`: Indica que la clase contiene definiciones de beans.
* `@Bean`: Marca un método como productor de un bean que será manejado por el contenedor Spring.
* `@Import`: Nos permite **importar configuraciones** desde otras clases de configuración.

---

### 🚀 Usando Java Config en una aplicación standalone

En vez de usar `ClassPathXmlApplicationContext`, usamos:

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
```

📌 Ejemplo completo:

```java
@Configuration
public class SpringConfig {
    @Bean
    public Dao dao() {
        return new Dao();
    }
}

public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dao dao = context.getBean(Dao.class);
        dao.create();
    }
}
```

---

### 🔗 Importando configuración entre clases

Podés dividir la configuración en varias clases e importarlas usando `@Import`:

```java
@Configuration
@Import(DaoConfig.class)
public class SpringConfig {
    @Bean
    public Service service() {
        return new Service();
    }
}

@Configuration
public class DaoConfig {
    @Bean
    public Dao dao() {
        return new Dao();
    }
}
```

📝 Esto permite una organización modular de los beans y una mayor escalabilidad de la aplicación.

---

### ✅ Resumen

* Spring desde la versión 3.0 permite configuración solo con Java.
* Usamos `@Configuration` para declarar clases fuente de beans.
* Cada método con `@Bean` produce un bean manejado por Spring.
* Usamos `AnnotationConfigApplicationContext` como contenedor.
* Podemos importar otras configuraciones con `@Import`.

🔧 **Más limpio, más modular, más controlado.**

---
