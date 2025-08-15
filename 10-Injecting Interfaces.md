### 💡 Inyección de Interfaces en Spring
---

Hasta ahora, venías creando clases, sus objetos, e inyectándolos en otros beans. Sin embargo, en aplicaciones Java reales, **siempre trabajamos con interfaces** para lograr una mayor **abstracción y desacoplamiento**.

### 🎯 Ejemplo real
---
Imaginá que estás trabajando con una lógica de negocio de órdenes:

```java
public interface OrderBO {
    void placeOrder();
}

public class OrderBOImpl implements OrderBO {
    private OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void placeOrder() {
        System.out.println("Inside OrderBOImpl - placing order...");
        orderDAO.createOrder();
    }
}
```

Y la capa de acceso a datos:

```java
public interface OrderDAO {
    void createOrder();
}

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void createOrder() {
        System.out.println("Inside OrderDAOImpl - creating order...");
    }
}
```
---
### ⚙️ ¿Cómo los inyectamos en Spring?
---
Recordá que **no se pueden instanciar interfaces directamente**. Por eso, debemos declarar e inyectar las **implementaciones** en el archivo de configuración XML.

```xml
<bean id="orderDAO" class="com.gyabisito.springcore.advanced.injectinginterfaces.OrderDAOImpl" />

<bean id="orderBO" class="com.gyabisito.springcore.advanced.injectinginterfaces.OrderBOImpl">
    <property name="orderDAO" ref="orderDAO" />
</bean>
```
---
### 📁 Estructura típica
---

* `OrderBO` (interface) ➡ contiene la lógica de negocio
* `OrderBOImpl` (implementación) ➡ implementa la lógica, depende de `OrderDAO`
* `OrderDAO` (interface) ➡ maneja el acceso a la base de datos
* `OrderDAOImpl` (implementación) ➡ realiza la conexión a BD
---
### ✅ Conclusión
---

🧩 Usamos interfaces para desacoplar lógica y facilitar el mantenimiento del código.

🧰 Spring nos permite inyectar implementaciones usando configuración XML o anotaciones (más adelante lo verás con `@Autowired` y `@Qualifier`).

🔄 La interfaz actúa como contrato, y Spring se encarga de inyectar la implementación concreta.

📌 En el próximo paso, deberás escribir el archivo de configuración XML y una clase de prueba para verificar que todo funcione correctamente. 💻
