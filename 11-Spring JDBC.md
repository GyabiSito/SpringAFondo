# 🛢️ Spring JDBC - Integración Sencilla con Bases de Datos

---

## ✨ Propósito

Spring no solo simplifica la inyección de dependencias, sino también **reduce drásticamente el código repetitivo** que solemos escribir cuando usamos APIs como JDBC, ORM o JMS.

---

## 🔹 Problemas del JDBC tradicional

Con JDBC puro:

* Hay que crear conexiones manualmente
* Preparar statements
* Manejar `ResultSet`
* Escribir try/catch por cada operación

```java
Connection con = DriverManager.getConnection(...);
Statement stmt = con.createStatement(...);
ResultSet rs = stmt.executeQuery(...);
```

🚩 Mucho código repetitivo (boilerplate).

---

## 💡 Solución de Spring: `JdbcTemplate`

Spring provee una clase llamada **`JdbcTemplate`** que sigue el patrón de diseño Template.

> ✨ Se encarga del manejo de conexiones, statements y result sets por vos.

### ⚖️ Requiere un `DataSource`

* Spring provee una clase llamada `DriverManagerDataSource` que implementa `javax.sql.DataSource`.
* Acepta 4 parámetros:

  * `driverClassName`
  * `url`
  * `username`
  * `password`

---

## 📁 Ejemplo de Configuración XML

```xml
<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" name="dataSource"
      p:driverClassName="com.mysql.jdbc.Driver" p:url="jdbc:mysql://localhost/mydb"
      p:username="root" p:password=""/>

<bean class="org.springframework.jdbc.core.JdbcTemplate" name="jdbcTemplate"
      p:dataSource-ref="dataSource"/>
```

---

## 🚀 Operaciones DML con JdbcTemplate

```java
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
JdbcTemplate con = (JdbcTemplate) context.getBean("jdbcTemplate");
String sql = "INSERT INTO employee VALUES(?,?,?)";
int res = con.update(sql, 1, "Jose", 2);
System.out.println("Registros insertados: " + res);
```

> `update(String sql, Object... args)` permite ejecutar insert, update y delete.

---

## 📊 SELECT con `JdbcTemplate`

Spring provee dos métodos para SELECT:

### 1. `queryForObject(String sql, RowMapper<T>, Object... args): T`

* Devuelve un único objeto

### 2. `query(String sql, RowMapper<T>): List<T>`

* Devuelve una lista de objetos

---

## 🧬 `RowMapper<T>` Interface

Es una interfaz de Spring que convierte cada fila del `ResultSet` en un objeto de nuestra clase.

### Ejemplo:

```java
public class EmployeeRowmapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setFirstName(rs.getString("firstname"));
        emp.setLastName(rs.getString("lastname"));
        return emp;
    }
}
```

---

## 💻 Ejemplo DAO usando JdbcTemplate

```java
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee read(int id) {
        String sql = "select * from employee where id=?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowmapper(), id);
    }

    @Override
    public List<Employee> readAll() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new EmployeeRowmapper());
    }
}
```

---

## 📂 Configuración XML Completa

```xml
<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" name="dataSource"
      p:driverClassName="com.mysql.jdbc.Driver" p:url="jdbc:mysql://localhost/mydb"
      p:username="root" p:password=""/>

<bean class="org.springframework.jdbc.core.JdbcTemplate" name="jdbcTemplate"
      p:dataSource-ref="dataSource"/>

<bean class="com.gyabisito.EmployeeDAOImpl" name="employeeDAO">
    <property name="jdbcTemplate">
        <ref bean="jdbcTemplate"/>
    </property>
</bean>
```

---

## 🔄 Resumen Spring JDBC

| Elemento           | Descripción                                |
| ------------------ | ------------------------------------------ |
| `JdbcTemplate`     | Simplifica operaciones comunes con JDBC    |
| `DataSource`       | Proporciona la conexión a la base de datos |
| `RowMapper<T>`     | Convierte ResultSet en objetos             |
| `update()`         | Ejecuta insert, update y delete            |
| `query()`          | Recupera listas de objetos                 |
| `queryForObject()` | Recupera un solo objeto desde la base      |

---

🔗 **Conclusión:** Spring JDBC te evita escribir código repetitivo, te aísla del manejo de errores de bajo nivel y te permite concentrarte en la lógica de negocio. Una herramienta simple y poderosa ✔️
