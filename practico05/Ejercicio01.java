/*
Prompt inicial utilizado:
Implement a recursive function to calculate the factorial of a non-negative integer n.
Explain why factorial can be solved recursively: n! = n * (n-1)!, which is a natural
self-referential definition. The base case is n = 0 or n = 1, where the result is 1.
The problem is reduced by calling factorial(n-1) and multiplying by n. Test with
n = 0, 1, 5, and 7. Expected results: 1, 1, 120, 5040.

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    public static long factorial(int n) {
        // Base case: 0! = 1 and 1! = 1
        if (n <= 1) {
            return 1;
        }
        // Recursive case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 1: Factorial ===");

        int[] testValues = {0, 1, 5, 7};
        long[] expected = {1, 1, 120, 5040};

        for (int i = 0; i < testValues.length; i++) {
            long result = factorial(testValues[i]);
            System.out.println("factorial(" + testValues[i] + ") = " + result
                    + " (expected: " + expected[i] + ") "
                    + (result == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
