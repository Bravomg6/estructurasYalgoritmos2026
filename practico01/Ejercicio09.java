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

        System.out.println("=== Calculadora con métodos ===");

        // Lee dos números del usuario.
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println();

        // Llama a cada método y muestra el resultado devuelto.
        // Los métodos permiten reutilizar código: una vez definidos, pueden llamarse
        // varias veces con argumentos diferentes sin reescribir la lógica.
        double sumResult = add(num1, num2);
        double subResult = subtract(num1, num2);
        double mulResult = multiply(num1, num2);

        System.out.println("Suma:           " + num1 + " + " + num2 + " = " + sumResult);
        System.out.println("Resta:          " + num1 + " - " + num2 + " = " + subResult);
        System.out.println("Multiplicación: " + num1 + " * " + num2 + " = " + mulResult);

        // Demuestra la reutilización: llama nuevamente al método add con otros valores.
        System.out.println();
        System.out.println("Reutilizando el método add: add(10, 20) = " + add(10, 20));

        scanner.close();
    }

    // Método que recibe dos parámetros double y devuelve su suma.
    public static double add(double a, double b) {
        return a + b;
    }

    // Método que recibe dos parámetros double y devuelve su diferencia.
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Método que recibe dos parámetros double y devuelve su producto.
    public static double multiply(double a, double b) {
        return a * b;
    }
}
