/*
Prompt inicial utilizado:
Implement a recursive function that sums the digits of a positive integer.
Get the last digit using modulo 10 (n % 10). Reduce the number using integer
division by 10 (n / 10 removes the last digit). The base case is n = 0, returning 0.
Combine results: lastDigit + sumDigits(n / 10). Test with 0, 7, 123, 9999, 5050.
Expected: 0, 7, 6, 36, 10.

Ajustes realizados:
Ninguno
*/

public class Ejercicio07 {

    public static int sumDigits(int n) {
        // Base case: no digits left to sum
        if (n == 0) {
            return 0;
        }
        // Recursive case: last digit + sum of remaining digits
        return (n % 10) + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 7: Sumar digitos ===");

        int[] testValues = {0, 7, 123, 9999, 5050};
        int[] expected = {0, 7, 6, 36, 10};

        for (int i = 0; i < testValues.length; i++) {
            int result = sumDigits(testValues[i]);
            System.out.println("sumDigits(" + testValues[i] + ") = " + result
                    + " (expected: " + expected[i] + ") "
                    + (result == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
