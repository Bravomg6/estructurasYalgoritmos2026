/*
Prompt inicial utilizado:
Implement a Java algorithm that determines whether two integer arrays are equal.
Strategy: first check if lengths match. Then iterate through both arrays
simultaneously, comparing elements at each position. The algorithm must
terminate as soon as a difference is detected (early exit).
Justification: early exit avoids unnecessary work when arrays differ early.
If arrays are identical, all elements must be compared.
Best case: O(1) — first elements differ or lengths are different.
Worst case: O(n) — arrays are identical or differ only at the last element.
Average case: O(n).
Space complexity: O(1).

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio06 {

    /**
     * Determines if two arrays are equal with early exit on first difference.
     * Best case: O(1), Worst case: O(n), Average case: O(n).
     * Space complexity: O(1).
     */
    public static boolean areEqual(int[] array1, int[] array2) {
        // If lengths differ, arrays cannot be equal — O(1) check
        if (array1.length != array2.length) {
            System.out.println("Arrays differ in length. Positions compared: 0");
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                System.out.println("Difference found at index " + i + ". Positions compared: " + (i + 1));
                return false; // Early exit: no need to check remaining elements
            }
        }

        System.out.println("All " + array1.length + " positions compared.");
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements for array 1: ");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];
        System.out.println("Enter " + n1 + " integers for array 1:");
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of elements for array 2: ");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];
        System.out.println("Enter " + n2 + " integers for array 2:");
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        boolean result = areEqual(array1, array2);
        System.out.println("Arrays are " + (result ? "equal" : "not equal"));

        scanner.close();
    }
}
