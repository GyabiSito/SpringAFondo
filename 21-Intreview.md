# 🧠 Spring Core - Preguntas de Entrevista Explicadas



### ❓ Q1. ¿Qué es DIP, DI y el IoC Container?

**A1.** Aunque están relacionados, son conceptos distintos:

1. **Dependency Inversion Principle (DIP)**: Principio SOLID que dice que los módulos de alto nivel no deben depender de los de bajo nivel, sino de abstracciones. Nos motiva a aplicar DI.

2. **Dependency Injection (DI)**: Patrón de diseño donde las dependencias se pasan desde fuera (por constructor o setters), en lugar de ser creadas internamente.

3. **Inversion of Control (IoC)**: Principio general donde el framework (como Spring) controla el flujo del programa. Spring es un contenedor IoC que implementa DI.

---

### ❓ Q2. ¿Qué se invierte en IoC?

**A2.** El flujo de control: en vez de que la clase cree o controle sus dependencias, se delega esa responsabilidad al contenedor (Spring).

---

### ❓ Q3. ¿Cuáles son los patrones que implementan IoC?

**A3.**

* **DI (Dependency Injection)**: Spring inyecta dependencias desde afuera.
* **Service Locator**: La clase usa un localizador de servicios para obtener instancias.

---

### ❓ Q4. ¿Cuándo usar Constructor Injection?

**A4.**

* Cuando los objetos son **inmutables**
* Cuando querés asegurar que el objeto está completamente inicializado
* Te obliga a tener un diseño más limpio si hay muchas dependencias

---

### ❓ Q5. ¿Cuándo usar Setter Injection?

**A5.**

* Cuando hay muchas dependencias opcionales
* Cuando querés permitir modificar dependencias luego de instanciar el objeto

---

### ❓ Q6. ¿Cómo es el ciclo de vida de un Spring Bean?

**A6.**

**Inicialización:**

1. Spring crea el bean desde la definición (XML o anotaciones)
2. Inyecta las propiedades
3. Llama `setBeanName()` si implementa `BeanNameAware`
4. Llama `setBeanFactory()` si implementa `BeanFactoryAware`
5. Llama `setApplicationContext()` si implementa `ApplicationContextAware`
6. Ejecuta `postProcessBeforeInitialization()` de los `BeanPostProcessor`
   7a. Llama `afterPropertiesSet()` si implementa `InitializingBean`
   7b. Llama el `init-method` si está configurado
7. Ejecuta `postProcessAfterInitialization()`
8. El bean está listo

**Destrucción:**

1. Llama `destroy()` si implementa `DisposableBean`
2. Llama el `destroy-method` si está configurado

---

### ❓ Q7. ¿La inyección de dependencias en Spring ocurre en tiempo de compilación o ejecución?

**A7.** En **tiempo de ejecución**.

---

### ❓ Q8. ¿Diferencia entre singleton y prototype scope? ¿Cuál es el default?

**A8.**

* **Singleton (default)**: Una única instancia por contenedor IoC.
* **Prototype**: Nueva instancia cada vez que se solicita.

---

### ❓ Q9. ¿Cuándo usar singleton y cuándo prototype?

**A9.**

* **Singleton**: Para servicios **stateless**, como DAOs o servicios comunes.
* **Prototype**: Para objetos **stateful** usados en hilos distintos, como un cliente HTTP no thread-safe.

---

### ❓ Q10. ¿Qué pasa si inyectás un bean prototype dentro de uno singleton?

**A10.** Se inyecta una única instancia del bean prototype durante la creación del singleton. Se comparte esa misma instancia.

---

### ❓ Q11. ¿Cuáles son los scopes especiales en una Web Application?

**A11.**

* **Request**: Nueva instancia por cada HTTP request.
* **Session**: Nueva instancia por sesión de usuario.
* **GlobalSession**: Como session, pero para contextos portlet.

---

### 📌 Resumen Final

| Concepto        | Propósito Principal                                            |
| --------------- | -------------------------------------------------------------- |
| DIP             | Separar niveles lógicos mediante abstracciones                 |
| DI              | Patrón para inyectar dependencias desde afuera                 |
| IoC             | Principio donde el framework maneja el control y ciclo de vida |
| Singleton Scope | Un solo bean por contenedor                                    |
| Prototype Scope | Bean nuevo cada vez que se solicita                            |
| Bean Lifecycle  | Desde creación e inyección, hasta destrucción controlada       |


Estas preguntas son muy comunes en entrevistas técnicas de Java/Spring y dominarlas te ayudará a destacar 🚀
