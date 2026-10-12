/*
Prompt inicial utilizado:
Implement a Java algorithm that searches for a target element in an unordered
integer array using linear scan. The strategy is to iterate through each element
sequentially and return the index of the first occurrence found.
Justification: because the array is unordered, no assumptions can be made about
element positions, so every element must be checked in the worst case. Linear
scan is the only correct approach without pre-processing.
Best case: O(1) — target is the first element.
Worst case: O(n) — target is the last element or not present.
Average case: O(n) — on average half the array is traversed.
The program must report how many positions were traversed.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio02 {

    /**
     * Searches for a target value in an unordered array.
     * Best case: O(1), Worst case: O(n), Average case: O(n).
     * Space complexity: O(1).
     * Returns the index of the target, or -1 if not found.
     * Also reports the number of positions traversed.
     */
    public static int linearSearch(int[] array, int target) {
        int positionsTraversed = 0;

        for (int i = 0; i < array.length; i++) {
            positionsTraversed++;
            if (array[i] == target) {
                System.out.println("Positions traversed: " + positionsTraversed);
                return i;
            }
        }

        System.out.println("Positions traversed: " + positionsTraversed);
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter " + n + " integers (unordered):");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the value to search: ");
        int target = scanner.nextInt();

        int result = linearSearch(array, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        scanner.close();
    }
}
