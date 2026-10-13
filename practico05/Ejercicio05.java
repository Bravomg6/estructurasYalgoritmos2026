/*
Prompt inicial utilizado:
Implementar una función recursiva que imprima una cuenta regresiva desde n hasta 0.
Esta función no necesita devolver un valor; solo imprime. El caso base
es cuando n < 0 (detener la recursión). Cada llamada imprime n y luego se llama a sí misma con
n-1, garantizando avance hacia el caso base. Si se usara n+1 en su lugar,
la función nunca terminaría (recursión infinita). Probar con n = 5.
Salida esperada: 5 4 3 2 1 0.

Ajustes realizados:
Ninguno
*/

public class Ejercicio05 {

    public static void countdown(int n) {
        // Caso base: detenerse cuando n sea menor que 0
        if (n < 0) {
            return;
        }
        // Imprimir el valor actual
        System.out.print(n + " ");
        // Llamada recursiva: acercarse al caso base decrementando
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
