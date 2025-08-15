# 🚚 Spring Autowiring - Wiring Automático de Beans

---

## 🤝 Introducción al Wiring de Beans

Cuando un **objeto A depende de un objeto B**, decimos que **B es la dependencia** y **A es el objeto dependiente**.

> Este proceso de vincular un bean con otro se llama **wiring**.

### 🔹 Bean Wiring (manual)

* Se hace usando `ref`, `property` o `constructor-arg` en el XML.
* Lo realiza el programador.

### 🔹 Autowiring (automático)

* Lo hace el **Spring Container**.
* Vos no escribís `ref` ni `property` manualmente.

---

## ✨ ¿Cómo se hace Autowiring?

Spring ofrece **dos formas**:

### 1. 📁 **Configuración XML**

```xml
<bean class="com.gyabisito.autowiring.Employee"
      name="employee" autowire="byType" />
```

#### Modos de autowiring en XML

| Modo          | Descripción                                                    |
| ------------- | -------------------------------------------------------------- |
| `no`          | Por defecto. No hay autowiring.                                |
| `byName`      | Busca un bean cuyo nombre coincida con el nombre del atributo. |
| `byType`      | Busca un bean cuyo tipo coincida con el tipo del atributo.     |
| `constructor` | Usa inyección por constructor.                                 |

### Ejemplo byType:

```xml
<bean class="com.gyabisito.autowiring.Employee" name="employee" autowire="byType"/>
<bean class="com.gyabisito.autowiring.Address" name="address" p:city="San Diego" />
```

> Asegurate de que `Employee` tenga un setter llamado `setAddress(Address address)`

### Ejemplo byName:

```xml
<bean class="com.gyabisito.autowiring.Employee" name="employee" autowire="byName"/>
<bean class="com.gyabisito.autowiring.Address" name="address" p:city="San Diego" />
```

> El atributo del bean debe llamarse igual que el `name` del bean inyectado.

### Ejemplo constructor:

```xml
<bean class="com.gyabisito.autowiring.Employee"
      name="employee" autowire="constructor"/>
```

> ⚠️ Si no tenés constructor por defecto, puede fallar:

```
BeanCreationException: No default constructor found
```

---

## 🖋️ Autowiring con Anotaciones (recomendado)

### 🔹 `@Autowired`

```java
@Component
public class Employee {

    @Autowired
    private Address address;

    // o

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }
}
```

* Se puede usar sobre propiedades, setters o constructores.
* Spring va a buscar un bean que **coincida por tipo**.

### 🔹 `@Qualifier` (para desambiguar)

Si hay **múltiples beans del mismo tipo**, usá `@Qualifier` para especificar cuál querés:

```java
@Autowired(required=false)
@Qualifier("address123")
private Address address;
```

```xml
<bean class="com.gyabisito.autowiring.annotations.Address"
      name="address123" p:city="San Diego" />
```

---

## ✅ Resumen Rápido

| Forma       | Detalles Clave                                          |
| ----------- | ------------------------------------------------------- |
| XML Wiring  | `autowire="byName"`, `byType`, `constructor`            |
| Anotaciones | `@Autowired`, `@Qualifier`                              |
| Ventajas    | Menos código repetido, el container se encarga de todo  |
| Precaución  | Puede fallar si no hay coincidencias claras entre beans |

---

## 🤔 ¿Cuándo usar cada uno?

* Usá **anotaciones** si querés código limpio, moderno y desacoplado.
* Usá **XML autowiring** si ya tenés un esquema de config legacy o muy centralizado.

---

🔗 **Conclusión:** Autowiring simplifica la configuración de dependencias en tus aplicaciones Spring. Te libera del trabajo repetitivo de vincular beans manualmente y mejora la claridad del código. Eso sí, asegurate de mantener los nombres y tipos bien definidos para que el container no se confunda 😎
