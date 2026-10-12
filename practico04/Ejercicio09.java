/*
Prompt inicial utilizado:
Implement a Java algorithm that finds the largest element in a 2D integer
matrix.
Strategy: initialize a variable with the first element, then traverse all rows
and columns comparing each element against the current maximum.
Justification: every element must be examined because the maximum could be
located at any position. No element can be skipped without risking an incorrect
result.
Time complexity: O(rows * cols) — full traversal required.
Space complexity: O(1) — only the max variable is needed.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio09 {

    /**
     * Finds the largest element in a 2D matrix.
     * Time complexity: O(rows * cols) — every element must be visited.
     * Space complexity: O(1) — only the max variable is maintained.
     */
    public static int findMaxInMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix must not be null or empty");
        }

        int max = matrix[0][0]; // Initialize with the first element

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

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int max = findMaxInMatrix(matrix);
        System.out.println("Largest element: " + max);

        scanner.close();
    }
}
