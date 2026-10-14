/*
Prompt inicial utilizado:
Implementa una cola de impresión usando una lista enlazada simple. Cada trabajo de impresión tiene:
nombre del archivo (file name), cantidad de páginas (page count) y usuario
que lo envió (user). Operaciones: agregar trabajos (add job), imprimir el próximo (print next),
consultar el próximo archivo (peek next file),
mostrar todos los pendientes (show all pending).
Usa una clase Node con datos de PrintJob. No uses colecciones de Java.
Incluye casos de prueba en main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio09 {

    static class PrintJob {
        String fileName;
        int pageCount;
        String user;

        PrintJob(String fileName, int pageCount, String user) {
            this.fileName = fileName;
            this.pageCount = pageCount;
            this.user = user;
        }

        @Override
        public String toString() {
            return fileName + " (" + pageCount + " páginas) - Enviado por: " + user;
        }
    }

    static class Node {
        PrintJob data;
        Node next;

        Node(PrintJob data) {
            this.data = data;
            this.next = null;
        }
    }

    static class PrintQueue {
        private Node head; // frente de la cola
        private Node tail; // final de la cola
        private int size;

        public PrintQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        // Agregar trabajo: encolar al final. O(1).
        public void addJob(String fileName, int pageCount, String user) {
            PrintJob job = new PrintJob(fileName, pageCount, user);
            Node newNode = new Node(job);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
            System.out.println("Agregado: " + job);
        }

        // Imprimir el próximo: desencolar desde el head. O(1).
        public PrintJob printNext() {
            if (isEmpty()) {
                throw new RuntimeException("No hay trabajos de impresión en la cola");
            }
            PrintJob job = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            System.out.println("Imprimiendo: " + job);
            return job;
        }

        // Consultar el próximo archivo: devuelve el frente sin eliminarlo. O(1).
        public PrintJob peekNext() {
            if (isEmpty()) {
                throw new RuntimeException("No hay trabajos de impresión en la cola");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Mostrar todos los trabajos pendientes: del frente al final. O(n).
        public void showAllPending() {
            if (isEmpty()) {
                System.out.println("No hay trabajos de impresión pendientes");
                return;
            }
            System.out.println("Trabajos de impresión pendientes (" + size + " en total):");
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
        System.out.println("=== Ejercicio 09: Cola de impresión ===\n");

        PrintQueue queue = new PrintQueue();

        // Probar la agregación de trabajos
        System.out.println("1. Agregando trabajos de impresión:");
        queue.addJob("report.pdf", 10, "Alice");
        queue.addJob("invoice.docx", 2, "Bob");
        queue.addJob("presentation.pptx", 25, "Charlie");
        queue.addJob("photo.jpg", 1, "Diana");
        System.out.println();

        // Probar mostrar todos los pendientes
        System.out.println("2. Todos los trabajos pendientes:");
        queue.showAllPending();
        System.out.println();

        // Probar consultar el próximo
        System.out.println("3. Próximo trabajo a imprimir: " + queue.peekNext());
        System.out.println();

        // Probar imprimir el próximo
        System.out.println("4. Imprimiendo trabajos:");
        queue.printNext();
        queue.printNext();
        System.out.println();

        // Probar los trabajos restantes
        System.out.println("5. Trabajos restantes:");
        queue.showAllPending();
        System.out.println();

        // Probar imprimir los que quedan
        System.out.println("6. Imprimiendo los restantes:");
        while (!queue.isEmpty()) {
            queue.printNext();
        }
        System.out.println();

        // Probar la cola vacía
        System.out.println("7. Probando la cola vacía:");
        queue.showAllPending();
        try {
            queue.printNext();
        } catch (RuntimeException e) {
            System.out.println("   Error esperado: " + e.getMessage());
        }

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
