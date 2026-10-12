/*
Prompt inicial utilizado:
Create a print queue system. Each document has a name and a page count.
Documents must be printed in the same order they were added (FIFO).
Operations: add document, print next document, check next document, check queue size.

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 8: Cola de Impresion ===\n");

        ColaImpresion printer = new ColaImpresion(10);

        System.out.println("Documents sent to printer:");
        printer.agregarDocumento("Report.pdf", 12);
        printer.agregarDocumento("Invoice.docx", 2);
        printer.agregarDocumento("Thesis.pdf", 85);
        printer.agregarDocumento("Photo.jpg", 1);
        System.out.println("Documents in queue: " + printer.size());
        System.out.println("Next to print: " + printer.consultarSiguiente());

        System.out.println("\nPrinting all documents (FIFO order):");
        int totalPages = 0;
        while (!printer.isEmpty()) {
            Documento doc = printer.imprimirSiguiente();
            System.out.println("Printing: " + doc.name + " (" + doc.pages + " pages)");
            totalPages += doc.pages;
        }
        System.out.println("Total pages printed: " + totalPages);

        System.out.println("\nPrinting with empty queue (underflow test)...");
        try {
            printer.imprimirSiguiente();
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}

class Documento {
    String name;
    int pages;

    public Documento(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }
}

class ColaImpresion {

    private Documento[] documents;
    private int front;
    private int rear;
    private int count;

    public ColaImpresion(int capacity) {
        this.documents = new Documento[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    /**
     * Adds a document to the end of the print queue.
     */
    public void agregarDocumento(String name, int pages) {
        if (isFull()) {
            throw new IllegalStateException("Print queue is full");
        }
        documents[rear] = new Documento(name, pages);
        rear++;
        count++;
    }

    /**
     * Removes and returns the next document to be printed (front of the queue).
     */
    public Documento imprimirSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("No documents in print queue");
        }
        Documento doc = documents[front];
        front++;
        count--;
        return doc;
    }

    /**
     * Returns the next document to be printed without removing it.
     */
    public Documento consultarSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("No documents in print queue");
        }
        return documents[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == documents.length;
    }

    public int size() {
        return count;
    }
}
