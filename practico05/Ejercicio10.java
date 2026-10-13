/*
Prompt inicial utilizado:
Implementar una función recursiva que busque un número en un arreglo sin
usar bucles (sin for, sin while). Iniciar la búsqueda desde el índice 0. Avanzar
incrementando el índice en cada llamada recursiva. Caso base 1: si el elemento
actual es igual al objetivo, devolver su índice (encontrado). Caso base 2: si el índice
alcanza la longitud del arreglo, devolver -1 (no encontrado). Probar con el arreglo {3, 7, 1, 9, 4}
buscando el 9 (índice esperado 3), el 5 (esperado -1) y el 3 (índice esperado 0).

Ajustes realizados:
Ninguno
*/

public class Ejercicio10 {

    public static int search(int[] arr, int target, int index) {
        // Caso base 1: se llegó al final sin encontrar el objetivo
        if (index >= arr.length) {
            return -1;
        }
        // Caso base 2: se encontró el objetivo en el índice actual
        if (arr[index] == target) {
            return index;
        }
        // Caso recursivo: buscar el resto del arreglo
        return search(arr, target, index + 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 10: Buscar un elemento en un arreglo ===");

        int[] arr = {3, 7, 1, 9, 4};

        // Prueba 1: el elemento existe en el medio
        int result1 = search(arr, 9, 0);
        System.out.println("search([3,7,1,9,4], 9) = " + result1
                + " (esperado: 3) " + (result1 == 3 ? "CORRECTO" : "INCORRECTO"));

        // Prueba 2: el elemento no existe
        int result2 = search(arr, 5, 0);
        System.out.println("search([3,7,1,9,4], 5) = " + result2
                + " (esperado: -1) " + (result2 == -1 ? "CORRECTO" : "INCORRECTO"));

        // Prueba 3: el elemento está al principio
        int result3 = search(arr, 3, 0);
        System.out.println("search([3,7,1,9,4], 3) = " + result3
                + " (esperado: 0) " + (result3 == 0 ? "CORRECTO" : "INCORRECTO"));

        // Prueba 4: el elemento está al final
        int result4 = search(arr, 4, 0);
        System.out.println("search([3,7,1,9,4], 4) = " + result4
                + " (esperado: 4) " + (result4 == 4 ? "CORRECTO" : "INCORRECTO"));
    }
}
