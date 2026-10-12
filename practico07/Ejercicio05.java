/*
Prompt inicial utilizado:
Implement a generic stack class Pila<T> using an array. It must allow storing
different types: Integer, String, or simple custom objects.
Explain what problem generics solve in this context.

Ajustes realizados:
Ninguno
*/

public class Ejercicio05 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 5: Pila Generica ===\n");

        // Stack of Integers
        System.out.println("--- Integer Stack ---");
        Pila<Integer> intStack = new Pila<>(5);
        intStack.push(100);
        intStack.push(200);
        intStack.push(300);
        System.out.println("Top: " + intStack.peek());
        System.out.println("Popped: " + intStack.pop());
        System.out.println("Size: " + intStack.size());

        // Stack of Strings
        System.out.println("\n--- String Stack ---");
        Pila<String> strStack = new Pila<>(5);
        strStack.push("hello");
        strStack.push("world");
        strStack.push("!");
        System.out.println("Top: " + strStack.peek());
        System.out.println("Popped: " + strStack.pop());
        System.out.println("Size: " + strStack.size());

        // Stack of custom objects
        System.out.println("\n--- Person Stack ---");
        Pila<Person> personStack = new Pila<>(5);
        personStack.push(new Person("Alice", 30));
        personStack.push(new Person("Bob", 25));
        System.out.println("Top: " + personStack.peek());
        System.out.println("Popped: " + personStack.pop());
        System.out.println("Size: " + personStack.size());

        System.out.println("\nWhat problem do generics solve?");
        System.out.println("Without generics, you would need a separate stack class for");
        System.out.println("each type (IntStack, StringStack, PersonStack) or use Object[]");
        System.out.println("with unsafe casts. Generics provide type safety at compile time:");
        System.out.println("the compiler enforces that only the declared type is stored,");
        System.out.println("eliminating ClassCastException risks and redundant code.");
    }
}

class Pila<T> {

    private Object[] data;
    private int top;

    public Pila(int capacity) {
        this.data = new Object[capacity];
        this.top = -1;
    }

    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        data[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) data[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public int size() {
        return top + 1;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
