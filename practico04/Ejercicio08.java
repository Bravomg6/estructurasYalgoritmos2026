/*
Prompt inicial utilizado:
Implement a Java algorithm that calculates the sum of all elements in a 2D
integer matrix.
Strategy: traverse the matrix row by row (outer loop over rows, inner loop over
columns), accumulating the sum in a variable.
Justification: every element must be visited exactly once to ensure a complete
sum, so a nested loop covering all rows and columns is required.
Time complexity: O(rows * cols) = O(n*m) where n is rows and m is columns.
Space complexity: O(1) — only the accumulator is needed.
The program must count the number of addition operations performed.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio08 {

    /**
     * Calculates the sum of all elements in a 2D matrix.
     * Traversal order: row by row, left to right within each row.
     * Time complexity: O(rows * cols) — each element visited exactly once.
     * Space complexity: O(1) — only accumulator and counter variables.
     * Returns an array where index 0 = sum, index 1 = number of additions.
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

        long[] result = sumMatrix(matrix);
        System.out.println("Sum of all elements: " + result[0]);
        System.out.println("Number of addition operations: " + result[1]);
        System.out.println("Total elements: " + (rows * cols));

        scanner.close();
    }
}
