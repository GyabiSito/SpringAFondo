# 🌱 Spring Framework - Explicación Profunda y Clara

---

## 🧾 ¿Qué es Spring?

**Spring** es un **framework de desarrollo para Java**, muy popular en el ecosistema **Java EE (Enterprise Edition)**, que nace con un objetivo claro:

> 🔧 **Simplificar el desarrollo de aplicaciones empresariales complejas** a través de principios como la **Inyección de Dependencia (DI)** y la **Inversión de Control (IoC)**.

---

## ❓ ¿Qué resuelve Spring?

Cuando construís una app en Java, tenés clases que dependen entre sí. Por ejemplo:

```java
class A {
  private B b = new B(); // ¡Acoplamiento fuerte!
}
```

Esto rompe el principio de inversión de dependencias porque **la clase A crea directamente una instancia de B**.

➡️ Con Spring, **delegamos la creación y gestión de dependencias al contenedor**.

---

## 🔄 Inversión de Control (IoC)

La **IoC** es un patrón donde el control de creación de objetos **ya no lo tiene tu código**, sino el contenedor (Spring).

> 💡 Vos no vas a `new`ear nada, Spring lo hace por vos.

### Ejemplo:

```java
class OrderService {
  private OrderDAO orderDAO;

  public OrderService(OrderDAO orderDAO) {
    this.orderDAO = orderDAO;
  }
}
```

🔧 Spring se encarga de:

* Crear `OrderDAO`
* Inyectarlo en `OrderService`
* Reutilizarlo en otras dependencias si es necesario

---

## 🧬 Inyección de Dependencias (DI)

Es el mecanismo que usa Spring para **inyectar las dependencias necesarias en tiempo de ejecución.**

### Tipos de inyección:

1. **Setter Injection**:

```xml
<bean id="employee" class="com.app.Employee">
  <property name="id" value="101"/>
  <property name="name" value="Juan"/>
</bean>
```

2. **Constructor Injection**:

```xml
<bean id="employee" class="com.app.Employee">
  <constructor-arg value="101"/>
  <constructor-arg value="Juan"/>
</bean>
```

📌 Spring puede inyectar:

* Tipos primitivos
* Colecciones (`List`, `Set`, `Map`)
* Referencias a otros beans

---

## ⚙️ Spring Container

### ¿Qué es?

Es el núcleo de Spring: **crea, mantiene y destruye** los objetos de tu app (los beans).

### ¿Qué necesita?

1. Clases Java (beans)
2. Configuración (XML, anotaciones, Java config)

### Tipos de ApplicationContext:

```java
ApplicationContext context =
  new ClassPathXmlApplicationContext("beans.xml");
```

* `ClassPathXmlApplicationContext`
* `FileSystemXmlApplicationContext`
* `AnnotationConfigApplicationContext`

---

## 🧱 Arquitectura Típica de App Spring

```
+------------------+
| UI Layer         | -> OrderController
+------------------+
        ↓
+------------------+
| Service Layer    | -> OrderService
+------------------+
        ↓
+------------------+
| Data Access Layer| -> OrderDAO
+------------------+
        ↓
+------------------+
| Database         |
+------------------+
```

> Spring se encarga de inyectar automáticamente las dependencias necesarias entre capas.

---

## 📦 Módulos Principales de Spring

Spring está compuesto por más de 20 módulos. Estos son los más destacados:

---

### 🧩 Core Container Module

El núcleo del framework. Aquí vive la magia de la IoC y la DI.

* `BeanFactory`
* `ApplicationContext`
* Ciclo de vida, scopes, perfiles, etc.

---

### 🛢️ Data Access / Integration

Sub-módulos:

* `Spring JDBC`
* `Spring ORM` (Hibernate, JPA)
* `Spring JMS`
* `Spring TX` (transacciones)

```java
@Entity
public class Employee {
  @Id
  private int id;
  private String name;
}
```

> Spring + Hibernate = Persistencia sin SQL crudo

---

### 🧹 AOP (Aspect Oriented Programming)

Agregá lógica transversal como:

* Logging
* Seguridad
* Transacciones

```java
@Aspect
public class LoggingAspect {
  @Before("execution(* com.app.service.*.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println("Método: " + joinPoint.getSignature());
  }
}
```

---

### 🌐 Web Module / Spring MVC

* `Spring Web`
* `Spring MVC`
* `WebSocket`
* `Servlet/Portlet`

MVC completo para apps Java web modernas.

---

### 🧪 Testing Module

* Integración con JUnit / TestNG
* Mockeo de beans
* `@SpringBootTest`, `@ContextConfiguration`

---

## ⚙️ Configuración XML en Spring

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

  <bean id="product" class="com.app.Product">
    <property name="id" value="10"/>
    <property name="name" value="Mouse"/>
  </bean>

</beans>
```

📌 `<bean>` = "creame un objeto de esta clase, con estas propiedades".

---

## 💡 Tipos de Datos a Inyectar

### 1. Primitivos:

```xml
<property name="id" value="10"/>
```

### 2. Colecciones:

```xml
<property name="tags">
  <list>
    <value>Java</value>
    <value>Spring</value>
  </list>
</property>
```

### 3. Referencias:

```xml
<property name="address" ref="addressBean"/>
```

---

## ✅ Resumen General

| 🧩 Concepto                | ✅ Qué Hace                                           |
| -------------------------- | ---------------------------------------------------- |
| Spring Framework           | Simplifica el desarrollo de apps Java                |
| Inversión de Control (IoC) | Spring crea y gestiona los objetos                   |
| Inyección de Dependencias  | Inyecta objetos automáticamente                      |
| Spring Container           | Motor que maneja el ciclo de vida de los beans       |
| Configuración XML          | Define cómo armar tu aplicación                      |
| Spring MVC                 | Framework MVC para web apps                          |
| AOP                        | Lógica transversal desacoplada                       |
| Spring ORM                 | Persistencia con Hibernate, JPA, etc.                |
| Spring JDBC                | Acceso simplificado a base de datos                  |
| Testing Module             | Soporte de testing con integración y mockeo de beans |
