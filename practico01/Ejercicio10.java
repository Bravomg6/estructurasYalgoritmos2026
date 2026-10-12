/*
Prompt inicial utilizado:
"Generame un programa en Java que cree un arreglo de notas y calcule el promedio."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Grade Average Calculator ===");

        // Ask the user how many grades they want to enter.
        System.out.print("How many grades do you want to store? ");
        int count = scanner.nextInt();

        // Validate that the count is a positive number.
        if (count <= 0) {
            System.out.println("Error: you must enter at least one grade.");
            scanner.close();
            return;
        }

        // Create an array of doubles with the specified size.
        // Arrays have a fixed size once created.
        double[] grades = new double[count];

        // Read each grade and store it in the array using its index.
        // Array indices start at 0 and go up to (length - 1).
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Variable used to accumulate the sum of all grades.
        double sum = 0;

        // Traverse the array using a for loop and add each grade to the sum.
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        // Calculate the average by dividing the total sum by the number of elements.
        // grades.length returns the number of elements in the array.
        double average = sum / grades.length;

        // Display all grades and the final average.
        System.out.println();
        System.out.println("=== Results ===");
        System.out.print("Grades entered: ");
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i]);
            if (i < grades.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.printf("Total sum:   %.2f%n", sum);
        System.out.printf("Average:     %.2f%n", average);

        scanner.close();
    }
}
