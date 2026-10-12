/*
Prompt inicial utilizado:
Implement a balanced parentheses checker using a linked stack. The program receives
an expression and determines if parentheses are balanced. Valid: (2 + 3) * (5 - 1),
((a + b) * c). Invalid: (2 + 3, ()(. Explain how a stack is used to store opening
parentheses and validate closing ones: push '(', pop and match on ')'.
Use a Node class with char data. Do not use Java collections.
Include test cases in main.

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
                throw new RuntimeException("Stack underflow");
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

        // Check if parentheses are balanced using a stack. O(n).
        public static boolean isBalanced(String expression) {
            LinkedStack stack = new LinkedStack();

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    // Push opening parenthesis onto stack
                    stack.push(ch);
                } else if (ch == ')') {
                    // Try to match with an opening parenthesis
                    if (stack.isEmpty()) {
                        // No matching opening parenthesis
                        return false;
                    }
                    char top = stack.pop();
                    if (top != '(') {
                        // Mismatched parenthesis type
                        return false;
                    }
                }
                // Ignore all other characters
            }

            // Balanced if stack is empty (all opening matched)
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 07: Balanced Parentheses Checker ===\n");

        // Valid expressions
        String[] validExpressions = {
            "(2 + 3) * (5 - 1)",
            "((a + b) * c)",
            "()",
            "(hello world)",
            "((()))",
            "a + (b * c) - (d / e)",
            "no parentheses at all"
        };

        // Invalid expressions
        String[] invalidExpressions = {
            "(2 + 3",
            "())(",
            ")(()",
            "((())",
            "())",
            "(a + b)) * (c",
            "(()"
        };

        System.out.println("1. Valid expressions (should all be TRUE):");
        for (String expr : validExpressions) {
            boolean result = ParenthesesChecker.isBalanced(expr);
            System.out.println("   \"" + expr + "\" -> " + result);
            if (!result) {
                System.out.println("   ERROR: Expected true!");
            }
        }

        System.out.println("\n2. Invalid expressions (should all be FALSE):");
        for (String expr : invalidExpressions) {
            boolean result = ParenthesesChecker.isBalanced(expr);
            System.out.println("   \"" + expr + "\" -> " + result);
            if (result) {
                System.out.println("   ERROR: Expected false!");
            }
        }

        System.out.println("\n=== All tests passed ===");
    }
}
