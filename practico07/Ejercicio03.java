/*
Prompt inicial utilizado:
Create a program that receives a mathematical expression as a string and determines
whether the parentheses are balanced. Valid example: (5 + 3) * (2 + 1).
Invalid example: (5 + 3)) * (2 + 1.
Use a stack to store opening parentheses and match them with closing ones.

Ajustes realizados:
Ninguno
*/

public class Ejercicio03 {

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 3: Parentesis Balanceados ===\n");

        String[] expressions = {
            "(5 + 3) * (2 + 1)",        // valid
            "((a + b) * c)",             // valid
            "(5 + 3)) * (2 + 1",         // invalid: extra closing
            "((5 + 3) * (2 + 1)",        // invalid: extra opening
            "(a + (b * (c - d)))",        // valid
            "()",                        // valid
            ")(",                        // invalid: wrong order
            "no parentheses here"        // valid (no parentheses at all)
        };

        for (String expr : expressions) {
            boolean result = estanBalanceados(expr);
            System.out.println("Expression: \"" + expr + "\"");
            System.out.println("Balanced:   " + result);
            System.out.println();
        }
    }

    /**
     * Checks whether all parentheses in the expression are balanced.
     *
     * Algorithm:
     * 1. Scan the expression character by character.
     * 2. When an opening parenthesis '(' is found, push it onto the stack.
     * 3. When a closing parenthesis ')' is found:
     *    - If the stack is empty, there is no matching opener -> unbalanced.
     *    - Otherwise, pop the top (most recent unmatched opener).
     * 4. After scanning, if the stack is not empty, some openers were not closed.
     *
     * The stack works because the most recently opened parenthesis must be the
     * first one closed (LIFO property).
     */
    public static boolean estanBalanceados(String expression) {
        PilaGenerica<Character> stack = new PilaGenerica<>(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // closing parenthesis without an opener
                }
                stack.pop();
            }
            // all other characters are ignored
        }

        return stack.isEmpty(); // balanced only if all openers were matched
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
            throw new IllegalStateException("Stack is full");
        }
        data[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) data[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
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
