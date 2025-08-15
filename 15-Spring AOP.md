# 🧩 Spring AOP (Aspect Oriented Programming)

---

## 🎯 ¿Qué es AOP?

**Aspect Oriented Programming** permite aplicar servicios externos como:

* 🔐 Seguridad
* 🧾 Logging
* 🔄 Transaction Management

a nuestras clases **sin modificar su código fuente**. Estos servicios se conocen como **cross-cutting concerns** porque atraviesan múltiples capas (DAO, Service, UI).

### 💼 Ejemplo:

```java
class OrderServiceImpl {
    placeOrder();
    shipOrder();
}
```

Servicios externos deseados:

```java
class ExternalService {
    createTransaction();
    sendEmail();
    log();
}
```

✅ Todos esos servicios se aplican a través de **AOP**, sin modificar la clase `OrderServiceImpl`.

---

## 🧠 Conceptos clave en AOP

| Término     | Descripción                                                                      |
| ----------- | -------------------------------------------------------------------------------- |
| `Aspect`    | Clase que representa el servicio externo (logging, transacción, etc.)            |
| `Advice`    | Método dentro del Aspect (implementa la lógica del servicio)                     |
| `Pointcut`  | Expresión que define qué métodos del negocio deben tener `Advice` aplicado       |
| `JoinPoint` | Combina Advice + Pointcut. Define a qué método se aplica qué advice              |
| `Target`    | Objeto de la clase de negocio al que se aplica el advice                         |
| `Weaving`   | Proceso que mezcla el Advice al método del Target                                |
| `Proxy`     | Objeto resultante del `Weaving`, contiene lógica de negocio + lógica del aspecto |

---

## 🧬 Pointcut Expressions

Permiten definir a qué métodos se les aplicará un aspecto.

### 🎯 Sintaxis:

```java
execution(modifier return-type package.class.method(params))
```

### 🌟 Wildcards:

* `*` → cualquier cosa
* `..` → subpaquetes o cualquier número de parámetros

### 📌 Ejemplos:

* `public void *Id()` → cualquier método que termine en `Id`
* `public int *e*(..)` → contiene `e`, cualquier parámetro
* `public int get(..)` → método exacto `get`, cualquier parámetro
* `public * *()` → cualquier método público sin parámetros
* `public void get(..)` → `get` exacto, cualquier parámetro
* `public int *(..)` → cualquier método que devuelva `int`, con cualquier parámetro
* `public * com.app..*.get*()` → cualquier método que empiece con `get`, en cualquier clase bajo `com.app` o subpaquetes, sin parámetros
* `public * *(..)` → cualquier método público con cualquier parámetro

---

## 🔧 Implementaciones de AOP

Frameworks comunes:

* 🔹 AspectJ (🔝 usado)
* 🔹 Spring AOP
* 🔹 JBoss AOP

### 🔗 En Spring:

* ✅ `AspectJ Annotation Driven` (moderno)
* 🧾 `AspectJ XML Driven`
* 🚫 `Classic Proxy-Based AOP` (obsoleto)

---

## 🏷️ Anotaciones de AspectJ

| Anotación         | Descripción                                        |
| ----------------- | -------------------------------------------------- |
| `@Aspect`         | Marca una clase como un aspecto                    |
| `@Before`         | Advice ejecutado **antes** del método de negocio   |
| `@After`          | Advice ejecutado **después** del método de negocio |
| `@AfterReturning` | Advice ejecutado justo antes del `return`          |
| `@Around`         | Advice ejecutado **antes y después** del método    |
| `@AfterThrowing`  | Advice ejecutado cuando se lanza una excepción     |

📌 Estas anotaciones se colocan **en métodos dentro de la clase aspecto**, no en los métodos de negocio.

### 🧪 Ejemplo:

```java
package com.gyabisito.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.gyabisito.service.ProductServiceImpl.multiply(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("🔍 Antes de llamar al método");
    }

    @After("execution(* com.gyabisito.service.ProductServiceImpl.multiply(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("✅ Después de llamar al método");
    }
}
```

### ⚙️ Configuración XML:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">

    <aop:aspectj-autoproxy/>

    <bean name="productService" class="com.gyabisito.service.ProductServiceImpl"/>
    <bean name="logginAspect" class="com.gyabisito.aspects.LoggingAspect"/>
</beans>
```

### 🚀 Ejecución:

```java
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ProductService productService = context.getBean("productService", ProductService.class);
        System.out.println(productService.multiply(4,5));
    }
}
```

### 🖨️ Salida esperada:

```
🔍 Antes de llamar al método
✅ Después de llamar al método
20
```

---

## ✅ Resumen final

* 🧩 AOP permite aplicar servicios sin modificar clases de negocio
* 🧱 Se basa en Aspect, Advice, Pointcut, JoinPoint, Target, Weaving y Proxy
* 🔎 Los Pointcuts definen qué métodos serán interceptados
* 🔧 Spring AOP soporta integración con AspectJ (Annotation Driven)
* 🛠️ Usamos anotaciones como `@Aspect`, `@Before`, `@After` para interceptar comportamientos
* ⚙️ Configuramos con `<aop:aspectj-autoproxy/>` en el XML

🔗 ¡Una herramienta poderosa para separar responsabilidades y mantener el código limpio!
