/*
Prompt inicial utilizado:
Implementar una clase de pila genérica Pila<T> usando un arreglo. Debe permitir
almacenar diferentes tipos: Integer, String u objetos simples personalizados.
Explicar qué problema resuelven los genéricos en este contexto.

Ajustes realizados:
Ninguno
*/

public class Ejercicio05 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 5: Pila Generica ===\n");

        // Pila de enteros
        System.out.println("--- Pila de enteros ---");
        Pila<Integer> intStack = new Pila<>(5);
        intStack.push(100);
        intStack.push(200);
        intStack.push(300);
        System.out.println("Elemento superior: " + intStack.peek());
        System.out.println("Desapilado: " + intStack.pop());
        System.out.println("Tamaño: " + intStack.size());

        // Pila de cadenas de texto
        System.out.println("\n--- Pila de cadenas ---");
        Pila<String> strStack = new Pila<>(5);
        strStack.push("hello");
        strStack.push("world");
        strStack.push("!");
        System.out.println("Elemento superior: " + strStack.peek());
        System.out.println("Desapilado: " + strStack.pop());
        System.out.println("Tamaño: " + strStack.size());

        // Pila de objetos personalizados
        System.out.println("\n--- Pila de Personas ---");
        Pila<Person> personStack = new Pila<>(5);
        personStack.push(new Person("Alice", 30));
        personStack.push(new Person("Bob", 25));
        System.out.println("Elemento superior: " + personStack.peek());
        System.out.println("Desapilado: " + personStack.pop());
        System.out.println("Tamaño: " + personStack.size());

        System.out.println("\n¿Qué problema resuelven los genéricos?");
        System.out.println("Sin genéricos, sería necesaria una clase de pila separada para");
        System.out.println("cada tipo (IntStack, StringStack, PersonStack) o usar Object[]");
        System.out.println("con conversiones inseguras. Los genéricos ofrecen seguridad de tipos");
        System.out.println("en tiempo de compilación: el compilador garantiza que solo se almacene");
        System.out.println("el tipo declarado, eliminando riesgos de ClassCastException y código redundante.");
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
            throw new IllegalStateException("La pila está llena");
        }
        data[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return (T) data[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
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
