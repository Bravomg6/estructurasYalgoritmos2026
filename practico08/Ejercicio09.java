/*
Prompt inicial utilizado:
Implement a method void invertir() for a singly linked list.
Example: 10 -> 20 -> 30 -> 40 -> null becomes 40 -> 30 -> 20 -> 10 -> null.
Explain what auxiliary references are needed: anterior, actual, siguiente.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio09 {

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

    public Ejercicio09() {
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

    // Reverse the linked list in-place
    //
    // Three auxiliary references are needed:
    // - anterior (previous): starts as null, tracks the new 'next' for each node
    // - actual (current):    the node being processed
    // - siguiente (next):    temporarily stores the rest of the list before we break the link
    //
    // For each node:
    //   1. siguiente = actual.siguiente  (save the rest of the list)
    //   2. actual.siguiente = anterior   (reverse the link)
    //   3. anterior = actual              (move anterior forward)
    //   4. actual = siguiente            (move actual forward)
    //
    // At the end, anterior points to the new head (formerly the last node).
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;  // step 1: save next node
            actual.siguiente = anterior;  // step 2: reverse the link
            anterior = actual;            // step 3: advance anterior
            actual = siguiente;          // step 4: advance actual
        }

        head = anterior; // anterior is now the new head (last node of original list)
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
        System.out.println("=== Ejercicio 9: Invertir lista enlazada ===");

        // Test 1: Reverse a list with multiple elements
        Ejercicio09 lista1 = new Ejercicio09();
        lista1.insertarAlFinal(10);
        lista1.insertarAlFinal(20);
        lista1.insertarAlFinal(30);
        lista1.insertarAlFinal(40);
        System.out.print("Before invertir: ");
        lista1.imprimir(); // expected: 10 -> 20 -> 30 -> 40 -> null
        lista1.invertir();
        System.out.print("After invertir: ");
        lista1.imprimir(); // expected: 40 -> 30 -> 20 -> 10 -> null
        System.out.println("Size: " + lista1.getSize());

        // Test 2: Reverse a single-element list
        Ejercicio09 lista2 = new Ejercicio09();
        lista2.insertarAlFinal(99);
        System.out.print("Before invertir (single): ");
        lista2.imprimir(); // expected: 99 -> null
        lista2.invertir();
        System.out.print("After invertir (single): ");
        lista2.imprimir(); // expected: 99 -> null

        // Test 3: Reverse an empty list
        Ejercicio09 lista3 = new Ejercicio09();
        System.out.print("Before invertir (empty): ");
        lista3.imprimir(); // expected: null
        lista3.invertir();
        System.out.print("After invertir (empty): ");
        lista3.imprimir(); // expected: null

        // Test 4: Reverse twice returns original order
        Ejercicio09 lista4 = new Ejercicio09();
        lista4.insertarAlFinal(1);
        lista4.insertarAlFinal(2);
        lista4.insertarAlFinal(3);
        System.out.print("Original: ");
        lista4.imprimir();
        lista4.invertir();
        System.out.print("Reversed once: ");
        lista4.imprimir();
        lista4.invertir();
        System.out.print("Reversed twice (back to original): ");
        lista4.imprimir(); // expected: 1 -> 2 -> 3 -> null
    }
}
