# 🧠 Spring Expression Language (SpEL)

Spring Expression Language, o **SpEL**, es una poderosa característica de Spring que permite evaluar expresiones directamente dentro del contexto del contenedor Spring. Lo usamos principalmente junto a la anotación `@Value`, para inyectar valores calculados dinámicamente 🧮.

---

## 🔧 ¿Cómo funciona?

Cuando colocamos una expresión dentro de `@Value`, Spring analiza esa expresión y la evalúa en tiempo de ejecución. El resultado final se inyecta en el campo donde estamos usando `@Value`.

Una expresión se marca con `#` y se encierra dentro de `{}`. Ejemplo:

```java
@Value("#{2 + 3}") // Resultado: 5
```

---

## 🔤 ¿Qué tipo de cosas podemos hacer?

SpEL soporta:

* 🔢 Tipos primitivos (números, booleanos)
* 📚 Colecciones (listas, mapas, sets)
* 🧮 Operadores matemáticos (`+`, `-`, `*`, `/`, `%`, etc.)
* ✅ Operadores lógicos (`&&`, `||`, `!`)
* 🔁 Ternarios (`condición ? valorSiTrue : valorSiFalse`)
* 🏷️ Llamadas a métodos estáticos u objetos
* 🧵 Creación de objetos nuevos

---

## 🧪 Ejemplos básicos

```java
@Value("#{66 + 44}")
private int suma; // Resultado: 110 ✅

@Value("#{5 > 3 ? 'Mayor' : 'Menor'}")
private String comparacion; // Resultado: "Mayor"

@Value("#{T(java.lang.Math).PI}")
private double pi; // Resultado: 3.1415...
```

También se pueden usar operadores ternarios:

```java
@Value("#{2 + 4 > 8 ? true : false}")
private boolean activo; // Resultado: false ❌
```

---

## 🏗️ Usando métodos y clases

```java
@Value("#{T(java.lang.Integer).MIN_VALUE}")
private int minValue; // Resultado: -2147483648 📉

@Value("#{new java.lang.String('Jose Hernandez')}")
private String nombre; // Resultado: "Jose Hernandez" 🙋‍♂️
```

---

## 📥 Inyectar listas (util schema)

Desde XML:

```xml
<util:list list-class="java.util.LinkedList" id="topics">
    <value>Java Web Services</value>
    <value>Core java</value>
    <value>XSLT</value>
</util:list>
```

Desde clase:

```java
@Value("#{topics}")
private List<String> topics; // 💡 Se inyecta la lista definida arriba
```

---

## 🧵 Conclusión

SpEL nos permite hacer mucho más que simples asignaciones. Podemos:

* Crear expresiones condicionales 🧩
* Invocar métodos estáticos 🔗
* Evaluar lógica compleja directamente desde XML o anotaciones 💥

Es una herramienta avanzada, flexible y muy útil cuando se trabaja con configuraciones dinámicas 💼.
