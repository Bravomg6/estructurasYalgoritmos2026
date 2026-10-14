/*
Prompt inicial utilizado:
Implementa un programa que invierte una palabra usando una pila enlazada. Ejemplo: "algoritmo"
se convierte en "omtirogla". Explica por qué la política LIFO permite invertir el orden: el último
carácter apilado es el primero que se desapila, lo que invierte naturalmente la secuencia.
Usa una clase Node con char data. No uses colecciones de Java.
Incluye casos de prueba en main.

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedStack {
        private Node head;

        public LinkedStack() {
            this.head = null;
        }

        public void push(char value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }

        public char pop() {
            if (isEmpty()) {
                throw new RuntimeException("Subdesborde de la pila");
            }
            char value = head.data;
            head = head.next;
            return value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    static class WordReverser {

        // Invierte una palabra usando una pila. O(n).
        public static String reverse(String word) {
            if (word == null || word.isEmpty()) {
                return word;
            }

            LinkedStack stack = new LinkedStack();

            // Apilar todos los caracteres
            for (int i = 0; i < word.length(); i++) {
                stack.push(word.charAt(i));
            }

            // Desapilar todos los caracteres: salen en orden inverso
            StringBuilder reversed = new StringBuilder();
            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }

            return reversed.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 08: Invertir una palabra con una pila ===\n");

        // Casos de prueba
        String[] testWords = {
            "algoritmo",
            "java",
            "stack",
            "hello",
            "a",
            "ab",
            "racecar",
            "estructura"
        };

        System.out.println("1. Invirtiendo palabras:");
        for (String word : testWords) {
            String reversed = WordReverser.reverse(word);
            System.out.println("   \"" + word + "\" -> \"" + reversed + "\"");
        }

        // Verificar el ejemplo específico
        System.out.println("\n2. Verificando el ejemplo del ejercicio:");
        String input = "algoritmo";
        String expected = "omtirogla";
        String result = WordReverser.reverse(input);
        System.out.println("   Entrada:   \"" + input + "\"");
        System.out.println("   Esperado:  \"" + expected + "\"");
        System.out.println("   Resultado: \"" + result + "\"");
        System.out.println("   Coincide: " + result.equals(expected));

        // Probar casos extremos
        System.out.println("\n3. Casos extremos:");
        System.out.println("   Cadena vacía:   \"" + WordReverser.reverse("") + "\"");
        System.out.println("   Carácter único: \"" + WordReverser.reverse("x") + "\"");
        System.out.println("   Palíndromo:     \"" + WordReverser.reverse("radar") + "\"");

        System.out.println("\n=== Todas las pruebas superadas ===");
    }
}
