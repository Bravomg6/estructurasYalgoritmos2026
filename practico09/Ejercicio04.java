/*
Prompt inicial utilizado:
Implement a generic queue using a singly linked list in Java. The queue must support
any type: Integer, String, or custom objects. Operations: enqueue, dequeue, front,
isEmpty, contains, print. Test with a queue of person names (String) and a queue
of Cliente objects. Use a Node<T> class with T data and Node<T> next.
Do not use Java collections for the main structure. Include test cases in main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio04 {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    static class GenericQueue<T> {
        private Node<T> head; // front
        private Node<T> tail; // rear
        private int size;

        public GenericQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void enqueue(T value) {
            Node<T> newNode = new Node<>(value);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue underflow: cannot dequeue from empty queue");
            }
            T value = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return value;
        }

        public T front() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty: no front element");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        public boolean contains(T value) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(value)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue (front -> rear): ");
            Node<T> current = head;
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

    static class Cliente {
        String nombre;
        int numeroTurno;
        String motivo;

        Cliente(String nombre, int numeroTurno, String motivo) {
            this.nombre = nombre;
            this.numeroTurno = numeroTurno;
            this.motivo = motivo;
        }

        @Override
        public String toString() {
            return "Turno #" + numeroTurno + ": " + nombre + " - " + motivo;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Cliente cliente = (Cliente) obj;
            return numeroTurno == cliente.numeroTurno && nombre.equals(cliente.nombre);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 04: Generic Queue ===\n");

        // Test with String (person names)
        System.out.println("--- Queue of Person Names ---");
        GenericQueue<String> nameQueue = new GenericQueue<>();
        nameQueue.enqueue("Maria");
        nameQueue.enqueue("Juan");
        nameQueue.enqueue("Ana");
        nameQueue.enqueue("Carlos");
        nameQueue.print();
        System.out.println("Front: " + nameQueue.front());
        System.out.println("Contains 'Ana': " + nameQueue.contains("Ana"));
        System.out.println("Dequeued: " + nameQueue.dequeue());
        nameQueue.print();

        // Test with Cliente objects
        System.out.println("\n--- Queue of Cliente Objects ---");
        GenericQueue<Cliente> clientQueue = new GenericQueue<>();
        clientQueue.enqueue(new Cliente("Pedro", 1, "Apertura de cuenta"));
        clientQueue.enqueue(new Cliente("Laura", 2, "Prestamo"));
        clientQueue.enqueue(new Cliente("Diego", 3, "Tarjeta de credito"));
        clientQueue.print();
        System.out.println("Front: " + clientQueue.front());
        System.out.println("Contains Laura: " + clientQueue.contains(new Cliente("Laura", 2, "Prestamo")));
        System.out.println("Dequeued: " + clientQueue.dequeue());
        clientQueue.print();

        System.out.println("\n=== All tests passed ===");
    }
}
