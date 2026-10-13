/*
Prompt inicial utilizado:
Crear un programa que reciba una expresión matemática como cadena de texto y determine
si los paréntesis están balanceados. Ejemplo válido: (5 + 3) * (2 + 1).
Ejemplo inválido: (5 + 3)) * (2 + 1.
Usar una pila para almacenar los paréntesis de apertura y emparejarlos con los de cierre.

Ajustes realizados:
Ninguno
*/

public class Ejercicio03 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 3: Parentesis Balanceados ===\n");

        String[] expressions = {
            "(5 + 3) * (2 + 1)",        // válido
            "((a + b) * c)",             // válido
            "(5 + 3)) * (2 + 1",         // inválido: cierra de más
            "((5 + 3) * (2 + 1)",        // inválido: abre de más
            "(a + (b * (c - d)))",        // válido
            "()",                        // válido
            ")(",                        // inválido: orden incorrecto
            "no parentheses here"        // válido (sin paréntesis)
        };

        for (String expr : expressions) {
            boolean result = estanBalanceados(expr);
            System.out.println("Expresión: \"" + expr + "\"");
            System.out.println("Balanceada: " + result);
            System.out.println();
        }
    }

    /**
     * Verifica si todos los paréntesis de la expresión están balanceados.
     *
     * Algoritmo:
     * 1. Recorrer la expresión carácter por carácter.
     * 2. Cuando se encuentra un paréntesis de apertura '(', apilarlo en la pila.
     * 3. Cuando se encuentra un paréntesis de cierre ')':
     *    - Si la pila está vacía, no hay un paréntesis de apertura que lo corresponda -> no balanceado.
     *    - En caso contrario, desapilar el elemento superior (el paréntesis de apertura más reciente sin cerrar).
     * 4. Al terminar el recorrido, si la pila no está vacía, algunos paréntesis de apertura no fueron cerrados.
     *
     * La pila funciona porque el paréntesis abierto más recientemente debe ser el
     * primero en cerrarse (propiedad LIFO).
     */
    public static boolean estanBalanceados(String expression) {
        PilaGenerica<Character> stack = new PilaGenerica<>(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // paréntesis de cierre sin su apertura
                }
                stack.pop();
            }
            // todos los demás caracteres se ignoran
        }

        return stack.isEmpty(); // balanceado solo si todos los de apertura fueron emparejados
    }
}

class PilaGenerica<T> {

    private Object[] data;
    private int top;

    public PilaGenerica(int capacity) {
        this.data = new Object[capacity];
        this.top = -1;
    }

    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("La pila está llena");
        }
        data[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return (T) data[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return (T) data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public int size() {
        return top + 1;
    }
}
