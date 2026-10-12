/*
Prompt inicial utilizado:
Implement a recursive function that sums all integers from n down to 1.
The simplest case is n = 0, where the sum is 0 (nothing to add).
The recursive idea: sum(n) = n + sum(n-1). Each call reduces n by 1,
guaranteeing progress toward the base case. Test with n = 0, 1, 5, 10.
Expected results: 0, 1, 15, 55.

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    public static int sumToN(int n) {
        // Base case: sum from 0 to 1 is 0
        if (n <= 0) {
            return 0;
        }
        // Recursive case: n + sum of (n-1) down to 1
        return n + sumToN(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 2: Suma de los primeros N numeros ===");

        int[] testValues = {0, 1, 5, 10};
        int[] expected = {0, 1, 15, 55};

        for (int i = 0; i < testValues.length; i++) {
            int result = sumToN(testValues[i]);
            System.out.println("sumToN(" + testValues[i] + ") = " + result
                    + " (expected: " + expected[i] + ") "
                    + (result == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
