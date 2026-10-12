/*
Prompt inicial utilizado:
Implement a recursive function to compute base^exponent without using Math.pow.
A power is successive multiplications: base^exponent = base * base^(exponent-1).
The base case is exponent = 0, where the result is 1 (any number to the power
of 0 is 1). Reduce the exponent by 1 on each recursive call. Test with
(2, 0), (3, 1), (2, 5), (5, 3). Expected: 1, 3, 32, 125.

Ajustes realizados:
Ninguno
*/

public class Ejercicio04 {

    public static long power(int base, int exponent) {
        // Base case: any number raised to 0 is 1
        if (exponent == 0) {
            return 1;
        }
        // Recursive case: base^exp = base * base^(exp - 1)
        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 4: Potencia ===");

        int[][] testPairs = {{2, 0}, {3, 1}, {2, 5}, {5, 3}};
        long[] expected = {1, 3, 32, 125};

        for (int i = 0; i < testPairs.length; i++) {
            long result = power(testPairs[i][0], testPairs[i][1]);
            System.out.println("power(" + testPairs[i][0] + ", " + testPairs[i][1] + ") = "
                    + result + " (expected: " + expected[i] + ") "
                    + (result == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
