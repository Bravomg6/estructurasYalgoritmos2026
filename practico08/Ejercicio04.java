/*
Prompt inicial utilizado:
Implement a method void insertarEnPosicion(int dato, int posicion) for a singly linked list.
The method must allow inserting at the beginning, in the middle, and at the end.
Explain the correct order of reference updates:
  nuevo.setSiguiente(actual.getSiguiente());
  actual.setSiguiente(nuevo);
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio04 {

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

    public Ejercicio04() {
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

    // Insert a new node at a specific position (0-based index)
    // Valid positions: 0 (beginning) to size (end)
    //
    // Correct order of reference updates:
    //   1. nuevo.siguiente = actual.siguiente;  (link new node to the rest of the list)
    //   2. actual.siguiente = nuevo;            (link previous node to the new node)
    //
    // If we reversed the order, we would lose the reference to the rest of the list.
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException(
                "Invalid position: " + posicion + ". Valid range: 0 to " + size);
        }

        // Insert at the beginning
        if (posicion == 0) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = head;
            head = nuevo;
            size++;
            return;
        }

        // Traverse to the node just before the insertion point
        Nodo actual = head;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }

        // Insert in the middle or at the end
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = actual.siguiente; // step 1: link new node to the rest
        actual.siguiente = nuevo;           // step 2: link previous node to new node
        size++;
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
        Ejercicio04 lista = new Ejercicio04();

        System.out.println("=== Ejercicio 4: Insertar en posicion especifica ===");

        // Build initial list: 10 -> 20 -> 30 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        System.out.print("Initial list: ");
        lista.imprimir();
        System.out.println("Size: " + lista.getSize());

        // Test: insert at the beginning (position 0)
        lista.insertarEnPosicion(5, 0);
        System.out.print("After insertarEnPosicion(5, 0): ");
        lista.imprimir(); // expected: 5 -> 10 -> 20 -> 30 -> null
        System.out.println("Size: " + lista.getSize());

        // Test: insert in the middle (position 2)
        lista.insertarEnPosicion(15, 2);
        System.out.print("After insertarEnPosicion(15, 2): ");
        lista.imprimir(); // expected: 5 -> 10 -> 15 -> 20 -> 30 -> null
        System.out.println("Size: " + lista.getSize());

        // Test: insert at the end (position = size)
        lista.insertarEnPosicion(35, lista.getSize());
        System.out.print("After insertarEnPosicion(35, size): ");
        lista.imprimir(); // expected: 5 -> 10 -> 15 -> 20 -> 30 -> 35 -> null
        System.out.println("Size: " + lista.getSize());

        // Test: invalid position (negative)
        try {
            lista.insertarEnPosicion(99, -1);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("insertarEnPosicion(99, -1) correctly threw: " + e.getMessage());
        }

        // Test: invalid position (greater than size)
        try {
            lista.insertarEnPosicion(99, 100);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("insertarEnPosicion(99, 100) correctly threw: " + e.getMessage());
        }
    }
}
