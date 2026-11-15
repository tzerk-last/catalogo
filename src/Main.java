// Integrantes del equipo:
// - Juan David González Reyes
// - Wen
// - Kevin Andrés Jaramillo Puerta

import java.util.Scanner;

public class Main {

    // =====================================================================
    // DATOS COMPARTIDOS (todos los integrantes usan estas variables)
    // =====================================================================
    static final int CAPACIDAD = 100;

    static String[] titulos = new String[CAPACIDAD];
    static String[] directores = new String[CAPACIDAD];
    static String[] generos = new String[CAPACIDAD];
    static int[] anios = new int[CAPACIDAD];
    static double[] calificaciones = new double[CAPACIDAD];

    static int cantidad = 0;                       // cuántas películas hay registradas
    static Scanner scanner = new Scanner(System.in);

    // =====================================================================
    // INTEGRANTE 1 — MENÚ Y NAVEGACIÓN
    // =====================================================================
    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    mostrarPeliculas();
                    break;
                case 3:
                    buscarPelicula();
                    break;
                case 4:
                    modificarPelicula();
                    break;
                case 5:
                    eliminarPelicula();
                    break;
                case 6:
                    mostrarInformacion();
                    break;
                case 7:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

            System.out.println();
        } while (opcion != 7);

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println("===== CATÁLOGO DE PELÍCULAS =====");
        System.out.println("1. Agregar película");
        System.out.println("2. Mostrar películas");
        System.out.println("3. Buscar película");
        System.out.println("4. Modificar calificación");
        System.out.println("5. Eliminar película");
        System.out.println("6. Información del programa");
        System.out.println("7. Salir");
    }

    static void mostrarInformacion() {
        System.out.println("--- Información del programa ---");
        System.out.println("Nombre: Catálogo de Películas");
        System.out.println("Lenguaje: Java");
        System.out.println("Tipo: Aplicación de consola");
        System.out.println("Equipo: Integrante 1, Integrante 2, Integrante 3, Integrante 4");
    }

    // =====================================================================
    // INTEGRANTE 2 — REGISTRO Y VISUALIZACIÓN (CREATE / READ)
    // =====================================================================
    static void agregarPelicula() {
        if (cantidad >= CAPACIDAD) {
            System.out.println("No hay espacio para más películas (máximo " + CAPACIDAD + ").");
            return;
        }

        System.out.println("--- Agregar película ---");
        String titulo = leerTexto("Título: ");
        String director = leerTexto("Director: ");
        String genero = leerTexto("Género: ");
        int anio = leerEntero("Año: ");
        double calificacion = leerCalificacion("Calificación (0 a 10): ");

        // Se guarda en la siguiente posición libre de los arrays
        titulos[cantidad] = titulo;
        directores[cantidad] = director;
        generos[cantidad] = genero;
        anios[cantidad] = anio;
        calificaciones[cantidad] = calificacion;
        cantidad++;

        System.out.println("Película agregada correctamente.");
    }

    static void mostrarPeliculas() {
        if (cantidad == 0) {
            System.out.println("No hay películas registradas.");
            return;
        }

        System.out.println("--- Películas registradas ---");
        for (int i = 0; i < cantidad; i++) {
            mostrarPelicula(i);
        }
    }

    // Muestra los datos de la película que está en la posición i
    static void mostrarPelicula(int i) {
        System.out.println("Título:       " + titulos[i]);
        System.out.println("Director:     " + directores[i]);
        System.out.println("Género:       " + generos[i]);
        System.out.println("Año:          " + anios[i]);
        System.out.println("Calificación: " + calificaciones[i]);
        System.out.println("------------------------------");
    }

    // =====================================================================
    // INTEGRANTE 3 — BÚSQUEDA Y MODIFICACIÓN (UPDATE)
    // =====================================================================
    // Devuelve la posición de la película con ese título, o -1 si no existe
    static int buscarIndice(String titulo) {
        for (int i = 0; i < cantidad; i++) {
            if (titulos[i].equalsIgnoreCase(titulo)) {
                return i;
            }
        }
        return -1;
    }

    static void buscarPelicula() {
        System.out.println("--- Buscar película ---");
        String titulo = leerTexto("Título a buscar: ");
        int i = buscarIndice(titulo);

        if (i == -1) {
            System.out.println("Película no encontrada.");
        } else {
            mostrarPelicula(i);
        }
    }

    static void modificarPelicula() {
        System.out.println("--- Modificar calificación ---");
        String titulo = leerTexto("Título de la película a modificar: ");
        int i = buscarIndice(titulo);

        if (i == -1) {
            System.out.println("Película no encontrada.");
            return;
        }

        mostrarPelicula(i);
        calificaciones[i] = leerCalificacion("Nueva calificación (0 a 10): ");
        System.out.println("Calificación actualizada.");
    }

    // =====================================================================
    // INTEGRANTE 4 — ELIMINACIÓN Y VALIDACIONES (DELETE + validaciones)
    // =====================================================================
    static void eliminarPelicula() {
        System.out.println("--- Eliminar película ---");
        String titulo = leerTexto("Título de la película a eliminar: ");
        int i = buscarIndice(titulo);

        if (i == -1) {
            System.out.println("Película no encontrada.");
            return;
        }

        mostrarPelicula(i);
        int confirmacion = leerEntero("¿Confirma la eliminación? 1. Sí  2. No: ");
        if (confirmacion != 1) {
            System.out.println("Eliminación cancelada.");
            return;
        }

        // Se corren las películas siguientes una posición hacia atrás
        for (int j = i; j < cantidad - 1; j++) {
            titulos[j] = titulos[j + 1];
            directores[j] = directores[j + 1];
            generos[j] = generos[j + 1];
            anios[j] = anios[j + 1];
            calificaciones[j] = calificaciones[j + 1];
        }

        // Se limpia la última posición que quedó repetida
        cantidad--;
        titulos[cantidad] = null;
        directores[cantidad] = null;
        generos[cantidad] = null;
        anios[cantidad] = 0;
        calificaciones[cantidad] = 0.0;

        System.out.println("Película eliminada correctamente.");
    }

    // --- Validaciones de entrada (las usan todos los integrantes) ---

    // Pide un texto y no acepta vacío
    static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    // Pide un número entero y repite hasta que sea válido
    static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    // Pide una calificación decimal entre 0 y 10 (acepta coma o punto)
    static double leerCalificacion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(entrada);
                if (valor >= 0 && valor <= 10) {
                    return valor;
                }
                System.out.println("La calificación debe estar entre 0 y 10.");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }
}
