# 🧬 Spring ORM & Hibernate - Integración Eficiente con la Base de Datos

---

## 🔁 ORM - Object Relational Mapping

**ORM** significa **Mapeo Objeto-Relacional**. Su objetivo principal es:

> 🔄 Mapear objetos Java a tablas de una base de datos relacional (y viceversa).

### 🚫 Con JDBC tradicional:

* Tenés que escribir:

  * Conexión
  * PreparedStatement
  * Ejecutar SQL
  * Procesar ResultSet
* Esto genera **mucho código repetitivo y frágil**.

### ✅ Con ORM:

* Creás una clase Java (POJO)
* La anotás con JPA: `@Entity`, `@Table`, `@Id`, `@Column`
* Hibernate convierte automáticamente el objeto en una fila de la BD (y viceversa)

```java
@Entity
@Table(name="emp")
class Employee {
  @Id
  @Column(name="id")
  private int id;

  @Column(name="firstname")
  private String firstName;

  @Column(name="lastname")
  private String lastName;
}
```

🧠 Hibernate genera y ejecuta los SQLs necesarios — sin que vos los escribas.

---

## 🌱 Spring ORM - Integración con Hibernate

Spring nos facilita el uso de Hibernate mediante una clase llamada `HibernateTemplate`.

### 🔹 Características:

* Oculta el boilerplate de Hibernate (abrir sesión, transacciones, etc.)
* Provee métodos como: `save`, `update`, `delete`, `get`, `loadAll`
* Todo funciona **a partir de objetos** (no escribís SQL)

---

## 🏗️ Componentes clave

1. `HibernateTemplate` → Donde ejecutamos las operaciones
2. `SessionFactory` → Crea las sesiones de Hibernate (depende de...)
3. `LocalSessionFactoryBean` → Bean Spring que produce el SessionFactory
4. `DataSource` → Para conectarse a la base de datos
5. `Hibernate Properties` → Dialecto, show\_sql, etc.
6. `TransactionManager` → Para manejo de transacciones

### 🧱 Estructura general:

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"
      p:driverClassName="com.mysql.cj.jdbc.Driver"
      p:url="jdbc:mysql://localhost:3306/mydb"
      p:username="root"
      p:password=""/>

<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
  <property name="dataSource" ref="dataSource"/>
  <property name="hibernateProperties">
    <props>
      <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
      <prop key="hibernate.show_sql">true</prop>
    </props>
  </property>
  <property name="annotatedClasses">
    <list>
      <value>com.gyabisito.model.Product</value>
    </list>
  </property>
</bean>

<bean id="hibernateTemplate" class="org.springframework.orm.hibernate5.HibernateTemplate">
  <property name="sessionFactory" ref="sessionFactory"/>
</bean>
```

---

## 🔐 Transaction Manager

Cuando realizamos operaciones múltiples (como `insert`, `update`, `delete`) es importante que sean **atómicas**: todo o nada.

Spring provee:

* `HibernateTransactionManager`

Y habilitás el soporte con:

```xml
<tx:annotation-driven transaction-manager="transactionManager"/>
```

Definición:

```xml
<bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
  <property name="sessionFactory" ref="sessionFactory"/>
</bean>
```

Y en tus clases:

```java
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

  @Override
  @Transactional(readOnly = false)
  public int create(Product product) {
    hibernateTemplate.save(product);
    return product.getId();
  }
}
```

---

## 🧾 Resumen Clave

| Elemento              | Descripción                                            |
| --------------------- | ------------------------------------------------------ |
| ORM                   | Mapea objetos Java con tablas BD                       |
| Hibernate             | Implementación de JPA                                  |
| @Entity, @Id, @Column | Anotaciones clave para mapear clases y campos          |
| HibernateTemplate     | Clase Spring para operaciones CRUD con Hibernate       |
| SessionFactory        | Provee sesiones de Hibernate                           |
| DataSource            | Conexión a la base de datos                            |
| hibernate.dialect     | Clase que genera SQL para tu motor de BD               |
| TransactionManager    | Manejo de transacciones (commit / rollback automático) |
| @Transactional        | Anotación para marcar métodos como transaccionales     |

---

## 🧠 Conclusión

Spring ORM + Hibernate es una combinación poderosa 🚀

* Elimina SQL repetitivo
* Mapea automáticamente objetos a filas
* Usa configuración declarativa y anotaciones
* Soporte completo para transacciones

🔗 Ideal para apps robustas, mantenibles y con acceso intensivo a base de datos.
