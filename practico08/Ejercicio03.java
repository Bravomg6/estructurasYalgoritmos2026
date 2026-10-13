/*
Prompt inicial utilizado:
Implementa un método int obtener(int posicion) para una lista enlazada simple de enteros.
El método debe validar posiciones inválidas (posicion < 0, posicion >= size).
Explica que, aunque se use una posición, la lista no tiene acceso directo como un arreglo.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio03 {

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

    public Ejercicio03() {
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

    // Obtener el valor en una posición dada (índice base 0)
    // Aunque usemos una posición, la lista no tiene acceso directo como un arreglo.
    // Debemos recorrer desde head, contando nodos hasta alcanzar la posición deseada.
    // Complejidad temporal: O(n) en el peor caso.
    public int obtener(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + ". Rango válido: 0 a " + (size - 1));
        }
        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente; // avanzar 'posicion' veces
        }
        return actual.dato;
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

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Ejercicio03 lista = new Ejercicio03();

        System.out.println("=== Ejercicio 3: Obtener elemento por posicion ===");

        // Construir la lista: 10 -> 20 -> 30 -> 40 -> 50 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(50);
        System.out.print("Lista: ");
        lista.imprimir();
        System.out.println("Tamaño: " + lista.getSize());

        // Prueba: obtener el primer elemento
        System.out.println("obtener(0): " + lista.obtener(0)); // esperado: 10

        // Prueba: obtener un elemento del medio
        System.out.println("obtener(2): " + lista.obtener(2)); // esperado: 30

        // Prueba: obtener el último elemento
        System.out.println("obtener(4): " + lista.obtener(4)); // esperado: 50

        // Prueba: posición negativa
        try {
            lista.obtener(-1);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("obtener(-1) lanzó correctamente: " + e.getMessage());
        }

        // Prueba: posición igual al tamaño
        try {
            lista.obtener(5);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("obtener(5) lanzó correctamente: " + e.getMessage());
        }

        // Prueba: posición mayor que el tamaño
        try {
            lista.obtener(100);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("obtener(100) lanzó correctamente: " + e.getMessage());
        }
    }
}
