/*
Prompt inicial utilizado:
Implement a singly linked list of integers from scratch in Java without using ArrayList or LinkedList.
The list must support: insertarAlInicio(int dato), insertarAlFinal(int dato), imprimir(), estaVacia(), getSize().
Explain how a node is represented, what role 'head' plays, and how the size is updated.
Include test cases in the main method.

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    // Node representation: each node holds data and a reference to the next node
    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo head; // head points to the first node; null means empty list
    private int size;  // tracks the number of nodes for O(1) size queries

    public Ejercicio01() {
        this.head = null;
        this.size = 0;
    }

    // Insert at the beginning: new node becomes the new head
    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = head; // link new node to the current first node
        head = nuevo;           // update head to point to the new node
        size++;
    }

    // Insert at the end: traverse to the last node and link the new node
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            head = nuevo; // empty list: new node becomes head
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente; // advance to the last node
            }
            actual.siguiente = nuevo; // link last node to the new node
        }
        size++;
    }

    // Print the list in the format: 10 -> 20 -> 30 -> null
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

    // Returns true if the list has no nodes
    public boolean estaVacia() {
        return head == null;
    }

    // Returns the number of nodes in the list
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Ejercicio01 lista = new Ejercicio01();

        System.out.println("=== Ejercicio 1: Lista enlazada simple desde cero ===");

        // Test estaVacia on a new list
        System.out.println("estaVacia() on new list: " + lista.estaVacia()); // expected: true
        System.out.println("getSize() on new list: " + lista.getSize());     // expected: 0

        // Test insertarAlFinal
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        System.out.print("After insertarAlFinal(10,20,30): ");
        lista.imprimir(); // expected: 10 -> 20 -> 30 -> null
        System.out.println("getSize(): " + lista.getSize()); // expected: 3
        System.out.println("estaVacia(): " + lista.estaVacia()); // expected: false

        // Test insertarAlInicio
        lista.insertarAlInicio(5);
        System.out.print("After insertarAlInicio(5): ");
        lista.imprimir(); // expected: 5 -> 10 -> 20 -> 30 -> null
        System.out.println("getSize(): " + lista.getSize()); // expected: 4

        // Test insertarAlInicio on empty list
        Ejercicio01 lista2 = new Ejercicio01();
        lista2.insertarAlInicio(100);
        System.out.print("After insertarAlInicio(100) on empty list: ");
        lista2.imprimir(); // expected: 100 -> null
        System.out.println("getSize(): " + lista2.getSize()); // expected: 1
    }
}
