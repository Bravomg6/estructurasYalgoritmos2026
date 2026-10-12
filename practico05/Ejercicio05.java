/*
Prompt inicial utilizado:
Implement a recursive function that prints a countdown from n down to 0.
This function does not need to return a value; it only prints. The base case
is when n < 0 (stop recursion). Each call prints n and then calls itself with
n-1, guaranteeing progress toward the base case. If n+1 were used instead,
the function would never terminate (infinite recursion). Test with n = 5.
Expected output: 5 4 3 2 1 0.

Ajustes realizados:
Ninguno
*/

public class Ejercicio05 {

    public static void countdown(int n) {
        // Base case: stop when n goes below 0
        if (n < 0) {
            return;
        }
        // Print current value
        System.out.print(n + " ");
        // Recursive call: approach base case by decrementing
        countdown(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 5: Conteo regresivo ===");

        System.out.print("countdown(5): ");
        countdown(5);
        System.out.println();

        System.out.print("countdown(0): ");
        countdown(0);
        System.out.println();

        System.out.print("countdown(3): ");
        countdown(3);
        System.out.println();
    }
}
