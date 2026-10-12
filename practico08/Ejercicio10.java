/*
Prompt inicial utilizado:
Transform the integer-based linked list implementation into a generic version: ListaEnlazada<T>, Nodo<T>.
It must work with ListaEnlazada<Integer>, ListaEnlazada<String>, and ListaEnlazada<Alumno>.
Include test cases in the main method demonstrating all three types.

Ajustes realizados:
Ninguno
*/

public class Ejercicio10 {

    // Generic node: can hold any type T
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Generic singly linked list
    private static class ListaEnlazada<T> {
        private Nodo<T> head;
        private int size;

        public ListaEnlazada() {
            this.head = null;
            this.size = 0;
        }

        public void insertarAlFinal(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            if (head == null) {
                head = nuevo;
            } else {
                Nodo<T> actual = head;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
            size++;
        }

        public void insertarAlInicio(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.siguiente = head;
            head = nuevo;
            size++;
        }

        public boolean buscar(T dato) {
            Nodo<T> actual = head;
            while (actual != null) {
                if (actual.dato.equals(dato)) {
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }

        public T obtener(int posicion) {
            if (posicion < 0 || posicion >= size) {
                throw new IndexOutOfBoundsException(
                    "Invalid position: " + posicion + ". Valid range: 0 to " + (size - 1));
            }
            Nodo<T> actual = head;
            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }
            return actual.dato;
        }

        public int getSize() {
            return size;
        }

        public boolean estaVacia() {
            return head == null;
        }

        public void imprimir() {
            Nodo<T> actual = head;
            while (actual != null) {
                System.out.print(actual.dato);
                if (actual.siguiente != null) {
                    System.out.print(" -> ");
                }
                actual = actual.siguiente;
            }
            System.out.println(" -> null");
        }
    }

    // Custom class to demonstrate the generic list with a user-defined type
    private static class Alumno {
        String nombre;
        int legajo;

        Alumno(String nombre, int legajo) {
            this.nombre = nombre;
            this.legajo = legajo;
        }

        @Override
        public String toString() {
            return nombre + " (#" + legajo + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Alumno other = (Alumno) obj;
            return legajo == other.legajo && nombre.equals(other.nombre);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 10: Lista enlazada generica ===");

        // Test 1: ListaEnlazada<Integer>
        System.out.println("\n--- ListaEnlazada<Integer> ---");
        ListaEnlazada<Integer> listaEnteros = new ListaEnlazada<>();
        listaEnteros.insertarAlFinal(10);
        listaEnteros.insertarAlFinal(20);
        listaEnteros.insertarAlFinal(30);
        listaEnteros.insertarAlInicio(5);
        System.out.print("Integer list: ");
        listaEnteros.imprimir(); // expected: 5 -> 10 -> 20 -> 30 -> null
        System.out.println("Size: " + listaEnteros.getSize());
        System.out.println("estaVacia(): " + listaEnteros.estaVacia());
        System.out.println("buscar(20): " + listaEnteros.buscar(20));
        System.out.println("buscar(99): " + listaEnteros.buscar(99));
        System.out.println("obtener(0): " + listaEnteros.obtener(0));
        System.out.println("obtener(3): " + listaEnteros.obtener(3));

        // Test 2: ListaEnlazada<String>
        System.out.println("\n--- ListaEnlazada<String> ---");
        ListaEnlazada<String> listaStrings = new ListaEnlazada<>();
        listaStrings.insertarAlFinal("Hello");
        listaStrings.insertarAlFinal("World");
        listaStrings.insertarAlFinal("Generic");
        listaStrings.insertarAlInicio("Say");
        System.out.print("String list: ");
        listaStrings.imprimir(); // expected: Say -> Hello -> World -> Generic -> null
        System.out.println("Size: " + listaStrings.getSize());
        System.out.println("buscar(\"World\"): " + listaStrings.buscar("World"));
        System.out.println("buscar(\"Java\"): " + listaStrings.buscar("Java"));
        System.out.println("obtener(1): " + listaStrings.obtener(1));

        // Test 3: ListaEnlazada<Alumno>
        System.out.println("\n--- ListaEnlazada<Alumno> ---");
        ListaEnlazada<Alumno> listaAlumnos = new ListaEnlazada<>();
        listaAlumnos.insertarAlFinal(new Alumno("Ana", 101));
        listaAlumnos.insertarAlFinal(new Alumno("Luis", 102));
        listaAlumnos.insertarAlFinal(new Alumno("Maria", 103));
        System.out.print("Alumno list: ");
        listaAlumnos.imprimir(); // expected: Ana (#101) -> Luis (#102) -> Maria (#103) -> null
        System.out.println("Size: " + listaAlumnos.getSize());
        System.out.println("buscar(Luis): " + listaAlumnos.buscar(new Alumno("Luis", 102)));
        System.out.println("buscar(Pedro): " + listaAlumnos.buscar(new Alumno("Pedro", 104)));
        System.out.println("obtener(0): " + listaAlumnos.obtener(0));
        System.out.println("obtener(2): " + listaAlumnos.obtener(2));
    }
}
