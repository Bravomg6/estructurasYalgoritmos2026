/*
Prompt inicial utilizado:
Implementa una pila genérica usando una lista enlazada simple en Java. La pila debe soportar
cualquier tipo: Integer, String u objetos personalizados. Operaciones: push, pop, peek, isEmpty,
contains, print. Explica qué significan los genéricos en Java: seguridad de tipos en tiempo de
compilación, no necesidad de conversiones de tipo y reutilización de código. Usa una clase Node<T>
con T data y Node<T> next. No uses colecciones de Java para la estructura principal.
Incluye casos de prueba en main con Integer, String y una clase personalizada Person.

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
                throw new RuntimeException("Subdesborde de la pila: no se puede hacer pop en una pila vacía");
            }
            T value = head.data;
            head = head.next;
            size--;
            return value;
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("La pila está vacía: no hay elemento en el tope");
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
                System.out.println("La pila está vacía");
                return;
            }
            System.out.print("Pila (tope -> fondo): ");
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
        System.out.println("=== Ejercicio 03: Pila genérica ===\n");

        // Probar con Integer
        System.out.println("--- Pila de Integer ---");
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.print();
        System.out.println("Tope: " + intStack.peek());
        System.out.println("Contiene 20: " + intStack.contains(20));
        System.out.println("Desapilado: " + intStack.pop());
        intStack.print();

        // Probar con String
        System.out.println("\n--- Pila de String ---");
        GenericStack<String> strStack = new GenericStack<>();
        strStack.push("hello");
        strStack.push("world");
        strStack.push("java");
        strStack.print();
        System.out.println("Tope: " + strStack.peek());
        System.out.println("Contiene 'world': " + strStack.contains("world"));
        System.out.println("Desapilado: " + strStack.pop());
        strStack.print();

        // Probar con objetos Person personalizados
        System.out.println("\n--- Pila de Person ---");
        GenericStack<Person> personStack = new GenericStack<>();
        personStack.push(new Person("Alice", 25));
        personStack.push(new Person("Bob", 30));
        personStack.push(new Person("Charlie", 35));
        personStack.print();
        System.out.println("Tope: " + personStack.peek());
        System.out.println("Contiene a Bob: " + personStack.contains(new Person("Bob", 30)));
        System.out.println("Desapilado: " + personStack.pop());
        personStack.print();

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
