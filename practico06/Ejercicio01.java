/*
Prompt inicial utilizado:
Implement a Bubble Sort algorithm that displays the original array and then the state of the array after each pass. Include comments explaining why the largest element "bubbles" toward the end of the array. The program should print the array before sorting, after each complete pass, and the final sorted array. Use the array {64, 34, 25, 12, 22, 11, 90} as input. Verify correctness by confirming the final array is in ascending order.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio01 {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("=== Bubble Sort Step by Step ===");
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println();

        int n = array.length;

        // Outer loop: each pass places the next largest element in its final position
        for (int i = 0; i < n - 1; i++) {
            System.out.println("--- Pass " + (i + 1) + " ---");

            // Inner loop: compare adjacent elements and swap if out of order
            // After each pass, the largest unsorted element bubbles to the end
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap adjacent elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(array));

            // Explanation: after pass i, the last i+1 elements are in final position
            if (i < n - 2) {
                System.out.println("  -> The largest element has bubbled to position " + (n - 1 - i));
            }
            System.out.println();
        }

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
