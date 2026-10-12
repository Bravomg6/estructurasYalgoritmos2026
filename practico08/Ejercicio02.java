/*
Prompt inicial utilizado:
Implement a method boolean buscar(int dato) for a singly linked list of integers.
The method must traverse from head until it finds the data or reaches null.
Explain why direct index-based access is not possible in a linked list.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

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

    public Ejercicio02() {
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

    // Search for a value by traversing from head to null
    // Returns true if found, false otherwise
    // Note: No direct index access exists because nodes are not stored in
    // contiguous memory; each node only knows its successor via 'siguiente'.
    public boolean buscar(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) {
                return true; // found the value
            }
            actual = actual.siguiente; // move to the next node
        }
        return false; // reached null without finding the value
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
        Ejercicio02 lista = new Ejercicio02();

        System.out.println("=== Ejercicio 2: Buscar elementos ===");

        // Build list: 10 -> 20 -> 30 -> 40 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        System.out.print("List: ");
        lista.imprimir();

        // Test: value exists in the middle
        System.out.println("buscar(20): " + lista.buscar(20)); // expected: true

        // Test: value exists at the beginning
        System.out.println("buscar(10): " + lista.buscar(10)); // expected: true

        // Test: value exists at the end
        System.out.println("buscar(40): " + lista.buscar(40)); // expected: true

        // Test: value does not exist
        System.out.println("buscar(99): " + lista.buscar(99)); // expected: false

        // Test: search in empty list
        Ejercicio02 listaVacia = new Ejercicio02();
        System.out.println("buscar(10) on empty list: " + listaVacia.buscar(10)); // expected: false
    }
}
