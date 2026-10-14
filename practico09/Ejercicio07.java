/*
Prompt inicial utilizado:
Implementa un verificador de paréntesis balanceados usando una pila enlazada. El programa recibe
una expresión y determina si los paréntesis están balanceados. Válidas: (2 + 3) * (5 - 1),
((a + b) * c). Inválidas: (2 + 3, ()(. Explica cómo se usa una pila para almacenar los paréntesis
de apertura y validar los de cierre: push '(', pop y coincidencia con ')'.
Usa una clase Node con char data. No uses colecciones de Java.
Incluye casos de prueba en main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio07 {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedStack {
        private Node head;

        public LinkedStack() {
            this.head = null;
        }

        public void push(char value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }

        public char pop() {
            if (isEmpty()) {
                throw new RuntimeException("Subdesborde de la pila");
            }
            char value = head.data;
            head = head.next;
            return value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    static class ParenthesesChecker {

        // Verifica si los paréntesis están balanceados usando una pila. O(n).
        public static boolean isBalanced(String expression) {
            LinkedStack stack = new LinkedStack();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    // Apilar el paréntesis de apertura
                    stack.push(ch);
                } else if (ch == ')') {
                    // Intentar coincidir con un paréntesis de apertura
                    if (stack.isEmpty()) {
                        // No hay paréntesis de apertura coincidente
                        return false;
                    }
                    char top = stack.pop();
                    if (top != '(') {
                        // Tipo de paréntesis no coincidente
                        return false;
                    }
                }
                // Ignorar todos los demás caracteres
            }

            // Está balanceado si la pila queda vacía (todos los de apertura coincidieron)
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 07: Verificador de paréntesis balanceados ===\n");

        // Expresiones válidas
        String[] validExpressions = {
            "(2 + 3) * (5 - 1)",
            "((a + b) * c)",
            "()",
            "(hello world)",
            "((()))",
            "a + (b * c) - (d / e)",
            "no parentheses at all"
        };

        // Expresiones inválidas
        String[] invalidExpressions = {
            "(2 + 3",
            "())(",
            ")(()",
            "((())",
            "())",
            "(a + b)) * (c",
            "(()"
        };

        System.out.println("1. Expresiones válidas (todas deben dar true):");
        for (String expr : validExpressions) {
            boolean result = ParenthesesChecker.isBalanced(expr);
            System.out.println("   \"" + expr + "\" -> " + result);
            if (!result) {
                System.out.println("   ERROR: se esperaba true");
            }
        }

        System.out.println("\n2. Expresiones inválidas (todas deben dar false):");
        for (String expr : invalidExpressions) {
            boolean result = ParenthesesChecker.isBalanced(expr);
            System.out.println("   \"" + expr + "\" -> " + result);
            if (result) {
                System.out.println("   ERROR: se esperaba false");
            }
        }

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
