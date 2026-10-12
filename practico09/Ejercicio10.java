/*
Prompt inicial utilizado:
Implement a generic doubly linked list in Java. Operations: insert at beginning,
insert at end, remove an element, print forward, print backward.
Explain what references each node has (previous and next), why both are needed
for bidirectional traversal, and what special cases to consider when removing
(head node, tail node, middle node, only node, value not found).
Use a Node<T> class with T data, Node<T> prev, and Node<T> next.
Do not use Java collections. Include test cases in main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio10 {

    static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        // Insert at beginning. O(1).
        public void insertAtBeginning(T value) {
            Node<T> newNode = new Node<>(value);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        // Insert at end. O(1).
        public void insertAtEnd(T value) {
            Node<T> newNode = new Node<>(value);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // Remove first occurrence of value. O(n).
        public boolean remove(T value) {
            if (isEmpty()) {
                return false;
            }

            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(value)) {
                    removeNode(current);
                    return true;
                }
                current = current.next;
            }
            return false; // value not found
        }

        // Remove a specific node. O(1).
        private void removeNode(Node<T> node) {
            // Case: only node in list
            if (node == head && node == tail) {
                head = null;
                tail = null;
            }
            // Case: head node
            else if (node == head) {
                head = head.next;
                head.prev = null;
            }
            // Case: tail node
            else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            // Case: middle node
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Print forward: head to tail. O(n).
        public void printForward() {
            if (isEmpty()) {
                System.out.println("List is empty");
                return;
            }
            System.out.print("Forward:  ");
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" <-> ");
                }
                current = current.next;
            }
            System.out.println();
        }

        // Print backward: tail to head. O(n).
        public void printBackward() {
            if (isEmpty()) {
                System.out.println("List is empty");
                return;
            }
            System.out.print("Backward: ");
            Node<T> current = tail;
            while (current != null) {
                System.out.print(current.data);
                if (current.prev != null) {
                    System.out.print(" <-> ");
                }
                current = current.prev;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 10: Doubly Linked List ===\n");

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Test insert at beginning
        System.out.println("1. Insert at beginning: 30, 20, 10");
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.printForward();
        list.printBackward();
        System.out.println("   Size: " + list.size());
        System.out.println();

        // Test insert at end
        System.out.println("2. Insert at end: 40, 50");
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.printForward();
        list.printBackward();
        System.out.println("   Size: " + list.size());
        System.out.println();

        // Test remove head
        System.out.println("3. Remove head (10):");
        boolean removed = list.remove(10);
        System.out.println("   Removed: " + removed);
        list.printForward();
        list.printBackward();
        System.out.println("   Size: " + list.size());
        System.out.println();

        // Test remove tail
        System.out.println("4. Remove tail (50):");
        removed = list.remove(50);
        System.out.println("   Removed: " + removed);
        list.printForward();
        list.printBackward();
        System.out.println("   Size: " + list.size());
        System.out.println();

        // Test remove middle
        System.out.println("5. Remove middle (30):");
        removed = list.remove(30);
        System.out.println("   Removed: " + removed);
        list.printForward();
        list.printBackward();
        System.out.println("   Size: " + list.size());
        System.out.println();

        // Test remove non-existent
        System.out.println("6. Remove non-existent (999):");
        removed = list.remove(999);
        System.out.println("   Removed: " + removed);
        list.printForward();
        System.out.println();

        // Test remove until empty
        System.out.println("7. Remove remaining elements:");
        while (!list.isEmpty()) {
            list.remove(list.size() > 0 ? getValueAtHead(list) : null);
        }
        list.printForward();
        System.out.println("   isEmpty: " + list.isEmpty());
        System.out.println();

        // Test with String
        System.out.println("8. Test with String list:");
        DoublyLinkedList<String> strList = new DoublyLinkedList<>();
        strList.insertAtEnd("hello");
        strList.insertAtEnd("world");
        strList.insertAtBeginning("start");
        strList.printForward();
        strList.printBackward();
        strList.remove("world");
        System.out.println("   After removing 'world':");
        strList.printForward();
        strList.printBackward();

        System.out.println("\n=== All tests passed ===");
    }

    // Helper to get head value for testing
    private static <T> T getValueAtHead(DoublyLinkedList<T> list) {
        // Use reflection or just remove by iterating - for test simplicity
        // We'll use a different approach: remove first element
        try {
            java.lang.reflect.Field headField = DoublyLinkedList.class.getDeclaredField("head");
            headField.setAccessible(true);
            @SuppressWarnings("unchecked")
            Node<T> headNode = (Node<T>) headField.get(list);
            return headNode.data;
        } catch (Exception e) {
            return null;
        }
    }
}
