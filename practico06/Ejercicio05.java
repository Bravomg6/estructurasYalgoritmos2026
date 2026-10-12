/*
Prompt inicial utilizado:
Implement ShellSort algorithm. The program should display the original array, show the gap value used in each stage, and display the state of the array after each pass. Use the gap sequence: start with gap = n/2 and halve it each time until gap = 0. Use the array {64, 34, 25, 12, 22, 11, 90, 45} as input. Include comments explaining how ShellSort improves upon Insertion Sort by sorting elements far apart first. Verify the result by confirming the array is sorted in ascending order.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio05 {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 45};

        System.out.println("=== ShellSort with Gap Explanation ===");
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println();

        shellSort(array);

        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    static void shellSort(int[] array) {
        int n = array.length;
        int gap = n / 2;

        while (gap > 0) {
            System.out.println("--- Gap = " + gap + " ---");

            // Perform gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }

            System.out.println("After gap " + gap + ": " + Arrays.toString(array));
            System.out.println();

            gap /= 2;
        }
    }
}
