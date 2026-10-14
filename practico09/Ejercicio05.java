/*
Prompt inicial utilizado:
Implementa un sistema simple de historial de navegación usando una pila enlazada. Operaciones:
visitar página (visit page), volver a la anterior (go back), consultar página actual
(get current page), imprimir historial (print history).
Explica por qué una pila representa el comportamiento de "volver atrás": LIFO significa que la
última página visitada es la primera a la que se regresa. Usa una clase Node con String data.
No uses colecciones de Java. Incluye casos de prueba en main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio05 {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static class BrowserHistory {
        private Node head; // tope de la pila = página actual
        private int size;

        public BrowserHistory() {
            this.head = null;
            this.size = 0;
        }

        // Visitar una página: apilar. O(1).
        public void visit(String url) {
            Node newNode = new Node(url);
            newNode.next = head;
            head = newNode;
            size++;
            System.out.println("Visitada: " + url);
        }

        // Volver atrás: desapilar. O(1).
        public String goBack() {
            if (isEmpty()) {
                throw new RuntimeException("No hay historial para volver atrás");
            }
            String currentUrl = head.data;
            head = head.next;
            size--;
            System.out.println("Se volvió atrás desde: " + currentUrl);
            return currentUrl;
        }

        // Obtener la página actual: peek. O(1).
        public String getCurrentPage() {
            if (isEmpty()) {
                return "No hay página cargada";
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Imprimir el historial: primero la página más reciente. O(n).
        public void printHistory() {
            if (isEmpty()) {
                System.out.println("El historial está vacío");
                return;
            }
            System.out.println("Historial del navegador (lo más reciente primero):");
            Node current = head;
            int index = 1;
            while (current != null) {
                System.out.println("  " + index + ". " + current.data);
                current = current.next;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 05: Historial de navegación con pila ===\n");

        BrowserHistory history = new BrowserHistory();

        // Probar la visita de páginas
        System.out.println("1. Visitando páginas:");
        history.visit("https://www.google.com");
        history.visit("https://www.github.com");
        history.visit("https://www.stackoverflow.com");
        history.visit("https://docs.oracle.com");
        System.out.println();

        // Probar la página actual
        System.out.println("2. Página actual: " + history.getCurrentPage());
        System.out.println();

        // Probar la impresión del historial
        System.out.println("3. Historial completo:");
        history.printHistory();
        System.out.println();

        // Probar volver atrás
        System.out.println("4. Volviendo atrás dos veces:");
        history.goBack();
        System.out.println("   Página actual: " + history.getCurrentPage());
        history.goBack();
        System.out.println("   Página actual: " + history.getCurrentPage());
        System.out.println();

        // Probar el historial después de volver atrás
        System.out.println("5. Historial después de volver atrás:");
        history.printHistory();
        System.out.println();

        // Probar visitar una página nueva después de volver atrás
        System.out.println("6. Visitando una página nueva después de volver atrás:");
        history.visit("https://www.wikipedia.org");
        System.out.println("   Página actual: " + history.getCurrentPage());
        history.printHistory();

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
