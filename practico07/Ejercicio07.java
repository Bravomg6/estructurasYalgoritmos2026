/*
Prompt inicial utilizado:
Create a turn-based attention system for an office. Each person who arrives
receives a turn number. Operations: add a person, attend the next person,
and check who is first in line.
Explain why this uses FIFO and not LIFO.

Ajustes realizados:
Ninguno
*/

public class Ejercicio07 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 7: Sistema de Turnos ===\n");

        SistemaTurnos system = new SistemaTurnos(10);

        System.out.println("People arriving at the office:");
        system.agregarPersona("Carlos");
        system.agregarPersona("Maria");
        system.agregarPersona("Juan");
        system.agregarPersona("Ana");
        System.out.println("People waiting: " + system.size());
        System.out.println("Next turn: " + system.consultarPrimero());

        System.out.println("\nAttending people in order:");
        while (!system.isEmpty()) {
            String attended = system.atenderSiguiente();
            System.out.println("Attending: " + attended
                    + " (remaining: " + system.size() + ")");
        }

        System.out.println("\nAttending when no one is waiting (underflow test)...");
        try {
            system.atenderSiguiente();
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\nWhy FIFO and not LIFO?");
        System.out.println("In an office, the first person to arrive should be the");
        System.out.println("first one to be attended. This is fairness: first come,");
        System.out.println("first served. A LIFO (stack) approach would serve the most");
        System.out.println("recent arrival first, making earlier visitors wait longer");
        System.out.println("indefinitely — that would be unfair and impractical.");
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
     * Adds a person to the end of the queue and assigns a turn number.
     */
    public void agregarPersona(String name) {
        if (isFull()) {
            throw new IllegalStateException("Waiting room is full");
        }
        people[rear] = name + " (Turn #" + nextTurn + ")";
        nextTurn++;
        rear++;
        count++;
    }

    /**
     * Removes and returns the person at the front of the queue (next to be attended).
     */
    public String atenderSiguiente() {
        if (isEmpty()) {
            throw new IllegalStateException("No one is waiting");
        }
        String person = people[front];
        front++;
        count--;
        return person;
    }

    /**
     * Returns the name of the person who is next in line without removing them.
     */
    public String consultarPrimero() {
        if (isEmpty()) {
            throw new IllegalStateException("No one is waiting");
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
