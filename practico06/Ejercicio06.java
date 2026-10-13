/*
Prompt inicial utilizado:
Implementar Quicksort usando el primer elemento como pivote. El programa debe mostrar el arreglo original y, en cada llamada recursiva, mostrar: el pivote elegido, el subarreglo izquierdo (elementos <= pivote), el subarreglo derecho (elementos > pivote) y el estado actual del arreglo. Usar el arreglo {8, 3, 7, 1, 5, 9, 2} como entrada. Incluir comentarios que expliquen la estrategia de dividir y conquistar. Verificar el resultado confirmando que el arreglo está ordenado en orden ascendente.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio06 {
    public static void main(String[] args) {
        int[] array = {8, 3, 7, 1, 5, 9, 2};

        System.out.println("=== Quicksort con el Primer Elemento como Pivote ===");
        System.out.println("Arreglo original: " + Arrays.toString(array));
        System.out.println();

        quickSort(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }

    static void quickSort(int[] array, int low, int high, int depth) {
        if (low >= high) {
            return;
        }

        String indent = "  ".repeat(depth);

        // Elegir el primer elemento como pivote
        int pivot = array[low];
        System.out.println(indent + "Pivote: " + pivot);
        System.out.println(indent + "Subarreglo: " + Arrays.toString(Arrays.copyOfRange(array, low, high + 1)));

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

        System.out.println(indent + "Izquierda (<= " + pivot + "): " + Arrays.toString(Arrays.copyOfRange(array, low, pivotIndex)));
        System.out.println(indent + "Derecha (> " + pivot + "): " + Arrays.toString(Arrays.copyOfRange(array, pivotIndex + 1, high + 1)));
        System.out.println(indent + "Arreglo: " + Arrays.toString(Arrays.copyOfRange(array, low, high + 1)));
        System.out.println();

        // Ordenar recursivamente los subarreglos izquierdo y derecho
        quickSort(array, low, pivotIndex - 1, depth + 1);
        quickSort(array, pivotIndex + 1, high, depth + 1);
    }
}
