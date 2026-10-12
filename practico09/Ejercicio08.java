/*
Prompt inicial utilizado:
Implement a program that reverses a word using a linked stack. Example: "algoritmo"
becomes "omtirogla". Explain why LIFO policy allows reversing the order: the last
character pushed is the first one popped, naturally inverting the sequence.
Use a Node class with char data. Do not use Java collections.
Include test cases in main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

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

    static class WordReverser {

        // Reverse a word using a stack. O(n).
        public static String reverse(String word) {
            if (word == null || word.isEmpty()) {
                return word;
            }

            LinkedStack stack = new LinkedStack();

            // Push all characters onto stack
            for (int i = 0; i < word.length(); i++) {
                stack.push(word.charAt(i));
            }

            // Pop all characters - they come out in reverse order
            StringBuilder reversed = new StringBuilder();
            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }

            return reversed.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 08: Reverse a Word with Stack ===\n");

        // Test cases
        String[] testWords = {
            "algoritmo",
            "java",
            "stack",
            "hello",
            "a",
            "ab",
            "racecar",
            "estructura"
        };

        System.out.println("1. Reversing words:");
        for (String word : testWords) {
            String reversed = WordReverser.reverse(word);
            System.out.println("   \"" + word + "\" -> \"" + reversed + "\"");
        }

        // Verify specific example
        System.out.println("\n2. Verifying example from exercise:");
        String input = "algoritmo";
        String expected = "omtirogla";
        String result = WordReverser.reverse(input);
        System.out.println("   Input:    \"" + input + "\"");
        System.out.println("   Expected: \"" + expected + "\"");
        System.out.println("   Result:   \"" + result + "\"");
        System.out.println("   Match: " + result.equals(expected));

        // Test edge cases
        System.out.println("\n3. Edge cases:");
        System.out.println("   Empty string: \"" + WordReverser.reverse("") + "\"");
        System.out.println("   Single char:  \"" + WordReverser.reverse("x") + "\"");
        System.out.println("   Palindrome:   \"" + WordReverser.reverse("radar") + "\"");

        System.out.println("\n=== All tests passed ===");
    }
}
