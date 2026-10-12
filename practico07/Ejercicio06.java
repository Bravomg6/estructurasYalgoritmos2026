/*
Prompt inicial utilizado:
Implement a simple integer queue (ColaEnteros) using an array.
Operations: enqueue, dequeue, front, isEmpty, isFull, size.
Explain the purpose of the front and rear indices.

Ajustes realizados:
Ninguno
*/

public class Ejercicio06 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 6: Cola Simple de Enteros ===\n");

        ColaEnteros queue = new ColaEnteros(5);

        System.out.println("Initial state:");
        System.out.println("isEmpty=" + queue.isEmpty() + ", isFull=" + queue.isFull()
                + ", size=" + queue.size());

        System.out.println("\nEnqueue: 10, 20, 30, 40, 50");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("size=" + queue.size() + ", isFull=" + queue.isFull()
                + ", front=" + queue.front());

        System.out.println("\nEnqueue a 6th element (overflow test)...");
        try {
            queue.enqueue(60);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\nDequeue elements (FIFO order):");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue() + ", remaining size=" + queue.size());
        }

        System.out.println("\nDequeue from empty queue (underflow test)...");
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n--- Front and Rear explanation ---");
        System.out.println("front: index of the next element to be dequeued (oldest).");
        System.out.println("rear:  index where the next element will be enqueued (newest).");
        System.out.println("Both start at 0. After enqueue, rear advances.");
        System.out.println("After dequeue, front advances. Elements between front and rear");
        System.out.println("are the active elements in the queue.");
    }
}

class ColaEnteros {

    private int[] data;
    private int front;
    private int rear;
    private int count;

    /**
     * Constructor: creates a queue with fixed capacity.
     *
     * front = index of the first (oldest) element.
     * rear  = index where the next element will be placed.
     * count = number of elements currently in the queue.
     */
    public ColaEnteros(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.data = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    /**
     * Adds an element at the rear of the queue.
     * Precondition: the queue must not be full.
     */
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full (overflow)");
        }
        data[rear] = value;
        rear++;
        count++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * Precondition: the queue must not be empty.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty (underflow)");
        }
        int value = data[front];
        front++;
        count--;
        return value;
    }

    /**
     * Returns the element at the front without removing it.
     * Precondition: the queue must not be empty.
     */
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    /**
     * Returns true when the queue contains no elements.
     * Invariant: isEmpty() == (count == 0).
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns true when the queue has reached its fixed capacity.
     * Invariant: isFull() == (count == data.length).
     */
    public boolean isFull() {
        return count == data.length;
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        return count;
    }
}
