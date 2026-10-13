/*
Prompt inicial utilizado:
Implementar una pila de enteros de tamaño fijo (PilaEnteros) respaldada por un arreglo. Debe soportar:
push, pop, peek, isEmpty, isFull y size. Explicar el uso del índice top, su valor inicial,
y qué sucede cuando la pila está llena (overflow) o vacía (underflow).

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 1: Pila de Enteros ===\n");

        PilaEnteros stack = new PilaEnteros(5);

        System.out.println("Estado inicial:");
        System.out.println("isEmpty=" + stack.isEmpty() + ", isFull=" + stack.isFull()
                + ", size=" + stack.size());

        System.out.println("\nApilando 10, 20, 30, 40, 50...");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("size=" + stack.size() + ", isFull=" + stack.isFull()
                + ", elemento superior (peek)=" + stack.peek());

        System.out.println("\nApilando un 6º elemento (prueba de overflow)...");
        try {
            stack.push(60);
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\nDesapilando elementos (orden LIFO):");
        while (!stack.isEmpty()) {
            System.out.println("Desapilado: " + stack.pop() + ", tamaño restante=" + stack.size());
        }

        System.out.println("\nDesapilando de una pila vacía (prueba de underflow)...");
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }
}

class PilaEnteros {

    private int[] data;
    private int top;

    /**
     * Constructor: crea una pila con capacidad fija.
     *
     * El índice top inicia en -1, lo que significa que la pila está vacía.
     * top siempre apunta a la posición del elemento apilado más recientemente.
     */
    public PilaEnteros(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva");
        }
        this.data = new int[capacity];
        this.top = -1;
    }

    /**
     * Apila un nuevo elemento en la parte superior de la pila.
     * Precondición: la pila no debe estar llena (overflow).
     */
    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("La pila está llena (overflow)");
        }
        top++;
        data[top] = value;
    }

    /**
     * Elimina y devuelve el elemento superior.
     * Precondición: la pila no debe estar vacía (underflow).
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía (underflow)");
        }
        int value = data[top];
        top--;
        return value;
    }

    /**
     * Devuelve el elemento superior sin eliminarlo.
     * Precondición: la pila no debe estar vacía.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía (underflow)");
        }
        return data[top];
    }

    /**
     * Devuelve true cuando la pila no contiene elementos.
     * Invariante: isEmpty() == (top == -1).
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Devuelve true cuando la pila ha alcanzado su capacidad fija.
     * Invariante: isFull() == (top == data.length - 1).
     */
    public boolean isFull() {
        return top == data.length - 1;
    }

    /**
     * Devuelve la cantidad de elementos almacenados actualmente.
     * Invariante: size() == top + 1.
     */
    public int size() {
        return top + 1;
    }
}
