/*
Prompt inicial utilizado:
Implementar el algoritmo ShellSort. El programa debe mostrar el arreglo original, mostrar el valor de la brecha (gap) utilizado en cada etapa y mostrar el estado del arreglo después de cada pasada. Usar la secuencia de brechas: empezar con gap = n/2 y dividirla a la mitad cada vez hasta que gap = 0. Usar el arreglo {64, 34, 25, 12, 22, 11, 90, 45} como entrada. Incluir comentarios que expliquen cómo ShellSort mejora Insertion Sort al ordenar primero elementos separados por grandes distancias. Verificar el resultado confirmando que el arreglo está ordenado en orden ascendente.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio05 {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 45};

        System.out.println("=== ShellSort con Explicación de la Brecha ===");
        System.out.println("Arreglo original: " + Arrays.toString(array));
        System.out.println();

        shellSort(array);

        System.out.println();
        System.out.println("Arreglo ordenado: " + Arrays.toString(array));
    }

    static void shellSort(int[] array) {
        int n = array.length;
        int gap = n / 2;

        while (gap > 0) {
            System.out.println("--- Gap = " + gap + " ---");

            // Realizar insertion sort con brecha
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temp;
            }

            System.out.println("Después del gap " + gap + ": " + Arrays.toString(array));
            System.out.println();

            gap /= 2;
        }
    }
}
