/*
Prompt inicial utilizado:
Implementa un método int contarOcurrencias(int dato) para una lista enlazada simple.
Ejemplo: 10 -> 20 -> 10 -> 30 -> 10 -> null, para el valor 10 debe devolver 3.
Explica por qué el recorrido no debe detenerse en la primera coincidencia.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

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

    public Ejercicio08() {
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

    // Contar cuántas veces aparece un valor en la lista
    //
    // NO debemos detener el recorrido en la primera coincidencia. El valor puede
    // aparecer varias veces a lo largo de la lista, así que hay que visitar cada nodo.
    // Complejidad temporal: O(n); siempre recorremos la lista completa.
    public int contarOcurrencias(int dato) {
        int count = 0;
        Nodo actual = head;
        while (actual != null) {
            if (actual.dato == dato) {
                count++;
            }
            actual = actual.siguiente; // siempre avanzar, incluso tras una coincidencia
        }
        return count;
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
        Ejercicio08 lista = new Ejercicio08();

        System.out.println("=== Ejercicio 8: Contar ocurrencias ===");

        // Construir la lista: 10 -> 20 -> 10 -> 30 -> 10 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(10);
        System.out.print("Lista: ");
        lista.imprimir();

        // Prueba: el valor aparece 3 veces
        System.out.println("contarOcurrencias(10): " + lista.contarOcurrencias(10)); // esperado: 3

        // Prueba: el valor aparece 1 vez
        System.out.println("contarOcurrencias(20): " + lista.contarOcurrencias(20)); // esperado: 1

        // Prueba: el valor aparece 1 vez (en otra posición)
        System.out.println("contarOcurrencias(30): " + lista.contarOcurrencias(30)); // esperado: 1

        // Prueba: el valor no aparece
        System.out.println("contarOcurrencias(99): " + lista.contarOcurrencias(99)); // esperado: 0

        // Prueba: contar en una lista vacía
        Ejercicio08 listaVacia = new Ejercicio08();
        System.out.println("contarOcurrencias(10) en lista vacía: " + listaVacia.contarOcurrencias(10)); // esperado: 0

        // Prueba: todos los elementos son iguales
        Ejercicio08 listaUniforme = new Ejercicio08();
        listaUniforme.insertarAlFinal(5);
        listaUniforme.insertarAlFinal(5);
        listaUniforme.insertarAlFinal(5);
        listaUniforme.insertarAlFinal(5);
        System.out.print("Lista uniforme: ");
        listaUniforme.imprimir();
        System.out.println("contarOcurrencias(5): " + listaUniforme.contarOcurrencias(5)); // esperado: 4
    }
}
