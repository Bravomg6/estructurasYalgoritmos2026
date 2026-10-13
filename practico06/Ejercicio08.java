/*
Prompt inicial utilizado:
Implementar el algoritmo MergeSort. El programa debe mostrar: cómo se divide el arreglo en subarreglos, cuándo se alcanza el caso base (subarreglo de tamaño 1) y cómo los subarreglos se vuelven a fusionar. Usar el arreglo {38, 27, 43, 3, 9, 82, 10} como entrada. Incluir comentarios que expliquen la estrategia de dividir y conquistar y el proceso de fusión. Mostrar el árbol de recursión con sangría para visualizar las fases de división y fusión. Verificar el resultado confirmando que el arreglo está ordenado en orden ascendente.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio08 {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("=== MergeSort Paso a Paso ===");
        System.out.println("Arreglo original: " + Arrays.toString(array));
        System.out.println();

        mergeSort(array, 0, array.length - 1, 0);

        System.out.println();
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }

    static void mergeSort(int[] array, int left, int right, int depth) {
        String indent = "  ".repeat(depth);

        if (left == right) {
            System.out.println(indent + "Caso base alcanzado: [" + array[left] + "]");
            return;
        }

        int mid = left + (right - left) / 2;

        System.out.println(indent + "Dividir: " + Arrays.toString(Arrays.copyOfRange(array, left, right + 1)));
        System.out.println(indent + "  Mitad izquierda: " + Arrays.toString(Arrays.copyOfRange(array, left, mid + 1)));
        System.out.println(indent + "  Mitad derecha: " + Arrays.toString(Arrays.copyOfRange(array, mid + 1, right + 1)));
        System.out.println();

        // Ordenar recursivamente la mitad izquierda
        mergeSort(array, left, mid, depth + 1);

        // Ordenar recursivamente la mitad derecha
        mergeSort(array, mid + 1, right, depth + 1);

        // Fusionar las mitades ordenadas
        merge(array, left, mid, right);

        System.out.println(indent + "Fusionado: " + Arrays.toString(Arrays.copyOfRange(array, left, right + 1)));
        System.out.println();
    }

    static void merge(int[] array, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
