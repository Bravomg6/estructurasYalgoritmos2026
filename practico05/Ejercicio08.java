/*
Prompt inicial utilizado:
Implement a recursive function that reverses a String.
The base case is an empty string or a single character — already reversed.
Separate the first character from the rest using substring. Reduce the problem
by reversing the rest and appending the first character at the end.
Reconstruction: reverse(rest) + firstChar. Test with "a", "ab", "hello", "recursion".
Expected: "a", "ba", "olleh", "noisrucer".

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

    public static String reverse(String s) {
        // Base case: empty string or single character is already reversed
        if (s == null || s.length() <= 1) {
            return s;
        }
        // Recursive case: reverse the rest, then append the first character
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 8: Invertir una palabra ===");

        String[] testValues = {"a", "ab", "hello", "recursion"};
        String[] expected = {"a", "ba", "olleh", "noisrucer"};

        for (int i = 0; i < testValues.length; i++) {
            String result = reverse(testValues[i]);
            System.out.println("reverse(\"" + testValues[i] + "\") = \"" + result
                    + "\" (expected: \"" + expected[i] + "\") "
                    + (result.equals(expected[i]) ? "PASS" : "FAIL"));
        }
    }
}
