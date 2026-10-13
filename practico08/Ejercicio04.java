/*
Prompt inicial utilizado:
Implementa un método void insertarEnPosicion(int dato, int posicion) para una lista enlazada simple.
El método debe permitir insertar al inicio, en el medio y al final.
Explica el orden correcto de actualización de referencias:
  nuevo.setSiguiente(actual.getSiguiente());
  actual.setSiguiente(nuevo);
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio04 {

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

    public Ejercicio04() {
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

    // Insertar un nuevo nodo en una posición específica (índice base 0)
    // Posiciones válidas: 0 (inicio) hasta size (final)
    //
    // Orden correcto de actualización de referencias:
    //   1. nuevo.siguiente = actual.siguiente;  (vincular el nuevo nodo con el resto de la lista)
    //   2. actual.siguiente = nuevo;            (vincular el nodo anterior con el nuevo nodo)
    //
    // Si invirtiéramos el orden, perderíamos la referencia al resto de la lista.
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + ". Rango válido: 0 a " + size);
        }

        // Insertar al inicio
        if (posicion == 0) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = head;
            head = nuevo;
            size++;
            return;
        }

        // Recorrer hasta el nodo anterior al punto de inserción
        Nodo actual = head;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }

        // Insertar en el medio o al final
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = actual.siguiente; // paso 1: vincular el nuevo nodo con el resto
        actual.siguiente = nuevo;           // paso 2: vincular el nodo anterior con el nuevo nodo
        size++;
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
        Ejercicio04 lista = new Ejercicio04();

        System.out.println("=== Ejercicio 4: Insertar en posicion especifica ===");

        // Construir la lista inicial: 10 -> 20 -> 30 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        System.out.print("Lista inicial: ");
        lista.imprimir();
        System.out.println("Tamaño: " + lista.getSize());

        // Prueba: insertar al inicio (posición 0)
        lista.insertarEnPosicion(5, 0);
        System.out.print("Después de insertarEnPosicion(5, 0): ");
        lista.imprimir(); // esperado: 5 -> 10 -> 20 -> 30 -> null
        System.out.println("Tamaño: " + lista.getSize());

        // Prueba: insertar en el medio (posición 2)
        lista.insertarEnPosicion(15, 2);
        System.out.print("Después de insertarEnPosicion(15, 2): ");
        lista.imprimir(); // esperado: 5 -> 10 -> 15 -> 20 -> 30 -> null
        System.out.println("Tamaño: " + lista.getSize());

        // Prueba: insertar al final (posición = size)
        lista.insertarEnPosicion(35, lista.getSize());
        System.out.print("Después de insertarEnPosicion(35, size): ");
        lista.imprimir(); // esperado: 5 -> 10 -> 15 -> 20 -> 30 -> 35 -> null
        System.out.println("Tamaño: " + lista.getSize());

        // Prueba: posición inválida (negativa)
        try {
            lista.insertarEnPosicion(99, -1);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("insertarEnPosicion(99, -1) lanzó correctamente: " + e.getMessage());
        }

        // Prueba: posición inválida (mayor que el tamaño)
        try {
            lista.insertarEnPosicion(99, 100);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("insertarEnPosicion(99, 100) lanzó correctamente: " + e.getMessage());
        }
    }
}
