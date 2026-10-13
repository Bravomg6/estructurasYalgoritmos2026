/*
Prompt inicial utilizado:
"Generame un programa en Java que muestre un contador utilizando while."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Contador con bucle while ===");

        // Pide al usuario el límite del contador.
        System.out.print("Ingrese el límite superior del contador: ");
        int limit = scanner.nextInt();

        // Valida que el límite sea positivo.
        if (limit <= 0) {
            System.out.println("Error: el límite debe ser un número positivo.");
            scanner.close();
            return;
        }

        // Inicializa la variable contador (valor inicial).
        int counter = 1;

        // El bucle while repite el bloque mientras la condición sea verdadera.
        // IMPORTANTE: el contador debe incrementarse dentro del bucle para evitar un bucle infinito.
        while (counter <= limit) {
            System.out.println("Contador: " + counter);

            // Incrementa el contador en 1 para avanzar hacia la condición de salida.
            counter++;
        }

        System.out.println("Contador finalizado. Valor final: " + counter);

        scanner.close();
    }
}
