/*
Prompt inicial utilizado:
Crear un sistema de atención por turnos para una oficina. Cada persona que llega
recibe un número de turno. Operaciones: agregar una persona, atender a la siguiente persona
y consultar quién está primero en la fila.
Explicar por qué se usa FIFO y no LIFO.

Ajustes realizados:
Ninguno
*/

public class Ejercicio07 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 7: Sistema de Turnos ===\n");

        SistemaTurnos system = new SistemaTurnos(10);

        System.out.println("Personas que llegan a la oficina:");
        system.agregarPersona("Carlos");
        system.agregarPersona("Maria");
        system.agregarPersona("Juan");
        system.agregarPersona("Ana");
        System.out.println("Personas en espera: " + system.size());
        System.out.println("Siguiente turno: " + system.consultarPrimero());

        System.out.println("\nAtendiendo a las personas en orden:");
        while (!system.isEmpty()) {
            String attended = system.atenderSiguiente();
            System.out.println("Atendiendo: " + attended
                    + " (restantes: " + system.size() + ")");
        }

        System.out.println("\nAtendiendo cuando no hay nadie en espera (prueba de underflow)...");
        try {
            system.atenderSiguiente();
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\n¿Por qué FIFO y no LIFO?");
        System.out.println("En una oficina, la primera persona en llegar debería ser");
        System.out.println("la primera en ser atendida. Esto es equidad: primero en llegar,");
        System.out.println("primero en ser atendido. Un enfoque LIFO (pila) atendería primero");
        System.out.println("a la llegada más reciente, haciendo que los visitantes anteriores");
        System.out.println("esperen más tiempo de forma indefinida: eso sería injusto e impráctico.");
    }
}

class SistemaTurnos {

    private String[] people;
    private int front;
    private int rear;
    private int count;
    private int nextTurn;

    public SistemaTurnos(int capacity) {
        this.people = new String[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.nextTurn = 1;
    }

    /**
     * Agrega una persona al final de la cola y le asigna un número de turno.
     */
    public void agregarPersona(String name) {
        if (isFull()) {
            throw new IllegalStateException("La sala de espera está llena");
        }
        people[rear] = name + " (Turno #" + nextTurn + ")";
        nextTurn++;
        rear++;
        count++;
    }

    /**
     * Elimina y devuelve a la persona al frente de la cola (la próxima en ser atendida).
     */
    public String atenderSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("No hay nadie en espera");
        }
        String person = people[front];
        front++;
        count--;
        return person;
    }

    /**
     * Devuelve el nombre de la persona que sigue en la fila sin eliminarla.
     */
    public String consultarPrimero() {
        if (isEmpty()) {
            throw new IllegalStateException("No hay nadie en espera");
        }
        return people[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == people.length;
    }

    public int size() {
        return count;
    }
}
