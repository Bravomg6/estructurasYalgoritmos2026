/*
Prompt inicial utilizado:
Implement a bank customer service queue using a singly linked list. Each client has:
name (nombre), turn number (numero de turno), and reason for consultation (motivo).
Operations: add client (agregar cliente), attend next (atender al proximo),
peek next (consultar quien sigue), print queue (imprimir la fila actual).
Use a Node class with Cliente data. Do not use Java collections.
Include test cases in main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio06 {

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
            return "Turno #" + numeroTurno + " | " + nombre + " | Motivo: " + motivo;
        }
    }

    static class Node {
        Cliente data;
        Node next;

        Node(Cliente data) {
            this.data = data;
            this.next = null;
        }
    }

    static class BankQueue {
        private Node head; // front of queue
        private Node tail; // rear of queue
        private int size;
        private int nextTurnNumber;

        public BankQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.nextTurnNumber = 1;
        }

        // Add client: enqueue at tail. O(1).
        public void addClient(String nombre, String motivo) {
            Cliente cliente = new Cliente(nombre, nextTurnNumber++, motivo);
            Node newNode = new Node(cliente);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
            System.out.println("Added: " + cliente);
        }

        // Attend next: dequeue from head. O(1).
        public Cliente attendNext() {
            if (isEmpty()) {
                throw new RuntimeException("No clients in queue");
            }
            Cliente cliente = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            System.out.println("Attending: " + cliente);
            return cliente;
        }

        // Peek next: return front without removing. O(1).
        public Cliente peekNext() {
            if (isEmpty()) {
                throw new RuntimeException("No clients in queue");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Print queue: front to rear. O(n).
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty - no clients waiting");
                return;
            }
            System.out.println("Current queue (" + size + " clients waiting):");
            Node current = head;
            int position = 1;
            while (current != null) {
                System.out.println("  " + position + ". " + current.data);
                current = current.next;
                position++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 06: Bank Customer Service Queue ===\n");

        BankQueue queue = new BankQueue();

        // Test adding clients
        System.out.println("1. Adding clients:");
        queue.addClient("Maria Garcia", "Apertura de cuenta");
        queue.addClient("Juan Perez", "Prestamo personal");
        queue.addClient("Ana Lopez", "Consulta de saldo");
        queue.addClient("Carlos Ruiz", "Tarjeta de credito");
        System.out.println();

        // Test print queue
        System.out.println("2. Current queue:");
        queue.printQueue();
        System.out.println();

        // Test peek next
        System.out.println("3. Next client: " + queue.peekNext());
        System.out.println();

        // Test attend next
        System.out.println("4. Attending clients:");
        queue.attendNext();
        queue.attendNext();
        System.out.println();

        // Test queue after attending
        System.out.println("5. Queue after attending:");
        queue.printQueue();
        System.out.println();

        // Test attend remaining
        System.out.println("6. Attending remaining:");
        while (!queue.isEmpty()) {
            queue.attendNext();
        }
        System.out.println();

        // Test empty queue
        System.out.println("7. Testing empty queue:");
        queue.printQueue();
        try {
            queue.attendNext();
        } catch (RuntimeException e) {
            System.out.println("   Caught expected error: " + e.getMessage());
        }

        System.out.println("\n=== All tests passed ===");
    }
}
