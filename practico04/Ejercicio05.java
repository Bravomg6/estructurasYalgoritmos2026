/*
Prompt inicial utilizado:
Implement a Java algorithm that counts how many times a target value appears
in an integer array.
Strategy: traverse the entire array once, maintaining a counter that increments
each time the current element matches the target.
Justification: the algorithm must examine every element because the target
could appear at any position. There is no shortcut without pre-processing or
additional data structures.
Time complexity: O(n) — full traversal is required.
Space complexity: O(1) — only a counter variable is needed.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio05 {

    /**
     * Counts the occurrences of a target value in an array.
     * Time complexity: O(n) — every element must be checked.
     * Space complexity: O(1) — only a counter is maintained.
     */
    public static int countOccurrences(int[] array, int target) {
        int count = 0;

        for (int element : array) {
            if (element == target) {
                count++;
            }
        }

        return count;
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

        System.out.print("Enter the value to count: ");
        int target = scanner.nextInt();

        int occurrences = countOccurrences(array, target);
        System.out.println("The value " + target + " appears " + occurrences + " time(s).");

        scanner.close();
    }
}
