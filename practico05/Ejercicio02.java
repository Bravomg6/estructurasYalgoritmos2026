/*
Prompt inicial utilizado:
Implementar una función recursiva que sume todos los enteros desde n hasta 1.
El caso más simple es n = 0, donde la suma es 0 (no hay nada que sumar).
La idea recursiva: sum(n) = n + sum(n-1). Cada llamada reduce n en 1,
garantizando avance hacia el caso base. Probar con n = 0, 1, 5 y 10.
Resultados esperados: 0, 1, 15, 55.

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    public static int sumToN(int n) {
        // Caso base: la suma de 0 a 1 es 0
        if (n <= 0) {
            return 0;
        }
        // Caso recursivo: n + suma de (n-1) hasta 1
        return n + sumToN(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 2: Suma de los primeros N numeros ===");

        int[] testValues = {0, 1, 5, 10};
        int[] expected = {0, 1, 15, 55};

        for (int i = 0; i < testValues.length; i++) {
            int result = sumToN(testValues[i]);
            System.out.println("sumToN(" + testValues[i] + ") = " + result
                    + " (esperado: " + expected[i] + ") "
                    + (result == expected[i] ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
