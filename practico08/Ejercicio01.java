/*
Prompt inicial utilizado:
Implementa una lista enlazada simple de enteros desde cero en Java sin usar ArrayList ni LinkedList.
La lista debe soportar: insertarAlInicio(int dato), insertarAlFinal(int dato), imprimir(), estaVacia(), getSize().
Explica cómo se representa un nodo, qué papel juega 'head' y cómo se actualiza el tamaño.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio01 {

    // Representación de un nodo: cada nodo guarda el dato y una referencia al siguiente nodo
    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo head; // head apunta al primer nodo; null indica lista vacía
    private int size;  // lleva la cuenta del número de nodos para consultas de tamaño en O(1)

    public Ejercicio01() {
        this.head = null;
        this.size = 0;
    }

    // Insertar al inicio: el nuevo nodo pasa a ser el nuevo head
    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = head; // vincular el nuevo nodo con el primer nodo actual
        head = nuevo;           // actualizar head para que apunte al nuevo nodo
        size++;
    }

    // Insertar al final: recorrer hasta el último nodo y vincular el nuevo nodo
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            head = nuevo; // lista vacía: el nuevo nodo pasa a ser el head
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente; // avanzar hasta el último nodo
            }
            actual.siguiente = nuevo; // vincular el último nodo con el nuevo nodo
        }
        size++;
    }

    // Imprimir la lista en el formato: 10 -> 20 -> 30 -> null
    public void imprimir() {
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> null");
    }

    // Devuelve true si la lista no tiene nodos
    public boolean estaVacia() {
        return head == null;
    }

    // Devuelve la cantidad de nodos de la lista
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Ejercicio01 lista = new Ejercicio01();

        System.out.println("=== Ejercicio 1: Lista enlazada simple desde cero ===");

        // Probar estaVacia con una lista nueva
        System.out.println("estaVacia() en lista nueva: " + lista.estaVacia()); // esperado: true
        System.out.println("getSize() en lista nueva: " + lista.getSize());     // esperado: 0

        // Probar insertarAlFinal
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        System.out.print("Después de insertarAlFinal(10,20,30): ");
        lista.imprimir(); // esperado: 10 -> 20 -> 30 -> null
        System.out.println("getSize(): " + lista.getSize()); // esperado: 3
        System.out.println("estaVacia(): " + lista.estaVacia()); // esperado: false

        // Probar insertarAlInicio
        lista.insertarAlInicio(5);
        System.out.print("Después de insertarAlInicio(5): ");
        lista.imprimir(); // esperado: 5 -> 10 -> 20 -> 30 -> null
        System.out.println("getSize(): " + lista.getSize()); // esperado: 4

        // Probar insertarAlInicio con una lista vacía
        Ejercicio01 lista2 = new Ejercicio01();
        lista2.insertarAlInicio(100);
        System.out.print("Después de insertarAlInicio(100) en lista vacía: ");
        lista2.imprimir(); // esperado: 100 -> null
        System.out.println("getSize(): " + lista2.getSize()); // esperado: 1
    }
}
