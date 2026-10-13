/*
Prompt inicial utilizado:
Implementa un método void modificar(int posicion, int nuevoDato) para una lista enlazada simple.
El método debe validar la posición antes de recorrer.
Explica la diferencia entre modificar el dato de un nodo y modificar la referencia al siguiente nodo.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio07 {

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

    public Ejercicio07() {
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

    // Modificar el dato almacenado en una posición dada
    //
    // Diferencia entre modificar el dato y modificar la referencia:
    // - Modificar el dato (este método): cambiamos 'nodo.dato'. La estructura de la lista
    //   (nodos y sus enlaces) permanece exactamente igual.
    // - Modificar la referencia: cambiamos 'nodo.siguiente'. Esto altera la
    //   estructura de la lista al agregar, eliminar u ordenar nodos.
    public void modificar(int posicion, int nuevoDato) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + ". Rango válido: 0 a " + (size - 1));
        }

        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente; // avanzar hasta el nodo destino
        }
        actual.dato = nuevoDato; // actualizar solo el dato, no el enlace
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
        Ejercicio07 lista = new Ejercicio07();

        System.out.println("=== Ejercicio 7: Modificar elemento de la lista ===");

        // Construir la lista: 10 -> 20 -> 30 -> 40 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        System.out.print("Lista inicial: ");
        lista.imprimir();

        // Prueba: modificar el primer elemento
        lista.modificar(0, 11);
        System.out.print("Después de modificar(0, 11): ");
        lista.imprimir(); // esperado: 11 -> 20 -> 30 -> 40 -> null

        // Prueba: modificar un elemento del medio
        lista.modificar(2, 33);
        System.out.print("Después de modificar(2, 33): ");
        lista.imprimir(); // esperado: 11 -> 20 -> 33 -> 40 -> null

        // Prueba: modificar el último elemento
        lista.modificar(3, 44);
        System.out.print("Después de modificar(3, 44): ");
        lista.imprimir(); // esperado: 11 -> 20 -> 33 -> 44 -> null

        // Prueba: posición inválida (negativa)
        try {
            lista.modificar(-1, 99);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("modificar(-1, 99) lanzó correctamente: " + e.getMessage());
        }

        // Prueba: posición inválida (igual al tamaño)
        try {
            lista.modificar(4, 99);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("modificar(4, 99) lanzó correctamente: " + e.getMessage());
        }

        // Verificar que la estructura no cambió tras las modificaciones (misma cantidad de nodos)
        System.out.println("Tamaño después de todas las modificaciones: " + lista.getSize()); // esperado: 4
    }
}
