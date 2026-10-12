/*
Prompt inicial utilizado:
Implement a method void modificar(int posicion, int nuevoDato) for a singly linked list.
The method must validate the position before traversing.
Explain the difference between modifying a node's data and modifying the reference to the next node.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio07 {

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

    public Ejercicio07() {
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

    // Modify the data stored at a given position
    //
    // Difference between modifying data vs modifying the reference:
    // - Modifying data (this method): we change 'nodo.dato'. The list structure
    //   (nodes and their links) remains exactly the same.
    // - Modifying the reference: we change 'nodo.siguiente'. This alters the
    //   list structure by adding, removing, or reordering nodes.
    public void modificar(int posicion, int nuevoDato) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                "Invalid position: " + posicion + ". Valid range: 0 to " + (size - 1));
        }

        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente; // advance to the target node
        }
        actual.dato = nuevoDato; // update only the data, not the link
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
        Ejercicio07 lista = new Ejercicio07();

        System.out.println("=== Ejercicio 7: Modificar elemento de la lista ===");

        // Build list: 10 -> 20 -> 30 -> 40 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        System.out.print("Initial list: ");
        lista.imprimir();

        // Test: modify first element
        lista.modificar(0, 11);
        System.out.print("After modificar(0, 11): ");
        lista.imprimir(); // expected: 11 -> 20 -> 30 -> 40 -> null

        // Test: modify middle element
        lista.modificar(2, 33);
        System.out.print("After modificar(2, 33): ");
        lista.imprimir(); // expected: 11 -> 20 -> 33 -> 40 -> null

        // Test: modify last element
        lista.modificar(3, 44);
        System.out.print("After modificar(3, 44): ");
        lista.imprimir(); // expected: 11 -> 20 -> 33 -> 44 -> null

        // Test: invalid position (negative)
        try {
            lista.modificar(-1, 99);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("modificar(-1, 99) correctly threw: " + e.getMessage());
        }

        // Test: invalid position (equal to size)
        try {
            lista.modificar(4, 99);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("modificar(4, 99) correctly threw: " + e.getMessage());
        }

        // Verify structure is unchanged after modifications (same number of nodes)
        System.out.println("Size after all modifications: " + lista.getSize()); // expected: 4
    }
}
