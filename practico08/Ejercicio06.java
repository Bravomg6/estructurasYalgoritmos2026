/*
Prompt inicial utilizado:
Implementa un método void eliminarEnPosicion(int posicion) para una lista enlazada simple.
El método debe validar posiciones inválidas y actualizar size.
Explica cómo encontrar el nodo anterior al que se va a eliminar.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio06 {

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

    public Ejercicio06() {
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

    // Eliminar el nodo en una posición específica (índice base 0)
    // Posiciones válidas: 0 a size-1
    //
    // Para eliminar un nodo, necesitamos encontrar el nodo ANTERIOR a él (el nodo previo)
    // y actualizar su referencia 'siguiente' para omitir el nodo que se elimina.
    // Para la posición 0 no existe nodo anterior, por lo que actualizamos head directamente.
    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + ". Rango válido: 0 a " + (size - 1));
        }

        // Eliminar el primer nodo
        if (posicion == 0) {
            head = head.siguiente;
            size--;
            return;
        }

        // Buscar el nodo justo anterior al que se va a eliminar
        Nodo anterior = head;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.siguiente;
        }

        // Omitir el nodo en 'posicion'
        anterior.siguiente = anterior.siguiente.siguiente;
        size--;
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
        System.out.println("=== Ejercicio 6: Eliminar nodo por posicion ===");

        // Prueba 1: eliminar el primer nodo (posición 0)
        Ejercicio06 lista1 = new Ejercicio06();
        lista1.insertarAlFinal(10);
        lista1.insertarAlFinal(20);
        lista1.insertarAlFinal(30);
        System.out.print("Antes: ");
        lista1.imprimir();
        lista1.eliminarEnPosicion(0);
        System.out.print("Después de eliminarEnPosicion(0): ");
        lista1.imprimir(); // esperado: 20 -> 30 -> null
        System.out.println("Tamaño: " + lista1.getSize());

        // Prueba 2: eliminar un nodo del medio
        Ejercicio06 lista2 = new Ejercicio06();
        lista2.insertarAlFinal(10);
        lista2.insertarAlFinal(20);
        lista2.insertarAlFinal(30);
        lista2.insertarAlFinal(40);
        System.out.print("Antes: ");
        lista2.imprimir();
        lista2.eliminarEnPosicion(2);
        System.out.print("Después de eliminarEnPosicion(2): ");
        lista2.imprimir(); // esperado: 10 -> 20 -> 40 -> null
        System.out.println("Tamaño: " + lista2.getSize());

        // Prueba 3: eliminar el último nodo
        Ejercicio06 lista3 = new Ejercicio06();
        lista3.insertarAlFinal(10);
        lista3.insertarAlFinal(20);
        lista3.insertarAlFinal(30);
        System.out.print("Antes: ");
        lista3.imprimir();
        lista3.eliminarEnPosicion(2);
        System.out.print("Después de eliminarEnPosicion(2): ");
        lista3.imprimir(); // esperado: 10 -> 20 -> null
        System.out.println("Tamaño: " + lista3.getSize());

        // Prueba 4: posición inválida (negativa)
        Ejercicio06 lista4 = new Ejercicio06();
        lista4.insertarAlFinal(10);
        try {
            lista4.eliminarEnPosicion(-1);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("eliminarEnPosicion(-1) lanzó correctamente: " + e.getMessage());
        }

        // Prueba 5: posición inválida (igual al tamaño)
        try {
            lista4.eliminarEnPosicion(1);
            System.out.println("ERROR: debió lanzar una excepción");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("eliminarEnPosicion(1) en lista de tamaño 1 lanzó correctamente: " + e.getMessage());
        }

        // Prueba 6: eliminar de una lista de un solo elemento
        Ejercicio06 lista5 = new Ejercicio06();
        lista5.insertarAlFinal(99);
        System.out.print("Antes: ");
        lista5.imprimir();
        lista5.eliminarEnPosicion(0);
        System.out.print("Después de eliminarEnPosicion(0): ");
        lista5.imprimir(); // esperado: null
        System.out.println("Tamaño: " + lista5.getSize());
    }
}
