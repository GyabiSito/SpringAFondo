# 🌐 Configuración avanzada de Beans en Spring (Required, Inner Beans, Scope)

---

## 🔨 Uso de la anotación `@Required`

Cuando una propiedad de un bean es **obligatoria** para el funcionamiento del mismo, podemos indicarle a Spring que valide esta necesidad en tiempo de inicialización.

### 🔹 ¿Dónde se usa `@Required`?

En el **setter** de la propiedad:

```java
@Required
public void setId(int id) {
    this.id = id;
}
```

> ⚡ No se pone a nivel de atributo o constructor. Solo en setters.

### ⚖️ Sin el RequiredAnnotationBeanPostProcessor

Si no habilitamos el `RequiredAnnotationBeanPostProcessor`, Spring simplemente setea valores por defecto:

```text
Prescription{id=0, patientName='null', medicines=null}
```

### 🚫 Con el `RequiredAnnotationBeanPostProcessor`

Si no se provee el valor requerido, lanza una excepción:

```
org.springframework.beans.factory.BeanCreationException:
Initialization of bean failed;
Property 'id' is required for bean 'prescription'
```

### 🔹 Configuración XML:

```xml
<bean class="com.gyabisito.springcore.dependencycheck.Prescription" name="prescription" p:id="1"/>

<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>
```

---

## 🛀 Inner Beans

Se utilizan cuando una clase depende de otra y queremos declarar esa dependencia **inline**, directamente en el bean padre.

### 🏛️ Ejemplo:

```java
public class Employee {
    private int id;
    private Address address;
}

public class Address {
    private int hno;
    private String street;
    private String city;
}
```

### 📁 Configuración XML:

```xml
<bean class="com.gyabisito.springcore.innerbeans.Employee" name="employee" p:id="123">
    <property name="address">
        <bean class="com.gyabisito.springcore.innerbeans.Address"
              p:city="Ciudad" p:hno="123" p:street="Street"/>
    </property>
</bean>
```

> ✅ No es necesario declarar el `Address` bean de forma global. Solo vive dentro del `Employee`.

---

## 🤹️ Bean Scope (Alcance de Beans)

Define **cuántas instancias** de un bean se crean y cuándo. Hay cinco scopes disponibles.

### 🥈 1. Singleton (por defecto)

* Un solo objeto por container.
* Reutilizado en todas las referencias.
* ¡No importa cuántas veces lo pidas, siempre es el mismo!

```xml
<bean id="employee" class="com.gyabisito.Employee"/>
```

```java
System.out.println(bean1.hashCode());
System.out.println(bean2.hashCode());
// Mismo hashCode
```

---

### 🪖 2. Prototype

* Un nuevo objeto **cada vez** que se lo solicita.

```xml
<bean id="employee" class="com.gyabisito.Employee" scope="prototype"/>
```

```java
System.out.println(bean1.hashCode());
System.out.println(bean2.hashCode());
// Diferentes hashCode
```

---

### 🚪 3. Request (solo apps web)

* Crea un bean por cada petición HTTP.
* Aplica a aplicaciones **Spring MVC**.

```xml
<bean id="userRequest" class="com.gyabisito.User" scope="request"/>
```

---

### 📅 4. Session (solo apps web)

* Un bean por sesión de usuario.
* Desde login hasta logout, el objeto se mantiene.

```xml
<bean id="userSession" class="com.gyabisito.User" scope="session"/>
```

---

### 🚵️ 5. Global Session (solo Portlet apps)

* Un bean por sesión **global**.
* Relevante solo en **Spring Portlet applications**.

```xml
<bean id="globalUser" class="com.gyabisito.User" scope="globalSession"/>
```

---

## ✅ Resumen

| Característica                        | Descripción                                                              |
| ------------------------------------- | ------------------------------------------------------------------------ |
| `@Required`                           | Marca propiedades que deben ser obligatorias en tiempo de inicialización |
| `RequiredAnnotationBeanPostProcessor` | Necesario para que `@Required` funcione                                  |
| Inner Bean                            | Bean definido dentro de otro bean, usado para dependencias simples       |
| Scope: Singleton                      | Un solo objeto por container                                             |
| Scope: Prototype                      | Objeto nuevo cada vez que se pide                                        |
| Scope: Request                        | Un objeto por request (solo apps web)                                    |
| Scope: Session                        | Un objeto por sesión de usuario (solo apps web)                          |
| Scope: GlobalSession                  | Un objeto por sesión global (solo apps portlet)                          |

---

🔗 **Conclusión:**  Este es un pilar fundamental para entender cómo se comportan los beans dentro del contenedor de Spring. Te da el control total sobre el ciclo de vida, la estructura y la reutilización de objetos. Cuando lo dominás, podés construir apps bien optimizadas, sin fugas de memoria ni errores tontos de inicialización.
