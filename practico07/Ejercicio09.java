/*
Prompt inicial utilizado:
Demostrar el problema de desperdicio de espacio en una cola simple (no circular).
Mostrar el arreglo interno después de varias operaciones de encolado y desencolado,
señalando cómo las posiciones libres al frente no pueden reutilizarse.

Ajustes realizados:
Ninguno
*/

public class Ejercicio09 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 9: Desperdicio de Espacio en Cola Simple ===\n");

        ColaSimpleDemo queue = new ColaSimpleDemo(6);

        System.out.println("Paso 1: Encolar A, B, C, D");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.printArray();

        System.out.println("\nPaso 2: Desencolar dos veces (elimina A y B)");
        queue.dequeue();
        queue.dequeue();
        queue.printArray();
        System.out.println("NOTA: Las posiciones 0 y 1 ahora están libres pero NO pueden reutilizarse");
        System.out.println("      porque rear ya está en el índice 4.");

        System.out.println("\nPaso 3: Encolar E, F");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.printArray();

        System.out.println("\nPaso 4: Intentar encolar G (debería fallar aunque las posiciones 0-1 estén libres)");
        try {
            queue.enqueue("G");
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\n--- Resumen del problema ---");
        System.out.println("En una cola simple basada en arreglos, front y rear solo avanzan.");
        System.out.println("Una vez que rear alcanza el final del arreglo, no se pueden encolar");
        System.out.println("más elementos aunque haya espacios libres al principio.");
        System.out.println("Esto se llama 'falso overflow': la cola reporta estar llena");
        System.out.println("aunque existe espacio sin usar. La solución es una cola CIRCULAR");
        System.out.println("(ver Ejercicio10) que hace girar los índices usando el módulo (%).");
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
                "La cola está llena (falso overflow) — rear=" + rear
                + ", longitud del arreglo=" + data.length
                + ", pero front=" + front + " (espacio desperdiciado al inicio)");
        }
        data[rear] = value;
        rear++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        String value = data[front];
        data[front] = null; // limpiar la referencia para la visualización
        front++;
        return value;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Imprime el arreglo interno mostrando qué posiciones están ocupadas, libres o desperdiciadas.
     */
    public void printArray() {
        System.out.print("Arreglo:  [");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] == null ? "_" : data[i]);
            if (i < data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("          front=" + front + ", rear=" + rear
                + ", elementos activos=" + (rear - front));
    }
}
