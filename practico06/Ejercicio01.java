/*
Prompt inicial utilizado:
Implementar un algoritmo de Bubble Sort que muestre el arreglo original y luego el estado del arreglo después de cada pasada. Incluir comentarios que expliquen por qué el elemento más grande "burbujea" hacia el final del arreglo. El programa debe imprimir el arreglo antes de ordenarlo, después de cada pasada completa y el arreglo final ordenado. Usar el arreglo {64, 34, 25, 12, 22, 11, 90} como entrada. Verificar la corrección confirmando que el arreglo final está en orden ascendente.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio01 {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("=== Bubble Sort Paso a Paso ===");
        System.out.println("Arreglo original: " + Arrays.toString(array));
        System.out.println();

        int n = array.length;

        // Bucle externo: cada pasada coloca el siguiente elemento más grande en su posición final
        for (int i = 0; i < n - 1; i++) {
            System.out.println("--- Pasada " + (i + 1) + " ---");

            // Bucle interno: compara elementos adyacentes y los intercambia si están desordenados
            // Después de cada pasada, el elemento sin ordenar más grande burbujea hasta el final
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar elementos adyacentes
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            System.out.println("Después de la pasada " + (i + 1) + ": " + Arrays.toString(array));

            // Explicación: después de la pasada i, los últimos i+1 elementos están en su posición final
            if (i < n - 2) {
                System.out.println("  -> El elemento más grande ha burbujeado hasta la posición " + (n - 1 - i));
            }
            System.out.println();
        }

        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }
}
