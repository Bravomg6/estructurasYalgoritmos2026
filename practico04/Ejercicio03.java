/*
Prompt inicial utilizado:
Implementar un algoritmo de búsqueda binaria en Java para un arreglo de enteros
ordenado.
Estrategia: dividir repetidamente el intervalo de búsqueda por la mitad
comparando el objetivo con el elemento central. Si el objetivo es menor, buscar
en la mitad izquierda; si es mayor, buscar en la mitad derecha.
Justificación: la búsqueda binaria es más eficiente que la búsqueda lineal sobre
datos ordenados porque cada comparación elimina la mitad de los elementos
restantes, lo que produce O(log n) de tiempo en lugar de O(n).
Complejidad temporal: O(log n). Complejidad espacial: O(1) para la versión
iterativa.
El programa debe mostrar paso a paso cómo evolucionan las variables (low, high,
mid).

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio03 {

    /**
     * Realiza una búsqueda binaria sobre un arreglo ordenado.
     * Complejidad temporal: O(log n) — el espacio de búsqueda se reduce a la mitad en cada iteración.
     * Complejidad espacial: O(1) — la implementación iterativa usa espacio extra constante.
     * Devuelve el índice del objetivo, o -1 si no se encuentra.
     */
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int step = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Evita un posible desbordamiento

            System.out.println("Paso " + step + ": low=" + low + ", high=" + high + ", mid=" + mid + ", array[mid]=" + array[mid]);

            if (array[mid] == target) {
                System.out.println("Objetivo encontrado en el índice: " + mid);
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1; // El objetivo está en la mitad derecha
            } else {
                high = mid - 1; // El objetivo está en la mitad izquierda
            }
            step++;
        }

        System.out.println("Objetivo no encontrado después de " + (step - 1) + " pasos.");
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Ingrese " + n + " enteros en orden ascendente:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Ingrese el valor a buscar: ");
        int target = scanner.nextInt();

        int result = binarySearch(array, target);
        if (result == -1) {
            System.out.println("Resultado: elemento no encontrado.");
        }

        scanner.close();
    }
}
