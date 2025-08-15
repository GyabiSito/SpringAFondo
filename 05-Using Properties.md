# 📂 Spring Bean Externalization - Property Placeholder

---

## 🔄 ¿Qué es Bean Externalization?

Es el proceso de **separar las configuraciones dinámicas** (como credenciales, puertos, hostnames, etc.) de tu código Java y moverlas a un archivo `.properties` externo. Así, evitás hardcodear valores sensibles o que puedan cambiar seguido.

---

## 🚀 ¿Para qué sirve?

* Evitás modificar el código cada vez que cambie una config.
* Podés reutilizar los mismos beans con diferentes configuraciones.
* Mejor mantenimiento, escalabilidad y seguridad.
* No requiere recompilar el proyecto para cambiar valores.

---

## ✅ ¿Cuándo se usa?

En apps reales, tenés valores como:

```properties
dbServer=bharathServer
dbPort=3306
dbUser=test
dbPass=test
```

Y estos deben estar **afuera** del código fuente.

---

## ✍️ Pasos para externalizar propiedades en Spring

### 1. Crear el archivo `.properties`

Creamos el archivo `database.properties`:

```properties
# Configuración de base de datos
dbServer=bharathServer
dbPort=3306
dbUser=test
dbPass=test
```

* ✅ Claves **case-sensitive** (`dbUser` ≠ `dbuser`).
* ⚠️ Si tenés claves duplicadas, Spring toma **la última**.
* `#` sirve para comentar.

Ubicalo en el classpath (por ejemplo: `src/main/resources`).

---

### 2. Vincular el archivo de propiedades en la configuración XML

```xml
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="location" value="classpath:database.properties"/>
</bean>
```

Esto le dice al container de Spring:

> "Leé este archivo de propiedades cuando cargues los beans."

---

### 3. Inyectar valores en los Beans

```xml
<bean id="dbConfig" class="com.gyabisito.springcore.DbConfig">
    <property name="server" value="${dbServer}"/>
    <property name="port" value="${dbPort}"/>
    <property name="username" value="${dbUser}"/>
    <property name="password" value="${dbPass}"/>
</bean>
```

* Los valores `${...}` se reemplazan con las entradas del archivo `.properties`.
* Spring hace el **binding automático** al cargar los beans.

---

## 🚀 Bonus: Clase Java asociada

```java
public class DbConfig {
    private String server;
    private int port;
    private String username;
    private String password;

    // setters y getters
}
```

> Spring va a setear cada propiedad desde el archivo externo.

---

## ✅ Ventajas

| Ventaja               | Explicación                                   |
| --------------------- | --------------------------------------------- |
| Configs centralizadas | Cambios en un solo archivo                    |
| Sin recompilación     | Solo actualizás el archivo `.properties`      |
| Reutilización         | Misma lógica con distintos entornos o valores |
| Seguridad y limpieza  | Separás configuración de la lógica de negocio |

---

## 🔹 Tips importantes

* Siempre ubicá el archivo `.properties` en el **classpath**.
* El `PropertyPlaceholderConfigurer` es clave para habilitar esta funcionalidad.
* Usá nombres de propiedades claros, en camelCase.

---

🔗 **Conclusión:** Externalizar configuraciones en Spring es una práctica esencial para proyectos reales. Te da flexibilidad, claridad y facilidad para mantener la app viva en diferentes entornos sin tocar una sola línea de código fuente. En el siguiente paso, lo unimos con los beans y lo probamos ✅
