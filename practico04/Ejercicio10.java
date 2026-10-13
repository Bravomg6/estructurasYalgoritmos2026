/*
Prompt inicial utilizado:
Implementar el algoritmo Bubble Sort en Java para ordenar un arreglo de enteros
en orden ascendente.
Estrategia: recorrer el arreglo repetidamente, comparando elementos adyacentes e
intercambiándolos si están en el orden incorrecto. Después de cada pasada, el
elemento sin ordenar más grande "burbujea" hasta su posición correcta.
Justificación: Bubble Sort solo es adecuado con fines educativos o para
conjuntos de datos muy pequeños, porque su complejidad temporal de O(n^2) en
promedio y en el peor caso lo hace impráctico para entradas grandes. Algoritmos
como QuickSort o MergeSort son preferidos en producción.
Complejidad temporal: O(n^2) en promedio y en el peor caso, O(n) en el mejor
caso (ya ordenado con la optimización). Complejidad espacial: O(1).
El programa debe contar la cantidad de comparaciones e intercambios realizados.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio10 {

    /**
     * Ordena un arreglo usando Bubble Sort con contadores de comparaciones e intercambios.
     * Complejidad temporal: O(n^2) en promedio/peor caso, O(n) en el mejor caso (optimizado).
     * Complejidad espacial: O(1) — ordenamiento en el lugar.
     * Devuelve un arreglo donde el índice 0 = comparaciones, índice 1 = intercambios.
     */
    public static long[] bubbleSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimización: detecta si el arreglo ya está ordenado

            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    // Se intercambian elementos adyacentes
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            // Si no hubo intercambios en esta pasada, el arreglo está ordenado
            if (!swapped) {
                break;
            }
        }

        return new long[]{comparisons, swaps};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Ingrese " + n + " enteros:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Arreglo original: ");
        printArray(array);

        long[] stats = bubbleSort(array);

        System.out.println("Arreglo ordenado: ");
        printArray(array);
        System.out.println("Comparaciones: " + stats[0]);
        System.out.println("Intercambios: " + stats[1]);

        scanner.close();
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
