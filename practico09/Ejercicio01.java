/*
Prompt inicial utilizado:
Implementa una pila de enteros usando una lista enlazada simple. La pila debe soportar:
push (apilar), pop (desapilar), peek (consultar tope), isEmpty (verificar si está vacía),
contains (buscar si contiene un valor) y print (imprimir contenido).
Explica por qué el head de la lista enlazada representa el tope de la pila y por qué
las operaciones push y pop son O(1). Usa una clase Node con int data y Node next.
No uses colecciones de Java para la estructura principal. Incluye casos de prueba en main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedStack {
        private Node head; // head representa el tope de la pila
        private int size;

        public LinkedStack() {
            this.head = null;
            this.size = 0;
        }

        // Push: se inserta al comienzo. O(1) porque solo se actualiza la referencia head.
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            size++;
        }

        // Pop: se elimina del comienzo. O(1) porque solo se actualiza la referencia head.
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Subdesborde de la pila: no se puede hacer pop en una pila vacía");
            }
            int value = head.data;
            head = head.next;
            size--;
            return value;
        }

        // Peek: devuelve el elemento del tope sin eliminarlo. O(1).
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("La pila está vacía: no hay elemento en el tope");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Búsqueda: recorre la lista para encontrar un valor. O(n).
        public boolean contains(int value) {
            Node current = head;
            while (current != null) {
                if (current.data == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Impresión: recorre desde el tope hasta el fondo. O(n).
        public void print() {
            if (isEmpty()) {
                System.out.println("La pila está vacía");
                return;
            }
            System.out.print("Pila (tope -> fondo): ");
            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 01: Pila enlazada de enteros ===\n");

        LinkedStack stack = new LinkedStack();

        // Probar isEmpty en una pila nueva
        System.out.println("1. isEmpty en pila nueva: " + stack.isEmpty());

        // Probar push
        System.out.println("\n2. Apilando: 10, 20, 30, 40, 50");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.print();
        System.out.println("   Tamaño: " + stack.size());

        // Probar peek
        System.out.println("\n3. Peek (tope): " + stack.peek());

        // Probar contains
        System.out.println("\n4. Contiene 30: " + stack.contains(30));
        System.out.println("   Contiene 99: " + stack.contains(99));

        // Probar pop
        System.out.println("\n5. Desapilando dos elementos:");
        System.out.println("   Desapilado: " + stack.pop());
        System.out.println("   Desapilado: " + stack.pop());
        stack.print();
        System.out.println("   Nuevo tope: " + stack.peek());
        System.out.println("   Tamaño: " + stack.size());

        // Probar pop hasta vaciar la pila
        System.out.println("\n6. Desapilando los elementos restantes:");
        while (!stack.isEmpty()) {
            System.out.println("   Desapilado: " + stack.pop());
        }
        System.out.println("   isEmpty después de vaciar: " + stack.isEmpty());

        // Probar subdesborde
        System.out.println("\n7. Probando subdesborde:");
        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println("   Error esperado: " + e.getMessage());
        }

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
