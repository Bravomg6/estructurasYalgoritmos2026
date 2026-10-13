/*
Prompt inicial utilizado:
Implementar un algoritmo en Java que calcule la suma de todos los elementos de
una matriz de enteros bidimensional.
Estrategia: recorrer la matriz fila por fila (bucle externo sobre filas, bucle
interno sobre columnas), acumulando la suma en una variable.
Justificación: cada elemento debe visitarse exactamente una vez para asegurar
una suma completa, por lo que se requiere un bucle anidado que cubra todas las
filas y columnas.
Complejidad temporal: O(filas * cols) = O(n*m) donde n son las filas y m las
columnas.
Complejidad espacial: O(1) — solo se necesita el acumulador.
El programa debe contar la cantidad de operaciones de suma realizadas.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio08 {

    /**
     * Calcula la suma de todos los elementos de una matriz bidimensional.
     * Orden de recorrido: fila por fila, de izquierda a derecha en cada fila.
     * Complejidad temporal: O(filas * cols) — cada elemento se visita exactamente una vez.
     * Complejidad espacial: O(1) — solo variables de acumulador y contador.
     * Devuelve un arreglo donde el índice 0 = suma, índice 1 = cantidad de sumas.
     */
    public static long[] sumMatrix(int[][] matrix) {
        long sum = 0;
        int additions = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                additions++;
            }
        }

        return new long[]{sum, additions};
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

        long[] result = sumMatrix(matrix);
        System.out.println("Suma de todos los elementos: " + result[0]);
        System.out.println("Cantidad de operaciones de suma: " + result[1]);
        System.out.println("Total de elementos: " + (rows * cols));

        scanner.close();
    }
}
