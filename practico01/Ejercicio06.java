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

        // Display the menu options to the user.
        System.out.println("=== Main Menu ===");
        System.out.println("1. View profile");
        System.out.println("2. Edit settings");
        System.out.println("3. View help");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Select an option (1-4): ");

        // Read the user's choice.
        int option = scanner.nextInt();

        // Use a switch statement to execute different logic per option.
        switch (option) {
            case 1:
                System.out.println("You selected: VIEW PROFILE");
                System.out.println("Loading profile data...");
                break;
            case 2:
                System.out.println("You selected: EDIT SETTINGS");
                System.out.println("Opening settings panel...");
                break;
            case 3:
                System.out.println("You selected: VIEW HELP");
                System.out.println("Displaying help documentation...");
                break;
            case 4:
                System.out.println("You selected: EXIT");
                System.out.println("Goodbye!");
                break;
            default:
                // The default case handles any value not covered above.
                System.out.println("Invalid option. Please choose a number between 1 and 4.");
                break;
        }

        scanner.close();
    }
}
