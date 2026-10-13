/*
Prompt inicial utilizado:
Implementar Insertion Sort sobre un arreglo casi ordenado: {1, 2, 3, 5, 4, 6, 7}. El programa debe mostrar el arreglo original, mostrar cada paso del proceso de inserción y contar el total de corrimientos (desplazamientos) realizados. Un corrimiento ocurre cuando un elemento se mueve una posición a la derecha para dejar espacio a la clave que se está insertando. Incluir comentarios que expliquen por qué Insertion Sort es eficiente en arreglos casi ordenados. Verificar el resultado confirmando que el arreglo está ordenado en orden ascendente.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio03 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 4, 6, 7};

        System.out.println("=== Insertion Sort en Arreglo Casi Ordenado ===");
        System.out.println("Arreglo original: " + Arrays.toString(array));
        System.out.println();

        int shifts = insertionSort(array);

        System.out.println();
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
        System.out.println("Total de corrimientos: " + shifts);
    }

    static int insertionSort(int[] array) {
        int shifts = 0;
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.println("Paso " + i + ": Insertando " + key);

            // Correr hacia la derecha los elementos mayores que la clave
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                shifts++;
                j--;
                System.out.println("  Corrido: " + Arrays.toString(array));
            }

            array[j + 1] = key;
            System.out.println("  Insertado " + key + " en la posición " + (j + 1));
            System.out.println("  Arreglo: " + Arrays.toString(array));
            System.out.println();
        }

        return shifts;
    }
}
