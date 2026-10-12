/*
Prompt inicial utilizado:
Implement two sorting algorithms: bubbleSort(int[] array) and selectionSort(int[] array). Both must sort the same array. The program should count and display the number of comparisons and swaps for each algorithm. Use the array {64, 34, 25, 12, 22, 11, 90} as input. Print the original array, the sorted array from each algorithm, and a comparison table showing which algorithm performed better. Include comments explaining the difference in comparison and swap counts.

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
        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println();

        // Test Bubble Sort
        int[] bubbleArray = original.clone();
        SortResult bubbleResult = bubbleSort(bubbleArray);

        // Test Selection Sort
        int[] selectionArray = original.clone();
        SortResult selectionResult = selectionSort(selectionArray);

        // Display results
        System.out.println("Bubble Sort:");
        System.out.println("  Sorted array: " + Arrays.toString(bubbleResult.sortedArray));
        System.out.println("  Comparisons: " + bubbleResult.comparisons);
        System.out.println("  Swaps: " + bubbleResult.swaps);
        System.out.println();

        System.out.println("Selection Sort:");
        System.out.println("  Sorted array: " + Arrays.toString(selectionResult.sortedArray));
        System.out.println("  Comparisons: " + selectionResult.comparisons);
        System.out.println("  Swaps: " + selectionResult.swaps);
        System.out.println();

        // Comparison
        System.out.println("=== Comparison ===");
        System.out.println("Bubble Sort made " + bubbleResult.comparisons + " comparisons and " + bubbleResult.swaps + " swaps.");
        System.out.println("Selection Sort made " + selectionResult.comparisons + " comparisons and " + selectionResult.swaps + " swaps.");

        if (bubbleResult.comparisons > selectionResult.comparisons) {
            System.out.println("Selection Sort required fewer comparisons.");
        } else if (bubbleResult.comparisons < selectionResult.comparisons) {
            System.out.println("Bubble Sort required fewer comparisons.");
        } else {
            System.out.println("Both algorithms required the same number of comparisons.");
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
