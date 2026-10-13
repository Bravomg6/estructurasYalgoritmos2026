/*
Prompt inicial utilizado:
Implementar un algoritmo en Java que busque un elemento objetivo en un arreglo
de enteros desordenado mediante un recorrido lineal. La estrategia es iterar
sobre cada elemento secuencialmente y devolver el índice de la primera
aparición encontrada.
Justificación: como el arreglo está desordenado, no se pueden hacer suposiciones
sobre las posiciones de los elementos, por lo que en el peor caso debe
verificarse cada elemento. El recorrido lineal es el único enfoque correcto sin
preprocesamiento.
Mejor caso: O(1) — el objetivo es el primer elemento.
Peor caso: O(n) — el objetivo es el último elemento o no está presente.
Caso promedio: O(n) — en promedio se recorre la mitad del arreglo.
El programa debe informar cuántas posiciones se recorrieron.

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio02 {

    /**
     * Busca un valor objetivo en un arreglo desordenado.
     * Mejor caso: O(1), peor caso: O(n), caso promedio: O(n).
     * Complejidad espacial: O(1).
     * Devuelve el índice del objetivo, o -1 si no se encuentra.
     * También informa la cantidad de posiciones recorridas.
     */
    public static int linearSearch(int[] array, int target) {
        int positionsTraversed = 0;

        for (int i = 0; i < array.length; i++) {
            positionsTraversed++;
            if (array[i] == target) {
                System.out.println("Posiciones recorridas: " + positionsTraversed);
                return i;
            }
        }

        System.out.println("Posiciones recorridas: " + positionsTraversed);
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Ingrese " + n + " enteros (desordenados):");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Ingrese el valor a buscar: ");
        int target = scanner.nextInt();

        int result = linearSearch(array, target);
        if (result != -1) {
            System.out.println("Elemento encontrado en el índice: " + result);
        } else {
            System.out.println("El elemento no se encuentra en el arreglo.");
        }

        scanner.close();
    }
}
