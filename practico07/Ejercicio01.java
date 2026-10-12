/*
Prompt inicial utilizado:
Implement a fixed-size integer stack (PilaEnteros) backed by an array. It must support:
push, pop, peek, isEmpty, isFull, and size. Explain the use of the top index, its initial value,
and what happens when the stack is full (overflow) or empty (underflow).

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 1: Pila de Enteros ===\n");

        PilaEnteros stack = new PilaEnteros(5);

        System.out.println("Initial state:");
        System.out.println("isEmpty=" + stack.isEmpty() + ", isFull=" + stack.isFull()
                + ", size=" + stack.size());

        System.out.println("\nPushing 10, 20, 30, 40, 50...");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("size=" + stack.size() + ", isFull=" + stack.isFull()
                + ", top element (peek)=" + stack.peek());

        System.out.println("\nPushing a 6th element (overflow test)...");
        try {
            stack.push(60);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\nPopping elements (LIFO order):");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop() + ", remaining size=" + stack.size());
        }

        System.out.println("\nPopping from empty stack (underflow test)...");
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}

class PilaEnteros {

    private int[] data;
    private int top;

    /**
     * Constructor: creates a stack with a fixed capacity.
     *
     * The top index starts at -1, meaning the stack is empty.
     * top always points to the position of the most recently pushed element.
     */
    public PilaEnteros(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.data = new int[capacity];
        this.top = -1;
    }

    /**
     * Pushes a new element onto the top of the stack.
     * Precondition: the stack must not be full (overflow).
     */
    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full (overflow)");
        }
        top++;
        data[top] = value;
    }

    /**
     * Removes and returns the top element.
     * Precondition: the stack must not be empty (underflow).
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty (underflow)");
        }
        int value = data[top];
        top--;
        return value;
    }

    /**
     * Returns the top element without removing it.
     * Precondition: the stack must not be empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty (underflow)");
        }
        return data[top];
    }

    /**
     * Returns true when the stack contains no elements.
     * Invariant: isEmpty() == (top == -1).
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns true when the stack has reached its fixed capacity.
     * Invariant: isFull() == (top == data.length - 1).
     */
    public boolean isFull() {
        return top == data.length - 1;
    }

    /**
     * Returns the number of elements currently stored.
     * Invariant: size() == top + 1.
     */
    public int size() {
        return top + 1;
    }
}
