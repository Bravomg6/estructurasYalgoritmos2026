/*
Prompt inicial utilizado:
Implementar un programa que ordene alfabéticamente un arreglo de nombres usando Selection Sort. El arreglo de entrada es {"Lucia", "Ana", "Pedro", "Juan"}. El programa debe mostrar el arreglo original, mostrar cada paso del proceso de selección (encontrar el mínimo e intercambiar) y mostrar el arreglo final ordenado. Usar String.compareTo() para la comparación alfabética. Incluir comentarios que expliquen cómo funciona Selection Sort con cadenas. Verificar el resultado confirmando que los nombres están en orden alfabético.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio04 {
    public static void main(String[] args) {
        String[] names = {"Lucia", "Ana", "Pedro", "Juan"};

        System.out.println("=== Selection Sort para Nombres ===");
        System.out.println("Arreglo original: " + Arrays.toString(names));
        System.out.println();

        selectionSort(names);

        System.out.println();
        System.out.println("Arreglo ordenado: " + Arrays.toString(names));
    }

    static void selectionSort(String[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            System.out.println("Pasada " + (i + 1) + ": Buscando el mínimo a partir del índice " + i);

            for (int j = i + 1; j < n; j++) {
                // compareTo devuelve un valor negativo si array[j] va antes que array[minIndex]
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                System.out.println("  Intercambiando \"" + array[i] + "\" con \"" + array[minIndex] + "\"");
                String temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            } else {
                System.out.println("  \"" + array[i] + "\" ya está en la posición correcta");
            }

            System.out.println("  Arreglo: " + Arrays.toString(array));
            System.out.println();
        }
    }
}
