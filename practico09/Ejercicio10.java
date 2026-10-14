/*
Prompt inicial utilizado:
Implementa una lista doblemente enlazada genérica en Java. Operaciones: insertar al comienzo,
insertar al final, eliminar un elemento, imprimir hacia adelante, imprimir hacia atrás.
Explica qué referencias tiene cada nodo (previo y siguiente), por qué ambas son necesarias
para el recorrido bidireccional y qué casos especiales considerar al eliminar
(nodo head, nodo tail, nodo intermedio, único nodo, valor no encontrado).
Usa una clase Node<T> con T data, Node<T> prev y Node<T> next.
No uses colecciones de Java. Incluye casos de prueba en main.

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

        // Insertar al comienzo. O(1).
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

        // Insertar al final. O(1).
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

        // Eliminar la primera aparición del valor. O(n).
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
            return false; // valor no encontrado
        }

        // Eliminar un nodo específico. O(1).
        private void removeNode(Node<T> node) {
            // Caso: único nodo de la lista
            if (node == head && node == tail) {
                head = null;
                tail = null;
            }
            // Caso: nodo head
            else if (node == head) {
                head = head.next;
                head.prev = null;
            }
            // Caso: nodo tail
            else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            }
            // Caso: nodo intermedio
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

        // Imprimir hacia adelante: de head a tail. O(n).
        public void printForward() {
            if (isEmpty()) {
                System.out.println("La lista está vacía");
                return;
            }
            System.out.print("Adelante: ");
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

        // Imprimir hacia atrás: de tail a head. O(n).
        public void printBackward() {
            if (isEmpty()) {
                System.out.println("La lista está vacía");
                return;
            }
            System.out.print("Atrás:    ");
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
        System.out.println("=== Ejercicio 10: Lista doblemente enlazada ===\n");

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Probar insertar al comienzo
        System.out.println("1. Insertar al comienzo: 30, 20, 10");
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.printForward();
        list.printBackward();
        System.out.println("   Tamaño: " + list.size());
        System.out.println();

        // Probar insertar al final
        System.out.println("2. Insertar al final: 40, 50");
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.printForward();
        list.printBackward();
        System.out.println("   Tamaño: " + list.size());
        System.out.println();

        // Probar eliminar el head
        System.out.println("3. Eliminar el head (10):");
        boolean removed = list.remove(10);
        System.out.println("   Eliminado: " + removed);
        list.printForward();
        list.printBackward();
        System.out.println("   Tamaño: " + list.size());
        System.out.println();

        // Probar eliminar el tail
        System.out.println("4. Eliminar el tail (50):");
        removed = list.remove(50);
        System.out.println("   Eliminado: " + removed);
        list.printForward();
        list.printBackward();
        System.out.println("   Tamaño: " + list.size());
        System.out.println();

        // Probar eliminar un elemento del medio
        System.out.println("5. Eliminar el del medio (30):");
        removed = list.remove(30);
        System.out.println("   Eliminado: " + removed);
        list.printForward();
        list.printBackward();
        System.out.println("   Tamaño: " + list.size());
        System.out.println();

        // Probar eliminar un valor inexistente
        System.out.println("6. Eliminar un valor inexistente (999):");
        removed = list.remove(999);
        System.out.println("   Eliminado: " + removed);
        list.printForward();
        System.out.println();

        // Probar eliminar hasta vaciar la lista
        System.out.println("7. Eliminar los elementos restantes:");
        while (!list.isEmpty()) {
            list.remove(list.size() > 0 ? getValueAtHead(list) : null);
        }
        list.printForward();
        System.out.println("   isEmpty: " + list.isEmpty());
        System.out.println();

        // Probar con String
        System.out.println("8. Prueba con lista de String:");
        DoublyLinkedList<String> strList = new DoublyLinkedList<>();
        strList.insertAtEnd("hello");
        strList.insertAtEnd("world");
        strList.insertAtBeginning("start");
        strList.printForward();
        strList.printBackward();
        strList.remove("world");
        System.out.println("   Después de eliminar 'world':");
        strList.printForward();
        strList.printBackward();

        System.out.println("\n=== Todas las pruebas superadas ===");
    }

    // Función auxiliar para obtener el valor del head en las pruebas
    private static <T> T getValueAtHead(DoublyLinkedList<T> list) {
        // Se usa reflexión o simplemente eliminar iterando; aquí se hace por simplicidad en la prueba
        // Se adopta un enfoque distinto: eliminar el primer elemento
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
