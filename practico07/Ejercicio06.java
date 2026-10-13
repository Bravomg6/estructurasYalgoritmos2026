/*
Prompt inicial utilizado:
Implementar una cola simple de enteros (ColaEnteros) usando un arreglo.
Operaciones: enqueue, dequeue, front, isEmpty, isFull, size.
Explicar el propósito de los índices front y rear.

Ajustes realizados:
Ninguno
*/

public class Ejercicio06 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 6: Cola Simple de Enteros ===\n");

        ColaEnteros queue = new ColaEnteros(5);

        System.out.println("Estado inicial:");
        System.out.println("isEmpty=" + queue.isEmpty() + ", isFull=" + queue.isFull()
                + ", size=" + queue.size());

        System.out.println("\nEncolar: 10, 20, 30, 40, 50");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("size=" + queue.size() + ", isFull=" + queue.isFull()
                + ", front=" + queue.front());

        System.out.println("\nEncolar un 6º elemento (prueba de overflow)...");
        try {
            queue.enqueue(60);
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\nDesencolar elementos (orden FIFO):");
        while (!queue.isEmpty()) {
            System.out.println("Desencolado: " + queue.dequeue() + ", tamaño restante=" + queue.size());
        }

        System.out.println("\nDesencolar de una cola vacía (prueba de underflow)...");
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\n--- Explicación de front y rear ---");
        System.out.println("front: índice del próximo elemento a desencolar (el más antiguo).");
        System.out.println("rear:  índice donde se insertará el próximo elemento (el más nuevo).");
        System.out.println("Ambos inician en 0. Después de encolar, rear avanza.");
        System.out.println("Después de desencolar, front avanza. Los elementos entre front y rear");
        System.out.println("son los elementos activos de la cola.");
    }
}

class ColaEnteros {

    private int[] data;
    private int front;
    private int rear;
    private int count;

    /**
     * Constructor: crea una cola con capacidad fija.
     *
     * front = índice del primer elemento (el más antiguo).
     * rear  = índice donde se ubicará el próximo elemento.
     * count = cantidad de elementos actualmente en la cola.
     */
    public ColaEnteros(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva");
        }
        this.data = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     * Precondición: la cola no debe estar llena.
     */
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("La cola está llena (overflow)");
        }
        data[rear] = value;
        rear++;
        count++;
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     * Precondición: la cola no debe estar vacía.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía (underflow)");
        }
        int value = data[front];
        front++;
        count--;
        return value;
    }

    /**
     * Devuelve el elemento al frente sin eliminarlo.
     * Precondición: la cola no debe estar vacía.
     */
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return data[front];
    }

    /**
     * Devuelve true cuando la cola no contiene elementos.
     * Invariante: isEmpty() == (count == 0).
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Devuelve true cuando la cola ha alcanzado su capacidad fija.
     * Invariante: isFull() == (count == data.length).
     */
    public boolean isFull() {
        return count == data.length;
    }

    /**
     * Devuelve la cantidad de elementos actualmente en la cola.
     */
    public int size() {
        return count;
    }
}
