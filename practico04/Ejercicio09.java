/*
Prompt inicial utilizado:
Implementar un algoritmo en Java que encuentre el elemento más grande de una
matriz de enteros bidimensional.
Estrategia: inicializar una variable con el primer elemento y luego recorrer
todas las filas y columnas comparando cada elemento con el máximo actual.
Justificación: debe examinarse cada elemento porque el máximo puede estar en
cualquier posición. No se puede omitir ningún elemento sin arriesgar un
resultado incorrecto.
Complejidad temporal: O(filas * cols) — se requiere un recorrido completo.
Complejidad espacial: O(1) — solo se necesita la variable max.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio09 {

    /**
     * Encuentra el elemento más grande de una matriz bidimensional.
     * Complejidad temporal: O(filas * cols) — debe visitarse cada elemento.
     * Complejidad espacial: O(1) — solo se mantiene la variable max.
     */
    public static int findMaxInMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("La matriz no debe ser nula ni estar vacía");
        }

        int max = matrix[0][0]; // Se inicializa con el primer elemento

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de filas: ");
        int rows = scanner.nextInt();
        System.out.print("Ingrese la cantidad de columnas: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Ingrese los elementos de la matriz fila por fila:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int max = findMaxInMatrix(matrix);
        System.out.println("Elemento más grande: " + max);

        scanner.close();
    }
}
