/*
Prompt inicial utilizado:
Implementar una función recursiva que sume los dígitos de un entero positivo.
Obtener el último dígito mediante el módulo 10 (n % 10). Reducir el número mediante
división entera por 10 (n / 10 elimina el último dígito). El caso base es n = 0, devolviendo 0.
Combinar resultados: lastDigit + sumDigits(n / 10). Probar con 0, 7, 123, 9999, 5050.
Esperado: 0, 7, 6, 36, 10.

Ajustes realizados:
Ninguno
*/

public class Ejercicio07 {

    public static int sumDigits(int n) {
        // Caso base: no quedan dígitos por sumar
        if (n == 0) {
            return 0;
        }
        // Caso recursivo: último dígito + suma de los dígitos restantes
        return (n % 10) + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 7: Sumar digitos ===");

        int[] testValues = {0, 7, 123, 9999, 5050};
        int[] expected = {0, 7, 6, 36, 10};

        for (int i = 0; i < testValues.length; i++) {
            int result = sumDigits(testValues[i]);
            System.out.println("sumDigits(" + testValues[i] + ") = " + result
                    + " (esperado: " + expected[i] + ") "
                    + (result == expected[i] ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
