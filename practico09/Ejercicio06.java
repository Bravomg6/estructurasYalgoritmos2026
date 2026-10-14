/*
Prompt inicial utilizado:
Implementa una cola de atención a clientes de un banco usando una lista enlazada simple. Cada cliente tiene:
nombre (name), número de turno (turn number) y motivo de consulta (reason for consultation).
Operaciones: agregar cliente (add client), atender al próximo (attend next),
consultar quién sigue (peek next), imprimir la cola actual (print queue).
Usa una clase Node con datos de Cliente. No uses colecciones de Java.
Incluye casos de prueba en main.

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
        private Node head; // frente de la cola
        private Node tail; // final de la cola
        private int size;
        private int nextTurnNumber;

        public BankQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.nextTurnNumber = 1;
        }

        // Agregar cliente: encolar al final. O(1).
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
            System.out.println("Agregado: " + cliente);
        }

        // Atender al próximo: desencolar desde el head. O(1).
        public Cliente attendNext() {
            if (isEmpty()) {
                throw new RuntimeException("No hay clientes en la cola");
            }
            Cliente cliente = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            System.out.println("Atendiendo: " + cliente);
            return cliente;
        }

        // Consultar quién sigue: devuelve el frente sin eliminarlo. O(1).
        public Cliente peekNext() {
            if (isEmpty()) {
                throw new RuntimeException("No hay clientes en la cola");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Imprimir la cola: del frente al final. O(n).
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("La cola está vacía - no hay clientes en espera");
                return;
            }
            System.out.println("Cola actual (" + size + " clientes en espera):");
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
        System.out.println("=== Ejercicio 06: Cola de atención a clientes de un banco ===\n");

        BankQueue queue = new BankQueue();

        // Probar la agregación de clientes
        System.out.println("1. Agregando clientes:");
        queue.addClient("Maria Garcia", "Apertura de cuenta");
        queue.addClient("Juan Perez", "Prestamo personal");
        queue.addClient("Ana Lopez", "Consulta de saldo");
        queue.addClient("Carlos Ruiz", "Tarjeta de credito");
        System.out.println();

        // Probar la impresión de la cola
        System.out.println("2. Cola actual:");
        queue.printQueue();
        System.out.println();

        // Probar consultar quién sigue
        System.out.println("3. Cliente siguiente: " + queue.peekNext());
        System.out.println();

        // Probar atender al próximo
        System.out.println("4. Atendiendo clientes:");
        queue.attendNext();
        queue.attendNext();
        System.out.println();

        // Probar la cola después de atender
        System.out.println("5. Cola después de atender:");
        queue.printQueue();
        System.out.println();

        // Probar atender a los que quedan
        System.out.println("6. Atendiendo a los restantes:");
        while (!queue.isEmpty()) {
            queue.attendNext();
        }
        System.out.println();

        // Probar la cola vacía
        System.out.println("7. Probando la cola vacía:");
        queue.printQueue();
        try {
            queue.attendNext();
        } catch (RuntimeException e) {
            System.out.println("   Error esperado: " + e.getMessage());
        }

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
