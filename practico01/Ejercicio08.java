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

        System.out.println("=== Generador de tabla de multiplicar ===");

        // Pide al usuario el número para generar su tabla de multiplicar.
        System.out.print("Ingrese un número para ver su tabla de multiplicar: ");
        int number = scanner.nextInt();

        System.out.println();
        System.out.println("Tabla de multiplicar del número " + number + ":");
        System.out.println("-----------------------------------");

        // El bucle for tiene tres partes:
        // 1. Inicialización: int i = 1 (valor inicial de la variable de control).
        // 2. Condición: i <= 10 (el bucle continúa mientras sea verdadera).
        // 3. Incremento: i++ (la variable de control aumenta en 1 después de cada iteración).
        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }

        System.out.println("-----------------------------------");

        scanner.close();
    }
}
