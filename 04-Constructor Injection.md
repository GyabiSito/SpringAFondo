# 🛀 Spring Constructor Injection - Detallado y sin misterios

---

## ✍️ ¿Qué es la Constructor Injection?

Es una forma que nos da Spring para inyectar dependencias **a través del constructor** de una clase, en lugar de setters. Es especialmente útil cuando querés que un bean sea **inmutable** o tenga sus dependencias obligatorias desde el principio.

---

## 📊 Sintaxis básica en XML

### 🔹 Ejemplo simple con tipos primitivos

```xml
<bean class="com.gyabisito.springcore.constructorinjector.MyBean">
    <constructor-arg>
        <value>42</value>
    </constructor-arg>
</bean>
```

### 🔹 Pasar referencias a otros beans

```xml
<constructor-arg>
    <ref bean="otroBean"/>
</constructor-arg>
```

También podés pasar listas, sets, maps, etc. dentro de `constructor-arg`.

---

## ⚠️ Problemas de Ambigüedad

Cuando tenés **múltiples constructores** con la misma cantidad de parámetros pero distintos tipos, Spring puede confundirse.

### 📒 Clase con constructores ambiguos

```java
public class Addition {
    Addition(Double a, Double b) { System.out.println("Double"); }
    Addition(int a, int b)     { System.out.println("Int"); }
    Addition(String a, String b) { System.out.println("String"); }
}
```

### 🔹 XML sin aclaraciones

```xml
<bean class="com.gyabisito.springcore.constructorinjector.Addition" name="addition">
    <constructor-arg value="10"/>
    <constructor-arg value="20"/>
</bean>
```

❌ Resultado: **Spring toma los valores como String por defecto** y entra al constructor `Addition(String, String)`.

---

## 🤠 Soluciones a la ambigüedad

Spring nos da tres atributos clave para aclararle qué constructor debe usar:

### 🔄 1. `type` (tipo de dato)

```xml
<constructor-arg value="10" type="int"/>
<constructor-arg value="20" type="int"/>
```

> Le decimos explícitamente el tipo. Ideal si los tipos son distintos entre constructores.

---

### 📈 2. `index` (posición del argumento)

Si tenés:

```java
Addition(double a, int b)
```

Entonces podés hacer:

```xml
<constructor-arg index="0" value="20" type="double"/>
<constructor-arg index="1" value="10" type="int"/>
```

> Esto evita que Spring use el orden en que aparecen en el XML, que puede no coincidir.

---

### 📄 3. `name` (nombre del parámetro)

Ideal si tu clase usa nombres descriptivos:

```java
Addition(double dividendo, double divisor)
```

```xml
<constructor-arg name="dividendo" value="20" type="double" index="0"/>
<constructor-arg name="divisor" value="10" type="double" index="1"/>
```

> ✅ `name` puede mejorar la claridad cuando hay muchos argumentos.

---

## 📅 Resumen

| Concepto          | Detalle                                                       |
| ----------------- | ------------------------------------------------------------- |
| `constructor-arg` | Se usa para pasar argumentos al constructor                   |
| `value`           | Puede ser un tipo primitivo o colección                       |
| `ref`             | Referencia a otro bean                                        |
| Ambigüedad        | Spring puede elegir mal el constructor si los tipos coinciden |
| `type`            | Define el tipo del argumento (ej: `int`, `double`, etc.)      |
| `index`           | Indica la posición del argumento en el constructor            |
| `name`            | Coincide con el nombre del parámetro del constructor          |

---

## ✅ Buenas prácticas

* Si tenés constructores sobrecargados, **usá `type` o `index`** para evitar ambigüedades.
* Para beans complejos, `name` ayuda a la legibilidad.
* Siempre preferí la inyección por constructor para dependencias obligatorias e inmutables.

---

🔗 **Conclusión:** La inyección por constructor es potente, clara y segura, pero hay que conocer cómo funciona internamente el proceso de resolución de constructores para evitar errores sutiles. Spring te da las herramientas para controlarlo todo: usalas bien y tené un container feliz
