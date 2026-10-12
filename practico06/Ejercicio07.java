/*
Prompt inicial utilizado:
Implement Quicksort on an already sorted array: {1, 2, 3, 4, 5, 6, 7}. The program should count and display the total number of recursive calls made. Use the first element as the pivot. Include comments explaining why this is the worst-case scenario for Quicksort (O(n^2) time complexity) and how it leads to unbalanced partitions. Display the recursion depth and the state of partitioning at each step. Verify the count by tracing through the recursion manually.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio07 {
    static int recursiveCalls = 0;
    static int maxDepth = 0;

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("=== Quicksort Worst Case (Sorted Array) ===");
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println();

        quickSort(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Total recursive calls: " + recursiveCalls);
        System.out.println("Maximum recursion depth: " + maxDepth);
        System.out.println();
        System.out.println("Explanation: With first element as pivot on a sorted array,");
        System.out.println("each partition creates one empty subarray and one subarray of size n-1.");
        System.out.println("This results in O(n^2) time complexity - the worst case for Quicksort.");
    }

    static void quickSort(int[] array, int low, int high, int depth) {
        recursiveCalls++;
        if (depth > maxDepth) {
            maxDepth = depth;
        }

        if (low >= high) {
            return;
        }

        String indent = "  ".repeat(depth);
        System.out.println(indent + "Call " + recursiveCalls + " (depth " + depth + "): " + Arrays.toString(Arrays.copyOfRange(array, low, high + 1)));

        // Choose first element as pivot
        int pivot = array[low];

        // Partition using Lomuto scheme (swap pivot to end first)
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;

        int pivotValue = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivotValue) {
                i++;
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        int t = array[i + 1];
        array[i + 1] = array[high];
        array[high] = t;

        int pivotIndex = i + 1;

        System.out.println(indent + "  Pivot: " + pivot);
        System.out.println(indent + "  Left: " + Arrays.toString(Arrays.copyOfRange(array, low, pivotIndex)));
        System.out.println(indent + "  Right: " + Arrays.toString(Arrays.copyOfRange(array, pivotIndex + 1, high + 1)));
        System.out.println();

        // Recursively sort left and right subarrays
        quickSort(array, low, pivotIndex - 1, depth + 1);
        quickSort(array, pivotIndex + 1, high, depth + 1);
    }
}
