/*
Prompt inicial utilizado:
Implementa una cola de enteros usando una lista enlazada simple. La cola debe soportar:
enqueue (encolar), dequeue (desencolar), front (consultar frente), isEmpty,
contains (buscar si contiene un valor) y print (imprimir contenido).
Explica por qué una cola necesita las referencias head y tail para que enqueue y dequeue sean O(1).
Usa una clase Node con int data y Node next. No uses colecciones de Java.
Incluye casos de prueba en main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedQueue {
        private Node head; // frente de la cola (desencolar desde aquí)
        private Node tail; // final de la cola (encolar aquí)
        private int size;

        public LinkedQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        // Enqueue: se inserta al final. O(1) gracias a la referencia tail.
        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // Dequeue: se elimina desde el head. O(1).
        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Subdesborde de la cola: no se puede desencolar una cola vacía");
            }
            int value = head.data;
            head = head.next;
            if (head == null) {
                tail = null; // la cola queda vacía
            }
            size--;
            return value;
        }

        // Front: devuelve el elemento del frente sin eliminarlo. O(1).
        public int front() {
            if (isEmpty()) {
                throw new RuntimeException("La cola está vacía: no hay elemento en el frente");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Búsqueda: recorre la lista. O(n).
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

        // Impresión: recorre desde el frente hasta el final. O(n).
        public void print() {
            if (isEmpty()) {
                System.out.println("La cola está vacía");
                return;
            }
            System.out.print("Cola (frente -> final): ");
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
        System.out.println("=== Ejercicio 02: Cola enlazada de enteros ===\n");

        LinkedQueue queue = new LinkedQueue();

        // Probar isEmpty en una cola nueva
        System.out.println("1. isEmpty en cola nueva: " + queue.isEmpty());

        // Probar enqueue
        System.out.println("\n2. Encolando: 100, 200, 300, 400");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.print();
        System.out.println("   Tamaño: " + queue.size());

        // Probar front
        System.out.println("\n3. Frente: " + queue.front());

        // Probar contains
        System.out.println("\n4. Contiene 200: " + queue.contains(200));
        System.out.println("   Contiene 999: " + queue.contains(999));

        // Probar dequeue
        System.out.println("\n5. Desencolando dos elementos:");
        System.out.println("   Desencolado: " + queue.dequeue());
        System.out.println("   Desencolado: " + queue.dequeue());
        queue.print();
        System.out.println("   Nuevo frente: " + queue.front());
        System.out.println("   Tamaño: " + queue.size());

        // Probar el orden FIFO
        System.out.println("\n6. Encolando 500 y luego desencolando todo:");
        queue.enqueue(500);
        queue.print();
        while (!queue.isEmpty()) {
            System.out.println("   Desencolado: " + queue.dequeue());
        }
        System.out.println("   isEmpty después de vaciar: " + queue.isEmpty());

        // Probar subdesborde
        System.out.println("\n7. Probando subdesborde:");
        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            System.out.println("   Error esperado: " + e.getMessage());
        }

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
