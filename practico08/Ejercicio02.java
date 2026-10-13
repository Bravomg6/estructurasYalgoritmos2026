/*
Prompt inicial utilizado:
Implementa un método boolean buscar(int dato) para una lista enlazada simple de enteros.
El método debe recorrer desde head hasta encontrar el dato o llegar a null.
Explica por qué en una lista enlazada no es posible el acceso directo por índice.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo head;
    private int size;

    public Ejercicio02() {
        this.head = null;
        this.size = 0;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    // Buscar un valor recorriendo desde head hasta null
    // Devuelve true si se encuentra, false en caso contrario
    // Nota: no existe acceso directo por índice porque los nodos no se almacenan en
    // memoria contigua; cada nodo solo conoce a su sucesor mediante 'siguiente'.
    public boolean buscar(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) {
                return true; // se encontró el valor
            }
            actual = actual.siguiente; // avanzar al siguiente nodo
        }
        return false; // se llegó a null sin encontrar el valor
    }

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

    public static void main(String[] args) {
        Ejercicio02 lista = new Ejercicio02();

        System.out.println("=== Ejercicio 2: Buscar elementos ===");

        // Construir la lista: 10 -> 20 -> 30 -> 40 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        System.out.print("Lista: ");
        lista.imprimir();

        // Prueba: el valor existe en el medio
        System.out.println("buscar(20): " + lista.buscar(20)); // esperado: true

        // Prueba: el valor existe al principio
        System.out.println("buscar(10): " + lista.buscar(10)); // esperado: true

        // Prueba: el valor existe al final
        System.out.println("buscar(40): " + lista.buscar(40)); // esperado: true

        // Prueba: el valor no existe
        System.out.println("buscar(99): " + lista.buscar(99)); // esperado: false

        // Prueba: búsqueda en una lista vacía
        Ejercicio02 listaVacia = new Ejercicio02();
        System.out.println("buscar(10) en lista vacía: " + listaVacia.buscar(10)); // esperado: false
    }
}
