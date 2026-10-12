/*
Prompt inicial utilizado:
Implement a method boolean eliminar(int dato) for a singly linked list.
The method must remove the first occurrence of the value.
Cases to handle: empty list, remove first node, remove middle node, remove last node, non-existent value.
Explain that in Java we do not manually delete a node; we make it unreachable for the Garbage Collector.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio05 {

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

    public Ejercicio05() {
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

    // Remove the first occurrence of a value
    // Returns true if the value was found and removed, false otherwise
    //
    // In Java, we do not manually delete a node. We simply unlink it by updating
    // the 'siguiente' reference of the previous node. Once no reference points
    // to the removed node, the Garbage Collector will reclaim its memory.
    public boolean eliminar(int dato) {
        // Case 1: empty list
        if (head == null) {
            return false;
        }

        // Case 2: remove the first node (head)
        if (head.dato == dato) {
            head = head.siguiente; // unlink the first node
            size--;
            return true;
        }

        // Case 3 & 4: remove a middle or last node
        Nodo actual = head;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == dato) {
                actual.siguiente = actual.siguiente.siguiente; // skip the node to remove
                size--;
                return true;
            }
            actual = actual.siguiente;
        }

        // Case 5: value not found
        return false;
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
        System.out.println("=== Ejercicio 5: Eliminar nodo por valor ===");

        // Test 1: Remove from empty list
        Ejercicio05 lista1 = new Ejercicio05();
        System.out.print("Empty list: ");
        lista1.imprimir();
        System.out.println("eliminar(10) on empty: " + lista1.eliminar(10)); // expected: false

        // Test 2: Remove first node
        Ejercicio05 lista2 = new Ejercicio05();
        lista2.insertarAlFinal(10);
        lista2.insertarAlFinal(20);
        lista2.insertarAlFinal(30);
        System.out.print("Before removing first: ");
        lista2.imprimir();
        System.out.println("eliminar(10): " + lista2.eliminar(10)); // expected: true
        System.out.print("After removing first: ");
        lista2.imprimir(); // expected: 20 -> 30 -> null
        System.out.println("Size: " + lista2.getSize());

        // Test 3: Remove middle node
        Ejercicio05 lista3 = new Ejercicio05();
        lista3.insertarAlFinal(10);
        lista3.insertarAlFinal(20);
        lista3.insertarAlFinal(30);
        System.out.print("Before removing middle: ");
        lista3.imprimir();
        System.out.println("eliminar(20): " + lista3.eliminar(20)); // expected: true
        System.out.print("After removing middle: ");
        lista3.imprimir(); // expected: 10 -> 30 -> null
        System.out.println("Size: " + lista3.getSize());

        // Test 4: Remove last node
        Ejercicio05 lista4 = new Ejercicio05();
        lista4.insertarAlFinal(10);
        lista4.insertarAlFinal(20);
        lista4.insertarAlFinal(30);
        System.out.print("Before removing last: ");
        lista4.imprimir();
        System.out.println("eliminar(30): " + lista4.eliminar(30)); // expected: true
        System.out.print("After removing last: ");
        lista4.imprimir(); // expected: 10 -> 20 -> null
        System.out.println("Size: " + lista4.getSize());

        // Test 5: Remove non-existent value
        Ejercicio05 lista5 = new Ejercicio05();
        lista5.insertarAlFinal(10);
        lista5.insertarAlFinal(20);
        System.out.print("Before removing non-existent: ");
        lista5.imprimir();
        System.out.println("eliminar(99): " + lista5.eliminar(99)); // expected: false
        System.out.print("After removing non-existent: ");
        lista5.imprimir(); // expected: 10 -> 20 -> null
        System.out.println("Size: " + lista5.getSize());

        // Test 6: Remove only element in a single-node list
        Ejercicio05 lista6 = new Ejercicio05();
        lista6.insertarAlFinal(42);
        System.out.print("Before removing only element: ");
        lista6.imprimir();
        System.out.println("eliminar(42): " + lista6.eliminar(42)); // expected: true
        System.out.print("After removing only element: ");
        lista6.imprimir(); // expected: null
        System.out.println("Size: " + lista6.getSize());
    }
}
