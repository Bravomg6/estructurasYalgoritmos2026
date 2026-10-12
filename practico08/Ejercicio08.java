/*
Prompt inicial utilizado:
Implement a method int contarOcurrencias(int dato) for a singly linked list.
Example: 10 -> 20 -> 10 -> 30 -> 10 -> null, for value 10 it must return 3.
Explain why the traversal should not stop at the first match.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo head;
    private int size;

    public Ejercicio08() {
        this.head = null;
        this.size = 0;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    // Count how many times a value appears in the list
    //
    // We must NOT stop the traversal at the first match. The value may appear
    // multiple times throughout the list, so we need to visit every node.
    // Time complexity: O(n) — we always traverse the entire list.
    public int contarOcurrencias(int dato) {
        int count = 0;
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) {
                count++;
            }
            actual = actual.siguiente; // always advance, even after a match
        }
        return count;
    }

    public void imprimir() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> null");
    }

    public static void main(String[] args) {
        Ejercicio08 lista = new Ejercicio08();

        System.out.println("=== Ejercicio 8: Contar ocurrencias ===");

        // Build list: 10 -> 20 -> 10 -> 30 -> 10 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(10);
        System.out.print("List: ");
        lista.imprimir();

        // Test: value appears 3 times
        System.out.println("contarOcurrencias(10): " + lista.contarOcurrencias(10)); // expected: 3

        // Test: value appears 1 time
        System.out.println("contarOcurrencias(20): " + lista.contarOcurrencias(20)); // expected: 1

        // Test: value appears 1 time (different position)
        System.out.println("contarOcurrencias(30): " + lista.contarOcurrencias(30)); // expected: 1

        // Test: value does not appear
        System.out.println("contarOcurrencias(99): " + lista.contarOcurrencias(99)); // expected: 0

        // Test: count in empty list
        Ejercicio08 listaVacia = new Ejercicio08();
        System.out.println("contarOcurrencias(10) on empty: " + listaVacia.contarOcurrencias(10)); // expected: 0

        // Test: all elements are the same
        Ejercicio08 listaUniforme = new Ejercicio08();
        listaUniforme.insertarAlFinal(5);
        listaUniforme.insertarAlFinal(5);
        listaUniforme.insertarAlFinal(5);
        listaUniforme.insertarAlFinal(5);
        System.out.print("Uniform list: ");
        listaUniforme.imprimir();
        System.out.println("contarOcurrencias(5): " + listaUniforme.contarOcurrencias(5)); // expected: 4
    }
}
