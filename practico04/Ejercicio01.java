/*
Prompt inicial utilizado:
Implementar un algoritmo en Java que encuentre el valor mínimo en un arreglo de
enteros.
Estrategia: realizar un único recorrido lineal, manteniendo una variable que
almacena el valor más pequeño visto hasta el momento. Inicializarla con el
primer elemento y actualizarla cada vez que se encuentre un elemento menor.
Justificación: cada elemento debe examinarse al menos una vez para garantizar
que se encuentre el mínimo, por lo que un único recorrido es óptimo. Ordenar no
es necesario porque ordenar tiene un costo de O(n log n) mientras que el mínimo
puede encontrarse en O(n).
Complejidad temporal: O(n). Complejidad espacial: O(1).

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio01 {

    /**
     * Encuentra el valor mínimo en un arreglo de enteros.
     * Complejidad temporal: O(n) — cada elemento se visita exactamente una vez.
     * Complejidad espacial: O(1) — se utiliza una única variable sin importar el tamaño de la entrada.
     */
    public static int findMinimum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("El arreglo no debe ser nulo ni estar vacío");
        }

        int min = array[0]; // Se inicia con el primer elemento como mínimo inicial

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]; // Se actualiza el mínimo cuando se encuentra un valor menor
            }
        }

        return min;
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

        int min = findMinimum(array);
        System.out.println("Valor mínimo: " + min);

        scanner.close();
    }
}
