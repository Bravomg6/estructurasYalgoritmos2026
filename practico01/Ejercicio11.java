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

        // ArrayList is a dynamic collection: it grows and shrinks automatically.
        // Unlike arrays, we do not need to specify a fixed size.
        // The <String> generics parameter means this list stores only Strings.
        ArrayList<String> students = new ArrayList<>();

        System.out.println("=== Student List Manager ===");
        System.out.println("Enter student names (type 'done' to finish):");
        System.out.println();

        // Read names in a loop until the user types "done".
        while (true) {
            System.out.print("Enter a name (or 'done' to finish): ");
            String name = scanner.nextLine();

            // Check if the user wants to stop entering names.
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            // Validate that the name is not empty before adding it.
            if (name.trim().isEmpty()) {
                System.out.println("Error: the name cannot be empty. Try again.");
                continue;
            }

            // add() inserts the new element at the end of the ArrayList.
            students.add(name);
            System.out.println("Added '" + name + "'. Total students: " + students.size());
        }

        System.out.println();
        System.out.println("=== Complete Student List ===");

        // Check if the list is empty before trying to display it.
        if (students.isEmpty()) {
            System.out.println("No students were registered.");
        } else {
            // size() returns the number of elements currently in the ArrayList.
            int total = students.size();
            System.out.println("Total students registered: " + total);
            System.out.println();

            // Display each student using get(index) to access elements by position.
            for (int i = 0; i < total; i++) {
                // get(i) retrieves the element at index i (0-based).
                String studentName = students.get(i);
                System.out.println((i + 1) + ". " + studentName);
            }

            // Demonstrate additional ArrayList operations.
            System.out.println();
            System.out.println("=== Additional Operations ===");
            System.out.println("First student: " + students.get(0));
            System.out.println("Last student:  " + students.get(total - 1));

            // contains() checks if an element exists in the list.
            System.out.print("Search for a name: ");
            String searchName = scanner.nextLine();
            if (students.contains(searchName)) {
                System.out.println("'" + searchName + "' was found in the list.");
            } else {
                System.out.println("'" + searchName + "' was NOT found in the list.");
            }

            // remove() removes the first occurrence of the specified element.
            System.out.print("Name to remove: ");
            String removeName = scanner.nextLine();
            if (students.remove(removeName)) {
                System.out.println("'" + removeName + "' was removed. New total: " + students.size());
            } else {
                System.out.println("'" + removeName + "' was not found. No changes made.");
            }

            // Show the updated list after removal.
            System.out.println();
            System.out.println("=== Updated List ===");
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }
        }

        scanner.close();
    }
}
