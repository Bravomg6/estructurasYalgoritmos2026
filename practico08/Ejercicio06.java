/*
Prompt inicial utilizado:
Implement a method void eliminarEnPosicion(int posicion) for a singly linked list.
The method must validate invalid positions and update size.
Explain how to find the node before the one to be removed.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio06 {

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

    public Ejercicio06() {
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

    // Remove the node at a specific position (0-based index)
    // Valid positions: 0 to size-1
    //
    // To remove a node, we need to find the node BEFORE it (the previous node)
    // and update its 'siguiente' reference to skip the node being removed.
    // For position 0, there is no previous node, so we update head directly.
    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                "Invalid position: " + posicion + ". Valid range: 0 to " + (size - 1));
        }

        // Remove the first node
        if (posicion == 0) {
            head = head.siguiente;
            size--;
            return;
        }

        // Find the node just before the one to remove
        Nodo anterior = head;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.siguiente;
        }

        // Skip the node at 'posicion'
        anterior.siguiente = anterior.siguiente.siguiente;
        size--;
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

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 6: Eliminar nodo por posicion ===");

        // Test 1: Remove first node (position 0)
        Ejercicio06 lista1 = new Ejercicio06();
        lista1.insertarAlFinal(10);
        lista1.insertarAlFinal(20);
        lista1.insertarAlFinal(30);
        System.out.print("Before: ");
        lista1.imprimir();
        lista1.eliminarEnPosicion(0);
        System.out.print("After eliminarEnPosicion(0): ");
        lista1.imprimir(); // expected: 20 -> 30 -> null
        System.out.println("Size: " + lista1.getSize());

        // Test 2: Remove middle node
        Ejercicio06 lista2 = new Ejercicio06();
        lista2.insertarAlFinal(10);
        lista2.insertarAlFinal(20);
        lista2.insertarAlFinal(30);
        lista2.insertarAlFinal(40);
        System.out.print("Before: ");
        lista2.imprimir();
        lista2.eliminarEnPosicion(2);
        System.out.print("After eliminarEnPosicion(2): ");
        lista2.imprimir(); // expected: 10 -> 20 -> 40 -> null
        System.out.println("Size: " + lista2.getSize());

        // Test 3: Remove last node
        Ejercicio06 lista3 = new Ejercicio06();
        lista3.insertarAlFinal(10);
        lista3.insertarAlFinal(20);
        lista3.insertarAlFinal(30);
        System.out.print("Before: ");
        lista3.imprimir();
        lista3.eliminarEnPosicion(2);
        System.out.print("After eliminarEnPosicion(2): ");
        lista3.imprimir(); // expected: 10 -> 20 -> null
        System.out.println("Size: " + lista3.getSize());

        // Test 4: Invalid position (negative)
        Ejercicio06 lista4 = new Ejercicio06();
        lista4.insertarAlFinal(10);
        try {
            lista4.eliminarEnPosicion(-1);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("eliminarEnPosicion(-1) correctly threw: " + e.getMessage());
        }

        // Test 5: Invalid position (equal to size)
        try {
            lista4.eliminarEnPosicion(1);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("eliminarEnPosicion(1) on size-1 list correctly threw: " + e.getMessage());
        }

        // Test 6: Remove from single-element list
        Ejercicio06 lista5 = new Ejercicio06();
        lista5.insertarAlFinal(99);
        System.out.print("Before: ");
        lista5.imprimir();
        lista5.eliminarEnPosicion(0);
        System.out.print("After eliminarEnPosicion(0): ");
        lista5.imprimir(); // expected: null
        System.out.println("Size: " + lista5.getSize());
    }
}
