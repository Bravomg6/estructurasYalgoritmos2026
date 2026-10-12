/*
Prompt inicial utilizado:
Implement a Java binary search algorithm for a sorted integer array.
Strategy: repeatedly divide the search interval in half by comparing the target
with the middle element. If the target is smaller, search the left half; if
larger, search the right half.
Justification: binary search is more efficient than linear search on sorted data
because each comparison eliminates half of the remaining elements, yielding
O(log n) time instead of O(n).
Time complexity: O(log n). Space complexity: O(1) for the iterative version.
The program must show step-by-step how the variables (low, high, mid) evolve.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio03 {

    /**
     * Performs binary search on a sorted array.
     * Time complexity: O(log n) — search space is halved each iteration.
     * Space complexity: O(1) — iterative implementation uses constant extra space.
     * Returns the index of the target, or -1 if not found.
     */
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int step = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential overflow

            System.out.println("Step " + step + ": low=" + low + ", high=" + high + ", mid=" + mid + ", array[mid]=" + array[mid]);

            if (array[mid] == target) {
                System.out.println("Target found at index: " + mid);
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
            step++;
        }

        System.out.println("Target not found after " + (step - 1) + " steps.");
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter " + n + " integers in sorted (ascending) order:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the value to search: ");
        int target = scanner.nextInt();

        int result = binarySearch(array, target);
        if (result == -1) {
            System.out.println("Result: Element not found.");
        }

        scanner.close();
    }
}
