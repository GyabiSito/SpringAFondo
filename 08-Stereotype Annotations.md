# Spring Stereotype Annotations y Component Scan

## Objetivo

Aprender a reemplazar la configuración XML tradicional de Spring para la creación de beans e inyección de dependencias, usando anotaciones como `@Component`, `@Scope`, `@Value` y `@Autowired`.

---

## 1. De XML a Anotaciones

Hasta ahora, creábamos beans usando XML:

```xml
<bean class="com.gyabisito.Instructor" name="inst" />
```

Esto puede ser reemplazado con:

```java
@Component("inst")
public class Instructor {
  ...
}
```

`@Component` es una *stereotype annotation* que le dice a Spring que debe crear un objeto de esa clase (como lo haría con un `<bean>`).

---

## 2. Activar escaneo de componentes

Para que Spring pueda encontrar esas clases anotadas, tenemos que decirle en qué paquete buscar:

```xml
<context:component-scan base-package="com.gyabisito.stereotype.annotations" />
```

Esto escanea el paquete indicado **y todos sus subpaquetes**, buscando clases anotadas con `@Component`, `@Service`, `@Repository`, `@Controller`, etc.

---

## 3. Nombres de Beans y Recuperación

Cuando usamos `@Component` sin nombre, Spring crea el bean usando camelCase del nombre de clase:

```java
@Component
public class SomeService {}
```

\=> Referencia del bean: `someService`

---

## 4. Scope del Bean

Podemos usar `@Scope("prototype")`, `@Scope("singleton")`, etc. para indicar el ciclo de vida:

```java
@Component("inst")
@Scope("prototype")
public class Instructor {
  ...
}
```

---

## 5. Inyectar Datos Primitivos con @Value

Podemos usar `@Value` para inyectar valores directos:

```java
@Value("20")
private int age;

@Value("Core Java")
private String topic;
```

### Inyectar colecciones:

```xml
<util:list list-class="java.util.LinkedList" id="topics">
  <value>Java Web Services</value>
  <value>Core java</value>
  <value>XSLT</value>
</util:list>
```

```java
@Value("#{topics}")
private List<String> topics;
```

Usamos `#{}` porque es Spring Expression Language (SpEL).

---

## 6. Inyectar Objetos con @Autowired

```java
@Autowired
private Profile profile;
```

Spring buscará un bean del tipo `Profile` y lo inyectará. Si hay más de uno, podemos usar `@Qualifier`.

---

## 7. Restricciones

* `@Component` solo puede usarse en clases que escribimos nosotros.
* No se puede usar en clases de terceros (ya compiladas).

---

## Resumen

* `@Component` reemplaza `<bean>`
* `@Scope` reemplaza `scope=""`
* `@Value` reemplaza `property value=""`
* `@Autowired` reemplaza `ref`/inyección de dependencias
* `context:component-scan` es obligatorio para que funcione todo esto

Esto permite que nuestra configuración sea más limpia, menos repetitiva y orientada al uso de anotaciones modernas de Spring.
