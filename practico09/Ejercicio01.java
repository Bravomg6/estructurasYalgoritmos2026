/*
Prompt inicial utilizado:
Implement a stack of integers using a singly linked list. The stack must support:
push (apilar), pop (desapilar), peek (consultar tope), isEmpty (verificar si esta vacia),
contains (buscar si contiene un valor), and print (imprimir contenido).
Explain why the head of the linked list represents the top of the stack and why
push and pop operations are O(1). Use a Node class with int data and Node next.
Do not use Java collections for the main structure. Include test cases in main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedStack {
        private Node head; // head represents the top of the stack
        private int size;

        public LinkedStack() {
            this.head = null;
            this.size = 0;
        }

        // Push: insert at the beginning. O(1) because we only update head reference.
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            size++;
        }

        // Pop: remove from the beginning. O(1) because we only update head reference.
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is underflow: cannot pop from empty stack");
            }
            int value = head.data;
            head = head.next;
            size--;
            return value;
        }

        // Peek: return top element without removing. O(1).
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty: no top element");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Search: traverse the list to find a value. O(n).
        public boolean contains(int value) {
            Node current = head;
            while (current != null) {
                if (current.data == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Print: traverse from top to bottom. O(n).
        public void print() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.print("Stack (top -> bottom): ");
            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 01: Linked Stack of Integers ===\n");

        LinkedStack stack = new LinkedStack();

        // Test isEmpty on new stack
        System.out.println("1. New stack isEmpty: " + stack.isEmpty());

        // Test push
        System.out.println("\n2. Pushing: 10, 20, 30, 40, 50");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.print();
        System.out.println("   Size: " + stack.size());

        // Test peek
        System.out.println("\n3. Peek (top): " + stack.peek());

        // Test contains
        System.out.println("\n4. Contains 30: " + stack.contains(30));
        System.out.println("   Contains 99: " + stack.contains(99));

        // Test pop
        System.out.println("\n5. Popping two elements:");
        System.out.println("   Popped: " + stack.pop());
        System.out.println("   Popped: " + stack.pop());
        stack.print();
        System.out.println("   New top: " + stack.peek());
        System.out.println("   Size: " + stack.size());

        // Test pop until empty
        System.out.println("\n6. Popping remaining elements:");
        while (!stack.isEmpty()) {
            System.out.println("   Popped: " + stack.pop());
        }
        System.out.println("   isEmpty after draining: " + stack.isEmpty());

        // Test underflow
        System.out.println("\n7. Testing underflow:");
        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println("   Caught expected error: " + e.getMessage());
        }

        System.out.println("\n=== All tests passed ===");
    }
}
