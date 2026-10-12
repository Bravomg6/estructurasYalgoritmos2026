/*
Prompt inicial utilizado:
"Realizá una calculadora básica en Java utilizando Scanner. Debe permitir sumar, restar, multiplicar, dividir y calcular el módulo entre dos números."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Basic Calculator ===");

        // Read the first number.
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        // Read the operator as a single character.
        System.out.print("Enter an operator (+, -, *, /, %): ");
        char operator = scanner.next().charAt(0);

        // Read the second number.
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result;
        boolean validOperation = true;

        // Perform the operation based on the operator entered.
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // Validate division by zero before performing the operation.
                if (num2 == 0) {
                    System.out.println("Error: division by zero is not allowed.");
                    validOperation = false;
                    result = 0;
                } else {
                    result = num1 / num2;
                }
                break;
            case '%':
                // Validate modulo by zero before performing the operation.
                if (num2 == 0) {
                    System.out.println("Error: modulo by zero is not allowed.");
                    validOperation = false;
                    result = 0;
                } else {
                    result = num1 % num2;
                }
                break;
            default:
                System.out.println("Error: invalid operator '" + operator + "'.");
                validOperation = false;
                result = 0;
        }

        // Display the result only if the operation was valid.
        if (validOperation) {
            System.out.println();
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }

        scanner.close();
    }
}
