/*
Prompt inicial utilizado:
Implementar una función recursiva que calcule el factorial de un entero no negativo n.
Explicar por qué el factorial puede resolverse recursivamente: n! = n * (n-1)!, que es una
definición auto-referencial natural. El caso base es n = 0 o n = 1, donde el resultado es 1.
El problema se reduce llamando a factorial(n-1) y multiplicando por n. Probar con
n = 0, 1, 5 y 7. Resultados esperados: 1, 1, 120, 5040.

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    public static long factorial(int n) {
        // Caso base: 0! = 1 y 1! = 1
        if (n <= 1) {
            return 1;
        }
        // Caso recursivo: n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 1: Factorial ===");

        int[] testValues = {0, 1, 5, 7};
        long[] expected = {1, 1, 120, 5040};

        for (int i = 0; i < testValues.length; i++) {
            long result = factorial(testValues[i]);
            System.out.println("factorial(" + testValues[i] + ") = " + result
                    + " (esperado: " + expected[i] + ") "
                    + (result == expected[i] ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
