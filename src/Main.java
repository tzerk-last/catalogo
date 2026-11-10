import java.util.Scanner;

/*
 * Taller: Catálogo de Películas en Java
 * PARTE 1 — Integrante 1: Menú y navegación.
 *
 * Esta parte contiene los datos compartidos y el menú principal.
 * Las opciones 1 a 5 llaman a métodos que escriben los demás integrantes
 * (Partes 2, 3 y 4) y se agregan en los siguientes commits.
 */
public class Main {

    // ===== DATOS COMPARTIDOS =====
    static final int CAPACIDAD = 100;

    static String[] titulos = new String[CAPACIDAD];
    static String[] directores = new String[CAPACIDAD];
    static String[] generos = new String[CAPACIDAD];
    static int[] anios = new int[CAPACIDAD];
    static double[] calificaciones = new double[CAPACIDAD];

    static int cantidad = 0;
    static Scanner scanner = new Scanner(System.in);

    // ===== MENÚ PRINCIPAL =====
    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    agregarPelicula();          // Parte 2
                    break;
                case 2:
                    mostrarPeliculas();         // Parte 2
                    break;
                case 3:
                    buscarPelicula();           // Parte 3
                    break;
                case 4:
                    modificarPelicula();        // Parte 3
                    break;
                case 5:
                    eliminarPelicula();         // Parte 4
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
}
