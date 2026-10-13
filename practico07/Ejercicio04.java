/*
Prompt inicial utilizado:
Crear un simulador simple de historial de navegación. Cada vez que el usuario visita una página,
la URL se apila en una pila. Permitir volver a la página anterior usando pop.
Explicar por qué el historial de navegación funciona bajo el principio LIFO.

Ajustes realizados:
Ninguno
*/

public class Ejercicio04 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 4: Historial de Navegacion ===\n");

        HistorialNavegacion history = new HistorialNavegacion(20);

        System.out.println("El usuario visita páginas:");
        history.visitar("https://www.google.com");
        history.visitar("https://www.github.com");
        history.visitar("https://www.stackoverflow.com");
        history.visitar("https://docs.oracle.com");
        System.out.println("Página actual: " + history.paginaActual());
        System.out.println("Profundidad del historial: " + history.size());

        System.out.println("\nEl usuario presiona el botón 'Atrás':");
        String previous = history.volver();
        System.out.println("Se volvió a: " + previous);
        System.out.println("Página actual: " + history.paginaActual());

        System.out.println("\nEl usuario presiona 'Atrás' dos veces más:");
        history.volver();
        history.volver();
        System.out.println("Página actual: " + history.paginaActual());
        System.out.println("Profundidad del historial: " + history.size());

        System.out.println("\nEl usuario visita una nueva página (borra implícitamente el historial hacia adelante):");
        history.visitar("https://www.wikipedia.org");
        System.out.println("Página actual: " + history.paginaActual());

        System.out.println("\n¿Por qué LIFO?");
        System.out.println("Al presionar 'Atrás', se vuelve a la ÚLTIMA página visitada.");
        System.out.println("La visita más reciente es la primera en deshacerse: eso es");
        System.out.println("exactamente el comportamiento LIFO de una pila. La página actual");
        System.out.println("siempre está en la parte superior, y 'Atrás' la desapila para mostrar la anterior.");
    }
}

class HistorialNavegacion {

    private String[] urls;
    private int top;

    public HistorialNavegacion(int capacity) {
        this.urls = new String[capacity];
        this.top = -1;
    }

    /** Simula la visita a una nueva página: apila la URL en el historial. */
    public void visitar(String url) {
        if (isFull()) {
            throw new IllegalStateException("Capacidad del historial excedida");
        }
        urls[++top] = url;
    }

    /**
     * Simula la pulsación del botón 'Atrás': desapila la página actual
     * y devuelve la URL de la página a la que se regresa.
     */
    public String volver() {
        if (size() <= 1) {
            throw new IllegalStateException("No hay página anterior en el historial");
        }
        pop(); // eliminar la página actual
        return peek(); // devolver la página en la que se aterriza
    }

    /** Devuelve la URL de la página actual sin navegar. */
    public String paginaActual() {
        if (isEmpty()) {
            throw new IllegalStateException("No hay página cargada");
        }
        return urls[top];
    }

    private void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("El historial está vacío");
        }
        top--;
    }

    private String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("El historial está vacío");
        }
        return urls[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == urls.length - 1;
    }

    public int size() {
        return top + 1;
    }
}
