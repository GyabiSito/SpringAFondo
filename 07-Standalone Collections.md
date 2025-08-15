# 🕵️‍♂️ Standalone Collections en Spring Framework

---

## 🚀 Problema: Listas no reutilizables y tipos limitados

Cuando definís una colección dentro de un bean así:

```xml
<property name="...">
    <list>
        <value>Uno</value>
        <value>Dos</value>
    </list>
</property>
```

### Problemas:

1. ❌ Esa colección **no puede ser reutilizada en otros beans**.
2. ❌ Solo usás las **implementaciones por defecto**:

   * `ArrayList` para listas
   * `LinkedHashSet` para sets
   * etc.
3. ❌ No podés elegir, por ejemplo, `LinkedList`, `TreeSet`, `HashMap`, etc.

---

## 📊 Solución: Standalone Collections con el schema `util`

Spring te permite crear colecciones reutilizables y tipadas mediante el namespace `util`.

### Paso 1: Importar el schema util

Agregá esto a tu `beans` root:

```xml
xmlns:util="http://www.springframework.org/schema/util"
```

Y al `xsi:schemaLocation`:

```xml
http://www.springframework.org/schema/util
http://www.springframework.org/schema/util/spring-util.xsd
```

---

## 🔹 Ejemplo Completo de Standalone List

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="
          http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          http://www.springframework.org/schema/context/spring-context.xsd
          http://www.springframework.org/schema/util
          http://www.springframework.org/schema/util/spring-util.xsd">

    <!-- Standalone collection -->
    <util:list id="productNames" list-class="java.util.LinkedList">
        <value>Mac Book</value>
        <value>Iphone</value>
    </util:list>

    <!-- Bean que reutiliza esa lista -->
    <bean class="com.gyabisito.standalone.collections.ProductsList" name="productsList">
        <property name="productNames">
            <ref bean="productNames" />
        </property>
    </bean>
</beans>
```

---

## 🔢 Tipos de colecciones soportadas

| Tipo de colección | Tag util            | Soporta clase custom |
| ----------------- | ------------------- | -------------------- |
| Lista             | `<util:list>`       | `list-class="..."`   |
| Set               | `<util:set>`        | `set-class="..."`    |
| Mapa              | `<util:map>`        | `map-class="..."`    |
| Properties        | `<util:properties>` | No aplica            |

### Ejemplo `util:map`:

```xml
<util:map id="countryCodes" map-class="java.util.TreeMap">
    <entry key="AR" value="Argentina"/>
    <entry key="UY" value="Uruguay"/>
</util:map>
```

---

## 🚀 Ventajas de las Standalone Collections

* ✅ Reutilizables entre varios beans
* ✅ Totalmente configurables (LinkedList, TreeMap, etc)
* ✅ Mejor organización y desacople de la lógica de datos
* ✅ Separación clara entre estructura y uso

---

## 🌐 En resumen

* Las standalone collections se definen **fuera de un bean** usando `util:*`.
* Podés indicar el tipo de colección mediante `*-class="..."`.
* Las podés **referenciar desde cualquier bean** con `ref`.

🎯 **Tip**: Usalas para listas predefinidas, catálogos, configuraciones globales, etc.

---

🔗 **Conclusión:** Las standalone collections en Spring Framework permiten definir y reutilizar colecciones tipadas fuera de los beans, facilitando la configuración, el desacople y la organización de datos compartidos. Aprovechar el namespace `util` mejora la flexibilidad y la mantenibilidad de tus aplicaciones Spring.