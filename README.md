# StockFácil 2.0 — PA4

Sistema web de gestión de inventario desarrollado para la evaluación PA4 del curso Programación Orientada a Objetos.

## Objetivo

Administrar productos electrónicos, alimenticios y de limpieza aplicando programación orientada a objetos y colecciones genéricas de Java.

## Tecnologías

- Java 17
- Maven
- JSP y Jakarta Servlets
- Apache Tomcat 11
- Java Collections Framework

## Contenidos que debe demostrar el equipo

- Colección genérica de objetos mediante `HashSet<Producto>`.
- Operaciones de registro, recorrido, búsqueda y eliminación.
- Uso de `ArrayList<Producto>` como colección auxiliar para ordenar.
- Jerarquía con clase abstracta `Producto` y tres subclases.
- Interfaz `Identificable`.
- Sobrescritura de métodos con `@Override`.
- Sobrescritura de `equals()` y `hashCode()` para evitar IDs duplicados en el `HashSet`.

## Contratos de integración acordados

### Modelo

- `Identificable`: `getId()` y `obtenerIdentificador()`.
- `Producto` abstracta: `id`, `nombre`, `precio`, `stock`, `calcularValorStock()` y `mostrarDetalles()`.
- Subclases: `ProductoElectronico`, `ProductoAlimenticio` y `ProductoLimpieza`.

### Servicio

`Inventario` administra el `HashSet<Producto>` y ofrece métodos para agregar, listar, buscar, eliminar, filtrar y ordenar productos.

## Estructura prevista

```text
src/main/java/com/stockfacil/
├── modelo/
├── servicio/
├── servlet/
└── configuracion/
src/main/webapp/
├── index.jsp
├── css/
└── WEB-INF/vistas/
```

## Ejecución

1. Abrir la carpeta que contiene `pom.xml` en IntelliJ IDEA.
2. Configurar JDK 17.
3. Recargar el proyecto Maven.
4. Ejecutar `clean` y `package` desde Maven > Lifecycle.
5. Desplegar el WAR en Apache Tomcat 11.

> Esta es la estructura inicial del equipo. Las funcionalidades se incorporarán durante el desarrollo colaborativo. El inventario se almacenará en memoria; los datos no serán persistentes al reiniciar la aplicación.

## Integrantes

- Sebastian Borda Ojeda
- Adrian Basurco Castro
- Ammy Illescas Carbajal
- Jorge Adrian Illescas Carbajal
- Rodrigo Sifuentes Alza

## Video de exposición

https://youtu.be/AgoNF5m9QFI
