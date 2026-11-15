# Catálogo de Películas en Java

Programa de consola, hecho en Java, para administrar un catálogo de películas. Permite agregar, listar, buscar, modificar la calificación y eliminar películas desde un menú interactivo.

Es el proyecto del taller *Catálogo de Películas en Java*, desarrollado en equipo por:

- Juan David González Reyes
- Wen
- Kevin Andrés Jaramillo Puerta

## Características

- Registro de películas con título, director, género, año y calificación (0 a 10).
- Listado de todas las películas registradas.
- Búsqueda por título (sin distinguir mayúsculas y minúsculas).
- Modificación de la calificación de una película.
- Eliminación de una película con confirmación previa.
- Validación de entradas: textos no vacíos, números enteros, años entre 1888 y 2100 y calificaciones entre 0 y 10.
- Si la entrada se cierra (Ctrl+D), el programa termina sin errores.

## Requisitos

- JDK 8 o superior (probado con JDK 17+).

## Cómo ejecutar

Clona el repositorio y entra a la carpeta del proyecto:

```bash
git clone https://github.com/tzerk-last/catalogo.git
cd catalogo
```

Compila y ejecuta desde la terminal:

```bash
javac -d out src/Main.java
java -cp out Main
```

También puedes abrir la carpeta en un IDE (VS Code, IntelliJ, Eclipse) y ejecutar `Main`.

## Menú

| Opción | Acción |
|---|---|
| 1 | Agregar película |
| 2 | Mostrar películas |
| 3 | Buscar película por título |
| 4 | Modificar calificación |
| 5 | Eliminar película (pide confirmación) |
| 6 | Información del programa |
| 7 | Salir |

## Estructura del proyecto

```
catalogo/
├── README.md
└── src/
    ├── Main.java      # Programa principal: menú y operaciones del catálogo
    └── Producto.java  # Clase de ejemplo del repositorio; no la usa el programa
```

## Notas de diseño

- Los datos se guardan en arrays paralelos de 100 posiciones: la posición `i` de cada array corresponde a la misma película.
- Los datos viven solo en memoria: al cerrar el programa se pierden.
- No se permiten más de 100 películas.

## Reparto de trabajo

Cada integrante escribió una parte del programa:

- **Menú y navegación:** `main`, `mostrarMenu`, `mostrarInformacion`.
- **Registro y visualización:** `agregarPelicula`, `mostrarPeliculas`, `mostrarPelicula`.
- **Búsqueda y modificación:** `buscarIndice`, `buscarPelicula`, `modificarPelicula`.
- **Eliminación y validaciones:** `eliminarPelicula`, `leerTexto`, `leerEntero`, `leerAnio`, `leerCalificacion`, `leerLinea`.

## Licencia

Proyecto con fines educativos.
