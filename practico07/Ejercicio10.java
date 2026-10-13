/*
Prompt inicial utilizado:
Implementar una cola circular usando un arreglo. Debe reutilizar las posiciones libres
al inicio del arreglo. Explicar cómo se usa el operador módulo (%)
para avanzar los índices front y rear, y cómo detectar si la cola está
llena o vacía.

Ajustes realizados:
Ninguno
*/

public class Ejercicio10 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 10: Cola Circular ===\n");

        ColaCircular queue = new ColaCircular(5);

        System.out.println("Paso 1: Encolar 10, 20, 30, 40, 50");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printArray();

        System.out.println("\nPaso 2: Desencolar dos veces (elimina 10, 20)");
        queue.dequeue();
        queue.dequeue();
        queue.printArray();

        System.out.println("\nPaso 3: Encolar 60, 70 (da la vuelta hasta los índices 0 y 1)");
        queue.enqueue(60);
        queue.enqueue(70);
        queue.printArray();
        System.out.println("NOTA: rear pasó del índice 4 al índice 0 usando el módulo.");

        System.out.println("\nPaso 4: Intentar encolar 80 (la cola está llena)");
        try {
            queue.enqueue(80);
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\nPaso 5: Desencolar todos los elementos");
        while (!queue.isEmpty()) {
            System.out.println("Desencolado: " + queue.dequeue());
        }
        queue.printArray();

        System.out.println("\n--- Cómo funciona la cola circular ---");
        System.out.println("1. Módulo para dar la vuelta: rear = (rear + 1) % capacity");
        System.out.println("   Cuando rear alcanza el último índice, vuelve a 0.");
        System.out.println("2. Detección de vacía: front == rear (y count == 0).");
        System.out.println("3. Detección de llena: (rear + 1) % capacity == front");
        System.out.println("   Se sacrifica una posición para distinguir llena de vacía.");
        System.out.println("4. Esto elimina el problema del falso overflow de las colas simples.");
    }
}

class ColaCircular {

    private int[] data;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    /**
     * Constructor: crea una cola circular con la capacidad indicada.
     *
     * Se usa una variable count para distinguir de forma confiable entre
     * los estados vacía (count == 0) y llena (count == capacity).
     */
    public ColaCircular(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser positiva");
        }
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1; // rear inicia antes de front; el primer enqueue lo mueve a 0
        this.count = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     * Usa el módulo para que rear vuelva a 0 cuando alcanza el final.
     */
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("La cola está llena (overflow)");
        }
        rear = (rear + 1) % capacity; // avance circular
        data[rear] = value;
        count++;
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     * Usa el módulo para que front vuelva a 0 cuando alcanza el final.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía (underflow)");
        }
        int value = data[front];
        front = (front + 1) % capacity; // avance circular
        count--;
        return value;
    }

    /**
     * Devuelve el elemento al frente sin eliminarlo.
     */
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return data[front];
    }

    /**
     * Devuelve true cuando la cola no contiene elementos.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Devuelve true cuando la cola ha alcanzado su capacidad.
     */
    public boolean isFull() {
        return count == capacity;
    }

    /**
     * Devuelve la cantidad de elementos actualmente en la cola.
     */
    public int size() {
        return count;
    }

    /**
     * Imprime el arreglo interno con los punteros front/rear para su visualización.
     */
    public void printArray() {
        System.out.print("Arreglo:  [");
        for (int i = 0; i < data.length; i++) {
            boolean isUsed = false;
            if (!isEmpty()) {
                // Verificar si el índice i está dentro del rango activo
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
