/*
Prompt inicial utilizado:
Implementar un algoritmo en Java que cuente cuántas veces aparece un valor
objetivo en un arreglo de enteros.
Estrategia: recorrer el arreglo completo una sola vez, manteniendo un contador
que se incrementa cada vez que el elemento actual coincide con el objetivo.
Justificación: el algoritmo debe examinar cada elemento porque el objetivo puede
aparecer en cualquier posición. No existe un atajo sin preprocesamiento ni
estructuras de datos adicionales.
Complejidad temporal: O(n) — se requiere un recorrido completo.
Complejidad espacial: O(1) — solo se necesita una variable contador.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio05 {

    /**
     * Cuenta las apariciones de un valor objetivo en un arreglo.
     * Complejidad temporal: O(n) — debe verificarse cada elemento.
     * Complejidad espacial: O(1) — solo se mantiene un contador.
     */
    public static int countOccurrences(int[] array, int target) {
        int count = 0;

        for (int element : array) {
            if (element == target) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Ingrese " + n + " enteros:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Ingrese el valor a contar: ");
        int target = scanner.nextInt();

        int occurrences = countOccurrences(array, target);
        System.out.println("El valor " + target + " aparece " + occurrences + " veces.");

        scanner.close();
    }
}
