/*
Prompt inicial utilizado:
Implement a recursive function that searches for a number in an array without
using loops (no for, no while). Start the search from index 0. Advance by
incrementing the index on each recursive call. Base case 1: if the current
element equals the target, return its index (found). Base case 2: if the index
reaches the array length, return -1 (not found). Test with array {3, 7, 1, 9, 4}
searching for 9 (expected index 3), 5 (expected -1), and 3 (expected index 0).

Ajustes realizados:
Ninguno
*/

public class Ejercicio10 {

    public static int search(int[] arr, int target, int index) {
        // Base case 1: reached the end without finding the target
        if (index >= arr.length) {
            return -1;
        }
        // Base case 2: found the target at current index
        if (arr[index] == target) {
            return index;
        }
        // Recursive case: search the rest of the array
        return search(arr, target, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 10: Buscar un elemento en un arreglo ===");

        int[] arr = {3, 7, 1, 9, 4};

        // Test 1: element exists in the middle
        int result1 = search(arr, 9, 0);
        System.out.println("search([3,7,1,9,4], 9) = " + result1
                + " (expected: 3) " + (result1 == 3 ? "PASS" : "FAIL"));

        // Test 2: element does not exist
        int result2 = search(arr, 5, 0);
        System.out.println("search([3,7,1,9,4], 5) = " + result2
                + " (expected: -1) " + (result2 == -1 ? "PASS" : "FAIL"));

        // Test 3: element at the beginning
        int result3 = search(arr, 3, 0);
        System.out.println("search([3,7,1,9,4], 3) = " + result3
                + " (expected: 0) " + (result3 == 0 ? "PASS" : "FAIL"));

        // Test 4: element at the end
        int result4 = search(arr, 4, 0);
        System.out.println("search([3,7,1,9,4], 4) = " + result4
                + " (expected: 4) " + (result4 == 4 ? "PASS" : "FAIL"));
    }
}
