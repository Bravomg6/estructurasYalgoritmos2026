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

        System.out.println("=== Calculadora de promedio de notas ===");

        // Pide al usuario cuántas notas desea ingresar.
        System.out.print("¿Cuántas notas desea ingresar? ");
        int count = scanner.nextInt();

        // Valida que la cantidad sea un número positivo.
        if (count <= 0) {
            System.out.println("Error: debe ingresar al menos una nota.");
            scanner.close();
            return;
        }

        // Crea un arreglo de tipo double con el tamaño especificado.
        // Los arreglos tienen un tamaño fijo una vez creados.
        double[] grades = new double[count];

        // Lee cada nota y la almacena en el arreglo usando su índice.
        // Los índices del arreglo comienzan en 0 y llegan hasta (length - 1).
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Variable utilizada para acumular la suma de todas las notas.
        double sum = 0;

        // Recorre el arreglo con un bucle for y suma cada nota al total.
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        // Calcula el promedio dividiendo la suma total por la cantidad de elementos.
        // grades.length devuelve la cantidad de elementos del arreglo.
        double average = sum / grades.length;

        // Muestra todas las notas y el promedio final.
        System.out.println();
        System.out.println("=== Resultados ===");
        System.out.print("Notas ingresadas: ");
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i]);
            if (i < grades.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.printf("Suma total:  %.2f%n", sum);
        System.out.printf("Promedio:    %.2f%n", average);

        scanner.close();
    }
}
