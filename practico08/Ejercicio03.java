/*
Prompt inicial utilizado:
Implement a method int obtener(int posicion) for a singly linked list of integers.
The method must validate invalid positions (posicion < 0, posicion >= size).
Explain that even though a position is used, the list does not have direct access like an array.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio03 {

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

    public Ejercicio03() {
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

    // Get the value at a given position (0-based index)
    // Even though we use a position, the list has no direct access like an array.
    // We must traverse from head, counting nodes until we reach the desired position.
    // Time complexity: O(n) in the worst case.
    public int obtener(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                "Invalid position: " + posicion + ". Valid range: 0 to " + (size - 1));
        }
        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente; // advance 'posicion' times
        }
        return actual.dato;
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
        Ejercicio03 lista = new Ejercicio03();

        System.out.println("=== Ejercicio 3: Obtener elemento por posicion ===");

        // Build list: 10 -> 20 -> 30 -> 40 -> 50 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(50);
        System.out.print("List: ");
        lista.imprimir();
        System.out.println("Size: " + lista.getSize());

        // Test: get first element
        System.out.println("obtener(0): " + lista.obtener(0)); // expected: 10

        // Test: get middle element
        System.out.println("obtener(2): " + lista.obtener(2)); // expected: 30

        // Test: get last element
        System.out.println("obtener(4): " + lista.obtener(4)); // expected: 50

        // Test: negative position
        try {
            lista.obtener(-1);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("obtener(-1) correctly threw: " + e.getMessage());
        }

        // Test: position equal to size
        try {
            lista.obtener(5);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("obtener(5) correctly threw: " + e.getMessage());
        }

        // Test: position greater than size
        try {
            lista.obtener(100);
            System.out.println("ERROR: should have thrown exception");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("obtener(100) correctly threw: " + e.getMessage());
        }
    }
}
