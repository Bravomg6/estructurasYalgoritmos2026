/*
Prompt inicial utilizado:
Implement MergeSort algorithm. The program should display: how the array is divided into subarrays, when the base case is reached (subarray of size 1), and how subarrays are merged back together. Use the array {38, 27, 43, 3, 9, 82, 10} as input. Include comments explaining the divide-and-conquer strategy and the merge process. Show the recursion tree with indentation to visualize the division and merging phases. Verify the result by confirming the array is sorted in ascending order.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio08 {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("=== MergeSort Step by Step ===");
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println();

        mergeSort(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    static void mergeSort(int[] array, int left, int right, int depth) {
        String indent = "  ".repeat(depth);

        if (left == right) {
            System.out.println(indent + "Base case reached: [" + array[left] + "]");
            return;
        }

        int mid = left + (right - left) / 2;

        System.out.println(indent + "Divide: " + Arrays.toString(Arrays.copyOfRange(array, left, right + 1)));
        System.out.println(indent + "  Left half: " + Arrays.toString(Arrays.copyOfRange(array, left, mid + 1)));
        System.out.println(indent + "  Right half: " + Arrays.toString(Arrays.copyOfRange(array, mid + 1, right + 1)));
        System.out.println();

        // Recursively sort left half
        mergeSort(array, left, mid, depth + 1);

        // Recursively sort right half
        mergeSort(array, mid + 1, right, depth + 1);

        // Merge the sorted halves
        merge(array, left, mid, right);

        System.out.println(indent + "Merged: " + Arrays.toString(Arrays.copyOfRange(array, left, right + 1)));
        System.out.println();
    }

    static void merge(int[] array, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
