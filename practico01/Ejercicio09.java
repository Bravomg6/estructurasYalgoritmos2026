/*
Prompt inicial utilizado:
"Generame un programa en Java con métodos sumar(), restar() y multiplicar(). Explicá cómo se reutiliza código mediante métodos."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio09 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculator with Methods ===");

        // Read two numbers from the user.
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println();

        // Call each method and display the returned result.
        // Methods allow code reusability: once defined, they can be called
        // multiple times with different arguments without rewriting the logic.
        double sumResult = add(num1, num2);
        double subResult = subtract(num1, num2);
        double mulResult = multiply(num1, num2);

        System.out.println("Sum:        " + num1 + " + " + num2 + " = " + sumResult);
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + subResult);
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + mulResult);

        // Demonstrate reusability: call the add method again with different values.
        System.out.println();
        System.out.println("Reusing the add method: add(10, 20) = " + add(10, 20));

        scanner.close();
    }

    // Method that receives two double parameters and returns their sum.
    public static double add(double a, double b) {
        return a + b;
    }

    // Method that receives two double parameters and returns their difference.
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method that receives two double parameters and returns their product.
    public static double multiply(double a, double b) {
        return a * b;
    }
}
