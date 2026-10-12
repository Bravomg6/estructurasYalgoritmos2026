/*
Prompt inicial utilizado:
Implement a circular queue using an array. It must reuse the free positions
at the beginning of the array. Explain how the modulo (%) operator is used
to advance front and rear indices, and how to detect whether the queue is
full or empty.

Ajustes realizados:
Ninguno
*/

public class Ejercicio10 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 10: Cola Circular ===\n");

        ColaCircular queue = new ColaCircular(5);

        System.out.println("Step 1: Enqueue 10, 20, 30, 40, 50");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printArray();

        System.out.println("\nStep 2: Dequeue twice (removes 10, 20)");
        queue.dequeue();
        queue.dequeue();
        queue.printArray();

        System.out.println("\nStep 3: Enqueue 60, 70 (wraps around to indices 0 and 1)");
        queue.enqueue(60);
        queue.enqueue(70);
        queue.printArray();
        System.out.println("NOTE: rear wrapped from index 4 to index 0 using modulo.");

        System.out.println("\nStep 4: Try to enqueue 80 (queue is full)");
        try {
            queue.enqueue(80);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\nStep 5: Dequeue all elements");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
        queue.printArray();

        System.out.println("\n--- How the circular queue works ---");
        System.out.println("1. Modulo for wrapping: rear = (rear + 1) % capacity");
        System.out.println("   When rear reaches the last index, it wraps to 0.");
        System.out.println("2. Empty detection: front == rear (and count == 0).");
        System.out.println("3. Full detection: (rear + 1) % capacity == front");
        System.out.println("   We sacrifice one slot to distinguish full from empty.");
        System.out.println("4. This eliminates the false overflow problem of simple queues.");
    }
}

class ColaCircular {

    private int[] data;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    /**
     * Constructor: creates a circular queue with the given capacity.
     *
     * We use a count variable to reliably distinguish between
     * empty (count == 0) and full (count == capacity) states.
     */
    public ColaCircular(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1; // rear starts before front; first enqueue moves it to 0
        this.count = 0;
    }

    /**
     * Adds an element at the rear of the queue.
     * Uses modulo to wrap rear back to 0 when it reaches the end.
     */
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full (overflow)");
        }
        rear = (rear + 1) % capacity; // circular advance
        data[rear] = value;
        count++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * Uses modulo to wrap front back to 0 when it reaches the end.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty (underflow)");
        }
        int value = data[front];
        front = (front + 1) % capacity; // circular advance
        count--;
        return value;
    }

    /**
     * Returns the element at the front without removing it.
     */
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    /**
     * Returns true when the queue contains no elements.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns true when the queue has reached its capacity.
     */
    public boolean isFull() {
        return count == capacity;
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        return count;
    }

    /**
     * Prints the internal array with front/rear pointers for visualization.
     */
    public void printArray() {
        System.out.print("Array:    [");
        for (int i = 0; i < data.length; i++) {
            boolean isUsed = false;
            if (!isEmpty()) {
                // Check if index i is within the active range
                int idx = front;
                for (int j = 0; j < count; j++) {
                    if (idx == i) {
                        isUsed = true;
                        break;
                    }
                    idx = (idx + 1) % capacity;
                }
            }
            System.out.print(isUsed ? String.valueOf(data[i]) : "_");
            if (i < data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("          front=" + front + ", rear=" + rear
                + ", count=" + count + "/" + capacity);
    }
}
