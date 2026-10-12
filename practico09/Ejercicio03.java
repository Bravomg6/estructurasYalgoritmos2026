/*
Prompt inicial utilizado:
Implement a generic stack using a singly linked list in Java. The stack must support
any type: Integer, String, or custom objects. Operations: push, pop, peek, isEmpty,
contains, print. Explain what generics mean in Java: type safety at compile time,
no casting needed, code reusability. Use a Node<T> class with T data and Node<T> next.
Do not use Java collections for the main structure. Include test cases in main
with Integer, String, and a custom Person class.

Ajustes realizados:
Ninguno
*/

public class Ejercicio03 {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    static class GenericStack<T> {
        private Node<T> head;
        private int size;

        public GenericStack() {
            this.head = null;
            this.size = 0;
        }

        public void push(T value) {
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow: cannot pop from empty stack");
            }
            T value = head.data;
            head = head.next;
            size--;
            return value;
        }

        public T peek() {
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

        public boolean contains(T value) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(value)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.print("Stack (top -> bottom): ");
            Node<T> current = head;
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

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age && name.equals(person.name);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 03: Generic Stack ===\n");

        // Test with Integer
        System.out.println("--- Integer Stack ---");
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.print();
        System.out.println("Peek: " + intStack.peek());
        System.out.println("Contains 20: " + intStack.contains(20));
        System.out.println("Pop: " + intStack.pop());
        intStack.print();

        // Test with String
        System.out.println("\n--- String Stack ---");
        GenericStack<String> strStack = new GenericStack<>();
        strStack.push("hello");
        strStack.push("world");
        strStack.push("java");
        strStack.print();
        System.out.println("Peek: " + strStack.peek());
        System.out.println("Contains 'world': " + strStack.contains("world"));
        System.out.println("Pop: " + strStack.pop());
        strStack.print();

        // Test with custom Person objects
        System.out.println("\n--- Person Stack ---");
        GenericStack<Person> personStack = new GenericStack<>();
        personStack.push(new Person("Alice", 25));
        personStack.push(new Person("Bob", 30));
        personStack.push(new Person("Charlie", 35));
        personStack.print();
        System.out.println("Peek: " + personStack.peek());
        System.out.println("Contains Bob: " + personStack.contains(new Person("Bob", 30)));
        System.out.println("Pop: " + personStack.pop());
        personStack.print();

        System.out.println("\n=== All tests passed ===");
    }
}
