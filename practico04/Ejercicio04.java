/*
Prompt inicial utilizado:
Implementar dos soluciones distintas en Java para detectar elementos duplicados
en un arreglo de enteros.
Solución 1 (fuerza bruta): usar dos bucles anidados para comparar cada elemento
con todos los demás.
Solución 2 (HashSet): iterar una sola vez sobre el arreglo, agregando cada
elemento a un HashSet. Si un elemento ya está en el conjunto, existe un
duplicado.
Justificación: el enfoque de fuerza bruta es sencillo pero ineficiente para
entradas grandes. HashSet proporciona una búsqueda promedio de O(1), lo que hace
que el enfoque general sea O(n).
Complejidad temporal: Solución 1 = O(n^2), Solución 2 = O(n) en promedio.
Complejidad espacial: Solución 1 = O(1), Solución 2 = O(n).
El programa debe comparar las dos soluciones.

Ajustes realizados:
Ninguno
*/

import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio04 {

    /**
     * Detecta duplicados usando dos bucles anidados (fuerza bruta).
     * Complejidad temporal: O(n^2) — cada elemento se compara con todos los elementos posteriores.
     * Complejidad espacial: O(1) — no se necesitan estructuras de datos adicionales.
     */
    public static boolean hasDuplicatesBruteForce(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Detecta duplicados usando un HashSet.
     * Complejidad temporal: O(n) en promedio — cada inserción y búsqueda es O(1) en promedio.
     * Complejidad espacial: O(n) — el HashSet puede almacenar todos los elementos en el peor caso.
     */
    public static boolean hasDuplicatesHashSet(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int element : array) {
            if (seen.contains(element)) {
                return true; // Se encontró un duplicado
            }
            seen.add(element);
        }
        return false;
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

        boolean bruteForceResult = hasDuplicatesBruteForce(array);
        boolean hashSetResult = hasDuplicatesHashSet(array);

        System.out.println("Resultado (fuerza bruta): " + (bruteForceResult ? "Duplicados encontrados" : "Sin duplicados"));
        System.out.println("Resultado (HashSet): " + (hashSetResult ? "Duplicados encontrados" : "Sin duplicados"));

        System.out.println("\nComparación de complejidades:");
        System.out.println("Fuerza bruta - Tiempo: O(n^2), Espacio: O(1)");
        System.out.println("HashSet      - Tiempo: O(n),   Espacio: O(n)");

        scanner.close();
    }
}
