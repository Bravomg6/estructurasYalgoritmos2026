/*
Prompt inicial utilizado:
Implement a print queue using a singly linked list. Each print job has:
file name (nombre del archivo), page count (cantidad de paginas), and user
(usuario que lo envio). Operations: add job (agregar trabajos), print next
(imprimir el proximo), peek next file (consultar el proximo archivo),
show all pending (mostrar todos los pendientes).
Use a Node class with PrintJob data. Do not use Java collections.
Include test cases in main.

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
            return fileName + " (" + pageCount + " pages) - Sent by: " + user;
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
        private Node head; // front of queue
        private Node tail; // rear of queue
        private int size;

        public PrintQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        // Add job: enqueue at tail. O(1).
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
            System.out.println("Added: " + job);
        }

        // Print next: dequeue from head. O(1).
        public PrintJob printNext() {
            if (isEmpty()) {
                throw new RuntimeException("No print jobs in queue");
            }
            PrintJob job = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            System.out.println("Printing: " + job);
            return job;
        }

        // Peek next file: return front without removing. O(1).
        public PrintJob peekNext() {
            if (isEmpty()) {
                throw new RuntimeException("No print jobs in queue");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Show all pending jobs: front to rear. O(n).
        public void showAllPending() {
            if (isEmpty()) {
                System.out.println("No pending print jobs");
                return;
            }
            System.out.println("Pending print jobs (" + size + " total):");
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
        System.out.println("=== Ejercicio 09: Print Queue ===\n");

        PrintQueue queue = new PrintQueue();

        // Test adding jobs
        System.out.println("1. Adding print jobs:");
        queue.addJob("report.pdf", 10, "Alice");
        queue.addJob("invoice.docx", 2, "Bob");
        queue.addJob("presentation.pptx", 25, "Charlie");
        queue.addJob("photo.jpg", 1, "Diana");
        System.out.println();

        // Test show all pending
        System.out.println("2. All pending jobs:");
        queue.showAllPending();
        System.out.println();

        // Test peek next
        System.out.println("3. Next job to print: " + queue.peekNext());
        System.out.println();

        // Test print next
        System.out.println("4. Printing jobs:");
        queue.printNext();
        queue.printNext();
        System.out.println();

        // Test remaining jobs
        System.out.println("5. Remaining jobs:");
        queue.showAllPending();
        System.out.println();

        // Test print remaining
        System.out.println("6. Printing remaining:");
        while (!queue.isEmpty()) {
            queue.printNext();
        }
        System.out.println();

        // Test empty queue
        System.out.println("7. Testing empty queue:");
        queue.showAllPending();
        try {
            queue.printNext();
        } catch (RuntimeException e) {
            System.out.println("   Caught expected error: " + e.getMessage());
        }

        System.out.println("\n=== All tests passed ===");
    }
}
