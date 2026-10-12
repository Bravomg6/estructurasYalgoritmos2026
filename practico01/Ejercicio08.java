/*
Prompt inicial utilizado:
"Generame un programa en Java que solicite un número y muestre su tabla de multiplicar utilizando for."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio08 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Multiplication Table Generator ===");

        // Ask the user for the number to generate its multiplication table.
        System.out.print("Enter a number to see its multiplication table: ");
        int number = scanner.nextInt();

        System.out.println();
        System.out.println("Multiplication table for " + number + ":");
        System.out.println("-----------------------------------");

        // The for loop has three parts:
        // 1. Initialization: int i = 1 (start value of the control variable).
        // 2. Condition: i <= 10 (the loop continues while this is true).
        // 3. Increment: i++ (the control variable increases by 1 after each iteration).
        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }

        System.out.println("-----------------------------------");

        scanner.close();
    }
}
