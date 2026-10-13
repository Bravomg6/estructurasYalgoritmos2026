/*
Prompt inicial utilizado:
Simular una torre de platos donde cada plato tiene un número o un nombre.
Operaciones: agregar un plato (push), retirar el plato superior (pop)
y consultar qué plato está en la parte superior (peek).
Explicar por qué se resuelve con una pila (LIFO) y no con una cola (FIFO).

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 2: Torre de Platos ===\n");

        TorreDePlatos tower = new TorreDePlatos(10);

        System.out.println("Agregando platos a la torre:");
        tower.agregarPlato("Plate-A");
        tower.agregarPlato("Plate-B");
        tower.agregarPlato("Plate-C");
        tower.agregarPlato("Plate-D");
        System.out.println("Tamaño de la torre: " + tower.size());
        System.out.println("Plato superior: " + tower.consultarSuperior());

        System.out.println("\nRetirando el plato superior:");
        String removed = tower.retirarSuperior();
        System.out.println("Retirado: " + removed);
        System.out.println("Nuevo plato superior: " + tower.consultarSuperior());

        System.out.println("\nRetirando los platos restantes (orden LIFO):");
        while (!tower.isEmpty()) {
            System.out.println("Retirado: " + tower.retirarSuperior());
        }
        System.out.println("La torre está vacía: " + tower.isEmpty());

        System.out.println("\n¿Por qué LIFO y no FIFO?");
        System.out.println("En una torre de platos real, siempre se agregan y retiran platos");
        System.out.println("desde la parte superior. El primer plato colocado (Plate-A) queda");
        System.out.println("en la base y solo se puede alcanzar después de retirar todos los demás.");
        System.out.println("Una cola retiraría primero el plato más antiguo, lo cual no");
        System.out.println("coincide con la realidad física.");
    }
}

class TorreDePlatos {

    private String[] plates;
    private int top;

    public TorreDePlatos(int capacity) {
        this.plates = new String[capacity];
        this.top = -1;
    }

    /** Agrega un plato en la parte superior de la torre. */
    public void agregarPlato(String plate) {
        if (isFull()) {
            throw new IllegalStateException("La torre está llena");
        }
        plates[++top] = plate;
    }

    /** Retira y devuelve el plato de la parte superior de la torre. */
    public String retirarSuperior() {
        if (isEmpty()) {
            throw new IllegalStateException("La torre está vacía");
        }
        return plates[top--];
    }

    /** Devuelve el plato que está actualmente en la parte superior sin eliminarlo. */
    public String consultarSuperior() {
        if (isEmpty()) {
            throw new IllegalStateException("La torre está vacía");
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
