/*
Prompt inicial utilizado:
Implementar una función recursiva que determine si una palabra es un palíndromo.
Comparar el primer y el último carácter. Si difieren, no es un palíndromo.
Reducir el problema eliminando ambos extremos y verificando la subcadena interna.
El caso base es una cadena de longitud 0 o 1, que siempre es un palíndromo.
Probar con "a", "ab", "aba", "abba", "abc", "racecar".
Esperado: true, false, true, true, false, true.

Ajustes realizados:
Ninguno
*/

public class Ejercicio09 {

    public static boolean isPalindrome(String s) {
        // Caso base: cadena vacía o un solo carácter es un palíndromo
        if (s == null || s.length() <= 1) {
            return true;
        }
        // Verificar el primer y el último carácter
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        // Caso recursivo: verificar la subcadena interna (eliminar ambos extremos)
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 9: Palindromo ===");

        String[] testValues = {"a", "ab", "aba", "abba", "abc", "racecar"};
        boolean[] expected = {true, false, true, true, false, true};

        for (int i = 0; i < testValues.length; i++) {
            boolean result = isPalindrome(testValues[i]);
            System.out.println("isPalindrome(\"" + testValues[i] + "\") = " + result
                    + " (esperado: " + expected[i] + ") "
                    + (result == expected[i] ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
