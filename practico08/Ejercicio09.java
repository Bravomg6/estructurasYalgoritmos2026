/*
Prompt inicial utilizado:
Implementa un método void invertir() para una lista enlazada simple.
Ejemplo: 10 -> 20 -> 30 -> 40 -> null pasa a ser 40 -> 30 -> 20 -> 10 -> null.
Explica qué referencias auxiliares se necesitan: anterior, actual, siguiente.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio09 {

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

    public Ejercicio09() {
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

    // Invertir la lista enlazada in situ
    //
    // Se necesitan tres referencias auxiliares:
    // - anterior:    comienza en null y registra el nuevo 'siguiente' de cada nodo
    // - actual:      el nodo que se está procesando
    // - siguiente:   guarda temporalmente el resto de la lista antes de romper el enlace
    //
    // Para cada nodo:
    //   1. siguiente = actual.siguiente  (guardar el resto de la lista)
    //   2. actual.siguiente = anterior   (invertir el enlace)
    //   3. anterior = actual             (avanzar anterior)
    //   4. actual = siguiente            (avanzar actual)
    //
    // Al final, anterior apunta al nuevo head (antes era el último nodo).
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;  // paso 1: guardar el siguiente nodo
            actual.siguiente = anterior;  // paso 2: invertir el enlace
            anterior = actual;            // paso 3: avanzar anterior
            actual = siguiente;          // paso 4: avanzar actual
        }

        head = anterior; // anterior es ahora el nuevo head (último nodo de la lista original)
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
        System.out.println("=== Ejercicio 9: Invertir lista enlazada ===");

        // Prueba 1: invertir una lista con varios elementos
        Ejercicio09 lista1 = new Ejercicio09();
        lista1.insertarAlFinal(10);
        lista1.insertarAlFinal(20);
        lista1.insertarAlFinal(30);
        lista1.insertarAlFinal(40);
        System.out.print("Antes de invertir: ");
        lista1.imprimir(); // esperado: 10 -> 20 -> 30 -> 40 -> null
        lista1.invertir();
        System.out.print("Después de invertir: ");
        lista1.imprimir(); // esperado: 40 -> 30 -> 20 -> 10 -> null
        System.out.println("Tamaño: " + lista1.getSize());

        // Prueba 2: invertir una lista de un solo elemento
        Ejercicio09 lista2 = new Ejercicio09();
        lista2.insertarAlFinal(99);
        System.out.print("Antes de invertir (lista de un elemento): ");
        lista2.imprimir(); // esperado: 99 -> null
        lista2.invertir();
        System.out.print("Después de invertir (lista de un elemento): ");
        lista2.imprimir(); // esperado: 99 -> null

        // Prueba 3: invertir una lista vacía
        Ejercicio09 lista3 = new Ejercicio09();
        System.out.print("Antes de invertir (lista vacía): ");
        lista3.imprimir(); // esperado: null
        lista3.invertir();
        System.out.print("Después de invertir (lista vacía): ");
        lista3.imprimir(); // esperado: null

        // Prueba 4: invertir dos veces devuelve el orden original
        Ejercicio09 lista4 = new Ejercicio09();
        lista4.insertarAlFinal(1);
        lista4.insertarAlFinal(2);
        lista4.insertarAlFinal(3);
        System.out.print("Original: ");
        lista4.imprimir();
        lista4.invertir();
        System.out.print("Invertida una vez: ");
        lista4.imprimir();
        lista4.invertir();
        System.out.print("Invertida dos veces (de vuelta al original): ");
        lista4.imprimir(); // esperado: 1 -> 2 -> 3 -> null
    }
}
