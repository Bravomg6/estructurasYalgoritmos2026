/*
Prompt inicial utilizado:
"Generame un programa en Java que utilice ArrayList para agregar nombres de alumnos y luego mostrar la lista completa."

Ajustes realizados:
Ninguno
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ArrayList es una colección dinámica: crece y se reduce automáticamente.
        // A diferencia de los arreglos, no es necesario indicar un tamaño fijo.
        // El parámetro genérico <String> indica que esta lista almacena solo String.
        ArrayList<String> students = new ArrayList<>();

        System.out.println("=== Gestor de lista de alumnos ===");
        System.out.println("Ingrese nombres de alumnos (escriba 'done' para finalizar):");
        System.out.println();

        // Lee nombres en un bucle hasta que el usuario escriba "done".
        while (true) {
            System.out.print("Ingrese un nombre (o 'done' para finalizar): ");
            String name = scanner.nextLine();

            // Verifica si el usuario quiere dejar de ingresar nombres.
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            // Valida que el nombre no esté vacío antes de agregarlo.
            if (name.trim().isEmpty()) {
                System.out.println("Error: el nombre no puede estar vacío. Intente de nuevo.");
                continue;
            }

            // add() inserta el nuevo elemento al final del ArrayList.
            students.add(name);
            System.out.println("Se agregó '" + name + "'. Total de alumnos: " + students.size());
        }

        System.out.println();
        System.out.println("=== Lista completa de alumnos ===");

        // Verifica si la lista está vacía antes de intentar mostrarla.
        if (students.isEmpty()) {
            System.out.println("No se registró ningún alumno.");
        } else {
            // size() devuelve la cantidad de elementos que tiene el ArrayList.
            int total = students.size();
            System.out.println("Total de alumnos registrados: " + total);
            System.out.println();

            // Muestra cada alumno usando get(index) para acceder a los elementos por posición.
            for (int i = 0; i < total; i++) {
                // get(i) obtiene el elemento en el índice i (comenzando en 0).
                String studentName = students.get(i);
                System.out.println((i + 1) + ". " + studentName);
            }

            // Demuestra operaciones adicionales con ArrayList.
            System.out.println();
            System.out.println("=== Operaciones adicionales ===");
            System.out.println("Primer alumno: " + students.get(0));
            System.out.println("Último alumno: " + students.get(total - 1));

            // contains() verifica si un elemento existe en la lista.
            System.out.print("Buscar un nombre: ");
            String searchName = scanner.nextLine();
            if (students.contains(searchName)) {
                System.out.println("'" + searchName + "' se encontró en la lista.");
            } else {
                System.out.println("'" + searchName + "' NO se encontró en la lista.");
            }

            // remove() elimina la primera aparición del elemento indicado.
            System.out.print("Nombre a eliminar: ");
            String removeName = scanner.nextLine();
            if (students.remove(removeName)) {
                System.out.println("'" + removeName + "' se eliminó. Nuevo total: " + students.size());
            } else {
                System.out.println("'" + removeName + "' no se encontró. No se realizaron cambios.");
            }

            // Muestra la lista actualizada después de la eliminación.
            System.out.println();
            System.out.println("=== Lista actualizada ===");
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }
        }

        scanner.close();
    }
}
