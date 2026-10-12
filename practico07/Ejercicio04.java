/*
Prompt inicial utilizado:
Create a simple navigation history simulator. Every time the user visits a page,
the URL is pushed onto a stack. Allow going back to the previous page using pop.
Explain why navigation history works under the LIFO principle.

Ajustes realizados:
Ninguno
*/

public class Ejercicio04 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 4: Historial de Navegacion ===\n");

        HistorialNavegacion history = new HistorialNavegacion(20);

        System.out.println("User visits pages:");
        history.visitar("https://www.google.com");
        history.visitar("https://www.github.com");
        history.visitar("https://www.stackoverflow.com");
        history.visitar("https://docs.oracle.com");
        System.out.println("Current page: " + history.paginaActual());
        System.out.println("History depth: " + history.size());

        System.out.println("\nUser presses 'Back' button:");
        String previous = history.volver();
        System.out.println("Returned to: " + previous);
        System.out.println("Current page: " + history.paginaActual());

        System.out.println("\nUser presses 'Back' two more times:");
        history.volver();
        history.volver();
        System.out.println("Current page: " + history.paginaActual());
        System.out.println("History depth: " + history.size());

        System.out.println("\nUser visits a new page (clears forward history implicitly):");
        history.visitar("https://www.wikipedia.org");
        System.out.println("Current page: " + history.paginaActual());

        System.out.println("\nWhy LIFO?");
        System.out.println("When you press 'Back', you return to the LAST page you visited.");
        System.out.println("The most recent visit is the first one to be undone — that is");
        System.out.println("exactly the LIFO behavior of a stack. The current page is always");
        System.out.println("at the top, and 'back' pops it to reveal the previous one.");
    }
}

class HistorialNavegacion {

    private String[] urls;
    private int top;

    public HistorialNavegacion(int capacity) {
        this.urls = new String[capacity];
        this.top = -1;
    }

    /** Simulates visiting a new page: pushes the URL onto the history stack. */
    public void visitar(String url) {
        if (isFull()) {
            throw new IllegalStateException("History capacity exceeded");
        }
        urls[++top] = url;
    }

    /**
     * Simulates pressing the 'Back' button: pops the current page
     * and returns the URL of the page the user goes back to.
     */
    public String volver() {
        if (size() <= 1) {
            throw new IllegalStateException("No previous page in history");
        }
        pop(); // remove current page
        return peek(); // return the page we landed on
    }

    /** Returns the URL of the current page without navigating. */
    public String paginaActual() {
        if (isEmpty()) {
            throw new IllegalStateException("No page loaded");
        }
        return urls[top];
    }

    private void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("History is empty");
        }
        top--;
    }

    private String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("History is empty");
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
