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

        System.out.println("=== Calculadora básica ===");

        // Lee el primer número.
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        // Lee el operador como un solo carácter.
        System.out.print("Ingrese un operador (+, -, *, /, %): ");
        char operator = scanner.next().charAt(0);

        // Lee el segundo número.
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double result;
        boolean validOperation = true;

        // Realiza la operación según el operador ingresado.
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
                // Valida la división por cero antes de realizar la operación.
                if (num2 == 0) {
                    System.out.println("Error: no se permite la división por cero.");
                    validOperation = false;
                    result = 0;
                } else {
                    result = num1 / num2;
                }
                break;
            case '%':
                // Valida el módulo por cero antes de realizar la operación.
                if (num2 == 0) {
                    System.out.println("Error: no se permite el módulo por cero.");
                    validOperation = false;
                    result = 0;
                } else {
                    result = num1 % num2;
                }
                break;
            default:
                System.out.println("Error: operador no válido '" + operator + "'.");
                validOperation = false;
                result = 0;
        }

        // Muestra el resultado solo si la operación fue válida.
        if (validOperation) {
            System.out.println();
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }

        scanner.close();
    }
}
