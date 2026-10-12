/*
Prompt inicial utilizado:
Implement a recursive function that determines if a word is a palindrome.
Compare the first and last characters. If they differ, it is not a palindrome.
Reduce the problem by removing both ends and checking the inner substring.
The base case is a string of length 0 or 1, which is always a palindrome.
Test with "a", "ab", "aba", "abba", "abc", "racecar".
Expected: true, false, true, true, false, true.

Ajustes realizados:
Ninguno
*/

public class Ejercicio09 {

    public static boolean isPalindrome(String s) {
        // Base case: empty string or single character is a palindrome
        if (s == null || s.length() <= 1) {
            return true;
        }
        // Check first and last characters
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        // Recursive case: check the inner substring (remove both ends)
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 9: Palindromo ===");

        String[] testValues = {"a", "ab", "aba", "abba", "abc", "racecar"};
        boolean[] expected = {true, false, true, true, false, true};

        for (int i = 0; i < testValues.length; i++) {
            boolean result = isPalindrome(testValues[i]);
            System.out.println("isPalindrome(\"" + testValues[i] + "\") = " + result
                    + " (expected: " + expected[i] + ") "
                    + (result == expected[i] ? "PASS" : "FAIL"));
        }
    }
}
