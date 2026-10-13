/*
Prompt inicial utilizado:
Implementar una función recursiva de multiplicación sin usar el operador *.
Representar la multiplicación como suma repetida: a * b = a + a + ... + a (b veces).
Reducir el segundo parámetro (b) en 1 en cada llamada recursiva. El caso base es
cuando b = 0, devolviendo 0 (sumar cero veces no produce nada). Probar con
(3, 4), (5, 0), (7, 1), (2, 8). Esperado: 12, 0, 7, 16.

Ajustes realizados:
Ninguno
*/

public class Ejercicio03 {

    public static int multiply(int a, int b) {
        // Caso base: cualquier cosa multiplicada por 0 es 0
        if (b == 0) {
            return 0;
        }
        // Caso recursivo: a * b = a + a * (b - 1)
        return a + multiply(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 3: Multiplicacion mediante sumas ===");

        int[][] testPairs = {{3, 4}, {5, 0}, {7, 1}, {2, 8}};
        int[] expected = {12, 0, 7, 16};

        for (int i = 0; i < testPairs.length; i++) {
            int result = multiply(testPairs[i][0], testPairs[i][1]);
            System.out.println("multiply(" + testPairs[i][0] + ", " + testPairs[i][1] + ") = "
                    + result + " (esperado: " + expected[i] + ") "
                    + (result == expected[i] ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
