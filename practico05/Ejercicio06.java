/*
Prompt inicial utilizado:
Implement a recursive function that counts the digits of a positive integer.
Reduce the number using integer division by 10 (n / 10 removes the last digit).
The base case is when n < 10, because a number less than 10 has exactly one digit.
Each recursive call returns 1 + countDigits(n / 10). Test with 0, 5, 42, 1234, 99999.
Expected: 1, 1, 2, 4, 5.

Ajustes realizados:
Ninguno
*/

public class Ejercicio06 {

    public static int countDigits(int n) {
        // Base case: a number less than 10 has exactly one digit
        if (n < 10) {
            return 1;
        }
        // Recursive case: 1 digit + count of remaining digits
        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 6: Contar digitos ===");

        int[] testValues = {0, 5, 42, 1234, 99999};
        int[] expected = {1, 1, 2, 4, 5};

        for (int i = 0; i < testValues.length; i++) {
            int result = countDigits(testValues[i]);
            System.out.println("countDigits(" + testValues[i] + ") = " + result
                    + " (expected: " + expected[i] + ") "
                    + (result == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
