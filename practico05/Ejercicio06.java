/*
Prompt inicial utilizado:
Implementar una función recursiva que cuente los dígitos de un entero positivo.
Reducir el número mediante división entera por 10 (n / 10 elimina el último dígito).
El caso base es cuando n < 10, porque un número menor que 10 tiene exactamente un dígito.
Cada llamada recursiva devuelve 1 + countDigits(n / 10). Probar con 0, 5, 42, 1234, 99999.
Esperado: 1, 1, 2, 4, 5.

Ajustes realizados:
Ninguno
*/

public class Ejercicio06 {

    public static int countDigits(int n) {
        // Caso base: un número menor que 10 tiene exactamente un dígito
        if (n < 10) {
            return 1;
        }
        // Caso recursivo: 1 dígito + conteo de los dígitos restantes
        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 6: Contar digitos ===");

        int[] testValues = {0, 5, 42, 1234, 99999};
        int[] expected = {1, 1, 2, 4, 5};

        for (int i = 0; i < testValues.length; i++) {
            int result = countDigits(testValues[i]);
            System.out.println("countDigits(" + testValues[i] + ") = " + result
                    + " (esperado: " + expected[i] + ") "
                    + (result == expected[i] ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
