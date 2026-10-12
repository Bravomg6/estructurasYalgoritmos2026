/*
Prompt inicial utilizado:
Implement a queue of integers using a singly linked list. The queue must support:
enqueue (encolar), dequeue (desencolar), front (consultar frente), isEmpty,
contains (buscar si contiene un valor), and print (imprimir contenido).
Explain why a queue needs both head and tail references for O(1) enqueue and dequeue.
Use a Node class with int data and Node next. Do not use Java collections.
Include test cases in main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedQueue {
        private Node head; // front of the queue (dequeue from here)
        private Node tail; // rear of the queue (enqueue here)
        private int size;

        public LinkedQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        // Enqueue: insert at tail. O(1) with tail reference.
        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        // Dequeue: remove from head. O(1).
        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue underflow: cannot dequeue from empty queue");
            }
            int value = head.data;
            head = head.next;
            if (head == null) {
                tail = null; // queue is now empty
            }
            size--;
            return value;
        }

        // Front: return front element without removing. O(1).
        public int front() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty: no front element");
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int size() {
            return size;
        }

        // Search: traverse the list. O(n).
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

        // Print: traverse from front to rear. O(n).
        public void print() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue (front -> rear): ");
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
        System.out.println("=== Ejercicio 02: Linked Queue of Integers ===\n");

        LinkedQueue queue = new LinkedQueue();

        // Test isEmpty on new queue
        System.out.println("1. New queue isEmpty: " + queue.isEmpty());

        // Test enqueue
        System.out.println("\n2. Enqueuing: 100, 200, 300, 400");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.print();
        System.out.println("   Size: " + queue.size());

        // Test front
        System.out.println("\n3. Front: " + queue.front());

        // Test contains
        System.out.println("\n4. Contains 200: " + queue.contains(200));
        System.out.println("   Contains 999: " + queue.contains(999));

        // Test dequeue
        System.out.println("\n5. Dequeuing two elements:");
        System.out.println("   Dequeued: " + queue.dequeue());
        System.out.println("   Dequeued: " + queue.dequeue());
        queue.print();
        System.out.println("   New front: " + queue.front());
        System.out.println("   Size: " + queue.size());

        // Test FIFO order
        System.out.println("\n6. Enqueuing 500, then dequeuing all:");
        queue.enqueue(500);
        queue.print();
        while (!queue.isEmpty()) {
            System.out.println("   Dequeued: " + queue.dequeue());
        }
        System.out.println("   isEmpty after draining: " + queue.isEmpty());

        // Test underflow
        System.out.println("\n7. Testing underflow:");
        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            System.out.println("   Caught expected error: " + e.getMessage());
        }

        System.out.println("\n=== All tests passed ===");
    }
}
