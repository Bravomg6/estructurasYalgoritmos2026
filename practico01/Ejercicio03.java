/*
Prompt inicial utilizado:
"Generame un programa que solicite nombre y edad utilizando Scanner."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args) {

        // Create a Scanner object that reads input from the console (System.in).
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== User Registration ===");

        // Prompt the user to enter their name and read the input as a String.
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Prompt the user to enter their age and read the input as an integer.
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Display a personalized message using the data entered by the user.
        System.out.println();
        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        // Conditional message based on age.
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }

        // Always close the Scanner to release system resources.
        scanner.close();
    }
}
