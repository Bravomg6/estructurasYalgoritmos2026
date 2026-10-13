/*
Prompt inicial utilizado:
Implementar un algoritmo en Java que determine si dos arreglos de enteros son
iguales.
Estrategia: primero verificar si las longitudes coinciden. Luego iterar sobre
ambos arreglos simultáneamente, comparando los elementos en cada posición. El
algoritmo debe terminar tan pronto como se detecte una diferencia (salida
temprana).
Justificación: la salida temprana evita trabajo innecesario cuando los arreglos
difieren al principio. Si los arreglos son idénticos, deben compararse todos
los elementos.
Mejor caso: O(1) — los primeros elementos difieren o las longitudes son
distintas.
Peor caso: O(n) — los arreglos son idénticos o difieren solo en el último
elemento.
Caso promedio: O(n).
Complejidad espacial: O(1).

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio06 {

    /**
     * Determina si dos arreglos son iguales con salida temprana en la primera diferencia.
     * Mejor caso: O(1), peor caso: O(n), caso promedio: O(n).
     * Complejidad espacial: O(1).
     */
    public static boolean areEqual(int[] array1, int[] array2) {
        // Si las longitudes difieren, los arreglos no pueden ser iguales — verificación O(1)
        if (array1.length != array2.length) {
            System.out.println("Los arreglos difieren en longitud. Posiciones comparadas: 0");
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                System.out.println("Diferencia encontrada en el índice " + i + ". Posiciones comparadas: " + (i + 1));
                return false; // Salida temprana: no es necesario verificar los elementos restantes
            }
        }

        System.out.println("Se compararon las " + array1.length + " posiciones.");
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del arreglo 1: ");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];
        System.out.println("Ingrese " + n1 + " enteros para el arreglo 1:");
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Ingrese la cantidad de elementos del arreglo 2: ");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];
        System.out.println("Ingrese " + n2 + " enteros para el arreglo 2:");
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        boolean result = areEqual(array1, array2);
        System.out.println("Los arreglos son " + (result ? "iguales" : "no iguales"));

        scanner.close();
    }
}
