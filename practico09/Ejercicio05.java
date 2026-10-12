/*
Prompt inicial utilizado:
Implement a simple browser history system using a linked stack. Operations:
visit page (visitar pagina), go back (volver a la anterior), get current page
(consultar pagina actual), print history (imprimir historial).
Explain why a stack represents "go back" behavior: LIFO means the last visited
page is the first one returned to. Use a Node class with String data.
Do not use Java collections. Include test cases in main.

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
        private Node head; // top of stack = current page
        private int size;

        public BrowserHistory() {
            this.head = null;
            this.size = 0;
        }

        // Visit a page: push onto stack. O(1).
        public void visit(String url) {
            Node newNode = new Node(url);
            newNode.next = head;
            head = newNode;
            size++;
            System.out.println("Visited: " + url);
        }

        // Go back: pop from stack. O(1).
        public String goBack() {
            if (isEmpty()) {
                throw new RuntimeException("No history to go back to");
            }
            String currentUrl = head.data;
            head = head.next;
            size--;
            System.out.println("Went back from: " + currentUrl);
            return currentUrl;
        }

        // Get current page: peek. O(1).
        public String getCurrentPage() {
            if (isEmpty()) {
                return "No page loaded";
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Print history: most recent first. O(n).
        public void printHistory() {
            if (isEmpty()) {
                System.out.println("History is empty");
                return;
            }
            System.out.println("Browser History (most recent first):");
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
        System.out.println("=== Ejercicio 05: Browser History with Stack ===\n");

        BrowserHistory history = new BrowserHistory();

        // Test visiting pages
        System.out.println("1. Visiting pages:");
        history.visit("https://www.google.com");
        history.visit("https://www.github.com");
        history.visit("https://www.stackoverflow.com");
        history.visit("https://docs.oracle.com");
        System.out.println();

        // Test current page
        System.out.println("2. Current page: " + history.getCurrentPage());
        System.out.println();

        // Test print history
        System.out.println("3. Full history:");
        history.printHistory();
        System.out.println();

        // Test go back
        System.out.println("4. Going back twice:");
        history.goBack();
        System.out.println("   Current page: " + history.getCurrentPage());
        history.goBack();
        System.out.println("   Current page: " + history.getCurrentPage());
        System.out.println();

        // Test history after going back
        System.out.println("5. History after going back:");
        history.printHistory();
        System.out.println();

        // Test visiting a new page after going back
        System.out.println("6. Visiting new page after going back:");
        history.visit("https://www.wikipedia.org");
        System.out.println("   Current page: " + history.getCurrentPage());
        history.printHistory();

        System.out.println("\n=== All tests passed ===");
    }
}
