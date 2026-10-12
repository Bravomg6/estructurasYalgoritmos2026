/*
Prompt inicial utilizado:
Implement a program that sorts an array of names alphabetically using Selection Sort. The input array is {"Lucia", "Ana", "Pedro", "Juan"}. The program should display the original array, show each step of the selection process (finding the minimum and swapping), and display the final sorted array. Use String.compareTo() for alphabetical comparison. Include comments explaining how Selection Sort works with strings. Verify the result by confirming the names are in alphabetical order.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio04 {
    public static void main(String[] args) {
        String[] names = {"Lucia", "Ana", "Pedro", "Juan"};

        System.out.println("=== Selection Sort for Names ===");
        System.out.println("Original array: " + Arrays.toString(names));
        System.out.println();

        selectionSort(names);

        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(names));
    }

    static void selectionSort(String[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            System.out.println("Pass " + (i + 1) + ": Finding minimum from index " + i);

            for (int j = i + 1; j < n; j++) {
                // compareTo returns negative if array[j] comes before array[minIndex]
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                System.out.println("  Swapping \"" + array[i] + "\" with \"" + array[minIndex] + "\"");
                String temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            } else {
                System.out.println("  \"" + array[i] + "\" is already in correct position");
            }

            System.out.println("  Array: " + Arrays.toString(array));
            System.out.println();
        }
    }
}
