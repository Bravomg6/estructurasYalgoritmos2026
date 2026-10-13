/*
Prompt inicial utilizado:
Crear un sistema de cola de impresión. Cada documento tiene un nombre y una cantidad de páginas.
Los documentos deben imprimirse en el mismo orden en que fueron agregados (FIFO).
Operaciones: agregar documento, imprimir el siguiente documento, consultar el siguiente
documento y consultar el tamaño de la cola.

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 8: Cola de Impresion ===\n");

        ColaImpresion printer = new ColaImpresion(10);

        System.out.println("Documentos enviados a la impresora:");
        printer.agregarDocumento("Report.pdf", 12);
        printer.agregarDocumento("Invoice.docx", 2);
        printer.agregarDocumento("Thesis.pdf", 85);
        printer.agregarDocumento("Photo.jpg", 1);
        System.out.println("Documentos en la cola: " + printer.size());
        System.out.println("Siguiente a imprimir: " + printer.consultarSiguiente());

        System.out.println("\nImprimiendo todos los documentos (orden FIFO):");
        int totalPages = 0;
        while (!printer.isEmpty()) {
            Documento doc = printer.imprimirSiguiente();
            System.out.println("Imprimiendo: " + doc.name + " (" + doc.pages + " páginas)");
            totalPages += doc.pages;
        }
        System.out.println("Total de páginas impresas: " + totalPages);

        System.out.println("\nImprimiendo con la cola vacía (prueba de underflow)...");
        try {
            printer.imprimirSiguiente();
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
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
     * Agrega un documento al final de la cola de impresión.
     */
    public void agregarDocumento(String name, int pages) {
        if (isFull()) {
            throw new IllegalStateException("La cola de impresión está llena");
        }
        documents[rear] = new Documento(name, pages);
        rear++;
        count++;
    }

    /**
     * Elimina y devuelve el próximo documento a imprimir (el frente de la cola).
     */
    public Documento imprimirSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("No hay documentos en la cola de impresión");
        }
        Documento doc = documents[front];
        front++;
        count--;
        return doc;
    }

    /**
     * Devuelve el próximo documento a imprimir sin eliminarlo.
     */
    public Documento consultarSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("No hay documentos en la cola de impresión");
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
