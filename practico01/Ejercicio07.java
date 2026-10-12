/*
Prompt inicial utilizado:
"Generame un programa en Java que muestre un contador utilizando while."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== While Loop Counter ===");

        // Ask the user for the limit of the counter.
        System.out.print("Enter the upper limit for the counter: ");
        int limit = scanner.nextInt();

        // Validate that the limit is positive.
        if (limit <= 0) {
            System.out.println("Error: the limit must be a positive number.");
            scanner.close();
            return;
        }

        // Initialize the counter variable (start value).
        int counter = 1;

        // The while loop repeats the block as long as the condition is true.
        // IMPORTANT: the counter must be incremented inside the loop to avoid an infinite loop.
        while (counter <= limit) {
            System.out.println("Counter: " + counter);

            // Increment the counter by 1 to move toward the exit condition.
            counter++;
        }

        System.out.println("Counter finished. Final value: " + counter);

        scanner.close();
    }
}
