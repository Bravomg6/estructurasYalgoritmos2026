/*
Prompt inicial utilizado:
Implementa un método boolean eliminar(int dato) para una lista enlazada simple.
El método debe eliminar la primera aparición del valor.
Casos a tener en cuenta: lista vacía, eliminar el primer nodo, eliminar un nodo del medio, eliminar el último nodo, valor inexistente.
Explica que en Java no borramos un nodo manualmente; lo hacemos inaccesible para el Garbage Collector.
Incluye casos de prueba en el método main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio05 {

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

    public Ejercicio05() {
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

    // Eliminar la primera aparición de un valor
    // Devuelve true si el valor se encontró y se eliminó, false en caso contrario
    //
    // En Java no eliminamos un nodo manualmente. Simplemente lo desvinculamos
    // actualizando la referencia 'siguiente' del nodo anterior. Cuando ninguna
    // referencia apunta al nodo eliminado, el Garbage Collector recupera su memoria.
    public boolean eliminar(int dato) {
        // Caso 1: lista vacía
        if (head == null) {
            return false;
        }

        // Caso 2: eliminar el primer nodo (head)
        if (head.dato == dato) {
            head = head.siguiente; // desvincular el primer nodo
            size--;
            return true;
        }

        // Casos 3 y 4: eliminar un nodo del medio o el último
        Nodo actual = head;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == dato) {
                actual.siguiente = actual.siguiente.siguiente; // omitir el nodo a eliminar
                size--;
                return true;
            }
            actual = actual.siguiente;
        }

        // Caso 5: valor no encontrado
        return false;
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
        System.out.println("=== Ejercicio 5: Eliminar nodo por valor ===");

        // Prueba 1: eliminar de una lista vacía
        Ejercicio05 lista1 = new Ejercicio05();
        System.out.print("Lista vacía: ");
        lista1.imprimir();
        System.out.println("eliminar(10) en lista vacía: " + lista1.eliminar(10)); // esperado: false

        // Prueba 2: eliminar el primer nodo
        Ejercicio05 lista2 = new Ejercicio05();
        lista2.insertarAlFinal(10);
        lista2.insertarAlFinal(20);
        lista2.insertarAlFinal(30);
        System.out.print("Antes de eliminar el primero: ");
        lista2.imprimir();
        System.out.println("eliminar(10): " + lista2.eliminar(10)); // esperado: true
        System.out.print("Después de eliminar el primero: ");
        lista2.imprimir(); // esperado: 20 -> 30 -> null
        System.out.println("Tamaño: " + lista2.getSize());

        // Prueba 3: eliminar un nodo del medio
        Ejercicio05 lista3 = new Ejercicio05();
        lista3.insertarAlFinal(10);
        lista3.insertarAlFinal(20);
        lista3.insertarAlFinal(30);
        System.out.print("Antes de eliminar el del medio: ");
        lista3.imprimir();
        System.out.println("eliminar(20): " + lista3.eliminar(20)); // esperado: true
        System.out.print("Después de eliminar el del medio: ");
        lista3.imprimir(); // esperado: 10 -> 30 -> null
        System.out.println("Tamaño: " + lista3.getSize());

        // Prueba 4: eliminar el último nodo
        Ejercicio05 lista4 = new Ejercicio05();
        lista4.insertarAlFinal(10);
        lista4.insertarAlFinal(20);
        lista4.insertarAlFinal(30);
        System.out.print("Antes de eliminar el último: ");
        lista4.imprimir();
        System.out.println("eliminar(30): " + lista4.eliminar(30)); // esperado: true
        System.out.print("Después de eliminar el último: ");
        lista4.imprimir(); // esperado: 10 -> 20 -> null
        System.out.println("Tamaño: " + lista4.getSize());

        // Prueba 5: eliminar un valor inexistente
        Ejercicio05 lista5 = new Ejercicio05();
        lista5.insertarAlFinal(10);
        lista5.insertarAlFinal(20);
        System.out.print("Antes de eliminar el inexistente: ");
        lista5.imprimir();
        System.out.println("eliminar(99): " + lista5.eliminar(99)); // esperado: false
        System.out.print("Después de eliminar el inexistente: ");
        lista5.imprimir(); // esperado: 10 -> 20 -> null
        System.out.println("Tamaño: " + lista5.getSize());

        // Prueba 6: eliminar el único elemento de una lista de un solo nodo
        Ejercicio05 lista6 = new Ejercicio05();
        lista6.insertarAlFinal(42);
        System.out.print("Antes de eliminar el único elemento: ");
        lista6.imprimir();
        System.out.println("eliminar(42): " + lista6.eliminar(42)); // esperado: true
        System.out.print("Después de eliminar el único elemento: ");
        lista6.imprimir(); // esperado: null
        System.out.println("Tamaño: " + lista6.getSize());
    }
}
