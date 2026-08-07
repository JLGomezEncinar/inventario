# Sistema de Gestión de Inventario - Distribuidora de Hostelería

Este proyecto es una aplicación web desarrollada en **Java** utilizando el framework **Spring Boot** para gestionar el catálogo de productos de una distribuidora de hostelería. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los productos, interactuando con una base de datos relacional **MySQL** a través de **Spring Data JPA** y presentando una interfaz de usuario dinámica con **Thymeleaf**.

---

## 🚀 Características principales

* **Gestión Completa de Productos (CRUD):**
  * **Listar:** Visualización de todos los productos registrados en una tabla dinámica.
  * **Registrar:** Formulario interactivo para dar de alta nuevos productos.
  * **Modificar:** Edición rápida de los campos de un producto existente.
  * **Eliminar:** Borrado de productos del inventario con confirmación de seguridad.
* **Validación de Datos en el Servidor:** Control estricto de los campos obligatorios y verificación de que el stock y precio sean valores positivos.
* **Interfaz Limpia y Moderna:** Estilos visuales optimizados usando CSS nativo y renderizado dinámico con plantillas de Thymeleaf.

---

## 🛠️ Tecnologías utilizadas

* **Backend:** Java 25 & Spring Boot (4.1.0)
* **Acceso a datos:** Spring Data JPA
* **Base de datos:** MySQL (a través de `mysql-connector-j`)
* **Frontend:** Thymeleaf (Motor de plantillas HTML5) y CSS3
* **Gestor de dependencias:** Maven
* **Entorno de desarrollo / Herramientas:** Spring Boot DevTools (recarga en caliente)

---

## 📂 Estructura del proyecto

El código fuente principal está organizado de la siguiente manera:

* [`src/main/java/com/jlgomezencinar/inventario`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario)
  * [`model/Producto.java`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario/model/Producto.java): Entidad JPA que representa un producto en la base de datos.
  * [`repository/IProductoRepository.java`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario/repository/IProductoRepository.java): Interfaz del repositorio que extiende de `JpaRepository` para las operaciones con la BD.
  * [`service/`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario/service): Contiene la lógica de negocio y las validaciones de los datos antes de persistirlos.
    * [`IProductoService.java`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario/service/IProductoService.java)
    * [`ProductoService.java`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario/service/ProductoService.java)
  * [`controller/ProductoWebController.java`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario/controller/ProductoWebController.java): Controlador web que gestiona los endpoints y el enrutamiento de las vistas.
* [`src/main/resources/`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/resources)
  * [`application.properties`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/resources/application.properties): Archivo de configuración global (conexión a base de datos, puerto, etc.).
  * [`templates/productos/`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/resources/templates/productos): Vistas de Thymeleaf (`lista.html` y `formulario.html`).
  * [`static/css/style.css`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/resources/static/css/style.css): Estilos visuales del frontend.

---

## 📋 Requisitos previos

Para poder ejecutar este proyecto de forma local, necesitarás disponer de:
1. **Java Development Kit (JDK)** versión 25 o superior.
2. **MySQL Server** (u otro servidor compatible con MySQL, como MariaDB).
3. **Maven** (incluido mediante el wrapper `./mvnw` en el proyecto).

---

## ⚙️ Configuración e Instalación

### 1. Clonar el repositorio
Asegúrate de estar en tu directorio de trabajo y clona el proyecto:
```bash
git clone <url-del-repositorio>
cd inventario
```

### 2. Configurar la Base de Datos MySQL
Inicia sesión en tu base de datos y crea el esquema correspondiente:
```sql
CREATE DATABASE dibesa;
```

### 3. Ajustar las Credenciales
Abre el archivo [`src/main/resources/application.properties`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/resources/application.properties) y edita las siguientes propiedades según tu configuración local de MySQL (usuario y contraseña):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dibesa
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

*Nota: La propiedad `spring.jpa.hibernate.ddl-auto=update` creará las tablas necesarias de forma automática la primera vez que inicies la aplicación.*

---

## 🏃 Ejecución de la aplicación

Puedes arrancar la aplicación de dos formas:

### Opción A: Desde la consola con Maven Wrapper
* **Windows (PowerShell/CMD):**
  ```powershell
  .\mvnw.cmd spring-boot:run
  ```
* **Linux / macOS:**
  ```bash
  ./mvnw spring-boot:run
  ```

### Opción B: Desde tu IDE favorito
Abre el proyecto en IntelliJ IDEA, Eclipse o VS Code y ejecuta la clase principal [`InventarioApplication.java`](file:///c:/Users/lalal/IdeaProjects/inventario/src/main/java/com/jlgomezencinar/inventario/InventarioApplication.java) como una aplicación Java standard.

Una vez iniciada con éxito, la aplicación estará disponible en tu navegador web en la dirección:
👉 **[http://localhost:8080/productos](http://localhost:8080/productos)**

---

## 📌 Rutas / Endpoints disponibles

| Método HTTP | Endpoint | Descripción |
| :--- | :--- | :--- |
| **GET** | `/productos` | Muestra el listado de todos los productos en stock. |
| **GET** | `/productos/nuevo` | Carga el formulario para registrar un nuevo producto. |
| **POST** | `/productos/crear` | Guarda el producto (crea uno nuevo o actualiza uno existente según su ID). |
| **GET** | `/productos/modificar/{codProducto}` | Carga el formulario con los datos cargados del producto a editar. |
| **POST** | `/productos/eliminar/{codProducto}` | Elimina el producto correspondiente de la base de datos. |

---

## 🧪 Pruebas unitarias
El proyecto contiene pruebas básicas de arranque que puedes ejecutar mediante:
```bash
./mvnw test
```
