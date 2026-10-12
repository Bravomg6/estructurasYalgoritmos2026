/*
Prompt inicial utilizado:
Implement two different Java solutions to detect duplicate elements in an
integer array.
Solution 1 (brute force): use two nested loops to compare each element with
every other element.
Solution 2 (HashSet): iterate once through the array, adding each element to
a HashSet. If an element is already in the set, a duplicate exists.
Justification: the brute force approach is simple but inefficient for large
inputs. HashSet provides O(1) average lookup, making the overall approach O(n).
Time complexity: Solution 1 = O(n^2), Solution 2 = O(n) average.
Space complexity: Solution 1 = O(1), Solution 2 = O(n).
The program must compare the two solutions.

Ajustes realizados:
Ninguno
*/

import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio04 {

    /**
     * Detects duplicates using two nested loops (brute force).
     * Time complexity: O(n^2) — each element is compared with all subsequent elements.
     * Space complexity: O(1) — no additional data structures needed.
     */
    public static boolean hasDuplicatesBruteForce(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Detects duplicates using a HashSet.
     * Time complexity: O(n) average — each insertion and lookup is O(1) on average.
     * Space complexity: O(n) — the HashSet may store all elements in the worst case.
     */
    public static boolean hasDuplicatesHashSet(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int element : array) {
            if (seen.contains(element)) {
                return true; // Duplicate found
            }
            seen.add(element);
        }
        return false;
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

        boolean bruteForceResult = hasDuplicatesBruteForce(array);
        boolean hashSetResult = hasDuplicatesHashSet(array);

        System.out.println("Brute force result: " + (bruteForceResult ? "Duplicates found" : "No duplicates"));
        System.out.println("HashSet result: " + (hashSetResult ? "Duplicates found" : "No duplicates"));

        System.out.println("\nComplexity Comparison:");
        System.out.println("Brute Force - Time: O(n^2), Space: O(1)");
        System.out.println("HashSet     - Time: O(n),   Space: O(n)");

        scanner.close();
    }
}
