/*
Prompt inicial utilizado:
Implementar tres algoritmos de ordenamiento: Bubble Sort, Selection Sort e Insertion Sort. Los tres deben ordenar el mismo arreglo. El programa debe mostrar: el arreglo original, el arreglo ordenado de cada algoritmo, el número de comparaciones y el número de intercambios/corrimientos de cada algoritmo. Usar el arreglo {64, 34, 25, 12, 22, 11, 90} como entrada. Incluir una tabla de comparación que muestre qué algoritmo tuvo el mejor desempeño. Agregar comentarios que expliquen las diferencias de rendimiento entre los tres algoritmos. Verificar que los tres produzcan el mismo resultado ordenado.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio09 {

    static class SortResult {
        String name;
        int[] sortedArray;
        int comparisons;
        int swaps;

        SortResult(String name, int[] sortedArray, int comparisons, int swaps) {
            this.name = name;
            this.sortedArray = sortedArray;
            this.comparisons = comparisons;
            this.swaps = swaps;
        }
    }

    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("=== Comparación de Algoritmos de Ordenamiento Simples ===");
        System.out.println("Arreglo original: " + Arrays.toString(original));
        System.out.println();

        // Probar los tres algoritmos
        SortResult bubble = bubbleSort(original.clone());
        SortResult selection = selectionSort(original.clone());
        SortResult insertion = insertionSort(original.clone());

        // Mostrar resultados
        System.out.println("Bubble Sort:");
        System.out.println("  Ordenado: " + Arrays.toString(bubble.sortedArray));
        System.out.println("  Comparaciones: " + bubble.comparisons);
        System.out.println("  Intercambios: " + bubble.swaps);
        System.out.println();

        System.out.println("Selection Sort:");
        System.out.println("  Ordenado: " + Arrays.toString(selection.sortedArray));
        System.out.println("  Comparaciones: " + selection.comparisons);
        System.out.println("  Intercambios: " + selection.swaps);
        System.out.println();

        System.out.println("Insertion Sort:");
        System.out.println("  Ordenado: " + Arrays.toString(insertion.sortedArray));
        System.out.println("  Comparaciones: " + insertion.comparisons);
        System.out.println("  Corrimientos: " + insertion.swaps);
        System.out.println();

        // Tabla de comparación
        System.out.println("=== Tabla Resumen ===");
        System.out.printf("%-15s %-12s %-12s%n", "Algoritmo", "Comparaciones", "Intercambios/Corrimientos");
        System.out.println("-".repeat(40));
        System.out.printf("%-15s %-12d %-12d%n", "Bubble Sort", bubble.comparisons, bubble.swaps);
        System.out.printf("%-15s %-12d %-12d%n", "Selection Sort", selection.comparisons, selection.swaps);
        System.out.printf("%-15s %-12d %-12d%n", "Insertion Sort", insertion.comparisons, insertion.swaps);
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

        return new SortResult("Bubble Sort", array, comparisons, swaps);
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

        return new SortResult("Selection Sort", array, comparisons, swaps);
    }

    static SortResult insertionSort(int[] array) {
        int comparisons = 0;
        int shifts = 0;
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }

            array[j + 1] = key;
        }

        return new SortResult("Insertion Sort", array, comparisons, shifts);
    }
}
