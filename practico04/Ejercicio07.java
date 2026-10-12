/*
Prompt inicial utilizado:
Implement two versions of a Java algorithm to reverse an integer array.
Version 1 (auxiliary array): create a new array, copy elements from the original
in reverse order, then copy back.
Version 2 (in-place): use two pointers (start and end) and swap elements until
they meet in the middle.
Justification: Version 1 is simpler to understand but uses extra memory.
Version 2 is memory-efficient but slightly more complex.
Time complexity: both O(n).
Space complexity: Version 1 = O(n), Version 2 = O(1).

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio07 {

    /**
     * Reverses an array using an auxiliary array.
     * Time complexity: O(n). Space complexity: O(n).
     * Advantages: simple logic, original array unchanged until final copy.
     * Disadvantages: requires O(n) extra memory.
     */
    public static int[] reverseWithAuxiliary(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    /**
     * Reverses an array in-place using two pointers.
     * Time complexity: O(n). Space complexity: O(1).
     * Advantages: no extra memory needed.
     * Disadvantages: modifies the original array.
     */
    public static void reverseInPlace(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Swap elements at left and right pointers
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] original = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            original[i] = scanner.nextInt();
        }

        // Version 1: auxiliary array
        int[] reversed1 = reverseWithAuxiliary(original);
        System.out.println("Original:            " + Arrays.toString(original));
        System.out.println("Reversed (auxiliary): " + Arrays.toString(reversed1));

        // Version 2: in-place
        int[] copy = Arrays.copyOf(original, original.length);
        reverseInPlace(copy);
        System.out.println("Reversed (in-place):   " + Arrays.toString(copy));

        System.out.println("\nComparison:");
        System.out.println("Auxiliary version - Time: O(n), Space: O(n)");
        System.out.println("In-place version   - Time: O(n), Space: O(1)");

        scanner.close();
    }
}
