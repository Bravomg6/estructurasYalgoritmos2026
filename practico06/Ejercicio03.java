/*
Prompt inicial utilizado:
Implement Insertion Sort on a nearly sorted array: {1, 2, 3, 5, 4, 6, 7}. The program should display the original array, show each step of the insertion process, and count the total number of shifts (displacements) performed. A shift occurs when an element is moved one position to the right to make room for the key being inserted. Include comments explaining why Insertion Sort is efficient for nearly sorted arrays. Verify the result by confirming the array is sorted in ascending order.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio03 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 4, 6, 7};

        System.out.println("=== Insertion Sort on Nearly Sorted Array ===");
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println();

        int shifts = insertionSort(array);

        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Total shifts: " + shifts);
    }

    static int insertionSort(int[] array) {
        int shifts = 0;
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.println("Step " + i + ": Inserting " + key);

            // Shift elements greater than key to the right
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                shifts++;
                j--;
                System.out.println("  Shifted: " + Arrays.toString(array));
            }

            array[j + 1] = key;
            System.out.println("  Inserted " + key + " at position " + (j + 1));
            System.out.println("  Array: " + Arrays.toString(array));
            System.out.println();
        }

        return shifts;
    }
}
