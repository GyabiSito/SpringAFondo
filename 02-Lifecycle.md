# ⏲️ Ciclo de Vida de los Beans en Spring

Cuando trabajamos con Spring, cada **bean** que el container crea tiene asociado un **ciclo de vida**. Spring nos da la posibilidad de intervenir en este ciclo con dos métodos clave:

```java
public void init() { ... }
public void destroy() { ... }
```

📌 (No tienen por qué llamarse exactamente así)

---

## 🔄 Etapas del Ciclo de Vida de un Bean

1. **Instanciación** → Spring crea la instancia del bean
2. **Inyección de dependencias** → Se inyectan valores o referencias necesarias
3. **Inicialización (`init`)** → Se ejecuta lógica de configuración inicial
4. **Uso** → El bean es usado en la aplicación
5. **Destrucción (`destroy`)** → Se liberan recursos antes de eliminar el bean

> ⚠️ El método `init` se ejecuta **después de inyectar** las dependencias, y `destroy` **antes de eliminar** el objeto.

---

## 🧩 Formas de Configurar los Métodos de Ciclo de Vida

### 📁 1. XML

```xml
<bean id="myBean" class="com.app.MyBean"
      init-method="init"
      destroy-method="destroy" />
```

📌 Los métodos deben ser `public void` y sin parámetros.

---

### 🖍️ 2. Interfaces de Spring

```java
public class MyBean implements InitializingBean, DisposableBean {

  @Override
  public void afterPropertiesSet() {
    // Lógica de init
  }

  @Override
  public void destroy() {
    // Lógica de destroy
  }
}
```

> ❗ Esta opción acopla tu clase al framework.

---

### 📌 3. Anotaciones `@PostConstruct` y `@PreDestroy`

```java
public class MyBean {

  @PostConstruct
  public void init() {
    // Lógica de inicialización
  }

  @PreDestroy
  public void destroy() {
    // Lógica de limpieza
  }
}
```

✔️ Requiere `@context:annotation-config` en XML si usás configuración basada en XML:

```xml
<context:annotation-config />
```

O:

```xml
<bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
```

---

## 📊 Comparativa Rápida

| Forma       | ¿Desacoplado? | ¿Sencillo? | ¿Moderno? |
| ----------- | ------------- | ---------- | --------- |
| XML Config  | ❌             | ✅          | ❌         |
| Interfaces  | ❌             | ❌          | ❌         |
| Anotaciones | ✅             | ✅          | ✅         |

---

## ✍️ Ejemplo Completo

```java
public class ConnectionBean {

  @PostConstruct
  public void connect() {
    System.out.println("Conectando a DB...");
  }

  @PreDestroy
  public void disconnect() {
    System.out.println("Desconectando de DB...");
  }
}
```

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

  <context:annotation-config />

  <bean id="connectionBean" class="com.app.ConnectionBean" />

</beans>
```

---

## 🧠 Resumen Ciclo de Vida

* `init()` → Se ejecuta después de setear propiedades: ideal para configurar cosas
* `destroy()` → Antes de destruir el bean: ideal para cerrar recursos
* Se puede configurar con XML, interfaces o anotaciones
* Las anotaciones son la opción más moderna y desacoplada ✅
