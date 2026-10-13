/*
Prompt inicial utilizado:
Implementar Quicksort sobre un arreglo ya ordenado: {1, 2, 3, 4, 5, 6, 7}. El programa debe contar y mostrar el total de llamadas recursivas realizadas. Usar el primer elemento como pivote. Incluir comentarios que expliquen por qué este es el peor caso de Quicksort (complejidad de tiempo O(n^2)) y cómo conduce a particiones desbalanceadas. Mostrar la profundidad de la recursión y el estado de la partición en cada paso. Verificar el conteo siguiendo la recursión manualmente.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio07 {
    static int recursiveCalls = 0;
    static int maxDepth = 0;

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("=== Peor Caso de Quicksort (Arreglo Ordenado) ===");
        System.out.println("Arreglo original: " + Arrays.toString(array));
        System.out.println();

        quickSort(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
        System.out.println("Total de llamadas recursivas: " + recursiveCalls);
        System.out.println("Profundidad máxima de recursión: " + maxDepth);
        System.out.println();
        System.out.println("Explicación: Con el primer elemento como pivote en un arreglo ordenado,");
        System.out.println("cada partición crea un subarreglo vacío y un subarreglo de tamaño n-1.");
        System.out.println("Esto resulta en una complejidad de tiempo O(n^2) - el peor caso de Quicksort.");
    }

    static void quickSort(int[] array, int low, int high, int depth) {
        recursiveCalls++;
        if (depth > maxDepth) {
            maxDepth = depth;
        }

        if (low >= high) {
            return;
        }

        String indent = "  ".repeat(depth);
        System.out.println(indent + "Llamada " + recursiveCalls + " (profundidad " + depth + "): " + Arrays.toString(Arrays.copyOfRange(array, low, high + 1)));

        // Elegir el primer elemento como pivote
        int pivot = array[low];

        // Particionar usando el esquema de Lomuto (primero intercambiar el pivote al final)
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;

        int pivotValue = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivotValue) {
                i++;
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }

        int t = array[i + 1];
        array[i + 1] = array[high];
        array[high] = t;

        int pivotIndex = i + 1;

        System.out.println(indent + "  Pivote: " + pivot);
        System.out.println(indent + "  Izquierda: " + Arrays.toString(Arrays.copyOfRange(array, low, pivotIndex)));
        System.out.println(indent + "  Derecha: " + Arrays.toString(Arrays.copyOfRange(array, pivotIndex + 1, high + 1)));
        System.out.println();

        // Ordenar recursivamente los subarreglos izquierdo y derecho
        quickSort(array, low, pivotIndex - 1, depth + 1);
        quickSort(array, pivotIndex + 1, high, depth + 1);
    }
}
