/*
Prompt inicial utilizado:
Demonstrate the space-waste problem in a simple (non-circular) queue.
Show the internal array after several enqueue and dequeue operations,
highlighting how free positions at the front cannot be reused.

Ajustes realizados:
Ninguno
*/

public class Ejercicio09 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 9: Desperdicio de Espacio en Cola Simple ===\n");

        ColaSimpleDemo queue = new ColaSimpleDemo(6);

        System.out.println("Step 1: Enqueue A, B, C, D");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.printArray();

        System.out.println("\nStep 2: Dequeue twice (removes A and B)");
        queue.dequeue();
        queue.dequeue();
        queue.printArray();
        System.out.println("NOTE: Positions 0 and 1 are now free but CANNOT be reused");
        System.out.println("      because rear is already at index 4.");

        System.out.println("\nStep 3: Enqueue E, F");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.printArray();

        System.out.println("\nStep 4: Try to enqueue G (should fail even though positions 0-1 are free)");
        try {
            queue.enqueue("G");
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n--- Problem Summary ---");
        System.out.println("In a simple array-based queue, front and rear only move forward.");
        System.out.println("Once rear reaches the end of the array, no more elements can be");
        System.out.println("enqueued even if there are free slots at the beginning.");
        System.out.println("This is called 'false overflow' — the queue reports being full");
        System.out.println("while actual unused space exists. The solution is a CIRCULAR queue");
        System.out.println("(see Ejercicio10) that wraps indices around using modulo (%).");
    }
}

class ColaSimpleDemo {

    private String[] data;
    private int front;
    private int rear;

    public ColaSimpleDemo(int capacity) {
        this.data = new String[capacity];
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(String value) {
        if (rear >= data.length) {
            throw new IllegalStateException(
                "Queue is full (false overflow) — rear=" + rear
                + ", array length=" + data.length
                + ", but front=" + front + " (wasted space at start)");
        }
        data[rear] = value;
        rear++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        String value = data[front];
        data[front] = null; // clear reference for visualization
        front++;
        return value;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Prints the internal array showing which positions are used, free, or wasted.
     */
    public void printArray() {
        System.out.print("Array:    [");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] == null ? "_" : data[i]);
            if (i < data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("          front=" + front + ", rear=" + rear
                + ", active elements=" + (rear - front));
    }
}
