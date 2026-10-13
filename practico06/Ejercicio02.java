/*
Prompt inicial utilizado:
Implementar dos algoritmos de ordenamiento: bubbleSort(int[] array) y selectionSort(int[] array). Ambos deben ordenar el mismo arreglo. El programa debe contar y mostrar el número de comparaciones e intercambios de cada algoritmo. Usar el arreglo {64, 34, 25, 12, 22, 11, 90} como entrada. Imprimir el arreglo original, el arreglo ordenado de cada algoritmo y una tabla de comparación que muestre qué algoritmo tuvo mejor desempeño. Incluir comentarios que expliquen la diferencia en la cantidad de comparaciones e intercambios.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio02 {

    static class SortResult {
        int[] sortedArray;
        int comparisons;
        int swaps;

        SortResult(int[] sortedArray, int comparisons, int swaps) {
            this.sortedArray = sortedArray;
            this.comparisons = comparisons;
            this.swaps = swaps;
        }
    }

    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("=== Bubble Sort vs Selection Sort ===");
        System.out.println("Arreglo original: " + Arrays.toString(original));
        System.out.println();

        // Probar Bubble Sort
        int[] bubbleArray = original.clone();
        SortResult bubbleResult = bubbleSort(bubbleArray);

        // Probar Selection Sort
        int[] selectionArray = original.clone();
        SortResult selectionResult = selectionSort(selectionArray);

        // Mostrar resultados
        System.out.println("Bubble Sort:");
        System.out.println("  Arreglo ordenado: " + Arrays.toString(bubbleResult.sortedArray));
        System.out.println("  Comparaciones: " + bubbleResult.comparisons);
        System.out.println("  Intercambios: " + bubbleResult.swaps);
        System.out.println();

        System.out.println("Selection Sort:");
        System.out.println("  Arreglo ordenado: " + Arrays.toString(selectionResult.sortedArray));
        System.out.println("  Comparaciones: " + selectionResult.comparisons);
        System.out.println("  Intercambios: " + selectionResult.swaps);
        System.out.println();

        // Comparación
        System.out.println("=== Comparación ===");
        System.out.println("Bubble Sort realizó " + bubbleResult.comparisons + " comparaciones y " + bubbleResult.swaps + " intercambios.");
        System.out.println("Selection Sort realizó " + selectionResult.comparisons + " comparaciones y " + selectionResult.swaps + " intercambios.");

        if (bubbleResult.comparisons > selectionResult.comparisons) {
            System.out.println("Selection Sort requirió menos comparaciones.");
        } else if (bubbleResult.comparisons < selectionResult.comparisons) {
            System.out.println("Bubble Sort requirió menos comparaciones.");
        } else {
            System.out.println("Ambos algoritmos requirieron la misma cantidad de comparaciones.");
        }
    }

    static SortResult bubbleSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                }
            }
        }

        return new SortResult(array, comparisons, swaps);
    }

    static SortResult selectionSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                swaps++;
            }
        }

        return new SortResult(array, comparisons, swaps);
    }
}
