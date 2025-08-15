# 🌐 Spring MVC - Arquitectura, Flujo y Comunicación con la Vista

---

## 🧩 ¿Qué es Spring MVC?

**Spring MVC** es un framework para construir aplicaciones web dinámicas en Java. Implementa el patrón **MVC (Model-View-Controller)** usando internamente tres patrones clave:

* **Front Controller**
* **Handler Mapper**
* **View Resolver**

---

## 🔄 Flujo de una Petición en Spring MVC

1. 🧭 **DispatcherServlet** (Front Controller) recibe todas las peticiones HTTP entrantes.
2. 🗺️ Usa un **HandlerMapper** para encontrar qué controlador debe manejar la petición.
3. 🧑‍💻 El **Controller** ejecuta la lógica necesaria y retorna un objeto `ModelAndView` con:

   * `model`: los datos
   * `view`: el nombre de la vista a mostrar
4. 🪞 El **ViewResolver** toma ese nombre de vista y le agrega:

   * `prefix` (ubicación del archivo)
   * `suffix` (extensión del archivo)
5. 🖼️ Finalmente, el `DispatcherServlet` renderiza la vista con el modelo y la envía al cliente

> ✔️ Este desacople permite cambiar de vista (JSP, Thymeleaf, JSF) o carpeta sin tocar el controlador.

---

## 🛠️ Configuración Básica

### 1. **web.xml** - Registrar el DispatcherServlet

```xml
<web-app>
  <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>
```

### 2. **dispatcher-servlet.xml** - ViewResolver y Scan

```xml
<beans ...>
  <context:component-scan base-package="gyabisito.controllers"/>

  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/views/"/>
    <property name="suffix" value=".jsp"/>
  </bean>
</beans>
```

### 3. **Controller**

```java
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello");
    }
}
```

### 4. **Vista hello.jsp**

`/WEB-INF/views/hello.jsp`

```jsp
<html>
  <head><title>Hello</title></head>
  <body>
    <h1>Welcome to Spring MVC</h1>
  </body>
</html>
```

---

## 🔁 Enviar Datos del Controller a la Vista

Usamos `ModelAndView.addObject(String key, Object value)`:

```java
ModelAndView mav = new ModelAndView("hello");
mav.addObject("name", "Jose");
```

📌 En la vista (JSP):

```jsp
<%= request.getAttribute("name") %>
```

---

## 🔁 Enviar Datos de la Vista al Controller

### 1. **Usando HTML Form + @ModelAttribute**

* Creamos una clase modelo `User` con campos que coincidan con los `name` del formulario.
* Spring crea un objeto automáticamente y lo inyecta con `@ModelAttribute`:

```java
@PostMapping("/register")
public String register(@ModelAttribute User user) {
    // usar user.getName(), user.getEmail(), etc
    return "success";
}
```

### 2. **Usando Query Params + @RequestParam**

```java
@GetMapping("/user")
public String getUser(@RequestParam("id") int id) {
    // usar el id recibido
    return "profile";
}
```

🛡️ Podemos hacerlos opcionales:

```java
@RequestParam(value="id", required=false, defaultValue="123") int id
```

---

## 🆚 ModelAndView vs ModelMap

| Característica | ModelAndView        | ModelMap + String View          |
| -------------- | ------------------- | ------------------------------- |
| Estilo         | Clásico             | Recomendado en versiones nuevas |
| Acoplamiento   | Más acoplado        | Desacoplado                     |
| Retorno        | Objeto ModelAndView | String (view) + ModelMap        |

---

## 🖥️ Despliegue y Ejecución

* Ejecutar `mvn clean package`
* Subir el `.war` generado a: `tomcat/webapps`
* Iniciar server: `./catalina.bat run` (en carpeta `tomcat/bin`)
* Acceder: `http://localhost:8082/springmvc/`

---

## ✅ Resumen Final

* Spring MVC implementa MVC con DispatcherServlet, HandlerMapper y ViewResolver
* Usamos anotaciones como `@Controller`, `@RequestMapping`, `@ModelAttribute`, `@RequestParam`
* Para enviar datos al usuario: `ModelAndView` o `ModelMap`
* Para recibir datos desde el formulario: `@ModelAttribute`
* Todo queda desacoplado gracias a configuraciones externas como ViewResolver

---

✅ **Spring MVC es una solución poderosa, flexible y modular para desarrollar aplicaciones web en Java.**
