/*
Prompt inicial utilizado:
"Generame un programa en Java con un menú de opciones usando switch. El menú debe tener cuatro opciones y una opción inválida."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Muestra las opciones del menú al usuario.
        System.out.println("=== Menú principal ===");
        System.out.println("1. Ver perfil");
        System.out.println("2. Editar configuración");
        System.out.println("3. Ver ayuda");
        System.out.println("4. Salir");
        System.out.println();
        System.out.print("Seleccione una opción (1-4): ");

        // Lee la opción elegida por el usuario.
        int option = scanner.nextInt();

        // Usa una sentencia switch para ejecutar una lógica distinta según la opción.
        switch (option) {
            case 1:
                System.out.println("Seleccionó: VER PERFIL");
                System.out.println("Cargando datos del perfil...");
                break;
            case 2:
                System.out.println("Seleccionó: EDITAR CONFIGURACIÓN");
                System.out.println("Abriendo el panel de configuración...");
                break;
            case 3:
                System.out.println("Seleccionó: VER AYUDA");
                System.out.println("Mostrando la documentación de ayuda...");
                break;
            case 4:
                System.out.println("Seleccionó: SALIR");
                System.out.println("¡Hasta luego!");
                break;
            default:
                // El caso default maneja cualquier valor no contemplado arriba.
                System.out.println("Opción no válida. Elija un número entre 1 y 4.");
                break;
        }

        scanner.close();
    }
}
