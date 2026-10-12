/*
Prompt inicial utilizado:
Implement a recursive multiplication function without using the * operator.
Represent multiplication as repeated addition: a * b = a + a + ... + a (b times).
Reduce the second parameter (b) by 1 on each recursive call. The base case is
when b = 0, returning 0 (adding zero times yields nothing). Test with
(3, 4), (5, 0), (7, 1), (2, 8). Expected: 12, 0, 7, 16.

Ajustes realizados:
Ninguno
*/

public class Ejercicio03 {

    public static int multiply(int a, int b) {
        // Base case: anything multiplied by 0 is 0
        if (b == 0) {
            return 0;
        }
        // Recursive case: a * b = a + a * (b - 1)
        return a + multiply(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 3: Multiplicacion mediante sumas ===");

        int[][] testPairs = {{3, 4}, {5, 0}, {7, 1}, {2, 8}};
        int[] expected = {12, 0, 7, 16};

        for (int i = 0; i < testPairs.length; i++) {
            int result = multiply(testPairs[i][0], testPairs[i][1]);
            System.out.println("multiply(" + testPairs[i][0] + ", " + testPairs[i][1] + ") = "
                    + result + " (expected: " + expected[i] + ") "
                    + (result == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
