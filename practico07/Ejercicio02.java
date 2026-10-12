/*
Prompt inicial utilizado:
Simulate a tower of plates where each plate has a number or name.
Operations: add a plate (push), remove the top plate (pop),
and check which plate is on top (peek).
Explain why this is solved with a stack (LIFO) and not a queue (FIFO).

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 2: Torre de Platos ===\n");

        TorreDePlatos tower = new TorreDePlatos(10);

        System.out.println("Adding plates to the tower:");
        tower.agregarPlato("Plate-A");
        tower.agregarPlato("Plate-B");
        tower.agregarPlato("Plate-C");
        tower.agregarPlato("Plate-D");
        System.out.println("Tower size: " + tower.size());
        System.out.println("Plate on top: " + tower.consultarSuperior());

        System.out.println("\nRemoving the top plate:");
        String removed = tower.retirarSuperior();
        System.out.println("Removed: " + removed);
        System.out.println("New plate on top: " + tower.consultarSuperior());

        System.out.println("\nRemoving remaining plates (LIFO order):");
        while (!tower.isEmpty()) {
            System.out.println("Removed: " + tower.retirarSuperior());
        }
        System.out.println("Tower is empty: " + tower.isEmpty());

        System.out.println("\nWhy LIFO and not FIFO?");
        System.out.println("In a real plate tower, you always add and remove plates");
        System.out.println("from the top. The first plate placed (Plate-A) is at the");
        System.out.println("bottom and can only be reached after removing all others.");
        System.out.println("A queue would remove the oldest plate first, which does not");
        System.out.println("match physical reality.");
    }
}

class TorreDePlatos {

    private String[] plates;
    private int top;

    public TorreDePlatos(int capacity) {
        this.plates = new String[capacity];
        this.top = -1;
    }

    /** Adds a plate on top of the tower. */
    public void agregarPlato(String plate) {
        if (isFull()) {
            throw new IllegalStateException("Tower is full");
        }
        plates[++top] = plate;
    }

    /** Removes and returns the plate from the top of the tower. */
    public String retirarSuperior() {
        if (isEmpty()) {
            throw new IllegalStateException("Tower is empty");
        }
        return plates[top--];
    }

    /** Returns the plate currently on top without removing it. */
    public String consultarSuperior() {
        if (isEmpty()) {
            throw new IllegalStateException("Tower is empty");
        }
        return plates[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == plates.length - 1;
    }

    public int size() {
        return top + 1;
    }
}
