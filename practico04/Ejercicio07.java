/*
Prompt inicial utilizado:
Implementar dos versiones de un algoritmo en Java para invertir un arreglo de
enteros.
Versión 1 (arreglo auxiliar): crear un nuevo arreglo, copiar los elementos del
original en orden inverso y luego copiarlos de vuelta.
Versión 2 (in situ): usar dos punteros (inicio y fin) e intercambiar los
elementos hasta que se encuentren en el medio.
Justificación: la versión 1 es más simple de entender pero usa memoria extra.
La versión 2 es eficiente en memoria pero algo más compleja.
Complejidad temporal: ambas O(n).
Complejidad espacial: Versión 1 = O(n), Versión 2 = O(1).

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio07 {

    /**
     * Invierte un arreglo usando un arreglo auxiliar.
     * Complejidad temporal: O(n). Complejidad espacial: O(n).
     * Ventajas: lógica simple, el arreglo original no cambia hasta la copia final.
     * Desventajas: requiere O(n) de memoria extra.
     */
    public static int[] reverseWithAuxiliary(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    /**
     * Invierte un arreglo in situ usando dos punteros.
     * Complejidad temporal: O(n). Complejidad espacial: O(1).
     * Ventajas: no se necesita memoria extra.
     * Desventajas: modifica el arreglo original.
     */
    public static void reverseInPlace(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Se intercambian los elementos en los punteros izquierdo y derecho
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        int[] original = new int[n];
        System.out.println("Ingrese " + n + " enteros:");
        for (int i = 0; i < n; i++) {
            original[i] = scanner.nextInt();
        }

        // Versión 1: arreglo auxiliar
        int[] reversed1 = reverseWithAuxiliary(original);
        System.out.println("Original:             " + Arrays.toString(original));
        System.out.println("Invertido (auxiliar): " + Arrays.toString(reversed1));

        // Versión 2: in situ
        int[] copy = Arrays.copyOf(original, original.length);
        reverseInPlace(copy);
        System.out.println("Invertido (in situ):  " + Arrays.toString(copy));

        System.out.println("\nComparación:");
        System.out.println("Versión auxiliar - Tiempo: O(n), Espacio: O(n)");
        System.out.println("Versión in situ  - Tiempo: O(n), Espacio: O(1)");

        scanner.close();
    }
}
