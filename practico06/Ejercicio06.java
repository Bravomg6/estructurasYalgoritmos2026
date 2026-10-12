/*
Prompt inicial utilizado:
Implement Quicksort using the first element as the pivot. The program should display the original array, and for each recursive call show: the pivot chosen, the left subarray (elements <= pivot), the right subarray (elements > pivot), and the current state of the array. Use the array {8, 3, 7, 1, 5, 9, 2} as input. Include comments explaining the divide-and-conquer strategy. Verify the result by confirming the array is sorted in ascending order.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio06 {
    public static void main(String[] args) {
        int[] array = {8, 3, 7, 1, 5, 9, 2};

        System.out.println("=== Quicksort with First Element as Pivot ===");
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println();

        quickSort(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    static void quickSort(int[] array, int low, int high, int depth) {
        if (low >= high) {
            return;
        }

        String indent = "  ".repeat(depth);

        // Choose first element as pivot
        int pivot = array[low];
        System.out.println(indent + "Pivot: " + pivot);
        System.out.println(indent + "Subarray: " + Arrays.toString(Arrays.copyOfRange(array, low, high + 1)));

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

        System.out.println(indent + "Left (<= " + pivot + "): " + Arrays.toString(Arrays.copyOfRange(array, low, pivotIndex)));
        System.out.println(indent + "Right (> " + pivot + "): " + Arrays.toString(Arrays.copyOfRange(array, pivotIndex + 1, high + 1)));
        System.out.println(indent + "Array: " + Arrays.toString(Arrays.copyOfRange(array, low, high + 1)));
        System.out.println();

        // Recursively sort left and right subarrays
        quickSort(array, low, pivotIndex - 1, depth + 1);
        quickSort(array, pivotIndex + 1, high, depth + 1);
    }
}
