/*
Prompt inicial utilizado:
Implement the Bubble Sort algorithm in Java for sorting an integer array in
ascending order.
Strategy: repeatedly traverse the array, comparing adjacent elements and
swapping them if they are in the wrong order. After each pass, the largest
unsorted element "bubbles up" to its correct position.
Justification: Bubble Sort is only suitable for educational purposes or very
small datasets because its O(n^2) average and worst-case time complexity makes
it impractical for large inputs. Algorithms like QuickSort or MergeSort are
preferred in production.
Time complexity: O(n^2) average and worst case, O(n) best case (already sorted
with optimization). Space complexity: O(1).
The program must count the number of comparisons and swaps performed.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio10 {

    /**
     * Sorts an array using Bubble Sort with comparison and swap counters.
     * Time complexity: O(n^2) average/worst case, O(n) best case (optimized).
     * Space complexity: O(1) — in-place sorting.
     * Returns an array where index 0 = comparisons, index 1 = swaps.
     */
    public static long[] bubbleSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization: detect if array is already sorted

            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    // Swap adjacent elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            // If no swaps occurred in this pass, array is sorted
            if (!swapped) {
                break;
            }
        }

        return new long[]{comparisons, swaps};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original array: ");
        printArray(array);

        long[] stats = bubbleSort(array);

        System.out.println("Sorted array: ");
        printArray(array);
        System.out.println("Comparisons: " + stats[0]);
        System.out.println("Swaps: " + stats[1]);

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
