/*
Prompt inicial utilizado:
Implementar una función recursiva que calcule base^exponente sin usar Math.pow.
Una potencia es multiplicaciones sucesivas: base^exponente = base * base^(exponente-1).
El caso base es exponente = 0, donde el resultado es 1 (cualquier número elevado
a la potencia 0 es 1). Reducir el exponente en 1 en cada llamada recursiva. Probar con
(2, 0), (3, 1), (2, 5), (5, 3). Esperado: 1, 3, 32, 125.

Ajustes realizados:
Ninguno
*/

public class Ejercicio04 {

    public static long power(int base, int exponent) {
        // Caso base: cualquier número elevado a 0 es 1
        if (exponent == 0) {
            return 1;
        }
        // Caso recursivo: base^exp = base * base^(exp - 1)
        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 4: Potencia ===");

        int[][] testPairs = {{2, 0}, {3, 1}, {2, 5}, {5, 3}};
        long[] expected = {1, 3, 32, 125};

        for (int i = 0; i < testPairs.length; i++) {
            long result = power(testPairs[i][0], testPairs[i][1]);
            System.out.println("power(" + testPairs[i][0] + ", " + testPairs[i][1] + ") = "
                    + result + " (esperado: " + expected[i] + ") "
                    + (result == expected[i] ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
