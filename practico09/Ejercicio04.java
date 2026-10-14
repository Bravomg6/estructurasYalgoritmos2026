/*
Prompt inicial utilizado:
Implementa una cola genérica usando una lista enlazada simple en Java. La cola debe soportar
cualquier tipo: Integer, String u objetos personalizados. Operaciones: enqueue, dequeue, front,
isEmpty, contains, print. Prueba con una cola de nombres de personas (String) y una cola
de objetos Cliente. Usa una clase Node<T> con T data y Node<T> next.
No uses colecciones de Java para la estructura principal. Incluye casos de prueba en main.

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
        private Node<T> head; // frente
        private Node<T> tail; // final
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
                throw new RuntimeException("Subdesborde de la cola: no se puede desencolar una cola vacía");
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
                System.out.println("La cola está vacía");
                return;
            }
            System.out.print("Cola (frente -> final): ");
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
        System.out.println("=== Ejercicio 04: Cola genérica ===\n");

        // Probar con String (nombres de personas)
        System.out.println("--- Cola de nombres de personas ---");
        GenericQueue<String> nameQueue = new GenericQueue<>();
        nameQueue.enqueue("Maria");
        nameQueue.enqueue("Juan");
        nameQueue.enqueue("Ana");
        nameQueue.enqueue("Carlos");
        nameQueue.print();
        System.out.println("Frente: " + nameQueue.front());
        System.out.println("Contiene 'Ana': " + nameQueue.contains("Ana"));
        System.out.println("Desencolado: " + nameQueue.dequeue());
        nameQueue.print();

        // Probar con objetos Cliente
        System.out.println("\n--- Cola de objetos Cliente ---");
        GenericQueue<Cliente> clientQueue = new GenericQueue<>();
        clientQueue.enqueue(new Cliente("Pedro", 1, "Apertura de cuenta"));
        clientQueue.enqueue(new Cliente("Laura", 2, "Prestamo"));
        clientQueue.enqueue(new Cliente("Diego", 3, "Tarjeta de credito"));
        clientQueue.print();
        System.out.println("Frente: " + clientQueue.front());
        System.out.println("Contiene a Laura: " + clientQueue.contains(new Cliente("Laura", 2, "Prestamo")));
        System.out.println("Desencolado: " + clientQueue.dequeue());
        clientQueue.print();

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
