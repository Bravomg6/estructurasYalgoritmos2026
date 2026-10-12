/*
Prompt inicial utilizado:
Implement three sorting algorithms: Bubble Sort, Selection Sort, and Insertion Sort. All three must sort the same array. The program should display: the original array, the sorted array from each algorithm, the number of comparisons, and the number of swaps/shifts for each algorithm. Use the array {64, 34, 25, 12, 22, 11, 90} as input. Include a comparison table showing which algorithm performed best. Add comments explaining the differences in performance between the three algorithms. Verify that all three produce the same sorted result.

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

        System.out.println("=== Comparison of Simple Sorting Algorithms ===");
        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println();

        // Test all three algorithms
        SortResult bubble = bubbleSort(original.clone());
        SortResult selection = selectionSort(original.clone());
        SortResult insertion = insertionSort(original.clone());

        // Display results
        System.out.println("Bubble Sort:");
        System.out.println("  Sorted: " + Arrays.toString(bubble.sortedArray));
        System.out.println("  Comparisons: " + bubble.comparisons);
        System.out.println("  Swaps: " + bubble.swaps);
        System.out.println();

        System.out.println("Selection Sort:");
        System.out.println("  Sorted: " + Arrays.toString(selection.sortedArray));
        System.out.println("  Comparisons: " + selection.comparisons);
        System.out.println("  Swaps: " + selection.swaps);
        System.out.println();

        System.out.println("Insertion Sort:");
        System.out.println("  Sorted: " + Arrays.toString(insertion.sortedArray));
        System.out.println("  Comparisons: " + insertion.comparisons);
        System.out.println("  Shifts: " + insertion.swaps);
        System.out.println();

        // Comparison table
        System.out.println("=== Summary Table ===");
        System.out.printf("%-15s %-12s %-12s%n", "Algorithm", "Comparisons", "Swaps/Shifts");
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
