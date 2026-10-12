/*
Prompt inicial utilizado:
Implement a Java algorithm that finds the minimum value in an integer array.
Strategy: perform a single linear scan, keeping a variable that stores the
smallest value seen so far. Initialize it with the first element and update it
whenever a smaller element is found.
Justification: every element must be examined at least once to guarantee the
minimum is found, so a single pass is optimal. Sorting is unnecessary because
sorting takes O(n log n) while the minimum can be found in O(n).
Time complexity: O(n). Space complexity: O(1).

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio01 {

    /**
     * Finds the minimum value in an integer array.
     * Time complexity: O(n) — every element is visited exactly once.
     * Space complexity: O(1) — only a single variable is used regardless of input size.
     */
    public static int findMinimum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = array[0]; // Start with the first element as the initial minimum

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]; // Update minimum when a smaller value is found
            }
        }

        return min;
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

        int min = findMinimum(array);
        System.out.println("Minimum value: " + min);

        scanner.close();
    }
}
